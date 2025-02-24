# Redis Cluster Setup

## 起動手順
1. `docker-compose up -d` コマンドでRedisクラスタを起動します。

## 初期化手順
2. `redis-init.sh` を実行して初期データを登録します。
```bash
sh redis-init.sh
```

## データ同期確認手順
3. マスターのデータ確認:
```bash
redis-cli -h redis-master -p 6379 GET venue:1
```

4. レプリカ1のデータ確認:
```bash
redis-cli -h redis-replica-1 -p 6380 GET venue:1
```

5. レプリカ2のデータ確認:
```bash
redis-cli -h redis-replica-2 -p 6381 GET venue:1
```