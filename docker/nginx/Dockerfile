# 1. Nginx 최신 공식 이미지 (버전 지정 해야할지 고민)
FROM nginx:latest

# 2. Nginx 설정 파일 복사
ARG NGINX_CONF=default.conf
COPY docker/nginx/conf.d/${NGINX_CONF} /etc/nginx/conf.d/default.conf

# 3. Nginx 포트 개방
EXPOSE 80