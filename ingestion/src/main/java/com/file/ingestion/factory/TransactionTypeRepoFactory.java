package com.file.ingestion.factory;

import com.file.persistence.repo.BalanceRepo;
import com.file.persistence.repo.CashflowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.file.ingestion.factory.TransactionType.BALANCE;
import static com.file.ingestion.factory.TransactionType.CASHFLOW;

@Component
public class TransactionTypeRepoFactory {

    private static final Map<TransactionType, JpaRepository> myRepoCache = new HashMap<>();

    private final BalanceRepo balanceRepo;
    private final CashflowRepo cashflowRepo;

    @Autowired
    public TransactionTypeRepoFactory(BalanceRepo balanceRepo, CashflowRepo cashflowRepo) {
        this.balanceRepo = balanceRepo;
        this.cashflowRepo = cashflowRepo;
    }

    @PostConstruct
    public void initMyServiceCache() {
        myRepoCache.put(BALANCE, balanceRepo);
        myRepoCache.put(CASHFLOW, cashflowRepo);
        Collections.unmodifiableMap(myRepoCache);
    }

    public static JpaRepository getRepo(TransactionType type) {
        return myRepoCache.get(type);
    }
}
