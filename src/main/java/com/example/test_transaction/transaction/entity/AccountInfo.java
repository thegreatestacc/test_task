package com.example.test_transaction.transaction.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "account_info")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "BALANCE")
    private BigDecimal balance;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "accountid")
    private List<PaymentInfo> paymentInfoList;
}
