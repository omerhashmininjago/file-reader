package com.file.ingestion.service;

import com.file.parser.response.ImportResponse;
import com.file.parser.service.FileReader;
import com.file.persistence.domain.Balance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FileImportServiceTest {

    @Mock
    private FileReader fileReader;

    @InjectMocks
    private FileImportService fileImportService;

    @Test
    public void testImportFile() throws ClassNotFoundException, IOException {
        String transactionType = "balance";

        ImportResponse<Balance> balanceImportResponse = new ImportResponse<>();
        List<Balance> expectedBalances = new ArrayList<>();
        Date valueDate = new Date();
        String chequeNumber = "000199";
        String transRemarks = "remarks";
        BigDecimal balanceAmount = BigDecimal.ONE;
        Balance balance = new Balance(valueDate, chequeNumber, transRemarks, balanceAmount);
        expectedBalances.add(balance);
        balanceImportResponse.setDomainObjectList(expectedBalances);

        File file = Mockito.mock(File.class);
        when(fileReader.read(file, transactionType)).thenReturn(balanceImportResponse);
        ImportResponse<Balance> actualImportResponse = fileImportService.importFile(file, transactionType);

        assertEquals(expectedBalances.size(), actualImportResponse.getDomainObjectList().size());
    }
}
