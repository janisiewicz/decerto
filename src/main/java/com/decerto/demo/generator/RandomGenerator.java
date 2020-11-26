package com.decerto.demo.generator;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomGenerator extends AbstractGenerator implements DataGenerator<Integer> {

    private final static String CODE = "RND";
    private final Random random;
    private final Integer maxValue;

    public RandomGenerator(final Random random, final Integer maxValue) {
        super(CODE);
        this.random = random;
        this.maxValue = maxValue;
    }

    @Override
    public Integer generate() {
        return random.nextInt(maxValue);
    }
}
