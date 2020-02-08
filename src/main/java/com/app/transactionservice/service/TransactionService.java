package com.app.transactionservice.service;

import com.app.transactionservice.dto.TransactionInputDTO;
import com.app.transactionservice.modal.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created By Shameera.A on 1/25/2020
 */
public interface TransactionService {
    Transaction saveTransactionWithTransactionObject(Transaction transaction);

    Transaction saveTransaction(TransactionInputDTO transactionInputDTO);

    void updateTransaction(TransactionInputDTO transactionInputDTO);

    Transaction getTransactionById(long id);

    Page<Transaction> getAllTransactions(Pageable pageable);

    List<Transaction> getAllTransactions();

    void deleteById(long id);
}
