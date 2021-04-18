package com.example.test_transaction.transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionApplication {
	private static final Logger logger = LoggerFactory.getLogger(TransactionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}

}
