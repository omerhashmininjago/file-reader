package com.file.ingestion.service;

import com.file.parser.response.ImportResponse;
import com.file.persistence.repo.FileTransactionRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class FileService<T> {

    private static final Logger LOG = LoggerFactory.getLogger(FileService.class);

    private final FileLoadService fileLoadService;

    private final FileImportService fileImportService;

    private final FileTransactionRepo fileTransactionRepo;

    @Autowired
    public FileService(FileLoadService fileLoadService, FileImportService fileImportService, FileTransactionRepo fileTransactionRepo) {
        this.fileLoadService = fileLoadService;
        this.fileImportService = fileImportService;
        this.fileTransactionRepo = fileTransactionRepo;
    }

    public List<T> loadFile(String transactionType) throws ClassNotFoundException, IOException {
        File file = fileLoadService.loadFile(transactionType);
        return importFile(file, transactionType);
    }

    public List<T> importFile(File file, String transactionType) throws ClassNotFoundException, IOException {
        ImportResponse<T> importResponse = fileImportService.importFile(file, transactionType);

        return fileTransactionRepo.saveAll(importResponse.getDomainObjectList());
        // TransactionTypeFactory.getRepo(TransactionType.valueOf(transactionType)).saveAll(importResponse.getDomainObjectList());
    }
}
