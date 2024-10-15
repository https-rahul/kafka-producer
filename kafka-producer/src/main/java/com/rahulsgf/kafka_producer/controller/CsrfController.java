package com.rahulsgf.kafka_producer.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CsrfController {

    //Cross Site Request Forgery
    @GetMapping("/auth")
    public CsrfToken getCsrfToken(HttpServletRequest request) {

        CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");

        if (csrfToken != null){
            log.info("CSRF TOKEN GENERATED: param name={}, value={}, header={}", csrfToken.getParameterName(), csrfToken.getToken(), csrfToken.getHeaderName());
            return (CsrfToken)request.getAttribute("_csrf");

        } else {
            log.warn("CSRF TOKEN NOT PRESENT IN THE REQUEST");
        }

        return null;
    }
}