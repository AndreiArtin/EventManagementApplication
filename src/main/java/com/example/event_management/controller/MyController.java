package com.example.event_management.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000") // Permite accesul din front-end
@RestController
@RequestMapping("/api")
public class MyController {

    @GetMapping("/message")
    public String getMessage() {
        return "Hello from backend!";

        // Endpoint-uri API pentru a adăuga și obține date
    }
}
