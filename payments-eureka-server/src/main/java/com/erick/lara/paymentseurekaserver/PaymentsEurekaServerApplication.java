package com.erick.lara.paymentseurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PaymentsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentsEurekaServerApplication.class, args);
	}

}
