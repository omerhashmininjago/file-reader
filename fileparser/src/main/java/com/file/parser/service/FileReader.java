package com.file.parser.service;

import com.file.parser.response.ImportResponse;

import java.io.File;

public interface FileReader {

    ImportResponse read(File file, String sourceSystem, String stmtType) throws Exception;
}
