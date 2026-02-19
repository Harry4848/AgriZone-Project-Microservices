package com.dealerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DealerserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DealerserviceApplication.class, args);
	}

}
