package com.rahulsgf.kafka_producer.services;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {

        log.info("Producing message in KafkaProducerService()");

        kafkaTemplate.send("test-topic", message);

        log.info("Message sent successfully to Kafka");
    }
}
