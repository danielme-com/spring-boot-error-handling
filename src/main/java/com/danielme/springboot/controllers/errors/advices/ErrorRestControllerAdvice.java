package com.danielme.springboot.controllers.errors.advices;

import com.danielme.springboot.controllers.errors.ExceptionUtils;
import com.danielme.springboot.model.CustomErrorJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

//@ControllerAdvice(basePackageClasses = ForceErrorRestController.class)
@ControllerAdvice(annotations = RestController.class)
public class ErrorRestControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ErrorRestControllerAdvice.class);

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public CustomErrorJson handleException(Exception ex, HttpServletRequest request) {
        logger.info("executing exception handler (REST)");

        return new CustomErrorJson(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getClass().getName(),
                ex.getMessage(),
                request.getRequestURI(),
                ExceptionUtils.buildTrace(ex),
                System.getProperty("java.version"));
    }

}