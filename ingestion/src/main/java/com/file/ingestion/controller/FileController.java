package com.file.ingestion.controller;

import com.file.ingestion.error.exception.TransactionTypeInvalidException;
import com.file.ingestion.factory.FileName;
import com.file.ingestion.filter.FileImportFilter;
import com.file.ingestion.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

import java.io.IOException;

import static org.apache.commons.lang3.EnumUtils.isValidEnum;

@RestController
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileLoadService) {
        this.fileService = fileLoadService;
    }

    @PostMapping(value = "/importFile/")
    public void importFile(@NotNull @RequestBody FileImportFilter fileImportFilter) {

        validateTransactionType(fileImportFilter.getTransactionType());
        fileService.importFile(fileImportFilter.getMultipartFile(), fileImportFilter.getTransactionType());
    }

    @PostMapping(value = "/loadFile/")
    public void loadFile(@NotNull @RequestParam String transactionType) throws TransactionTypeInvalidException, ClassNotFoundException, IOException {

        validateTransactionType(transactionType);
        fileService.loadFile(transactionType);
    }

    private void validateTransactionType(String transactionType) {

        if (!isValidEnum(FileName.class, transactionType.toUpperCase())) {
            throw new TransactionTypeInvalidException("Transaction Type is invalid, please provide a valid value");
        }
    }
}
