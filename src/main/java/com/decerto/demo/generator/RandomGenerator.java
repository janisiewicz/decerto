package com.decerto.demo.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Qualifier("random")
public class RandomGenerator implements DataGenerator<Integer> {

    private final Random random;

    @Value("${random.max}")
    private int maxValue;

    @Autowired
    public RandomGenerator(Random random) {
        this.random = random;
    }

    @Override
    public Integer generate() {
        return random.nextInt(maxValue);
    }
}
