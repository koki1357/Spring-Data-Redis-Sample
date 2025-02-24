package com.example.springdataredissample.repository.redis;

import com.example.springdataredissample.entity.Concert;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
//@RequiredArgsConstructor
public class ConcertRedisRepository {
    private final RedisTemplate<String, String> redisTemplate;
    private final ObjectMapper objectMapper;

    private static final String KEY_PREFIX = "concert:";

    public ConcertRedisRepository(RedisTemplate<String, String> redisTemplate, ObjectMapper objectMapper) {
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    public List<Concert> findAll() {
        Set<String> keys = redisTemplate.keys(KEY_PREFIX + "*");
        return keys.stream()
                .map(key -> redisTemplate.opsForValue().get(key))
                .map(this::deserialize)
                .collect(Collectors.toList());
    }

    private Concert deserialize(String json) {
        try {
            return objectMapper.readValue(json, Concert.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to deserialize concert data", e);
        }
    }
}