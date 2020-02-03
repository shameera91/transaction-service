package com.app.transactionservice.service.impl;

import com.app.transactionservice.exceptions.ResourceNotFoundException;
import com.app.transactionservice.modal.FullTransaction;
import com.app.transactionservice.repository.FullTransactionRepository;
import com.app.transactionservice.service.FullTransactionService;
import org.springframework.stereotype.Service;

/**
 * Created By Shameera.A on 2/1/2020
 */

@Service
public class FullTransactionServiceImpl implements FullTransactionService {
    private final FullTransactionRepository fullTransactionRepository;

    public FullTransactionServiceImpl(FullTransactionRepository fullTransactionRepository) {
        this.fullTransactionRepository = fullTransactionRepository;
    }

    @Override
    public FullTransaction findFullTransactionById(long id) {
        return fullTransactionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No full transaction found"));
    }
}
