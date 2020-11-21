package com.decerto.demo.generator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Qualifier("rest")
public class RestGenerator implements DataGenerator<Integer> {

    @Value("${rest.uri}")
    private String uri;

    @Override
    public Integer generate() {

        String result = WebClient
                .builder()
                .baseUrl(uri)
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class)
                .block()
                .trim();
        return Integer.valueOf(result);
    }
}
