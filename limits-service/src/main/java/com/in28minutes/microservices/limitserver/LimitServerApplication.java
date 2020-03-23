package com.in28minutes.microservices.limitserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class LimitServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitServerApplication.class, args);
	}

}
