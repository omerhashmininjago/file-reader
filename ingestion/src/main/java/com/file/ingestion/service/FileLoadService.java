package com.file.ingestion.service;

import org.springframework.stereotype.Service;

import java.io.File;

import static com.file.ingestion.factory.TransactionType.valueOf;

@Service
public class FileLoadService {

    public File loadFile(String transactionType) {

        String filePath = valueOf(transactionType.toUpperCase()).getFilePath();
        return new File(Thread.currentThread().getContextClassLoader().getResource(filePath).getFile());
    }

}
