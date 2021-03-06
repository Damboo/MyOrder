package com.joy.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.joy.constant.JsonFieldConst;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

import static com.joy.example.PreOrderExample.*;

public class PreOrderAddDTO extends AbstractDTO {

    @ApiModelProperty(notes = N_USERCODE, example = E_USERCODE)
    @NotNull(message = "业主代码不能为空")
    private String userCode;

    @ApiModelProperty(notes = N_ROOMCODE, example = E_ROOMCODE)
    @NotNull(message = "房间代码不能为空")
    private String roomCode;

    @ApiModelProperty(notes = N_BEGINDATE, example = E_BEGINDATE)
    @NotNull(message = "开始日期不能为空")
    @JSONField(format = JsonFieldConst.DEFAULT_DATETIME_FORMAT)
    private Date beginDate;

    @ApiModelProperty(notes = N_ENDDATE, example = E_ENDDATE)
    @NotNull(message = "截止日期不能为空")
    @JSONField(format = JsonFieldConst.DEFAULT_DATETIME_FORMAT)
    private Date endDate;

    @ApiModelProperty(notes = N_TOTALMONEY, example = E_TOTALMONEY)
    @NotNull(message = "应缴总金额不能为空")
    private Double totalMoney;

    @Valid
    private List<BillInfoAddDTO> billDetailList;

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

    public List<BillInfoAddDTO> getBillDetailList() {
        return billDetailList;
    }

    public void setBillDetailList(List<BillInfoAddDTO> billDetailList) {
        this.billDetailList = billDetailList;
    }
}
