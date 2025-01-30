package com.indium.restapimoredocker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Value("${welcome.message}")
    private String welcomeMessage;

    @Value("${bye.message}")
    private String byeMessage;

    @GetMapping("/bye")
    public String bye() {
        return byeMessage;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return welcomeMessage;
    }
}
