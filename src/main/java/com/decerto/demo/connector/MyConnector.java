package com.decerto.demo.connector;

import com.decerto.demo.generator.DataGenerator;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BinaryOperator;

@Service
public class MyConnector implements DataConnector<Integer> {

    @Override
    public Optional<Integer> connect(BinaryOperator<Integer> operation, DataGenerator<Integer>... generators) {
        return Arrays.stream(generators)
                .map(DataGenerator::generate)
                .peek(i -> System.out.format("Generated value: %d%n", i))
                .reduce(operation);
    }
}
