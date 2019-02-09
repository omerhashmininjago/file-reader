package com.file.ingestion.domain;

import com.file.ingestion.factory.TransactionType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class TransactionResponse<T> extends ResponseEntity {

    @NotNull
    private List<T> transactionList;

    private int count;

    @NotNull
    private TransactionType transactionType;

    public TransactionResponse(HttpStatus status, @NotNull List<T> transactionList, @NotNull String transactionType) {
        super(status);
        this.transactionList = transactionList;
        this.count = transactionList.size();
        this.transactionType = TransactionType.valueOf(transactionType);
    }
}
