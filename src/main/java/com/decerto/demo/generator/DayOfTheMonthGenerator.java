package com.decerto.demo.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Qualifier("date")
public class DayOfTheMonthGenerator implements DataGenerator<Integer> {

    private final LocalDate localDate;

    @Autowired
    public DayOfTheMonthGenerator(final LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public Integer generate() {
        return localDate.getDayOfMonth();
    }
}
