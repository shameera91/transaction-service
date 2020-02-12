package com.app.transactionservice.modal;

import com.app.transactionservice.dto.TransactionOutputDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created By Shameera.A on 1/25/2020
 */

@Entity
@Table(name = "C2_TRANSACTION")
@SequenceGenerator(name = "trans_id_generator", allocationSize = 1, sequenceName = "C2_TRAN_ID_SEQ")
@Inheritance(strategy = InheritanceType.JOINED)
public class Transaction extends AbstractTransaction implements Serializable {


    @JsonIgnore
    public TransactionOutputDTO viewAsDTO() {
        return new TransactionOutputDTO(getTransactionId(), getParentTranId(), getServiceName(), getUserName(),
                getUserProfileName(), getSessionId(), getExecutionTime(), getRequestTime());
    }

}
