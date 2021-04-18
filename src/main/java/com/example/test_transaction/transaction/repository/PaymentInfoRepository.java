package com.example.test_transaction.transaction.repository;

import com.example.test_transaction.transaction.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, Long> {
}
