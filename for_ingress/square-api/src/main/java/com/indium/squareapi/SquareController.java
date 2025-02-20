package com.indium.squareapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SquareController {
    @GetMapping("/square/{number}")
    public int squareNumber(@PathVariable int number) {
        return number * number;
    }
}
