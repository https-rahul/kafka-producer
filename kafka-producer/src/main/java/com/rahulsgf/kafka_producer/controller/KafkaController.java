package com.rahulsgf.kafka_producer.controller;

import com.rahulsgf.kafka_producer.model.MessageRequest;
import com.rahulsgf.kafka_producer.services.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class KafkaController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/sendMessage")
    public String sendMessageToKafka(@RequestBody MessageRequest messageRequest) {

        String message = messageRequest.getMessage();

        log.info("Received request to send message: {}", message);
        kafkaProducerService.sendMessage(message);
        return "Message sent to Kafka successfully!";
    }
}