package com.danielme.springboot.controllers.errors;

import com.danielme.springboot.model.CustomErrorJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
public class CustomErrorController implements ErrorController {

    private static final Logger logger = LoggerFactory.getLogger(CustomErrorController.class);

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    public String handleError(@RequestHeader("Accept") String accept, HttpServletRequest request, WebRequest webRequest, Model model) {
        logger.info("executing custom error controller");

        if (isREST(accept)) {
            return "forward:/errorJSON";
        }

        if (is404(request)) {
            return "/error/404";
        }

        model.addAllAttributes(buildMapErrors(webRequest));

        return "error";
    }

    @RequestMapping("/errorJSON")
    @ResponseBody
    public CustomErrorJson handleErrorJson(HttpServletRequest request, WebRequest webRequest) {
        Map<String, Object> mapErrors = buildMapErrors(webRequest);
        int status = (int) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        return new CustomErrorJson(status,
                (String) mapErrors.get("error"),
                (String) mapErrors.get("message"),
                (String) mapErrors.get("path"),
                (String) mapErrors.get("trace"),
                (String) mapErrors.get("jdk"));
    }

    private boolean isREST(String accept) {
        return MediaType.APPLICATION_JSON.toString().equalsIgnoreCase(accept);
    }

    private boolean is404(HttpServletRequest request) {
        return HttpStatus.NOT_FOUND
                .value() == (int) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    }

    private Map<String, Object> buildMapErrors(WebRequest webRequest) {
        ErrorAttributeOptions options = ErrorAttributeOptions.of(
                ErrorAttributeOptions.Include.STACK_TRACE,
                ErrorAttributeOptions.Include.EXCEPTION,
                ErrorAttributeOptions.Include.MESSAGE);
        return errorAttributes.getErrorAttributes(webRequest, options);
    }

}