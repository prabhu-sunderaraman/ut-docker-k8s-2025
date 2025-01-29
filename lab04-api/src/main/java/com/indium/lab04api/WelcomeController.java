package com.indium.lab04api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WelcomeController {

    @GetMapping("/api/welcome")
    public Map<String, String> getWelcomeMessage() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to the Dockerized Spring Boot API!");
        return response;
    }
}