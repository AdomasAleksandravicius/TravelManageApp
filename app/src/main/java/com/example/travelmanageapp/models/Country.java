package com.example.travelmanageapp.models;

import java.util.List;
import java.util.UUID;

public class Country {
    private String id;
    private String name;
    private String description;
    private List<City> cities;
    public Country() {
    }

    public Country(String id ,String name, String description) {

        if (id == null){
            id = UUID.randomUUID().toString();
        }

        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
