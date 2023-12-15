package com.devstack.placeorderserviceapo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class PlaceOrderServiceApoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaceOrderServiceApoApplication.class, args);
	}

}
