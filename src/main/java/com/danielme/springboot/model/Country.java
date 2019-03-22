package com.danielme.springboot.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Country {

    private Integer id;
    
    @NotNull
    private String name;
    
    @NotNull
    @Min(1)
    @Max(2000000000)
    private Integer population;
    
    public Country() {
        super();
    }

    public Country(Integer id, String name, Integer population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }
    
    
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

}