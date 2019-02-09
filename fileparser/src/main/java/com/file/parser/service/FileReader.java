package com.file.parser.service;

import com.file.parser.response.ImportResponse;

import java.io.File;
import java.io.IOException;

public interface FileReader<T> {

    ImportResponse<T> read(File file, String transactionType) throws ClassNotFoundException, IOException;
}
