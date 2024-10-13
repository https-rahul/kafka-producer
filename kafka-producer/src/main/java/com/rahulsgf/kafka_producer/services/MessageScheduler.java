package com.rahulsgf.kafka_producer.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class MessageScheduler {

    private int messageCount = 0;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    private boolean isSchedulerRunning = false;

    @Scheduled(fixedRate = 2000)
    public void sendScheduledMessage() {

        if (isSchedulerRunning) {

            long currentMillis = System.currentTimeMillis();
            Date currentTimeStamp = new Date(currentMillis);

            String message = "Automated message count: "+messageCount++ ;

            kafkaProducerService.sendMessage(message);
            log.info("Automated message sent with count {} @ {}", messageCount, currentTimeStamp);
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

// TODO: create test class