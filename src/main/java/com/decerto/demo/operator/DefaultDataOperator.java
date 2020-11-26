package com.decerto.demo.operator;

import org.springframework.stereotype.Component;

@Component
public class DefaultDataOperator implements DataOperator<Integer> {

    private final String CODE = "INT";

    @Override
    public Integer apply(Integer firstParameter, Integer secondParameter) {
        return firstParameter + secondParameter;
    }

    @Override
    public String getCode() {
        return CODE;
    }
}
