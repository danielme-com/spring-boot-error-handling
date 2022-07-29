package com.danielme.springboot;

import com.danielme.springboot.controllers.errors.CustomErrorAttributes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ErrorsApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ErrorsApp.class, args);
    }

    @Bean
    public CustomErrorAttributes errorAttributes() {
        return new CustomErrorAttributes();
    }

}
