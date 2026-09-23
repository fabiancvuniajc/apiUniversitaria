package com.example.apiuniversitaria.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.apiuniversitaria.repositories")
@EntityScan("com.example.apiuniversitaria.repositories.entities")
@ComponentScan("com.example.apiuniversitaria")
public class ApiUniversitariaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiUniversitariaApplication.class, args);
    }

}
