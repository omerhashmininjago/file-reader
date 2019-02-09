package com.file.ingestion.controller;

import com.file.ingestion.domain.TransactionResponse;
import com.file.ingestion.error.exception.TransactionTypeInvalidException;
import com.file.ingestion.factory.TransactionType;
import com.file.ingestion.filter.FileImportFilter;
import com.file.ingestion.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.apache.commons.lang3.EnumUtils.isValidEnum;

@RestController
public class FileController<T> {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileLoadService) {
        this.fileService = fileLoadService;
    }

    @PostMapping(value = "/importFile/")
    public TransactionResponse<T> importFile(@NotNull @RequestBody FileImportFilter fileImportFilter) throws IOException, ClassNotFoundException {

        String transactionType = fileImportFilter.getTransactionType();
        MultipartFile importedFile = fileImportFilter.getMultipartFile();
        validateTransactionType(transactionType);
        File importingFile = new File(importedFile.getOriginalFilename());
        importedFile.transferTo(importingFile);
        List<T> persistedTransactions = fileService.importFile(importingFile, transactionType);

        return new TransactionResponse(HttpStatus.OK, persistedTransactions, transactionType);
    }

    @PostMapping(value = "/loadFile/")
    public TransactionResponse<T> loadFile(@NotNull @RequestParam String transactionType) throws TransactionTypeInvalidException, ClassNotFoundException, IOException {

        validateTransactionType(transactionType);
        List<T> persistedTransactions = fileService.loadFile(transactionType);
        return new TransactionResponse<>(HttpStatus.OK, persistedTransactions, transactionType);
    }

    private void validateTransactionType(String transactionType) {

        if (!isValidEnum(TransactionType.class, transactionType.toUpperCase())) {
            throw new TransactionTypeInvalidException("Transaction Type is invalid, please provide a valid value");
        }
    }
}
