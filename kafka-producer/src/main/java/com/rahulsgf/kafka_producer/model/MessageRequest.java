package com.rahulsgf.kafka_producer.model;

import lombok.Data;

@Data
public class MessageRequest {
    private String message;

    public MessageRequest() {}

    public MessageRequest(String message) {
        this.message = message;
    }
}