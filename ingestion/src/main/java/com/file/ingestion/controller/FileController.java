package com.file.ingestion.controller;

import com.file.ingestion.filter.FileFilter;
import com.file.ingestion.filter.FileImportFilter;
import com.file.ingestion.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
public class FileController {

    private static final Logger LOG = LoggerFactory.getLogger(FileController.class);

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileLoadService) {
        this.fileService = fileLoadService;
    }

    @PostMapping(value = "/importFile/")
    public void importFile(@NotNull @RequestBody FileImportFilter fileImportFilter) {

        fileService.importFile(fileImportFilter.getMultipartFile(), fileImportFilter.getSystemName(), fileImportFilter.getStatementType());
    }

    @PostMapping(value = "/loadFile/")
    public void loadFile(@NotNull @RequestBody FileFilter fileFilter) {

        fileService.loadFile(fileFilter.getSystemName(), fileFilter.getStatementType());
    }
}
