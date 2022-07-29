package com.danielme.springboot.controllers.rest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ForceErrorRestController {

    @GetMapping(value = "/api/throwException")
    public void throwException() {
        throw new IllegalArgumentException("\"I am the error message from Rest Controller\"");
    }

    /*@ExceptionHandler(value = IllegalArgumentException.class)
    public Map<String, Object> handleException(Exception ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", ex.getMessage());
        map.put("timestamp", new Date());
        return map;
    }*/

}
