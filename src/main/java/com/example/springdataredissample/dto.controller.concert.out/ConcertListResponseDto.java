package com.example.springdataredissample.dto.controller.concert.out;

import java.time.LocalDateTime;

public class ConcertListResponseDto {
    private String concertId;
    private String concertName;
    private LocalDateTime startDateTime;
    private VenueInfo venue;

    // Getters
    public String getConcertId() {
        return this.concertId;
    }

    public String getConcertName() {
        return this.concertName;
    }

    public LocalDateTime getStartDateTime() {
        return this.startDateTime;
    }

    public VenueInfo getVenue() {
        return this.venue;
    }

    // Setters
    public void setConcertId(String concertId) {
        this.concertId = concertId;
    }

    public void setConcertName(String concertName) {
        this.concertName = concertName;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public void setVenue(VenueInfo venue) {
        this.venue = venue;
    }

    // 内部クラスVenueInfoも同様に明示的に実装
    public static class VenueInfo {
        private String name;
        private String address;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return this.address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}