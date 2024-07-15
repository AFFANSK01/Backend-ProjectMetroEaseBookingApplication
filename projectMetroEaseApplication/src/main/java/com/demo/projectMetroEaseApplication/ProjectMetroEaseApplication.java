package com.demo.projectMetroEaseApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.demo.projectMetroEaseApplication","com.model", "com.dao","com.exception", "com.service","com.controller"})
@EntityScan("com.model")
@EnableJpaRepositories("com.dao")
public class ProjectMetroEaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectMetroEaseApplication.class, args);
	}

}
