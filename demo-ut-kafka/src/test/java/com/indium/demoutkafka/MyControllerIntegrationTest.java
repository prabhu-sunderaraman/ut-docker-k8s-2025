package com.indium.demoutkafka;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.kafka.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyControllerIntegrationTest {
    @LocalServerPort
    private int randomServerPort;

    static final KafkaContainer kafka = new KafkaContainer(
            DockerImageName.parse("apache/kafka-native:latest")//.asCompatibleSubstituteFor("apache/kafka")
    );

    @BeforeAll
    public static void setup() {
        kafka.start();
    }

    @AfterAll
    public static void tearDown() {
        kafka.stop();
    }

    @DynamicPropertySource
    static void overrideProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.kafka.bootstrap-servers", kafka::getBootstrapServers);
    }

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void add_two_numbers() {
        String url = "http://localhost:" + randomServerPort + "/send/hello";
        ResponseEntity<String> responseEntity = testRestTemplate.postForEntity(url, null, String.class);
        String response = responseEntity.getBody();
        assertEquals(response, "Message sent to the Kafka Topic myTopic Successfully");
    }
}
