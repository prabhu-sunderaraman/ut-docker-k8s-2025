package com.indium.lab06movieapp;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.junit.jupiter.api.Assertions.*;
@Disabled
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MovieControllerIntegrationTest {

    @Autowired
    private MovieRepository movieRepository;

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    private int port = 10000;

    private static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:latest")
            .withDatabaseName("testdb")
            .withUsername("testuser")
            .withPassword("testpass");

    @DynamicPropertySource
    static void setDatasourceProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgresContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgresContainer::getUsername);
        registry.add("spring.datasource.password", postgresContainer::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create-drop");
        registry.add("server.port", () -> "10000");
    }

    @BeforeEach
    public void initializeMovies() {
        Movie movie = new Movie("The Matrix", "Sci-Fi", 1999);
        movieRepository.save(movie);
    }

    @BeforeAll
    public static void setup() {
        postgresContainer.start();
    }

    @AfterAll
    public static void tearDown() {
        postgresContainer.stop();
    }

    @Test
    public void testSetup() {
        assertNotNull(postgresContainer);
        assertTrue(port > 0);
    }

    @Test
    public void testGetAllMovies() {
        String url = "http://localhost:" + port + "/movies";
        Movie[] movies = restTemplate.getForObject(url, Movie[].class);
        assertEquals(1, movies.length);
    }
}
