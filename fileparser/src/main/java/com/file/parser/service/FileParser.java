package com.file.parser.service;

import com.file.parser.response.ImportResponse;

import java.io.FileReader;

public interface FileParser {

    ImportResponse read(FileReader fileReader, String systemName, String statementType) throws Exception;
}
