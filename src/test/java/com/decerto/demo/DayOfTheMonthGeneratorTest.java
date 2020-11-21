package com.decerto.demo;

import com.decerto.demo.generator.DayOfTheMonthGenerator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DayOfTheMonthGeneratorTest {

    private final static LocalDate LOCAL_DATE = LocalDate.of(2001, 01, 15);
    private final static int DAY_OF_THE_MONTH = 15;
    private final static int FIRST_DAY = 1;
    private final static int LAST_DAY = 31;

    @Test
    public void dayOfTheMonthShouldBePositiveNumber() throws Exception {
        //given
        DayOfTheMonthGenerator dayOfTheMonthGenerator = new DayOfTheMonthGenerator(LocalDate.now());
        //when
        int result = dayOfTheMonthGenerator.generate();
        //then
        assertTrue(result >= FIRST_DAY);
        assertTrue(result <= LAST_DAY);
    }

    @Test
    public void dayOfTheMonthShouldWorks() throws Exception {
        //given
        DayOfTheMonthGenerator dayOfTheMonthGenerator = new DayOfTheMonthGenerator(LOCAL_DATE);
        //when
        int result = dayOfTheMonthGenerator.generate();
        //then
        assertEquals(result, DAY_OF_THE_MONTH);
    }

}
