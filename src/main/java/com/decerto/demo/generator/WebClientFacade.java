package com.decerto.demo.generator;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientFacade {

    public String getResponse(final String uri) {
        WebClient webClient = createWebClient(uri);

        return webClient
                .get()
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    private WebClient createWebClient(final String uri) {
        return WebClient
                .builder()
                .baseUrl(uri)
                .build();
    }
}
