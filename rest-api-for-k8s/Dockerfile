FROM maven:3.9.6-eclipse-temurin-21 as builder
WORKDIR /app
COPY . /app
RUN ./mvnw clean compile package -DskipTests

FROM eclipse-temurin:21.0.6_7-jre-ubi9-minimal
WORKDIR /app
COPY --from=builder /app/target/rest-api-for-k8s-0.0.1.jar app.jar
CMD ["java", "-jar", "app.jar"]