package com.file.parser.service.impl;

import com.file.parser.config.ConfigService;
import com.file.parser.response.ImportResponse;
import com.file.parser.service.FileParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class GenericFileParser implements FileParser {

    private final ConfigService configService;

    @Autowired
    public GenericFileParser(ConfigService configService) {
        this.configService = configService;
    }

    public ImportResponse read(FileReader fileReader, final String transactionType) throws ClassNotFoundException, IOException {

        Class targetClass = getTargetClass(transactionType);
        CellProcessor[] cellProcessors = getCellProcessors(transactionType);
        String[] fieldsInTargetClass = getFieldsInTargetClass(transactionType);

        ICsvBeanReader beanReader = new CsvBeanReader(fileReader, getPreference());

        ImportResponse response = new ImportResponse();
        beanReader.getHeader(true);

        Object domainObj;
        List<Object> domainObjectList = new ArrayList<Object>();

        do {
            domainObj = beanReader.read(targetClass, fieldsInTargetClass, cellProcessors);

            if (domainObj != null) {
                domainObjectList.add(domainObj);
            }

        } while (domainObj != null);

        response.setDomainObjectList(domainObjectList);
        return response;
    }

    public CsvPreference getPreference() {
        return CsvPreference.STANDARD_PREFERENCE;
    }

    private Class getTargetClass(final String transactionType) throws ClassNotFoundException {

        String domainClass = configService.getDomains().get(transactionType + "_domain");
        return Class.forName(domainClass);
    }

    private CellProcessor[] getCellProcessors(final String transactionType) {

        Map<String, CellProcessor> cellProcessors = configService.getCellProcessors()
                .get(transactionType + "_cellProcessors");

        Collection<CellProcessor> cellProcessorList = cellProcessors.values();

        return cellProcessorList.toArray(new CellProcessorAdaptor[]{});
    }

    private String[] getFieldsInTargetClass(final String transactionType) {
        List<String> fields = configService.getDomainFields().get(transactionType + "_class_attributes");
        return fields.toArray(new String[]{});
    }
}
