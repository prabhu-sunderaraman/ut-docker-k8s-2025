package com.indium.restapifork8s;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${DB_PASSWORD:Default Password}")
    private String dbPassword;

    @Value("${welcome.message}")
    private String welcomeMessage;

    @Value("${greetings:Default Hello}")
    private String greetingsMessage;

    @GetMapping("/dbpassword")
    public String dbPassword() {
        return dbPassword;
    }

    @GetMapping("/greetings")
    public String greetings() {
        return greetingsMessage;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return welcomeMessage;
    }


    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
}
