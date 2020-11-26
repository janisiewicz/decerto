package com.decerto.demo.connector;

import com.decerto.demo.generator.DataGenerator;
import com.decerto.demo.operator.DataOperator;

import java.util.List;
import java.util.Optional;

public interface DataConnector<T> {

    Optional<T> connect(List<DataOperator<T>> dataOperatorList, List<DataGenerator<T>> generators);
    String getCode();
}
