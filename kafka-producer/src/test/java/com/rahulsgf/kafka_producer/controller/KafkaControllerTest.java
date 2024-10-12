package com.rahulsgf.kafka_producer.controller;

import com.rahulsgf.kafka_producer.model.MessageRequest;
import com.rahulsgf.kafka_producer.services.KafkaProducerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class KafkaControllerTest {

    @InjectMocks
    private KafkaController kafkaController;

    @Mock
    private KafkaProducerService kafkaProducerService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(kafkaController).build();
    }

    @Test
    void testSendMessageToKafka() throws Exception {
        // Arrange
        String message = "Hello Kafka!";
        MessageRequest messageRequest = new MessageRequest();
        messageRequest.setMessage(message);

        // Act & Assert
        mockMvc.perform(post("/sendMessage")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"message\":\"" + message + "\"}"))
                .andExpect(status().isOk());

        // Verify that the service method was called with the correct message
        verify(kafkaProducerService).sendMessage(message);
    }
}