package com.rahulsgf.kafka_producer.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@Slf4j
class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHome() throws Exception {

        log.info("Simulating GET() on home");

        // simulate a GET request to "/"
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Application started: Welcome home!"));
    }
}
