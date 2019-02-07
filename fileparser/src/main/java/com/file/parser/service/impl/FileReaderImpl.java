package com.file.parser.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

import com.file.parser.response.ImportResponse;
import com.file.parser.service.FileParser;
import com.file.parser.service.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FileReaderImpl implements FileReader {

    private Map<String, FileParser> fileParsers;

    public ImportResponse read(File file, String sourceSystem, String stmtType) throws Exception {

        String fileName = file.getName();
        FileParser fileParser = fileParsers.get(getFileExtn(fileName));

        java.io.FileReader fileReader = new java.io.FileReader(file);
        return fileParser.read(fileReader, sourceSystem, stmtType);
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
