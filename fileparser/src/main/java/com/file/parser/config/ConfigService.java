package com.file.parser.config;

import org.supercsv.cellprocessor.ift.CellProcessor;

import java.util.List;
import java.util.Map;

public interface ConfigService {

    Map<String, Map<String, CellProcessor>> getCellProcessors();
    Map<String, List<String>> getDomainFields();
    Map<String, String> getDomains();
}
