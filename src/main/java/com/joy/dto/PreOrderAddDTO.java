package com.joy.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.joy.constant.JsonFieldConst;
import com.joy.vo.BillInfoVO;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static com.joy.example.PreOrderExample.*;

public class PreOrderAddDTO implements Serializable {

    @ApiModelProperty(notes = N_USERCODE, example = E_USERCODE)
    @NotNull
    private String userCode;

    @ApiModelProperty(notes = N_ROOMCODE, example = E_ROOMCODE)
    @NotNull
    private String roomCode;

    @ApiModelProperty(notes = N_BEGINDATE, example = E_BEGINDATE)
    @NotNull
    @JSONField(format = JsonFieldConst.DEFAULT_DATETIME_FORMAT)
    private Date beginDate;

    @ApiModelProperty(notes = N_ENDDATE, example = E_ENDDATE)
    @NotNull
    @JSONField(format = JsonFieldConst.DEFAULT_DATETIME_FORMAT)
    private Date endDate;

    @ApiModelProperty(notes = N_TOTALMONEY, example = E_TOTALMONEY)
    @NotNull
    private Double totalMoney;

    private List<BillInfoVO> billDetailList;

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

    public List<BillInfoVO> getBillDetailList() {
        return billDetailList;
    }

    public void setBillDetailList(List<BillInfoVO> billDetailList) {
        this.billDetailList = billDetailList;
    }
}
