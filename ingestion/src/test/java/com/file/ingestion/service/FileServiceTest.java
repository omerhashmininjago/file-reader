package com.file.ingestion.service;

import com.file.parser.response.ImportResponse;
import com.file.persistence.domain.Balance;
import com.file.persistence.domain.Cashflow;
import com.file.persistence.repo.FileTransactionRepo;
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
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FileServiceTest {


    @Mock
    private FileLoadService fileLoadService;

    @Mock
    private FileImportService fileImportService;

    @Mock
    private FileTransactionRepo fileTransactionRepo;

    @InjectMocks
    private FileService fileService;

    @Test
    public void testLoadFileValidTransactionType() throws IOException, ClassNotFoundException {
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

        when(fileLoadService.loadFile(transactionType)).thenReturn(file);
        when(fileImportService.importFile(file, transactionType)).thenReturn(balanceImportResponse);
        fileService.loadFile(transactionType);

        verify(fileTransactionRepo, times(1)).saveAll(expectedBalances);
    }

    @Test
    public void testImportFile() throws ClassNotFoundException, IOException {
        String transactionType = "cashflow";
        ImportResponse<Cashflow> cashflowImportResponse = new ImportResponse<>();
        List<Cashflow> cashflowList = new ArrayList<>();
        Date transactionDate = new Date();
        BigDecimal depositAmt = BigDecimal.ONE;
        BigDecimal cashflowAmount = BigDecimal.ONE;
        Cashflow cashflow = new Cashflow(transactionDate, depositAmt, cashflowAmount);
        cashflowList.add(cashflow);
        cashflowImportResponse.setDomainObjectList(cashflowList);
        File file = Mockito.mock(File.class);

        when(fileImportService.importFile(file, transactionType)).thenReturn(cashflowImportResponse);
        fileService.importFile(file, transactionType);

        verify(fileTransactionRepo, times(1)).saveAll(cashflowList);
    }

}
