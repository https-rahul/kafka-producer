package com.rahulsgf.kafka_producer.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageScheduler {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    private boolean isSchedulerRunning = false;

    @Scheduled(fixedRate = 2000)
    public void sendScheduledMessage() {
        if (isSchedulerRunning) {
            String message = "Automated message " + System.currentTimeMillis();
            kafkaProducerService.sendMessage(message);
            log.info("Automated message sent: " + message);
        }
    }

    // Methods to start and stop the scheduler
    public void startScheduler() {
        isSchedulerRunning = true;
        log.info("Message scheduler started.");
    }

    public void stopScheduler() {
        isSchedulerRunning = false;
        log.info("Message scheduler stopped.");
    }

    public boolean isSchedulerRunning() {

        log.info("Current scheduler status: " +isSchedulerRunning);
        return isSchedulerRunning;
    }
}
