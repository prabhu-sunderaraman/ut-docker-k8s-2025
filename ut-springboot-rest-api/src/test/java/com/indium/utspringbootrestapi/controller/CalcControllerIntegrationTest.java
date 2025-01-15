package com.indium.utspringbootrestapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

//Postman testing
//Written after the development
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalcControllerIntegrationTest {
    @LocalServerPort
    private int randomServerPort;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void add_two_numbers() {
        String url = "http://localhost:" + randomServerPort + "/calc/sum/12/12";
        ResponseEntity<Integer> responseEntity = testRestTemplate.getForEntity(url, Integer.class);
        int sum = responseEntity.getBody();
        assertEquals(sum, 24);
    }
}
