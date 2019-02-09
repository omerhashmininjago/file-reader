package com.file.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileTransactionRepo<T> extends JpaRepository<T, String> {
}
