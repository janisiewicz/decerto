package com.decerto.demo.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Qualifier("random")
public class RandomGenerator implements DataGenerator<Integer> {

    private final Random random;
    private final Integer maxValue;

    @Autowired
    public RandomGenerator(Random random, Integer maxValue) {
        this.random = random;
        this.maxValue = maxValue;
    }

    @Override
    public Integer generate() {
        return random.nextInt(maxValue);
    }
}
