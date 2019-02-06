package com.file.parser.service.impl;

import com.file.parser.config.ConfigService;
import com.file.parser.response.ImportResponse;
import com.file.parser.service.FileParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class GenericFileParser implements FileParser {

    private static final Logger LOG = LoggerFactory.getLogger(GenericFileParser.class);

    private ConfigService configService;

    public ImportResponse read(FileReader fileReader, String systemName, String statementType) {

        Class targetClass = getTargetClass(systemName, statementType);
        CellProcessor[] cellProcessors = getCellProcessors(systemName, statementType);
        String[] filedsInTargetClass = getFieldsInTargetClass(systemName, statementType);

        ICsvBeanReader beanReader = new CsvBeanReader(fileReader, getPreference());

        ImportResponse response = new ImportResponse();
        try {
            beanReader.getHeader(true);

            Object domainObj;
            List<Object> domainObjectList = new ArrayList<Object>();

            do {
                domainObj = beanReader.read(targetClass, filedsInTargetClass, cellProcessors);

                if (domainObj != null) {
                    domainObjectList.add(domainObj);
                }

            } while (domainObj != null);

            response.setDomainObjectList(domainObjectList);
        } catch (Exception e) {
            LOG.error("Exception Occured", e);
        }

        return response;
    }

    public CsvPreference getPreference() {
        return CsvPreference.STANDARD_PREFERENCE;
    }

    private Class getTargetClass(String systemName, String statementType) {

        Class clazz = null;
        String domainClass = configService.getDomains().get(systemName + "_" + statementType + "_domain");

        try {
            clazz = Class.forName(domainClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    private CellProcessor[] getCellProcessors(String systemName, String statementType) {

        Map<String, CellProcessor> cellProcessors = configService.getCellProcessors()
                .get(systemName + "_" + statementType + "_cellProcessors");

        Collection<CellProcessor> cellProcessorList = cellProcessors.values();

        return cellProcessorList.toArray(new CellProcessorAdaptor[]{});
    }

    private String[] getFieldsInTargetClass(String systemName, String statementType) {
        List<String> fields = configService.getDomainFields().get(systemName + "_" + statementType + "_class_attributes");
        return fields.toArray(new String[]{});
    }
}
