package com.statistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.statistics.client.LibraryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(clients = LibraryClient.class)
public class LibraryStatisticsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryStatisticsServiceApplication.class, args);
	}

}
