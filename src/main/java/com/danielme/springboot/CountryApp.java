package com.danielme.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CountryApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CountryApp.class, args);
    }

}