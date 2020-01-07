package com.up.jingshan.client.platform.log.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 日志记录
 *
 * @Author Yuan Jingshan
 * @Date 2018-05-10
 */
@Data
@Entity
@Table(name = "sys_audit_log")
public class Log implements Serializable {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    /**
     * 客户端请求ip
     */
    @Column(name = "req_client_ip")
    private String clientIp;
    /**
     * 客户端请求路径
     */
    @Column(name = "req_uri")
    private String uri;
    /**
     * 终端请求方式,普通请求,ajax请求
     */
    @Column(name = "req_type")
    private String type;
    /**
     * 请求方式method,post,get等
     */
    @Column(name = "req_method")
    private String method;
    /**
     * 请求参数内容,json
     */
    @Column(name = "req_param_data")
    private String paramData;
    /**
     * 请求接口唯一session标识
     */
    @Column(name = "session_id")
    private String sessionId;
    /**
     * 请求时间
     */
    @Column(name = "req_time")
    private Date reqTime;
    /**
     * 接口返回时间
     */
    @Column(name = "returm_time")
    private Date returnTime;
    /**
     * 接口返回数据json
     */
    @Column(name = "return_data")
    private String returnData;
    /**
     * 请求时httpStatusCode代码，如：200,400,404等
     */
    @Column(name = "http_status_code")
    private String httpStatusCode;
    /**
     * 请求耗时秒单位
     */
    @Column(name = "time_consuming")
    private int timeConsuming;
}
