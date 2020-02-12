package com.app.transactionservice.service;

import com.app.transactionservice.dto.TransactionInputDTO;
import com.app.transactionservice.dto.TransactionOutputDTO;
import com.app.transactionservice.modal.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created By Shameera.A on 1/25/2020
 */
public interface TransactionService {

    TransactionOutputDTO saveTransaction(TransactionInputDTO transactionInputDTO);

    void updateTransaction(TransactionInputDTO transactionInputDTO);

    Transaction getTransactionById(long id);

    Page<Transaction> getAllTransactions(Pageable pageable);
}
