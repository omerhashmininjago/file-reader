package com.file.ingestion.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;

import static com.file.ingestion.factory.TransactionType.valueOf;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FileLoadServiceTest {

    @InjectMocks
    FileLoadService fileLoadService;

    @Test
    public void testLoadFile() {
        String transactionType = "balance";
        String filePath = "balance.csv";
        File expectedFile = new File(Thread.currentThread().getContextClassLoader().getResource(filePath).getFile());
        File actualFile = fileLoadService.loadFile(transactionType);

        assertEquals(expectedFile.getName(), actualFile.getName());
    }
}
