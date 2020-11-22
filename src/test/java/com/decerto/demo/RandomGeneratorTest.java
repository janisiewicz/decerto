package com.decerto.demo;

import com.decerto.demo.generator.RandomGenerator;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomGeneratorTest {

    private static final int MAX_VALUE = 33;

    @Test
    public void randomGeneratorShouldWorks() {
        //given
        RandomGenerator randomGenerator = new RandomGenerator(new DeterministicRandomGenerator(), MAX_VALUE);
        //when
        int result = randomGenerator.generate();
        //then
        assertEquals(result, MAX_VALUE);
    }


    private static class DeterministicRandomGenerator extends Random {

        public int nextInt(final int bound) {
            return MAX_VALUE;
        }
    }
}
