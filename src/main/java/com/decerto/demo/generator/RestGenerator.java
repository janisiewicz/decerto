package com.decerto.demo.generator;

import org.springframework.stereotype.Component;

@Component
public class RestGenerator extends AbstractGenerator implements DataGenerator<Integer> {

    private final static String CODE = "RST";
    private final String uri;
    private final WebClientFacade webClientFacade;

    public RestGenerator(String uri, WebClientFacade webClientFacade) {
        super(CODE);
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
