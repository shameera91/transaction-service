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

    @Column(name = "REQUEST_BUFFER")
    private byte[] requestBuffer;

    @Column(name = "PARENT_ID")
    private Long parentId;

    public Long getFullTransId() {
        return fullTransId;
    }

    public void setFullTransId(Long fullTransId) {
        this.fullTransId = fullTransId;
    }

    public byte[] getRequestBuffer() {
        return requestBuffer;
    }

    public void setRequestBuffer(byte[] requestBuffer) {
        this.requestBuffer = requestBuffer;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
