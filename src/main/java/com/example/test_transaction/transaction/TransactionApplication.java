package com.example.test_transaction.transaction;

import com.example.test_transaction.transaction.entity.Account;
import com.example.test_transaction.transaction.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TransactionApplication {
	private static final Logger logger = LoggerFactory.getLogger(TransactionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}

/*	@Bean
	public CommandLineRunner loadData(AccountService accountService) {
		return (args) -> {
			accountService.createAccount(new Account(1L, 100L));
			accountService.createAccount(new Account(2L, 200L));
			accountService.createAccount(new Account(3L, 300L));
			logger.info("find all");
			accountService.accounts().forEach(System.out::println);
			logger.info("find by id (1)");
			var result = accountService.findAccountById(1L).toString();
			logger.info(result);
			logger.info(result.toString());
		};
	}*/
}
