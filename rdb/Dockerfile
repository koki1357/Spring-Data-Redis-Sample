FROM mysql:8.0.34

# ポートの設定
EXPOSE 3306

# ログディレクトリの作成とパーミッション設定
RUN mkdir -p /var/log/mysql \
   && chown mysql:mysql /var/log/mysql

# MySQL設定ファイルをコピー
COPY ./my.cnf /etc/mysql/conf.d/my.cnf

# コンテナ内の/docker-entrypoint-initdb.d/配下にDB初期化用のSQLファイルを配置する
# /docker-entrypoint-initdb.d/配下のSQLファイルはファイル名の昇順で実行される
COPY ./initdb.d/1_schema.sql /docker-entrypoint-initdb.d/1_schema.sql
COPY ./initdb.d/2_testdata.sql /docker-entrypoint-initdb.d/2_testdata.sql

CMD ["mysqld"]