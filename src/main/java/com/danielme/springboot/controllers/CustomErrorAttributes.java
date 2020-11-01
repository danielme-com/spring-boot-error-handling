package com.danielme.springboot.controllers;

import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;


@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

    //para Spring Boot < 2.3
    /*@Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest,
            boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest,
                includeStackTrace);
        errorAttributes.put("jdk", System.getProperty("java.version"));
        return errorAttributes;
    }*/

    //sólo para Spring Boot 2.3
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        errorAttributes.put("jdk", System.getProperty("java.version"));
        return errorAttributes;
    }
}
