package com.lpu.circuit.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    int count = 0;

    @GetMapping("/test")

    // Circuit breaker monitors this method
    @CircuitBreaker(name = "demoService", fallbackMethod = "fallbackMethod")
    public String testService() {

        count++;

        System.out.println("Service called : " + count);

        // First 3 requests succeed
        if (count <= 3) {
            return "Request successful : " + count;
        }

        // Reset counter after some requests
        if (count == 15) {
            count = 0;
        }

        // Simulate failure
        throw new RuntimeException("Service failed " + count);
    }

    // Fallback method executed when circuit breaker opens
    public String fallbackMethod(Exception ex) {

        System.out.println("Fallback executed");

        return "Fallback response - Circuit Breaker active";
    }
}