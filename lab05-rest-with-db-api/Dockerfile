FROM eclipse-temurin:21-alpine
COPY target/lab05-rest-with-db-api-0.0.1.jar app.jar
ENV DB_HOST=localhost
ENV DB_PORT=5432
ENV DB_NAME=training
ENV DB_USER=root
ENV DB_PASSWORD=root
CMD ["java", "-jar", "-Dspring.datasource.url=jdbc:mysql://${DB_HOST}:${DB_PORT}/${DB_NAME}", "-Dspring.datasource.username=${DB_USER}", "-Dspring.datasource.password=${DB_PASSWORD}",  "app.jar"]