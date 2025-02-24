package com.example.springdataredissample.controller.concert;

import com.example.springdataredissample.dto.controller.concert.out.ConcertListResponseDto;
import com.example.springdataredissample.service.concert.ConcertService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/concerts")
//@RequiredArgsConstructor
public class ConcertController {
    private final ConcertService concertService;

    @Autowired
    public ConcertController(ConcertService concertService) {
        this.concertService = concertService;
    }


    @GetMapping
    public ResponseEntity<List<ConcertListResponseDto>> getAllConcerts() {
        return ResponseEntity.ok(concertService.getAllConcertsWithVenues());
    }
}