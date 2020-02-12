package com.app.transactionservice.dto;

import java.util.Date;

/**
 * Created By Shameera.A on 2/12/2020
 */
public class TransactionOutputDTO {

    private Long id;
    private Long parentTranId;
    private String serviceName = "";
    private String userName = "";
    private String userProfileName = "";
    private String sessionId;
    private String executionTime;
    private Date requestTime;

    public TransactionOutputDTO() {
    }

    public TransactionOutputDTO(Long id, Long parentTranId, String serviceName, String userName, String userProfileName,
                                String sessionId, String executionTime, Date requestTime) {
        this.id = id;
        this.parentTranId = parentTranId;
        this.serviceName = serviceName;
        this.userName = userName;
        this.userProfileName = userProfileName;
        this.sessionId = sessionId;
        this.executionTime = executionTime;
        this.requestTime = requestTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentTranId() {
        return parentTranId;
    }

    public void setParentTranId(Long parentTranId) {
        this.parentTranId = parentTranId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserProfileName() {
        return userProfileName;
    }

    public void setUserProfileName(String userProfileName) {
        this.userProfileName = userProfileName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }
}
