FROM eclipse-temurin:21-alpine
COPY target/rest-api-more-docker-0.0.1.jar app.jar

ENV WELCOME="Welcome to Dockerized API"
ENV BYE="Goodbye from Dockerized API"

CMD ["java","-jar", "-Dwelcome.message=${WELCOME}", "-Dbye.message=${BYE}", "/app.jar"]

# docker run -e WELCOME="Hello from Dockerized API" -e BYE="Goodbye from Dockerized API" -p 8080:8080 rest-api-more-docker:0.0.1