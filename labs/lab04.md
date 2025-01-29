## Lab 04
* Create a Spring boot Rest API say **lab04-api** with the following controller code

``` java
@RestController
public class WelcomeController {

    @GetMapping("/api/welcome")
    public Map<String, String> getWelcomeMessage() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to the Dockerized Spring Boot API!");
        return response;
    }
}
```

#### To Do

* Create a **Dockerfile** and bundle the application as an image say **lab04-api:1.0.0**
* Create a **docker-compose-dev.yml** file and configure two instances of lab04-api. Give appropriate port mappings
* Add a **healthcheck** section in **docker-compose-dev.yml**. Refer to **https://docs.docker.com/reference/compose-file/services/#healthcheck**

* Deploy them and start the containers

* Add the two instances to the same network and curl one instance from the other and check
