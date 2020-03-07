package com.app.transactionservice;

import com.app.transactionservice.dto.TransactionInputDTO;
import com.app.transactionservice.dto.TransactionOutputDTO;
import com.app.transactionservice.modal.Transaction;
import com.app.transactionservice.repository.TransactionRepository;
import com.app.transactionservice.service.TransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created By Shameera.A on 2/12/2020
 */

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionRepository transactionRepository;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @AfterEach
    void cleanUp() {
        transactionRepository.deleteAll();
    }

    @Test
    void aj_testSaveTransaction() throws Exception {
        this.mockMvc.perform(post("/api/v1/transaction/save").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(buildDto()))).andExpect(status().isCreated());
    }

    @Test
    void aj_testGetTransactionById() throws Exception {
        TransactionOutputDTO transactionOutputDTO = this.transactionService.saveTransaction(buildDto());
        this.mockMvc.perform(get("/api/v1/transaction/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.transactionId").value(transactionOutputDTO.getId()))
                .andExpect(jsonPath("$.parentTranId").value(transactionOutputDTO.getParentTranId()))
                .andExpect(jsonPath("$.serviceName").value(transactionOutputDTO.getServiceName()))
                .andExpect(jsonPath("$.userName").value(transactionOutputDTO.getUserName()))
                .andExpect(jsonPath("$.userProfileName").value(transactionOutputDTO.getUserProfileName()))
                .andExpect(jsonPath("$.sessionId").value(transactionOutputDTO.getSessionId()))
                .andExpect(jsonPath("$.executionTime").value(transactionOutputDTO.getExecutionTime()));

    }

    @Test
    void aj_testGetTransactionWhenInvalidIdPresent() throws Exception {
        TransactionOutputDTO transactionOutputDTO = this.transactionService.saveTransaction(buildDto());
        this.mockMvc.perform(get("/api/v1/transaction/2")).andExpect(status().isNotFound());
    }

    @Test
    void aj_testGetTransactionWhenEmptyIdPresent() throws Exception {
        TransactionOutputDTO transactionOutputDTO = this.transactionService.saveTransaction(buildDto());
        this.mockMvc.perform(get("/api/v1/transaction/ ")).andExpect(status().isBadRequest());
    }

    @Test
    void aj_testGetAllTransactionsWithWithDefaultPageParams() throws Exception {
        TransactionOutputDTO transactionOutputDTO = this.transactionService.saveTransaction(buildDto());
        TransactionOutputDTO transactionOutputDTOTwo = this.transactionService.saveTransaction(buildDtoTransactionTwo());
        this.mockMvc.perform(get("/api/v1/transaction/")).andExpect(status().isOk())
                .andExpect(jsonPath("$.content", Matchers.hasSize(2)))
                .andExpect(jsonPath("$.content[0].transactionId").value(transactionOutputDTO.getId()))
                .andExpect(jsonPath("$.content[0].parentTranId").value(transactionOutputDTO.getParentTranId()))
                .andExpect(jsonPath("$.content[0].serviceName").value(transactionOutputDTO.getServiceName()))
                .andExpect(jsonPath("$.content[0].userName").value(transactionOutputDTO.getUserName()))
                .andExpect(jsonPath("$.content[0].userProfileName").value(transactionOutputDTO.getUserProfileName()))
                .andExpect(jsonPath("$.content[0].sessionId").value(transactionOutputDTO.getSessionId()))
                .andExpect(jsonPath("$.content[0].executionTime").value(transactionOutputDTO.getExecutionTime()))

                .andExpect(jsonPath("$.pageable.offset").value(0))
                .andExpect(jsonPath("$.pageable.pageSize").value(20))
                .andExpect(jsonPath("$.pageable.pageNumber").value(0))
                .andExpect(jsonPath("$.pageable.paged").value(true));

    }

    private TransactionInputDTO buildDto() {
        return new TransactionInputDTO(345l, "service name", "user one", "profile one", "S00445", "334", new Date(), "code1", "ONLINE");
    }

    private TransactionInputDTO buildDtoTransactionTwo() {
        return new TransactionInputDTO(112l, "service name2", "user two", "profile two", "S00122", "100", new Date(), "code1", "ONLINE");
    }


}
