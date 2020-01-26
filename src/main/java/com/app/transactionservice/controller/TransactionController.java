package com.app.transactionservice.controller;

import com.app.transactionservice.repository.TransactionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NoResultException;

/**
 * Created By Shameera.A on 1/25/2020
 */
@RestController
@RequestMapping("api/v1/transaction")
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getTransaction(@PathVariable long id) throws JsonProcessingException, NoResultException {
        return objectMapper.writeValueAsString(transactionRepository.findById(id).orElseThrow(NoResultException::new));
    }
}
