package cn.hd.mytest.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (TReqLog)实体类
 *
 * @author makejava
 * @since 2020-09-15 18:56:41
 */
public class TReqLog implements Serializable {
    private static final long serialVersionUID = 301208771936898904L;
    /**
     * 主键
     */
    private String id;
    /**
     * 请求url
     */
    private String reqUrl;
    /**
     * 请求uri
     */
    private String reqUri;
    /**
     * sesssionId
     */
    private String reqSessionId;
    /**
     * 请求方法
     */
    private String reqMethodName;
    /**
     * 请求ip
     */
    private String reqIp;
    /**
     * 请求参数个数
     */
    private Integer reqParamCount;
    /**
     * 请求方法类型
     */
    private String reqMethodType;
    /**
     * 返回值类型
     */
    private String reqMethodReturnType;
    /**
     * 处理方法注解类型
     */
    private String reqMethodAnnotationType;

    private Date reqCrtTime;

    private Date reqEndTime;
    /**
     * 备注
     */
    private String remark;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReqUrl() {
        return reqUrl;
    }

    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl;
    }

    public String getReqUri() {
        return reqUri;
    }

    public void setReqUri(String reqUri) {
        this.reqUri = reqUri;
    }

    public String getReqSessionId() {
        return reqSessionId;
    }

    public void setReqSessionId(String reqSessionId) {
        this.reqSessionId = reqSessionId;
    }

    public String getReqMethodName() {
        return reqMethodName;
    }

    public void setReqMethodName(String reqMethodName) {
        this.reqMethodName = reqMethodName;
    }

    public String getReqIp() {
        return reqIp;
    }

    public void setReqIp(String reqIp) {
        this.reqIp = reqIp;
    }

    public Integer getReqParamCount() {
        return reqParamCount;
    }

    public void setReqParamCount(Integer reqParamCount) {
        this.reqParamCount = reqParamCount;
    }

    public String getReqMethodType() {
        return reqMethodType;
    }

    public void setReqMethodType(String reqMethodType) {
        this.reqMethodType = reqMethodType;
    }

    public String getReqMethodReturnType() {
        return reqMethodReturnType;
    }

    public void setReqMethodReturnType(String reqMethodReturnType) {
        this.reqMethodReturnType = reqMethodReturnType;
    }

    public String getReqMethodAnnotationType() {
        return reqMethodAnnotationType;
    }

    public void setReqMethodAnnotationType(String reqMethodAnnotationType) {
        this.reqMethodAnnotationType = reqMethodAnnotationType;
    }

    public Date getReqCrtTime() {
        return reqCrtTime;
    }

    public void setReqCrtTime(Date reqCrtTime) {
        this.reqCrtTime = reqCrtTime;
    }

    public Date getReqEndTime() {
        return reqEndTime;
    }

    public void setReqEndTime(Date reqEndTime) {
        this.reqEndTime = reqEndTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}