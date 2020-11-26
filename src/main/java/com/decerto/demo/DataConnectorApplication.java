package com.decerto.demo;

import com.decerto.demo.connector.DataConnector;
import com.decerto.demo.generator.DataGenerator;
import com.decerto.demo.operator.DataOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@Slf4j
@SpringBootApplication
public class DataConnectorApplication implements CommandLineRunner {

	@Value("${connector}")
	private String connector;

	private final List<DataConnector> dataConnectorList;
	private final List<DataOperator> dataOperatorList;
	private final List<DataGenerator> dataGeneratorList;

	public DataConnectorApplication(
			List<DataConnector> dataConnectorList,
			List<DataOperator> dataOperatorList,
			List<DataGenerator> dataGeneratorList) {
		this.dataConnectorList = dataConnectorList;
		this.dataOperatorList = dataOperatorList;
		this.dataGeneratorList = dataGeneratorList;
	}

	public static void main(String[] args) {
		SpringApplication.run(DataConnectorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Optional<DataConnector> dataConnector = dataConnectorList
				.stream()
				.filter(dc -> dc.getCode().equals(connector))
				.findAny();

		dataConnector.ifPresent(dc -> {
			Optional result = dc.connect(dataOperatorList, dataGeneratorList);
			result.ifPresent(res -> {
				log.info("Final result: {}", res);
			});
		});
	}
}
