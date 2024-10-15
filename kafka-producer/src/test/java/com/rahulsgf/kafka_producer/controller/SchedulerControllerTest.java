package com.rahulsgf.kafka_producer.controller;

import com.rahulsgf.kafka_producer.services.MessageScheduler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SchedulerControllerTest {

    @Mock
    private MessageScheduler messageScheduler;

    @InjectMocks
    private SchedulerController schedulerController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(schedulerController).build();
    }

    @Test
    void testStartMessageScheduler_whenSchedulerNotRunning_ShouldStartScheduler() throws Exception {

        when(messageScheduler.isSchedulerRunning()).thenReturn(false);

        // When: Sending GET request to /start-schedule and expecting a successful response
        mockMvc.perform(get("/start-schedule").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Message scheduler started successfully!"));

        // Then: Verifying that the startScheduler method was called
        verify(messageScheduler).startScheduler();
    }

    // when message scheduler is already running
    @Test
    void testStartMessageScheduler_whenSchedulerIsRunning_shouldNotStartScheduler() throws Exception {

        // Given: Mocking the behavior of messageScheduler.isSchedulerRunning to return true
        when(messageScheduler.isSchedulerRunning()).thenReturn(true);

        // When: Sending GET request to /start-schedule and expecting a successful response
        mockMvc.perform(get("/start-schedule").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Message scheduler is already running."));

        // Then: Verifying that the startScheduler method was not called
        verify(messageScheduler, never()).startScheduler();
    }

    @Test
    void testStopMessageScheduler_schedulerIsRunning() {
        when(messageScheduler.isSchedulerRunning()).thenReturn(true);
        doNothing().when(messageScheduler).stopScheduler();
        Assertions.assertEquals("Message scheduler stopped successfully!", schedulerController.stopMessageScheduler() );
    }

    @Test
    void testStopMessageScheduler_schedulerIsNotRunning() {
        when(messageScheduler.isSchedulerRunning()).thenReturn(false);
        doNothing().when(messageScheduler).stopScheduler();
        Assertions.assertEquals("Message scheduler is not running.", schedulerController.stopMessageScheduler() );
    }

}