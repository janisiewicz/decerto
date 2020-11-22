package com.decerto.demo.connector;

import com.decerto.demo.generator.DataGenerator;

import java.util.Optional;
import java.util.function.BinaryOperator;

public interface DataConnector<T> {

    Optional<T> connect(BinaryOperator<T> operation, DataGenerator<T>... generators);
}
