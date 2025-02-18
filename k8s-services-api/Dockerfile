FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21.0.6_7-jre
WORKDIR /app
COPY --from=builder /app/target/k8s-services-api-0.0.1.jar app.jar
CMD ["java", "-jar", "app.jar"]