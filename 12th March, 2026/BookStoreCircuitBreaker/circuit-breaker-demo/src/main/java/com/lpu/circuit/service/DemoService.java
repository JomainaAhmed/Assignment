package com.lpu.circuit.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @CircuitBreaker(name = "demoService", fallbackMethod = "fallbackMethod")
    public String callService() {

        throw new RuntimeException("Service Down");
    }

    public String fallbackMethod(Exception ex) {
        return "Fallback Response: Service Unavailable";
    }
}