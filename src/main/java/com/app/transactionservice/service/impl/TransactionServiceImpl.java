package com.app.transactionservice.service.impl;

import com.app.transactionservice.dto.TransactionInputDTO;
import com.app.transactionservice.dto.TransactionOutputDTO;
import com.app.transactionservice.exceptions.DataException;
import com.app.transactionservice.exceptions.ResourceNotFoundException;
import com.app.transactionservice.modal.Transaction;
import com.app.transactionservice.repository.TransactionRepository;
import com.app.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;

/**
 * Created By Shameera.A on 1/25/2020
 */

@Service
public class TransactionServiceImpl implements TransactionService {

    /** The application resource bundles */
    @Autowired
    private MessageSource messageSource;

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public TransactionOutputDTO saveTransaction(TransactionInputDTO input) {

        validateParameters(input);

        /* currently setting few parameters only*/
        Transaction transaction = new Transaction();
        transaction.setParentTranId(input.getParentTranId());
        transaction.setServiceName(input.getServiceName());
        transaction.setUserName(input.getUserName());
        transaction.setUserProfileName(input.getUserProfileName());
        transaction.setSessionId(input.getSessionId());
        transaction.setExecutionTime(input.getExecutionTime());
        transaction.setRequestTime(input.getRequestTime());

        Transaction save = transactionRepository.save(transaction);

        return save.viewAsDTO();
    }

    private void validateParameters(TransactionInputDTO dto) throws DataException {

        String sessionId;
        String mode;
        String accountCode;
        String serviceName;
        long parentTranId = 0;
        long childSeqNo = 0;

        // get all the fields from the dto
        sessionId = dto.getSessionId();

        /*mode = dto.getMode();*/    /* these fields are not in our transaction entity*/
       /* accountCode = dto.getAccountDomain().getAccountCode();*/
        /*serviceName = dto.getTransactionDomain().getServiceName();*/

        // may have a parent
        if (dto.getParentTranId() != null) {
            parentTranId = dto.getParentTranId();

            // if has a parent then must have a childSequenceNumber
            childSeqNo = dto.getChildSeqNo().longValue();
        }

        // don't want to proceed if mandatory fields are not set
        /*if (!StringUtils.hasText(sessionId) || !StringUtils.hasText(accountCode) || !StringUtils.hasText(mode)
                || !StringUtils.hasText(serviceName)) {*/
        if (!StringUtils.hasText(sessionId)) {

            throw new DataException(getMessage("error.newtran.data.format", new Object[] {  sessionId }), dto);
        }

        // don't want to proceed if other fields are null or invalid
        if ((parentTranId < 0) || (childSeqNo < 0)) {

            throw new DataException(getMessage("error.dto.initialization", new Object[] { this.getClass().getName() }),
                    "error.dto.initialization", dto);
        }
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

    protected String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, null);
    }
}
