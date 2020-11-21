package com.decerto.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Random;

@Configuration
public class MyConfiguration {

    @Bean
    public Random createRandom() {
        return new Random();
    }

    @Bean
    public LocalDate createLocalDate() {
        return LocalDate.now();
    }
}
