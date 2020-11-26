package com.decerto.demo.connector;

import com.decerto.demo.configuration.GeneratorConfiguration;
import com.decerto.demo.generator.DataGenerator;
import com.decerto.demo.operator.DataOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class SimpleDataConnector implements DataConnector<Integer> {

    @Value("${operator}")
    private String operator;

    private final String CODE =  "INT";

    private final GeneratorConfiguration generatorConfiguration;

    public SimpleDataConnector(GeneratorConfiguration generatorConfiguration) {
        this.generatorConfiguration = generatorConfiguration;
    }

    @Override
    public Optional<Integer> connect(List<DataOperator<Integer>> dataOperatorList, List<DataGenerator<Integer>> generators) {

        Optional<DataOperator<Integer>> dataOperator = dataOperatorList
                .stream()
                .filter(op -> op.getCode().equals(operator))
                .findAny();

        return dataOperator
                .flatMap(integerDataOperator -> generators.stream()
                .filter(g -> generatorConfiguration.getGenerators().contains(g.getCode()))
                .map(DataGenerator::generate)
                .peek(i -> log.info("Generated value: {}", i))
                .reduce(integerDataOperator));
    }

    @Override
    public String getCode() {
        return CODE;
    }
}
