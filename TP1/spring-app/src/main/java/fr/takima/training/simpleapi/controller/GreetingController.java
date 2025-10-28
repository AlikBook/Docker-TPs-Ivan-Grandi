package fr.takima.training.simpleapi.controller;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@CrossOrigin
public class GreetingController {

    private static final String TEMPLATE = "Bonjour, %s!";
    private final AtomicLong counter = new AtomicLong();

    private static final String INSTANCE = System.getenv().getOrDefault("BACKEND_INSTANCE", "unknown");

    @GetMapping("/")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Monde") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name) + " from " + INSTANCE);
    }

    record Greeting(long id, String content) { }
}
