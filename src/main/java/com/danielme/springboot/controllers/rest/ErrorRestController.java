package com.danielme.springboot.controllers.rest;
 
import java.io.PrintWriter;
import java.io.StringWriter;
 
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.danielme.springboot.model.CustomErrorJson;

//@ControllerAdvice(basePackages = "com.danielme.springboot.controllers.rest")
@ControllerAdvice(annotations=RestController.class)
public class ErrorRestController {
 
    private static final Logger logger = LoggerFactory.getLogger(ErrorRestController.class);
   
    @ExceptionHandler
    @ResponseBody
    public CustomErrorJson handleException(Exception ex, HttpServletRequest request) {
        logger.info("executing exception handler (REST)");
 
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));
 
        return new CustomErrorJson(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getClass().getName(),
                ex.getMessage(),
                request.getRequestURI(),
                sw.toString());
    }

}