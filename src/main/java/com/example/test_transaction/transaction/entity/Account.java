package com.example.test_transaction.transaction.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(schema = "account")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "BALANCE")
    private Long balance;
}
