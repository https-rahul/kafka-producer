package com.rahulsgf.kafka_producer.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MessageRequestTest {

    @Test
    void testNoArgsConstructor() {
        MessageRequest messageRequest = new MessageRequest();
        assertNull(messageRequest.getMessage(), "Message should be null after using no-args constructor");
    }

    @Test
    void testAllArgsConstructor() {
        String expectedMessage = "Test message";
        MessageRequest messageRequest = new MessageRequest(expectedMessage);

        assertEquals(expectedMessage, messageRequest.getMessage(), "Message should match the one passed in the constructor");
    }

    @Test
    void testSetMessage() {
        MessageRequest messageRequest = new MessageRequest();
        String newMessage = "New message";

        messageRequest.setMessage(newMessage);

        assertEquals(newMessage, messageRequest.getMessage(), "Message should match the one set using setMessage()");
    }

    @Test
    void testGetMessage() {
        String expectedMessage = "Hello Kafka!";
        MessageRequest messageRequest = new MessageRequest();
        messageRequest.setMessage(expectedMessage);

        assertEquals(expectedMessage, messageRequest.getMessage(), "Message should match the one set using setMessage()");
    }
}













