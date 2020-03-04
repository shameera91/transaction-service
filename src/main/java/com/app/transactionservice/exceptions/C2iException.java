package com.app.transactionservice.exceptions;

import com.app.transactionservice.dto.TransactionInputDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created By Shameera.A on 3/1/2020
 */
public class C2iException extends RuntimeException {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(C2iException.class);

    /**
     * Default error message to use in the Exception if none is provided.
     */
    private static final String defaultMsg = "A problem occurred";

    /**
     * The default error code to use if none is provided, default is "exception.general"
     */
    private static final String defaultErrorCode = "exception.general";

    /**
     * Data transfer objection associated with this exception if any.
     */
    private TransactionInputDTO dto;

    /**
     * Flag to indicate that this exception has already been logged using C2iTrace
     */
    private boolean traced = false;

    /**
     * The error code for the message
     */
    private String errorCode = "";

    public C2iException() {
        super(defaultMsg);
        setErrorCode(defaultErrorCode);
    }

    public C2iException(String msg) {
        super(msg);
        setErrorCode(defaultErrorCode);
    }

    public C2iException(String msg, String errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }

    public C2iException(TransactionInputDTO dto) {
        super(defaultMsg);
        setTransferObject(dto);
        setErrorCode(defaultErrorCode);
    }

    public C2iException(String msg, Throwable rootCause) {
        super(msg, rootCause);
        setErrorCode(defaultErrorCode);
    }

    public C2iException(String msg, String errorCode, Throwable rootCause) {
        super(msg, rootCause);
        this.errorCode = errorCode;
    }

    public C2iException(String msg, Throwable rootCause, TransactionInputDTO dto) {
        super(msg, rootCause);
        setTransferObject(dto);
        setErrorCode(defaultErrorCode);
    }

    public C2iException(String msg, String errorCode, Throwable rootCause,
                        TransactionInputDTO dto) {
        super(msg, rootCause);
        setTransferObject(dto);
        this.errorCode = errorCode;
    }

    public C2iException(String msg, TransactionInputDTO dto) {
        super(msg);
        setTransferObject(dto);
        setErrorCode(defaultErrorCode);
    }

    public C2iException(String msg, String errorCode, TransactionInputDTO dto) {
        super(msg);
        setTransferObject(dto);
        this.errorCode = errorCode;
    }

    public void setTransferObject(TransactionInputDTO dto) {
        this.dto = dto;
    }

    public TransactionInputDTO getTransferObject() {
        return dto;
    }

    public void setTraced(boolean traced) {
        this.traced = traced;
    }

    public boolean isTraced() {
        return traced;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
