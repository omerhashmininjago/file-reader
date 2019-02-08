package com.file.ingestion.service;

import static com.file.ingestion.factory.FileName.valueOf;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FileLoadService {

    public File loadFile(String transactionType) {

        String filePath = valueOf(transactionType.toUpperCase()).getFilePath();
        return new File(Thread.currentThread().getContextClassLoader().getResource(filePath).getFile());
    }

}
