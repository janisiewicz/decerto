package com.decerto.demo;

import com.decerto.demo.generator.RestGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RestGeneratorIT {

    @Autowired
    private RestGenerator generator;

    @Test
    public void restGeneratorShouldWorks() throws Exception {
        Integer result = generator.generate();
        assertTrue(result >= 0);
        assertTrue(result <= 100);
    }
}
