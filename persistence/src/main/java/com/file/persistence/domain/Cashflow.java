package com.file.persistence.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "CASHFLOW")
@Table
@Getter
@Setter
public class Cashflow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;

    @Column(name = "TRANSACTION_DATE")
    private LocalDate transactionDate;

    @Column(name = "DEPOSIT_AMOUNT")
    private BigDecimal depositAmt;

    @Column(name = "CASHFLOW")
    private BigDecimal cashflow;

    public Cashflow(LocalDate transactionDate, BigDecimal depositAmt, BigDecimal cashflow) {
        this.transactionDate = transactionDate;
        this.depositAmt = depositAmt;
        this.cashflow = cashflow;
    }

    @Override
    public String toString() {
        return "Cashflow{" +
                "id='" + id + '\'' +
                ", transactionDate=" + transactionDate +
                ", depositAmt=" + depositAmt +
                ", cashflow=" + cashflow +
                '}';
    }
}
