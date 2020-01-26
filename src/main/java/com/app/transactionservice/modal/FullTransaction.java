package com.app.transactionservice.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created By Shameera.A on 1/25/2020
 */

@Entity
@Table(name = "C2_FULL_TRANSACTION")
public class FullTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "full_tran_id_generator")
    @Column(name = "FULL_TRANS_ID")
    private Long fullTransId;
}
