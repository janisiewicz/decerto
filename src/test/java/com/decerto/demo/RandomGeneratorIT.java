package com.decerto.demo;

import com.decerto.demo.generator.RandomGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RandomGeneratorIT {

    @Autowired
    private RandomGenerator generator;

    @Test
    public void randomGeneratorShouldWorks() throws Exception {
        //when
        int result = generator.generate();
        //then
        assertTrue(result >= 0);
        assertTrue(result < 10);
    }
}
