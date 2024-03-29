package com.danielme.springboot.controllers.errors.advices;

import com.danielme.springboot.controllers.errors.ExceptionUtils;
import com.danielme.springboot.controllers.web.ForceErrorJspController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;


@Order(2)
@ControllerAdvice(annotations = Controller.class)
//@ControllerAdvice(basePackageClasses = ForceErrorJspController.class)
public class ErrorJspControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ErrorJspControllerAdvice.class);

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception ex, HttpServletRequest request, Model model) {
        logger.info("executing exception handler (web)");

        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("error", ex.getClass().getName());
        model.addAttribute("exception", ex.getClass());
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("path", request.getRequestURI());
        model.addAttribute("jdk", System.getProperty("java.version"));
        model.addAttribute("trace", ExceptionUtils.buildTrace(ex));

        return "error";
    }

}
