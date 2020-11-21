package com.decerto.demo;

import com.decerto.demo.connector.DataConnector;
import com.decerto.demo.generator.DataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("random")
	private DataGenerator<Integer> randomGenerator;

	@Autowired
	@Qualifier("rest")
	private DataGenerator<Integer> restGenerator;

	@Autowired
	@Qualifier("date")
	private DataGenerator<Integer> dayOfTheMonthGenerator;

	@Autowired
	private DataConnector<Integer> myConnector;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Optional<Integer> result = myConnector.connect(
				Integer::sum,
				randomGenerator,
				dayOfTheMonthGenerator,
				restGenerator);

		System.out.println(result.get());
	}
}
