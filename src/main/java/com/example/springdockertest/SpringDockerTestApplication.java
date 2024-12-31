package com.example.springdockertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringDockerTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDockerTestApplication.class, args);
    }

    @RestController
    public static class HelloWorldController {

        @GetMapping("/")
        public String hello() {
            return "Hello, World!";
        }
    }

}
