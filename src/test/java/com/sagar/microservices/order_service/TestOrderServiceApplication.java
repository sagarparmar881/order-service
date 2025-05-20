package com.sagar.microservices.order;

import com.sagar.microservices.order.OrderServiceApplication;
import org.springframework.boot.SpringApplication;

public class TestOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(OrderServiceApplication::main).with(com.sagar.microservices.order.TestcontainersConfiguration.class).run(args);
	}

}
