package com.app.transactionservice.service.impl;

import com.app.transactionservice.dto.TransactionInputDTO;
import com.app.transactionservice.modal.Transaction;
import com.app.transactionservice.repository.TransactionRepository;
import com.app.transactionservice.service.TransactionService;
import org.springframework.stereotype.Service;

/**
 * Created By Shameera.A on 1/25/2020
 */

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction saveTransaction(TransactionInputDTO input) {

        /* currently setting few parameters only*/
        Transaction transaction = new Transaction();
        transaction.setParentTranId(input.getParentTranId());
        transaction.setServiceName(input.getServiceName());
        transaction.setUserName(input.getUserName());
        transaction.setUserProfileName(input.getUserProfileName());
        transaction.setSessionId(input.getSessionId());
        transaction.setExecutionTime(input.getExecutionTime());
        transaction.setRequestTime(input.getRequestTime());


        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionById(long id) {
        return transactionRepository.findById(id).get();
    }
}
