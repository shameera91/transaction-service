package com.app.transactionservice.exceptions;

/**
 * Created By Shameera.A on 3/6/2020
 */
public class ApiError {

    private int status;
    private String message;

    ApiError() {
    }

    ApiError(int status) {
        this.status = status;
    }

    ApiError(int status, Throwable ex) {
        this.status = status;
        this.message = ex.getLocalizedMessage();
    }

    ApiError(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
