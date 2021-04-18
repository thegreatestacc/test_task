package com.example.test_transaction.transaction.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment_info")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "paymentid")
    private Long paymentId;
    @Column(name = "accountid")
    private Long accountId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "paymentdate")
    private Date paymentDate;
    private Long amount;
}
