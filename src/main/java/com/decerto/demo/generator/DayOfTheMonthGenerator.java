package com.decerto.demo.generator;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DayOfTheMonthGenerator extends AbstractGenerator implements DataGenerator<Integer> {

    private final static String CODE = "MTH";
    private final LocalDate localDate;

    public DayOfTheMonthGenerator(final LocalDate localDate) {
        super(CODE);
        this.localDate = localDate;
    }

    @Override
    public Integer generate() {
        return localDate.getDayOfMonth();
    }
}
