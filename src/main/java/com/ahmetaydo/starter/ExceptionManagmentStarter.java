package com.ahmetaydo.starter;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EntityScan(basePackages = {"com.ahmetaydo"})
@EnableJpaRepositories(basePackages = {"com.ahmetaydo"})
@ComponentScan(basePackages = {"com.ahmetaydo"})
@SpringBootApplication
@EnableScheduling
public class ExceptionManagmentStarter {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionManagmentStarter.class, args);
	}

}
