#### Lab 06
* In this lab you will learn to use **testcontainers** for developing integration tests for spring boot rest api
* Please refer to the example in **https://github.com/prabhu-sunderaraman/ut-docker-k8s-2025/blob/main/demo-rest-api/src/test/java/com/indium/demorestapi/service/ProductServiceIntegrationTest.java**
* Create a spring boot rest api *lab06-movie-app* with the following dependencies(web, jpa, postgres, testcontainers, lombok)

* A few dependencies for your reference is given below

``` xml

	<dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
    </dependency>

    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <scope>test</scope>
    </dependency>

    <!-- Testcontainers for PostgreSQL -->
    <dependency>
        <groupId>org.testcontainers</groupId>
        <artifactId>postgresql</artifactId>
        <scope>test</scope>
    </dependency>
```

* Here's the structure of the application

```markdown
lab06-movie-app/
│── src/
│   ├── main/java/com/indium/lab06-movie-app/
│   │   ├── Movie.java
│   │   ├── MovieRepository.java
│   │   ├── MovieService.java
│   │   ├── MovieController.java
│   ├── test/java/com/example/movies/
│   │   ├── MovieServiceTest.java
|	|	|__ MovieControllerTest.java
│── pom.xml
│── application.yml

```

```java

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private int releaseYear;
}
```


```java

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
```


``` java

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}

```

``` java
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}

```

* Implement the integration tests **MovieServiceTest** and **MovieControllerTest**
* When you run the tests observe the docker desktop containers for postgres testcontainers getting created