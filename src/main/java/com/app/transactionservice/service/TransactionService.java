package com.app.transactionservice.service;

import com.app.transactionservice.dto.TransactionInputDTO;
import com.app.transactionservice.modal.Transaction;

/**
 * Created By Shameera.A on 1/25/2020
 */
public interface TransactionService {

    Transaction saveTransaction(TransactionInputDTO transactionInputDTO);

    Transaction getTransactionById(long id);
}
