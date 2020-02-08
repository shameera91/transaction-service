package com.app.transactionservice.service.impl;

import com.app.transactionservice.dto.TransactionInputDTO;
import com.app.transactionservice.exceptions.ResourceNotFoundException;
import com.app.transactionservice.modal.Transaction;
import com.app.transactionservice.repository.TransactionRepository;
import com.app.transactionservice.service.TransactionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
    public Transaction saveTransactionWithTransactionObject(Transaction transaction) {
        return transactionRepository.save(transaction);
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

    @Transactional
    @Override
    public void updateTransaction(TransactionInputDTO input) {
        Transaction result = transactionRepository.findById(input.getId()).orElseThrow(() -> new ResourceNotFoundException(" No transaction found"));
        result.setParentTranId(input.getParentTranId());
        result.setServiceName(input.getServiceName());
        result.setUserName(input.getUserName());
        result.setUserProfileName(input.getUserProfileName());
        result.setSessionId(input.getSessionId());
        result.setExecutionTime(input.getExecutionTime());
        result.setRequestTime(input.getRequestTime());
        transactionRepository.save(result);
    }

    @Override
    public Transaction getTransactionById(long id) {
        return transactionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Transaction found for given id"));
    }

    @Override
    public Page<Transaction> getAllTransactions(Pageable pageable) {
        Page<Transaction> allTransactions = transactionRepository.findAll(pageable);
        return new PageImpl<>(allTransactions.getContent(), pageable, allTransactions.getTotalElements());
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        transactionRepository.deleteById(id);
    }
}
