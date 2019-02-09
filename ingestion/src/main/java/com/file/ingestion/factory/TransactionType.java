package com.file.ingestion.factory;

import static java.util.Objects.requireNonNull;

/**
 * Using enum for representing a Factory
 * <p>
 * This ensures the code is cleaner as it avoids if and switch statements in the code
 * <p>
 * Other alternative ways are to use Reflection and an Unmodifiable Map
 */
public enum TransactionType {

    BALANCE("balance.csv"),
    CASHFLOW("cashflow.csv");

    private final String filePath;

    TransactionType(String filePath) {
        this.filePath = requireNonNull(filePath);
    }

    public String getFilePath() {
        return filePath;
    }

}