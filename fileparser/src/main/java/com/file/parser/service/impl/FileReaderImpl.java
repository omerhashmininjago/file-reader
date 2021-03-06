package com.file.parser.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import com.file.parser.response.ImportResponse;
import com.file.parser.service.FileParser;
import com.file.parser.service.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

public class FileReaderImpl<T> implements FileReader<T> {

    private Map<String, FileParser> fileParsers;

    public ImportResponse<T> read(File file, String transactionType) throws ClassNotFoundException, IOException {

        String fileName = file.getName();
        FileParser fileParser = fileParsers.get(getFileExtn(fileName));

        java.io.FileReader fileReader = new java.io.FileReader(file);
        return fileParser.read(fileReader, transactionType);
    }

    private String getFileExtn(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    public Map<String, FileParser> getFileParsers() {
        return fileParsers;
    }

    public void setFileParsers(Map<String, FileParser> fileParsers) {
        this.fileParsers = fileParsers;
    }
}
