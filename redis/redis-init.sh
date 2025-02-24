#!/bin/bash

# Redisマスターにデータを登録
redis-cli -h localhost -p 6379 <<EOF
SET venue:1 "{ \"name\": \"会場A\", \"address\": \"住所A\", \"capacity\": 1000, \"access\": \"アクセス情報A\" }"
SET concert:1 "{ \"name\": \"コンサートA\", \"artist\": \"アーティストA\", \"date\": \"2025-12-31\", \"venueId\": \"1\" }"
SET seatType:1 "{ \"name\": \"VIP席\", \"description\": \"最前列\" }"
SET ticketPrice:1:1 "{ \"price\": 10000, \"description\": \"VIP席料金\" }"
SET seatMap:1:1 "{ \"seats\": [\"A1\", \"A2\", \"A3\"], \"totalCount\": 3 }"
EOF