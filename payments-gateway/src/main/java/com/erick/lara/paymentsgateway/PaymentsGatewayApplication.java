package com.erick.lara.paymentsgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentsGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentsGatewayApplication.class, args);
	}

}
