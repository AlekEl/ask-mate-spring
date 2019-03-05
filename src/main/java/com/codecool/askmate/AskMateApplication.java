package com.codecool.askmate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AskMateApplication {

    public static void main(String[] args) {
        SpringApplication.run(AskMateApplication.class, args);
    }

}
