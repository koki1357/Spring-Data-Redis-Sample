package com.example.springdataredissample.repository.redis;

import com.example.springdataredissample.entity.Venue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
//@RequiredArgsConstructor
public class VenueRedisRepository {
    private final RedisTemplate<String, String> redisTemplate;
    private final ObjectMapper objectMapper;

    private static final String KEY_PREFIX = "venue:";

    @Autowired  // 必要に応じて追加
    public VenueRedisRepository(RedisTemplate<String, String> redisTemplate, ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }


    public List<Venue> findAllById(List<String> ids) {
        return ids.stream()
                .map(id -> redisTemplate.opsForValue().get(KEY_PREFIX + id))
                .filter(json -> json != null)
                .map(this::deserialize)
                .collect(Collectors.toList());
    }

    private Venue deserialize(String json) {
        try {
            return objectMapper.readValue(json, Venue.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to deserialize venue data", e);
        }
    }
}