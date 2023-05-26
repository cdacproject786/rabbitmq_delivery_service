
FROM eclipse-temurin:20-alpine

LABEL mentainer="arbaazsayed1602@gmail.com"

WORKDIR /app

COPY target/deliver_service.jar /app/deliver_service.jar

ENTRYPOINT ["java", "-jar", "deliver_service.jar"]