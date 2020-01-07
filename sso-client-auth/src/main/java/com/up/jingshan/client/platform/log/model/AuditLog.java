package com.up.jingshan.client.platform.log.model;

import java.io.Serializable;
import java.util.Date;

public class AuditLog implements Serializable {

    private Integer id;

    /**
     * 客户端请求ip
     */
    private String reqClientIp;
    /**
     * 客户端请求路径
     */
    private String reqUri;
    /**
     * 客户端请求方式,普通请求,ajax请求
     */
    private String reqType;
    /**
     * 请求方式method,post,get等
     */
    private String reqMethod;
    /**
     * 请求接口唯一session标识
     */
    private String sessionId;
    /**
     * 请求时间
     */
    private Date reqTime;
    /**
     * 接口返回时间
     */
    private Date returmTime;
    /**
     * 请求时httpStatusCode代码，如：200,400,404等
     */
    private String httpStatusCode;
    /**
     * 请求耗时秒单位
     */
    private Integer timeConsuming;
    /**
     * 请求参数内容,json
     */
    private String reqParamData;

    private String returnData;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReqClientIp() {
        return reqClientIp;
    }

    public void setReqClientIp(String reqClientIp) {
        this.reqClientIp = reqClientIp == null ? null : reqClientIp.trim();
    }

    public String getReqUri() {
        return reqUri;
    }

    public void setReqUri(String reqUri) {
        this.reqUri = reqUri == null ? null : reqUri.trim();
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType == null ? null : reqType.trim();
    }

    public String getReqMethod() {
        return reqMethod;
    }

    public void setReqMethod(String reqMethod) {
        this.reqMethod = reqMethod == null ? null : reqMethod.trim();
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId == null ? null : sessionId.trim();
    }

    public Date getReqTime() {
        return reqTime;
    }

    public void setReqTime(Date reqTime) {
        this.reqTime = reqTime;
    }

    public Date getReturmTime() {
        return returmTime;
    }

    public void setReturmTime(Date returmTime) {
        this.returmTime = returmTime;
    }

    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(String httpStatusCode) {
        this.httpStatusCode = httpStatusCode == null ? null : httpStatusCode.trim();
    }

    public Integer getTimeConsuming() {
        return timeConsuming;
    }

    public void setTimeConsuming(Integer timeConsuming) {
        this.timeConsuming = timeConsuming;
    }

    public String getReqParamData() {
        return reqParamData;
    }

    public void setReqParamData(String reqParamData) {
        this.reqParamData = reqParamData == null ? null : reqParamData.trim();
    }

    public String getReturnData() {
        return returnData;
    }

    public void setReturnData(String returnData) {
        this.returnData = returnData == null ? null : returnData.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", reqClientIp=").append(reqClientIp);
        sb.append(", reqUri=").append(reqUri);
        sb.append(", reqType=").append(reqType);
        sb.append(", reqMethod=").append(reqMethod);
        sb.append(", sessionId=").append(sessionId);
        sb.append(", reqTime=").append(reqTime);
        sb.append(", returmTime=").append(returmTime);
        sb.append(", httpStatusCode=").append(httpStatusCode);
        sb.append(", timeConsuming=").append(timeConsuming);
        sb.append(", reqParamData=").append(reqParamData);
        sb.append(", returnData=").append(returnData);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}