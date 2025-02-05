package com.indium.demoutkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/send/{message}")
    public String sendMessage(@PathVariable String message) {
        kafkaTemplate.send("myTopic", message);
        return "Message sent to the Kafka Topic myTopic Successfully";
    }
}
