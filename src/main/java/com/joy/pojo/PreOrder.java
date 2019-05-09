package com.joy.pojo;

import com.joy.core.Column;
import com.joy.core.MySqlTypeConst;
import com.joy.core.TableInfo;
import com.joy.core.Transient;

import java.util.Date;

import static com.joy.example.PreOrderExample.*;


@TableInfo(tableName = PreOrder.TABLE_NAME, pkName = "id")
public class PreOrder {

    @Transient
    public static final String TABLE_NAME = "property_pre_payment";

    @Column(length = 10, defaultValue = "", autoIncrement = true, comment = N_ID)
    private Integer id;

    @Column(length = 255, comment = N_BILLNO)
    private String billNo;

    @Column(length = 255, comment = N_AREANAME)
    private String areaName;

    @Column(length = 11, comment = N_AREACODE)
    private Integer areaCode;

    @Column(notNull = true, comment = N_BILLDATE)
    private Date billDate;

    @Column(notNull = true, length = 11, comment = N_BILLTYPE)
    private Integer billType;

    @Column(notNull = true, length = 2, comment = N_STATUSCODE)
    private Integer statusCode;

    @Column(notNull = true, comment = N_CREATEDTIME)
    private Date createdTime;

    @Column(notNull = true, length = 200, comment = N_USERCODE)
    private String userCode;

    @Column(notNull = true, length = 200, comment = N_ROOMCODE)
    private String roomCode;

    @Column(notNull = true, comment = N_BEGINDATE)
    private Date beginDate;

    @Column(notNull = true, comment = N_ENDDATE)
    private Date endDate;

    @Column(notNull = true, type = MySqlTypeConst.DECIMAL, length = 11, comment = N_TOTALMONEY)
        private Double totalMoney;

    @Column(type = MySqlTypeConst.SMALLINT, length = 1, notNull = true, defaultValue = "0", comment = N_DEL_FLAG)
    private Integer delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

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

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}
