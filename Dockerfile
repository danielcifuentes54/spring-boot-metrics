FROM openjdk:8-jre-alpine
WORKDIR /app
COPY target/spring-boot-metrics.jar /app/
ENTRYPOINT ["java", "-jar", "spring-boot-metrics.jar"]