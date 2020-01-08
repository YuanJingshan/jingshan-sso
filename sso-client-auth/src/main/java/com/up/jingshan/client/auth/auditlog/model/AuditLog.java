package com.up.jingshan.client.auth.auditlog.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
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
    private Date returnTime;
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
    /**
     * 返回结果
     */
    private String returnData;

    private static final long serialVersionUID = 1L;

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
        sb.append(", returnTime=").append(returnTime);
        sb.append(", httpStatusCode=").append(httpStatusCode);
        sb.append(", timeConsuming=").append(timeConsuming);
        sb.append(", reqParamData=").append(reqParamData);
        sb.append(", returnData=").append(returnData);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}