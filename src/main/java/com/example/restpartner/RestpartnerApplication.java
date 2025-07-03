package com.example.restpartner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RestpartnerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestpartnerApplication.class, args);
    }

}
