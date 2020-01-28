package com.app.transactionservice.controller;

import com.app.transactionservice.dto.TransactionInputDTO;
import com.app.transactionservice.modal.Transaction;
import com.app.transactionservice.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    /*@Autowired
    TransactionRepository transactionRepository;

    @Autowired
    FullTransactionRepository fullTransactionRepository;

    @Autowired
    ObjectMapper objectMapper;*/

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveTransaction(@RequestBody TransactionInputDTO transactionInputDTO) {
        return new ResponseEntity<>(this.transactionService.saveTransaction(transactionInputDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable long id){
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

   /* @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getTransaction(@PathVariable long id) throws JsonProcessingException, NoResultException {
        return objectMapper.writeValueAsString(transactionRepository.findById(id).orElseThrow(NoResultException::new));
    }

    @GetMapping(value = "/{id}/full", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getFullTransaction(@PathVariable long id) throws JsonProcessingException, NoResultException {
        return objectMapper.writeValueAsString(fullTransactionRepository.findById(id).orElseThrow(NoResultException::new));
    }

    @GetMapping(value = "/save/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String updateTransaction() throws JsonProcessingException, NoResultException {
        byte[] randomBytes = new byte[30];       *//* this doesn't make sense to me   ( what is the thing you are going to update ?)*//*
        new Random().nextBytes(randomBytes);
        FullTransaction t = new FullTransaction();
        t.setRequestBuffer(randomBytes);
        return objectMapper.writeValueAsString(t);
    }

    @GetMapping(value = "/{id}/parent", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getParentTransaction(@PathVariable long id) throws JsonProcessingException, NoResultException {
        return objectMapper.writeValueAsString(transactionRepository
                .findById(id).map(t -> transactionRepository.findById(t.getParentTranId())).orElseThrow(NoResultException::new));
    }*/




}
