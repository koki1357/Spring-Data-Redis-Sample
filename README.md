# Spring-Data-Redis-Sample

## プロジェクト概要
このプロジェクトは、Spring Bootを使用してRedisとMySQLを統合したサンプルアプリケーションです。

## 前提条件
- Java 17
- Maven 3.6+
- Docker

## 環境構築と起動手順

### 1. リポジトリのクローン
- git clone https://github.com/your-repo/spring-data-redis-sample.git
- cd spring-data-redis-sample

### 2. MySQLの起動
- cd rdb
- docker compose up -d

### 3. アプリケーションの起動
- ./mvnw spring-boot:run

### 4. 停止手順
#### MySQLの停止
- cd rdb
- docker compose down

#### データの削除（必要な場合）
- rm -rf rdb/db-volume

## 技術スタック
- Java 17
- Spring Boot 3.4.3
- MySQL
- Redis
- MyBatis 3.0.4

## 主な依存関係
- spring-boot-starter-data-redis-reactive
- spring-boot-starter-web
- mybatis-spring-boot-starter
- mysql-connector-j
- lombok

## ビルドとテスト
- ./mvnw clean package

## テストの実行
- ./mvnw test