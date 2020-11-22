package com.decerto.demo.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("rest")
public class RestGenerator implements DataGenerator<Integer> {

    private final String uri;
    private final WebClientFacade webClientFacade;

    @Autowired
    public RestGenerator(String uri, WebClientFacade webClientFacade) {
        this.uri = uri;
        this.webClientFacade = webClientFacade;
    }

    @Override
    public Integer generate() {
        String response = webClientFacade.getResponse(uri);
        return convertToInt(response);
    }

    private Integer convertToInt(String response) {
        if(response != null) {
            response = response.trim();
            return Integer.valueOf(response);
        } else return 0;
    }
}
