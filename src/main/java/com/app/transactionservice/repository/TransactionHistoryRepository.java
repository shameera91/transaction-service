package com.app.transactionservice.repository;

import com.app.transactionservice.modal.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By Shameera.A on 2/1/2020
 */
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory,Long> {
}
