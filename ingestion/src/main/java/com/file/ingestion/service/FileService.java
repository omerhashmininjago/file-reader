package com.file.ingestion.service;

import com.file.ingestion.filter.FileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FilterInputStream;

@Service
public class FileService {

    private final FileLoadService fileLoadService;

    private final FileImportService fileImportService;

    @Autowired
    public FileService(FileLoadService fileLoadService, FileImportService fileImportService) {
        this.fileLoadService = fileLoadService;
        this.fileImportService = fileImportService;
    }

    public void loadFile(String systemName, String statementType) throws Exception {
        File file = fileLoadService.loadFile();
        importFile(file, systemName, statementType);
    }

    public void importFile(File file, String systemName, String statementType) throws Exception {
        fileImportService.importFile(file, systemName, statementType);
    }
}
