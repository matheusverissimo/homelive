package com.matheusverissimo.homelive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class HomeliveApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeliveApplication.class, args);
	}

}
