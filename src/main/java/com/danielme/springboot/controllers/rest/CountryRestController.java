package com.danielme.springboot.controllers.rest;

import com.danielme.springboot.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(CountryRestController.COUNTRY_RESOURCE)
public class CountryRestController {

    public static final String COUNTRY_RESOURCE = "/api/country";

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid Country country) {
       //noting here :P
    }

}
