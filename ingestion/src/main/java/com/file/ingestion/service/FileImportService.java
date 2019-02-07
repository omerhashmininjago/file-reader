package com.file.ingestion.service;

import com.file.ingestion.config.ConfigServiceImpl;
import com.file.parser.config.ConfigService;
import com.file.parser.service.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FileImportService {

    private final FileReader fileReader;

    @Autowired
    public FileImportService(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public void importFile(File file, String systemName, String statementType) throws Exception {

        fileReader.read(file, systemName, statementType);
    }
}
