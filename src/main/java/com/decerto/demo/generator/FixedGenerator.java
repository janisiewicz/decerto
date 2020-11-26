package com.decerto.demo.generator;

import org.springframework.stereotype.Component;

@Component
public class FixedGenerator extends AbstractGenerator implements DataGenerator<String> {

    private final static String CODE = "FIX";
    private final static String VALUE = "333";

    public FixedGenerator() {
        super(CODE);
    }

    @Override
    public String generate() {
        return VALUE;
    }
}
