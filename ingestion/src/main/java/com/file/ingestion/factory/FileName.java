package com.file.ingestion.factory;

import static java.util.Objects.requireNonNull;

/**
 * Using enum for representing a Factory
 *
 * This ensures the code is cleaner as it avoids if and switch statements in the code
 *
 * Other alternative ways are to use Reflection and an Unmodifiable Map
 */
public enum FileName {

    BALANCE("balance.csv"),
    CASHFLOW("cashflow.csv");

    private final String filePath;

    FileName(String filePath) {
        this.filePath = requireNonNull(filePath);
    }

    public String getFilePath() {
        return filePath;
    }

}