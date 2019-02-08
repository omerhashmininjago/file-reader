package com.file.ingestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class FileService {

    private final FileLoadService fileLoadService;

    private final FileImportService fileImportService;

    @Autowired
    public FileService(FileLoadService fileLoadService, FileImportService fileImportService) {
        this.fileLoadService = fileLoadService;
        this.fileImportService = fileImportService;
    }

    public void loadFile(String transactionType) throws ClassNotFoundException, IOException {
        File file = fileLoadService.loadFile(transactionType);
        importFile(file, transactionType);
    }

    public void importFile(File file, String transactionType) throws ClassNotFoundException, IOException {
        fileImportService.importFile(file, transactionType);
    }
}
