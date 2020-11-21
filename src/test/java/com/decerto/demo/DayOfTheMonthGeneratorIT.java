package com.decerto.demo;

import com.decerto.demo.generator.DataGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DayOfTheMonthGeneratorIT {

    @Autowired
    @Qualifier("date")
    private DataGenerator<Integer> generator;

    @Test
    public void dayOfTheMonthShouldWorks() throws Exception {
        //when
        Integer result = generator.generate();
        //then
        assertTrue(result >= 1);
        assertTrue(result <= 31);
    }
}
