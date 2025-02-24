package com.example.springdataredissample.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Venue {
    private String id;
    private String name;
    private String address;
    private Integer capacity;

    private String access;

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

    public String getAccess() {  // 追加
        return access;
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

    public void setAccess(String access) {  // 追加
        this.access = access;
    }
}