package com.cjaqo.batchmenuapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.cjaqo.batchmenuapp.components"})
@EntityScan("com.cjaqo.batchmenuapp.domain")
@EnableJpaRepositories("com.cjaqo.batchmenuapp.repository")
public class BatchmenuappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchmenuappApplication.class, args);
	}

}
