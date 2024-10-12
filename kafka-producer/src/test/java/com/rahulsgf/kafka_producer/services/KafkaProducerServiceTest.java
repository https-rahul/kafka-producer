package com.rahulsgf.kafka_producer.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.*;

@Slf4j  // Enables logging using Lombok
class KafkaProducerServiceTest {

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;  // Mock KafkaTemplate to prevent actual Kafka interaction

    @InjectMocks
    private KafkaProducerService kafkaProducerService;  // Inject the mocked KafkaTemplate into KafkaProducerService

    @BeforeEach
    void setUp() {
        log.info("Initializing mocks before each test.");
        MockitoAnnotations.openMocks(this);  // Initialize mocks before each test
        log.info("Mocks initialized successfully.");
    }

    @Test
    void testSendMessage() {
        // Arrange
        String message = "Test message";
        log.info("Starting test for sendMessage with message: {}", message);

        // Act
        kafkaProducerService.sendMessage(message);
        log.info("sendMessage method executed.");

        // Assert
        verify(kafkaTemplate, times(1)).send("test-topic", message);  // Verify send() was called with correct parameters
        log.info("Verified that KafkaTemplate.send() was called once with message: {}", message);
    }

    @Test
    void testSendMessage_withNullMessage() {
        // Arrange
        String message = null;
        log.info("Starting test for sendMessage with a null message.");

        // Act
        kafkaProducerService.sendMessage(message);
        log.info("sendMessage method executed with null message.");

        // Assert
        verify(kafkaTemplate, times(1)).send("test-topic", message);  // Verify send() was called with null
        log.info("Verified that KafkaTemplate.send() was called once with a null message.");
    }
}