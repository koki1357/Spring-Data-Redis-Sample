package com.example.springdataredissample.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Concert {
    private String id;
    private String name;
    private String venueId;
    private LocalDateTime startDateTime;
    private String description;

    // Getters
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getVenueId() {
        return this.venueId;
    }

    public LocalDateTime getStartDateTime() {
        return this.startDateTime;
    }

    public String getDescription() {
        return this.description;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}