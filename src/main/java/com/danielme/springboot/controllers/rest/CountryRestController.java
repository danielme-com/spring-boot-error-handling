package com.danielme.springboot.controllers.rest;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.danielme.springboot.model.Country;
import com.danielme.springboot.services.CountryService;

@RestController
@RequestMapping(CountryRestController.COUNTRY_RESOURCE)
public class CountryRestController {

    public static final String COUNTRY_RESOURCE = "/api/country";

    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "/{id}/")
    public ResponseEntity<Country> getById(@PathVariable("id") Integer id) {
        Optional<Country> country = countryService.findById(id);
        if (country.isPresent()) {
            return new ResponseEntity<>(country.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody @Valid Country country) {
       //noting here :P
    }

}
