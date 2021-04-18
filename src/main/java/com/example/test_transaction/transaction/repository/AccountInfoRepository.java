package com.example.test_transaction.transaction.repository;

import com.example.test_transaction.transaction.entity.AccountInfo;
import org.springframework.data.repository.CrudRepository;

public interface AccountInfoRepository extends CrudRepository<AccountInfo, Long> {

}
