package com.rahulsgf.kafka_producer.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@Slf4j
@WebMvcTest(HomeController.class)
class HomeControllerTest {

    @InjectMocks
    HomeController homeController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHome() throws Exception {

        log.info("Simulating GET() on home");
        Assertions.assertEquals("Application started: Welcome home!", homeController.home());

        // simulate a GET request to "/"
//        mockMvc.perform(get("/"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Application started: Welcome home!"));
    }
}