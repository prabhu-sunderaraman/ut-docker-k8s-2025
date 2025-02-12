package com.indium.restapifork8s;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping("/welcome")
    public String welcome() {
        return welcomeMessage;
    }


    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
}
