package com.app.transactionservice.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created By Shameera.A on 1/25/2020
 */

@Entity
@Table(name = "C2_TRAN_STATUS_HISTORY")
@SequenceGenerator(name = "tran_id_history_generator", allocationSize = 1, sequenceName = "C2_TRAN_STATUS_SEQ")
public class TransactionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tran_id_history_generator")
    @Column(name = "TRAN_STATUS_ID")
    private Long tranStatusId;

    @Column(name = "TRAN_ID")
    private Long transactionId;

    @Column(name = "STATUS_TIME")
    private Timestamp statusTime;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "PRESENTATION_STATUS")
    private String presentationStatus;

    public Long getTranStatusId() {
        return tranStatusId;
    }

    public void setTranStatusId(Long tranStatusId) {
        this.tranStatusId = tranStatusId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Timestamp getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(Timestamp statusTime) {
        this.statusTime = statusTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPresentationStatus() {
        return presentationStatus;
    }

    public void setPresentationStatus(String presentationStatus) {
        this.presentationStatus = presentationStatus;
    }

    @Override
    public String toString() {
        return "Transaction Status History{" +
                "tranStatusId=" + tranStatusId +
                ", transactionId=" + transactionId +
                ", statusTime=" + statusTime +
                ", status='" + status + '\'' +
                ", presentationStatus='" + presentationStatus + '\'' +
                '}';
    }
}
