package com.rahulsgf.kafka_producer.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        return "Application started: Welcome user! \nSessionID: " +request.getSession().getId();
    }
}