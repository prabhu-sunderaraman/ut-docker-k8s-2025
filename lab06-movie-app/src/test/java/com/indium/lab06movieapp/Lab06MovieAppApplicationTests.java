package com.indium.lab06movieapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class Lab06MovieAppApplicationTests {

    @Test
    void contextLoads() {
    }

}
