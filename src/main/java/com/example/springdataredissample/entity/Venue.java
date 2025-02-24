package com.example.springdataredissample.entity;

public class Venue {
    private String id;
    private String name;
    private String address;
    private Integer capacity;

    // Getters
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public Integer getCapacity() {
        return this.capacity;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}