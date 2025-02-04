package com.indium.lab06movieapp;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ComponentScan(basePackages = "com.indium.lab06movieapp")
public class MovieServiceIntegrationTest {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieService movieService;

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
    }

    @BeforeEach
    public void initializeMovies() {
        Movie movie = new Movie("The Matrix", "Sci-Fi", 1999);
        movieRepository.save(movie);
    }

    @AfterEach
    public void cleanupMovies() {
        movieRepository.deleteAll();
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
        assertNotNull(movieRepository);
    }

    @Test
    public void testGetAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        assertEquals(1, movies.size());
    }

    @Test
    public void testGetMovieById() {
        Movie movie = movieService.getMovieById(1L);
        assertNotNull(movie);
        assertEquals("The Matrix", movie.getTitle());
    }

    @Test
    public void testDeleteMovie() {
        movieService.deleteMovie(1L);
        List<Movie> movies = movieService.getAllMovies();
        assertEquals(0, movies.size());
    }

    @Test
    public void testAddMovie() {
        Movie movie = new Movie("The Matrix Reloaded", "Sci-Fi", 2003);
        movieService.addMovie(movie);
        List<Movie> movies = movieService.getAllMovies();
        assertEquals(2, movies.size());
    }
}
