package com.rahulsgf.kafka_producer.controller;

import com.rahulsgf.kafka_producer.services.MessageScheduler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SchedulerController {

    @Autowired
    private MessageScheduler messageScheduler;

    @GetMapping("/start-schedule")
    public String startMessageScheduler() {
        if (!messageScheduler.isSchedulerRunning()) {
            messageScheduler.startScheduler();
            return "Message scheduler started successfully!";
        } else {
            return "Message scheduler is already running.";
        }
    }

    @GetMapping("/stop-schedule")
    public String stopMessageScheduler() {
        if (messageScheduler.isSchedulerRunning()) {
            messageScheduler.stopScheduler();
            return "Message scheduler stopped successfully!";
        } else {
            return "Message scheduler is not running.";
        }
    }
}
