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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

/**
 * Created By Shameera.A on 2/5/2020
 */
@Controller
public class TransactionViewController {

    private final TransactionService transactionService;
    private final TransactionHistoryService transactionHistoryService;
    private final FullTransactionService fullTransactionService;

    public TransactionViewController(TransactionService transactionService,
                                     TransactionHistoryService transactionHistoryService,
                                     FullTransactionService fullTransactionService) {
        this.transactionService = transactionService;
        this.transactionHistoryService = transactionHistoryService;
        this.fullTransactionService = fullTransactionService;
    }

    @RequestMapping("/")
    public String getAllTransaction(Model model,Pageable pageable) {
        List<Transaction> content = transactionService.getAllTransactions();
        model.addAttribute("transactions",content);
        return "list-transactions";
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id){
        if (id.isPresent()) {
            Transaction transaction = transactionService.getTransactionById(id.get());
            model.addAttribute("transaction", transaction);
        } else {
            model.addAttribute("transaction", new Transaction());
        }
        return "add-edit-transaction";
    }

    @PostMapping(value = "/save")
    public String saveTransaction(Transaction transaction) {
        transactionService.saveTransactionWithTransactionObject(transaction);
        return "redirect:/";
    }

    @RequestMapping("/add-new")
    public String showNewProductPage(Model model) {
        Transaction transaction = new Transaction();
        model.addAttribute("transaction", transaction);
        return "add-edit-transaction";
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



    @GetMapping(value = "/{id}/full")
    public ResponseEntity<FullTransaction> getFullTransaction(@PathVariable long id) {
        return ResponseEntity.ok(fullTransactionService.findFullTransactionById(id));
    }
}
