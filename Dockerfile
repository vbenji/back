FROM eclipse-temurin:21-jre

WORKDIR /app

COPY target/michelin-back-*.jar michelin-back.jar

CMD ["java", "-jar", "michelin-back.jar"]
