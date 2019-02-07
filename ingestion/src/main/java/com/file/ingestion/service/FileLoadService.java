package com.file.ingestion.service;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FileLoadService {

    public File loadFile() {
        return new File("C:\\OpTransactionHistory27-02-2016.csv");
    }

}
