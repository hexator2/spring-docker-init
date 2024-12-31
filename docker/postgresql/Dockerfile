# 1. PostgreSQL 최신 공식 이미지 (버전 지정 해야할지 고민)
FROM postgres:latest

# 2. 초기화 SQL 파일 복사 (필요 시)
# COPY init.sql /docker-entrypoint-initdb.d/

# 3. PostgreSQL 설정 파일 복사
COPY docker/postgresql/conf/postgresql.conf /etc/postgresql/postgresql.conf

# 4. PostgreSQL 포트 개방
EXPOSE 5432