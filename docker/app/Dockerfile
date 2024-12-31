# 1. OpenJDK 17 Slim 버전 기반 이미지 사용 ->
# 불필요 소프트웨어,유틸리티,개발도구등이 삭제된버전 ex) gcc, make, gdb, vim, nano
FROM openjdk:17-jdk-slim

# 2. 컨테이너 내 작업 디렉토리 설정
WORKDIR /app

# 3. Gradle Wrapper와 설정 파일 복사 및 의존성 다운로드
COPY gradlew settings.gradle build.gradle ./
COPY gradle ./gradle
RUN ./gradlew dependencies

# 4. 소스 코드 복사
COPY src ./src

# 5. 운영 환경에서만 JAR 빌드 실행
ARG SPRING_PROFILES_ACTIVE=local
ENV SPRING_PROFILES_ACTIVE=${SPRING_PROFILES_ACTIVE}
# 5-1. 운영환경에서 gradle 빌드시 캐시적용하지않고 재설치, 테스트는 건너뜀 ( 로컬, 스테이지등 충분한 테스트 했다는 가정 )
# RUN if [ "$SPRING_PROFILES_ACTIVE" = "prod" ]; then ./gradlew clean build -x test; fi
RUN if [ "$SPRING_PROFILES_ACTIVE" = "prod" ]; then ./gradlew clean build; fi

# 6. 애플리케이션 실행 (운영/개발 환경 분기 처리)
CMD ["sh", "-c", "if [ \"$SPRING_PROFILES_ACTIVE\" = \"prod\" ]; then java -jar build/libs/*.jar; else ./gradlew bootRun; fi"]

# 7. 애플리케이션 실행을 위한 포트 개방
EXPOSE 8080