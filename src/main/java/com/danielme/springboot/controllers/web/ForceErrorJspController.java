package com.danielme.springboot.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForceErrorJspController {

    @GetMapping(value = "/throwException")
    public void throwException() {
        throw new IllegalArgumentException("\"I am the error message from JSP Controller\"");
    }

}
