package com.example.springdataredissample.service.concert;

import com.example.springdataredissample.dto.controller.concert.out.ConcertListResponseDto;
import java.util.List;

public interface ConcertService {
    /**
     * コンサート情報と会場情報を結合して全件取得する
     * @return コンサート一覧情報
     */
    List<ConcertListResponseDto> getAllConcertsWithVenues();
}