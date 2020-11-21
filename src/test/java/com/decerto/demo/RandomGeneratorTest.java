package com.decerto.demo;

import com.decerto.demo.generator.RandomGenerator;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomGeneratorTest {

    private static int MAX_VALUE = 33;

    @Test
    public void randomGeneratorShouldWorks() throws Exception {
        //given
        RandomGenerator randomGenerator = new RandomGenerator(new DeterministicRandomGenerator(MAX_VALUE));
        //when
        int result = randomGenerator.generate();
        //then
        assertEquals(result, MAX_VALUE);
    }


    private class DeterministicRandomGenerator extends Random {

        private final int maxValue;

        private DeterministicRandomGenerator(int maxValue) {
            this.maxValue = maxValue;
        }

        public int nextInt(final int bound) {
            return maxValue;
        }
    }
}
