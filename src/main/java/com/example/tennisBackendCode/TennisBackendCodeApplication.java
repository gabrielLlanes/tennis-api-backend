package com.example.tennisBackendCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class TennisBackendCodeApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(TennisBackendCodeApplication.class);

	@Autowired
	private Environment env;

	@Override
	public void run(String... args) throws Exception {
		logger.info("{}", env.getProperty("spring.datasource.username"));
		logger.info(System.getenv("TEMP"));
	}

	public static void main(String[] args) {
		SpringApplication.run(TennisBackendCodeApplication.class, args);
	}

}
