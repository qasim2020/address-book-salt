package com.example.saltqasimdirectory.controller;

import com.example.saltqasimdirectory.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

// entry point to our application
@RestController
public class GreetingController {

    private static final String template = "hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam( value = "name", defaultValue = "World") String name) {
        return new Greeting( counter.incrementAndGet(), String.format(template, name));
    }

}
