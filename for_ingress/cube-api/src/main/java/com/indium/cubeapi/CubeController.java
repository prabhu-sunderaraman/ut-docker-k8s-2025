package com.indium.cubeapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CubeController {
    @GetMapping("/cube/{number}")
    public int cubeNumber(@PathVariable int number) {
        return number * number * number;
    }
}
