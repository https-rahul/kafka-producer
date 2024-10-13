package com.rahulsgf.kafka_producer.controller;

import com.rahulsgf.kafka_producer.model.MessageRequest;
import com.rahulsgf.kafka_producer.services.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@Slf4j
public class KafkaController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/sendMessage")
    public String sendMessageToKafka(@RequestBody MessageRequest messageRequest) {

        String message = messageRequest.getMessage();

        long currentMillis = System.currentTimeMillis();
        Date receiveTime = new Date(currentMillis);
        log.info("Received message:  //{}// at: {}", message, receiveTime);

        kafkaProducerService.sendMessage(message);

        Date afterPushTime = new Date(currentMillis);
        log.info("Message successfully pushed to Kafka topic at: {}", afterPushTime);

        return "Message sent to Kafka successfully!";
    }
}