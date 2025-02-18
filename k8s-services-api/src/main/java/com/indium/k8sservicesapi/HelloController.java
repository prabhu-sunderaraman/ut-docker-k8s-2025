package com.indium.k8sservicesapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        //get the hostname and podname
        String message = "Hello from K8s Services API - Host: " +
                System.getenv().getOrDefault("HOSTNAME", "unknown host") +
                ", Pod: " +
                System.getenv().getOrDefault("POD_NAME", "unknown pod");
        return message;
    }
}
