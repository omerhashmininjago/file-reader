package com.file.ingestion.config;


import com.file.parser.config.ConfigService;
import org.supercsv.cellprocessor.ift.CellProcessor;

import java.util.List;
import java.util.Map;

public class ConfigServiceImpl implements ConfigService {

    private Map<String, Map<String, CellProcessor>> cellProcessors;
    private Map<String, String> domains;
    private Map<String, List<String>> domainFields;

    public ConfigServiceImpl(){}

    public void setCellProcessors(Map<String, Map<String, CellProcessor>> columnValidators) {
        this.cellProcessors = columnValidators;
    }

    public void setDomainFields(Map<String, List<String>> domainFields) {
        this.domainFields = domainFields;
    }

    public void setDomains(Map<String, String> domains) {
        this.domains = domains;
    }

    public Map<String, Map<String, CellProcessor>> getCellProcessors() {
        return cellProcessors;
    }

    public Map<String, List<String>> getDomainFields() {
        return domainFields;
    }

    public Map<String, String> getDomains() {
        return domains;
    }
}
