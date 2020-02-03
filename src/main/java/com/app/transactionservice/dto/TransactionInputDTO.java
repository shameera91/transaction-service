package com.app.transactionservice.dto;

import java.util.Date;

/**
 * Created By Shameera.A on 1/28/2020
 */
public class TransactionInputDTO {

    private Long id;
    private Long parentTranId;
    private String serviceName = "";
    private String userName = "";
    private String userProfileName = "";
    private String sessionId;
    private String executionTime;
    private Date requestTime;


    private Date responseTime;
    private Date retrievalTime;
    private Date retrievalExpiryTime;
    private Date assumedFailedTime;
    private Date lastRestartTime;
    private String deliveryDetails = "";
    private String presentationStatus = "";
    private String status = "";
    private String requestMsgVersion = "";
    private String requestMsgId = "";
    private String providerReference = "";
    private String paymentReference = "";
    private Long childSeqNo;
    private Long nextRestartAttempt;
    private Date nextRestartDueTime;
    private String userId = "";
    private String renderedResult = "No";



    public TransactionInputDTO() {

    }

    public TransactionInputDTO(Long id, Long parentTranId, String serviceName, String userName,
                               String userProfileName, String sessionId, String executionTime, Date requestTime) {
        this.id = id;
        this.parentTranId = parentTranId;
        this.serviceName = serviceName;
        this.userName = userName;
        this.userProfileName = userProfileName;
        this.sessionId = sessionId;
        this.executionTime = executionTime;
        this.requestTime = requestTime;
    }

    public TransactionInputDTO(Long parentTranId, String serviceName, String userName,
                               String userProfileName, String sessionId, String executionTime, Date requestTime) {
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





    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public Date getRetrievalTime() {
        return retrievalTime;
    }

    public void setRetrievalTime(Date retrievalTime) {
        this.retrievalTime = retrievalTime;
    }

    public Date getRetrievalExpiryTime() {
        return retrievalExpiryTime;
    }

    public void setRetrievalExpiryTime(Date retrievalExpiryTime) {
        this.retrievalExpiryTime = retrievalExpiryTime;
    }

    public Date getAssumedFailedTime() {
        return assumedFailedTime;
    }

    public void setAssumedFailedTime(Date assumedFailedTime) {
        this.assumedFailedTime = assumedFailedTime;
    }

    public Date getLastRestartTime() {
        return lastRestartTime;
    }

    public void setLastRestartTime(Date lastRestartTime) {
        this.lastRestartTime = lastRestartTime;
    }

    public String getDeliveryDetails() {
        return deliveryDetails;
    }

    public void setDeliveryDetails(String deliveryDetails) {
        this.deliveryDetails = deliveryDetails;
    }

    public String getPresentationStatus() {
        return presentationStatus;
    }

    public void setPresentationStatus(String presentationStatus) {
        this.presentationStatus = presentationStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestMsgVersion() {
        return requestMsgVersion;
    }

    public void setRequestMsgVersion(String requestMsgVersion) {
        this.requestMsgVersion = requestMsgVersion;
    }

    public String getRequestMsgId() {
        return requestMsgId;
    }

    public void setRequestMsgId(String requestMsgId) {
        this.requestMsgId = requestMsgId;
    }

    public String getProviderReference() {
        return providerReference;
    }

    public void setProviderReference(String providerReference) {
        this.providerReference = providerReference;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public Long getChildSeqNo() {
        return childSeqNo;
    }

    public void setChildSeqNo(Long childSeqNo) {
        this.childSeqNo = childSeqNo;
    }

    public Long getNextRestartAttempt() {
        return nextRestartAttempt;
    }

    public void setNextRestartAttempt(Long nextRestartAttempt) {
        this.nextRestartAttempt = nextRestartAttempt;
    }

    public Date getNextRestartDueTime() {
        return nextRestartDueTime;
    }

    public void setNextRestartDueTime(Date nextRestartDueTime) {
        this.nextRestartDueTime = nextRestartDueTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRenderedResult() {
        return renderedResult;
    }

    public void setRenderedResult(String renderedResult) {
        this.renderedResult = renderedResult;
    }
}
