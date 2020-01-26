package com.app.transactionservice.repository;

import com.app.transactionservice.modal.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By Shameera.A on 1/26/2020
 */
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
