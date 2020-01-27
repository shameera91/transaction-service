package com.app.transactionservice.controller;

import com.app.transactionservice.modal.FullTransaction;
import com.app.transactionservice.repository.FullTransactionRepository;
import com.app.transactionservice.repository.TransactionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NoResultException;
import java.util.Random;

/**
 * Created By Shameera.A on 1/25/2020
 */
@RestController
@RequestMapping("api/v1/transaction")
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    FullTransactionRepository fullTransactionRepository;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getTransaction(@PathVariable long id) throws JsonProcessingException, NoResultException {
        return objectMapper.writeValueAsString(transactionRepository.findById(id).orElseThrow(NoResultException::new));
    }

    @GetMapping(path = "/{id}/full", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getFullTransaction(@PathVariable long id) throws JsonProcessingException, NoResultException {
        return objectMapper.writeValueAsString(fullTransactionRepository.findById(id).orElseThrow(NoResultException::new));
    }

    @GetMapping(path = "/save/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String updateTransaction() throws JsonProcessingException, NoResultException {
        byte[] randomBytes = new byte[30];       /* this doesn't make sense to me   ( what is the thing you are going to update ?)*/
        new Random().nextBytes(randomBytes);
        FullTransaction t = new FullTransaction();
        t.setRequestBuffer(randomBytes);
        return objectMapper.writeValueAsString(t);
    }

    @GetMapping(path = "/save/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getParentTransaction(@PathVariable long id) throws JsonProcessingException, NoResultException {
        return objectMapper.writeValueAsString(transactionRepository
                .findById(id).map(t -> transactionRepository.findById(t.getParenTranId())).orElseThrow(NoResultException::new));
    }


    @PostMapping(path = "/save")
    public void saveTransaction() {
            /*
            *
            * */
    }

}
