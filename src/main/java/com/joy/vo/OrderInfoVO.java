package com.joy.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import static com.joy.example.PreOrderExample.*;

@ApiModel(description = "订单详情展示对象")
public class OrderInfoVO {

    @ApiModelProperty(notes = N_AREANAME, example = E_AREANAME)
    private String areaName;

    @ApiModelProperty(notes = N_AREACODE, example = E_AREACODE)
    private Integer areaCode;

    @ApiModelProperty(notes = N_UNIONPAYMONEY, example = E_UNIONPAYMONEY)
    private Integer unionPayMoney;

    @ApiModelProperty(notes = N_BILLNO, example = E_BILLNO)
    private String billNo;

    @ApiModelProperty(notes = N_BILLTYPE, example = E_BILLTYPE)
    private String billType;

    @ApiModelProperty(notes = N_STATUSCODE, example = E_STATUSCODE)
    private Integer statusCode;

    @ApiModelProperty(notes = N_STATUSNAME, example = E_STATUSNAME)
    private String statusName;

    @ApiModelProperty(notes = N_CREATEDTIME, example = E_CREATEDTIME)
    private Date createdTime;

    @ApiModelProperty(notes = N_SERVERTIME, example = E_SERVERTIME)
    private Date serverTime;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getUnionPayMoney() {
        return unionPayMoney;
    }

    public void setUnionPayMoney(Integer unionPayMoney) {
        this.unionPayMoney = unionPayMoney;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getServerTime() {
        return serverTime;
    }

    public void setServerTime(Date serverTime) {
        this.serverTime = serverTime;
    }
}
