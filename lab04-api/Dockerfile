FROM eclipse-temurin:21-alpine
RUN apk add --no-cache curl
# COPY means copy the file from the host to the container as app.jar;
# WHY app.jar? It's a convention to name the jar file as app.jar
COPY target/lab04-api-0.0.1.jar app.jar
CMD ["java", "-jar", "app.jar"]