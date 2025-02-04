package com.indium.demoutkafka;

import org.springframework.boot.SpringApplication;

public class TestDemoUtKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.from(DemoUtKafkaApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
