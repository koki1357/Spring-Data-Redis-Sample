package com.example.springdataredissample.dto.service.concert.out;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ConcertDetailsDto {
    private String id;
    private String name;
    private LocalDateTime startDateTime;
    private String description;
    private VenueDto venue;

    @Data
    public static class VenueDto {
        private String id;
        private String name;
        private String address;
        private Integer capacity;
    }
}