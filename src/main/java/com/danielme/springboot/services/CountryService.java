package com.danielme.springboot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.danielme.springboot.model.Country;

@Service
public class CountryService {

    private static final List<Country> countries;
    static {
        countries = new ArrayList<>();
        countries.add(new Country(1, "Spain", 49067981));
        countries.add(new Country(2, "Mexico", 130497248));
    }

    public List<Country> findAll() {
        return countries;
    }

    public Optional<Country> findById(Integer id) {
        return countries.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

}