package com.devstack.productserviceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class ProductServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApiApplication.class, args);
	}

}
