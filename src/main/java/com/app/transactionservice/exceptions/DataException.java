package com.app.transactionservice.exceptions;

import com.app.transactionservice.dto.TransactionInputDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created By Shameera.A on 3/1/2020
 */
public class DataException extends C2iException {

    private static final long serialVersionUID = 3008465322657678589L;

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(DataException.class);

    protected static final String defaultMsg = "A problem occured with the data";

    private static final String defaultErrorCode = "exception.data";

    public DataException() {
        super(defaultMsg);
        setErrorCode(defaultErrorCode);
    }

    public DataException(String msg) {
        super(msg);
        setErrorCode(defaultErrorCode);
    }

    public DataException(String msg, String errorCode) {
        super(msg);
        setErrorCode(errorCode);
    }

    public DataException(TransactionInputDTO dto) {
        super(defaultMsg);
        setTransferObject(dto);
        setErrorCode(defaultErrorCode);
    }

    public DataException(String msg, Throwable rootCause) {
        super(msg, rootCause);
        setErrorCode(defaultErrorCode);
    }

    public DataException(String msg, Throwable rootCause, TransactionInputDTO dto) {
        super(msg, rootCause);
        setTransferObject(dto);
        setErrorCode(defaultErrorCode);
    }

    public DataException(String msg, TransactionInputDTO dto) {
        super(msg);
        setTransferObject(dto);
        setErrorCode(defaultErrorCode);
    }

    public DataException(String msg, String errorCode, Throwable rootCause) {
        super(msg, rootCause);
        setErrorCode(errorCode);
    }

    public DataException(String msg, String errorCode, Throwable rootCause,
                         TransactionInputDTO dto) {
        super(msg, rootCause);
        setTransferObject(dto);
        setErrorCode(errorCode);
    }

    public DataException(String msg, String errorCode, TransactionInputDTO dto) {
        super(msg);
        setTransferObject(dto);
        setErrorCode(errorCode);
    }
}
