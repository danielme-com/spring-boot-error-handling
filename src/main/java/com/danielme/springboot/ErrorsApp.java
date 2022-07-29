package com.danielme.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ErrorsApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ErrorsApp.class, args);
    }

}
