package com.example.test_transaction.transaction.repository;

import com.example.test_transaction.transaction.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
