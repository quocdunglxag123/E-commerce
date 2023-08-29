package com.ecommerce.storesystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.ecommerce.storesystem")
@EntityScan(basePackages = { "com.ecommerce.storesystem" })
@EnableJpaAuditing
public class StoreSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreSystemApplication.class, args);
	}

}
