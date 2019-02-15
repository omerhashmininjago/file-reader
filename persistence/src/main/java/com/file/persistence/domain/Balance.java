package com.file.persistence.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "BALANCE")
@Table
@Getter
@Setter
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;

    @Column(name = "VALUE_DATE")
    private Date valueDate;

    @Column(name = "CHEQUE_NUMBER")
    private String chequeNumber;

    @Column(name = "TRANS_REMARKS")
    private String transRemarks;

    @Column(name = "BALANCE")
    private BigDecimal balance;

    public Balance(Date valueDate, String chequeNumber, String transRemarks, BigDecimal balance) {
        this.valueDate = valueDate;
        this.chequeNumber = chequeNumber;
        this.transRemarks = transRemarks;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "id='" + id + '\'' +
                ", valueDate='" + valueDate + '\'' +
                ", chequeNumber='" + chequeNumber + '\'' +
                ", transRemarks='" + transRemarks + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
