package com.decerto.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Random;

@Configuration
public class DefaultConfiguration {

    @Value("${rest.uri}")
    private String uri;

    @Value("${random.max}")
    private Integer maxValue;

    @Bean
    public String createUri() {
        return uri;
    }

    @Bean
    public Integer createMaxValue() {
        return maxValue;
    }

    @Bean
    public Random createRandom() {
        return new Random();
    }

    @Bean
    public LocalDate createLocalDate() {
        return LocalDate.now();
    }
}
