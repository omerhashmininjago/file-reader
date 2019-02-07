package com.file.persistence.repo;

import com.file.persistence.domain.Cashflow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashflowRepo extends JpaRepository<Cashflow, String> {
}
