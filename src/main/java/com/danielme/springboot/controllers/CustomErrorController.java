package com.danielme.springboot.controllers;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.danielme.springboot.model.CustomErrorJson;

@Controller
public class CustomErrorController implements ErrorController {

    private static final Logger logger = LoggerFactory.getLogger(CustomErrorController.class);

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    public String handleError(@RequestHeader("Accept") String accept, HttpServletRequest request, 
            WebRequest webRequest, Model model) {
        logger.info("executing custom error controller");

        if (accept.contains("application/json")) {
            return "forward:/errorJSON";
        }
        
        if (HttpStatus.NOT_FOUND
                .value() == (int) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)) {
            return "/error/404";
        }

        Map<String, Object> mapErrors = errorAttributes.getErrorAttributes(webRequest, true);
        model.addAllAttributes(mapErrors);

        return "error";
    }
    
    @RequestMapping("/errorJSON")
    @ResponseBody
    public CustomErrorJson handleErrorJson(HttpServletRequest request, WebRequest webRequest) {
        Map<String, Object> mapErrors = errorAttributes.getErrorAttributes(webRequest, true);

        return new CustomErrorJson((int) request.getAttribute(
                RequestDispatcher.ERROR_STATUS_CODE),
                (String) mapErrors.get("error"),
                (String) mapErrors.get("message"),
                (String) mapErrors.get("path"),
                (String) mapErrors.get("trace"));
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}