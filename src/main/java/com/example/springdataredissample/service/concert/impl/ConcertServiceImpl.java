package com.example.springdataredissample.service.concert.impl;

import com.example.springdataredissample.dto.controller.concert.out.ConcertListResponseDto;
import com.example.springdataredissample.dto.service.concert.out.ConcertDetailsDto;
import com.example.springdataredissample.entity.Concert;
import com.example.springdataredissample.entity.Venue;
import com.example.springdataredissample.repository.redis.ConcertRedisRepository;
import com.example.springdataredissample.repository.redis.VenueRedisRepository;
import com.example.springdataredissample.service.concert.ConcertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class ConcertServiceImpl implements ConcertService {
    private final ConcertRedisRepository concertRedisRepository;
    private final VenueRedisRepository venueRedisRepository;

    public ConcertServiceImpl(ConcertRedisRepository concertRedisRepository,
                              VenueRedisRepository venueRedisRepository) {
        this.concertRedisRepository = concertRedisRepository;
        this.venueRedisRepository = venueRedisRepository;
    }



    @Override
    public List<ConcertListResponseDto> getAllConcertsWithVenues() {
        // Redisから全コンサート情報を取得
        List<Concert> concerts = concertRedisRepository.findAll();

        // 関連する会場IDを収集
        List<String> venueIds = concerts.stream()
                .map(Concert::getVenueId)
                .distinct()
                .collect(Collectors.toList());

        // 会場情報を一括取得
        Map<String, Venue> venueMap = venueRedisRepository.findAllById(venueIds)
                .stream()
                .collect(Collectors.toMap(Venue::getId, venue -> venue));

        // コンサート情報と会場情報を結合してDTOに変換
        return concerts.stream()
                .map(concert -> {
                    Venue venue = venueMap.get(concert.getVenueId());
                    return createResponseDto(concert, venue);
                })
                .collect(Collectors.toList());
    }

    private ConcertListResponseDto createResponseDto(Concert concert, Venue venue) {
        ConcertListResponseDto dto = new ConcertListResponseDto();
        dto.setConcertId(concert.getId());
        dto.setConcertName(concert.getName());
        dto.setStartDateTime(concert.getStartDateTime());

        ConcertListResponseDto.VenueInfo venueInfo = new ConcertListResponseDto.VenueInfo();
        if (venue != null) {
            venueInfo.setName(venue.getName());
            venueInfo.setAddress(venue.getAddress());
            dto.setVenue(venueInfo);
        }

        return dto;
    }
}