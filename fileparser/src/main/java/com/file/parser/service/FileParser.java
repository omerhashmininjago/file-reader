package com.file.parser.service;

import com.file.parser.response.ImportResponse;

import java.io.FileReader;
import java.io.IOException;

public interface FileParser {

    ImportResponse read(FileReader fileReader, String transactionType) throws ClassNotFoundException, IOException;
}
