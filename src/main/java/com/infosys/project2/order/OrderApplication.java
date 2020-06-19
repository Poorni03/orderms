package com.infosys.project2.order;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderApplication {
		public static void main(String[] args) {
			System.out.println("before controller");
			SpringApplication.run(OrderApplication.class, args);
			System.out.println("after controller");
			
		}
	}



