package com.file.ingestion.service;

import com.file.parser.response.ImportResponse;
import com.file.parser.service.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class FileImportService<T> {

    private final FileReader fileReader;

    @Autowired
    public FileImportService(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public ImportResponse<T> importFile(File file, String transactionType) throws ClassNotFoundException, IOException {

        return fileReader.read(file, transactionType);
    }
}
