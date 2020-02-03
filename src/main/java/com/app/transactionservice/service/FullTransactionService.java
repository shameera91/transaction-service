package com.app.transactionservice.service;

import com.app.transactionservice.modal.FullTransaction;

/**
 * Created By Shameera.A on 2/1/2020
 */
public interface FullTransactionService {

    FullTransaction findFullTransactionById(long id);
}
