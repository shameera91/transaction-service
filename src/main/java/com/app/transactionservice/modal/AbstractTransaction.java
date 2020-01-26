package com.app.transactionservice.modal;

import org.hibernate.annotations.OptimisticLock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created By Shameera.A on 1/25/2020
 */

@Entity
public abstract class AbstractTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tran_id_generator")
    @Column(name = "TRAN_ID")
    private Long transactionId;

    @Column(name = "PARENT_TRAN_ID")
    private Long parenTranId;

    @Column(name = "SERVICE_NAME")
    private String serviceName = "";

    @Column(name = "USER_NAME")
    private String userName = "";

    @Column(name = "USER_PROFILE_NAME")
    private String userProfileName = "";

    @Column(name = "SESSION_ID")
    private String sessionId;

    @Column(name = "EXECUTION_TIME")
    private String executionTime;

    @Column(name = "REQUEST_TIME")
    private Date requestTime;

    @Column(name = "RESPONSE_TIME")
    @OptimisticLock(excluded = true)
    private Date responseTime;

    @Column(name = "RETRIEVAL_TIME")
    private Date retrievalTime;

    @Column(name = "RETRIEVAL_EXPIRY_TIME")
    private Date retrievalExpiryTime;

    @Column(name = "ASSUMED_FAILED_TIME")
    private Date assumedFailedTime;

    @Column(name = "LAST_RESTART_TIME")
    private Date lastRestartTime;

    @Column(name = "DELIVERY_DETAILS")
    private String deliveryDetails = "";

    @Column(name = "PRESENTATION_STATUS")
    private String presentationStatus = "";

    @Column(name = "STATUS")
    private String status = "";

    @Column(name = "REQUEST_MSG_VERSION")
    private String requestMsgVersion = "";

    @Column(name = "REQUEST_MSG_ID")
    private String requestMsgId = "";

    @Column(name = "PROVIDER_REFERENCE")
    private String providerReference = "";

    @Column(name = "PAYMENT_REFERENCE")
    private String paymentReference = "";

    @Column(name = "CHILD_SEQ_NO")
    private Long childSeqNo;

    @Column(name = "NEXT_RESTART_ATTEMPT")
    private Long nextRestartAttempt;

    @Column(name = "NEXT_RESTART_DUE_TIME")
    private Date nextRestartDueTime;

    @Column(name = "USER_ID")
    private String userId = "";

    @Column(name = "RENDERED_RESULT")
    private String renderedResult = "No";

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", parenTranId=" + parenTranId +
                ", serviceName='" + serviceName + '\'' +
                ", userName='" + userName + '\'' +
                ", userProfileName='" + userProfileName + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", executionTime='" + executionTime + '\'' +
                ", requestTime=" + requestTime +
                ", responseTime=" + responseTime +
                ", retrievalTime=" + retrievalTime +
                ", retrievalExpiryTime=" + retrievalExpiryTime +
                ", assumedFailedTime=" + assumedFailedTime +
                ", lastRestartTime=" + lastRestartTime +
                ", deliveryDetails='" + deliveryDetails + '\'' +
                ", presentationStatus='" + presentationStatus + '\'' +
                ", status='" + status + '\'' +
                ", requestMsgVersion='" + requestMsgVersion + '\'' +
                ", requestMsgId='" + requestMsgId + '\'' +
                ", providerReference='" + providerReference + '\'' +
                ", paymentReference='" + paymentReference + '\'' +
                ", childSeqNo=" + childSeqNo +
                ", nextRestartAttempt=" + nextRestartAttempt +
                ", nextRestartDueTime=" + nextRestartDueTime +
                ", userId='" + userId + '\'' +
                ", renderedResult='" + renderedResult + '\'' +
                '}';
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getParenTranId() {
        return parenTranId;
    }

    public void setParenTranId(Long parenTranId) {
        this.parenTranId = parenTranId;
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
