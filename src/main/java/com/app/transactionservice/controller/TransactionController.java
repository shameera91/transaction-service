package com.app.transactionservice.controller;

import com.app.transactionservice.dto.TransactionInputDTO;
import com.app.transactionservice.modal.FullTransaction;
import com.app.transactionservice.modal.Transaction;
import com.app.transactionservice.service.FullTransactionService;
import com.app.transactionservice.service.TransactionHistoryService;
import com.app.transactionservice.service.TransactionService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By Shameera.A on 1/25/2020
 */
@RestController
@RequestMapping("api/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionHistoryService transactionHistoryService;
    private final FullTransactionService fullTransactionService;

    public TransactionController(TransactionService transactionService,
                                 TransactionHistoryService transactionHistoryService,
                                 FullTransactionService fullTransactionService) {
        this.transactionService = transactionService;
        this.transactionHistoryService = transactionHistoryService;
        this.fullTransactionService = fullTransactionService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveTransaction(@RequestBody TransactionInputDTO transactionInputDTO) {
        return new ResponseEntity<>(this.transactionService.saveTransaction(transactionInputDTO), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/update")
    public ResponseEntity<?> updateTransaction(@RequestBody TransactionInputDTO transactionInputDTO) {
        this.transactionService.updateTransaction(transactionInputDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable long id) {
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllTransaction(Pageable pageable) {
        return ResponseEntity.ok(transactionService.getAllTransactions(pageable));
    }

    @GetMapping(value = "/{id}/full")
    public ResponseEntity<FullTransaction> getFullTransaction(@PathVariable long id) {
        return ResponseEntity.ok(fullTransactionService.findFullTransactionById(id));
    }
}
