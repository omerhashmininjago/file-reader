package com.file.ingestion.service;

import com.file.parser.service.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class FileImportService {

    private final FileReader fileReader;

    @Autowired
    public FileImportService(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public void importFile(File file, String systemName) throws ClassNotFoundException, IOException {

        fileReader.read(file, systemName);
    }
}
