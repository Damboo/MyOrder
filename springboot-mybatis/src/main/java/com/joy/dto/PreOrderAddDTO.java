package com.joy.dto;

import com.joy.vo.BillInfoVO;
import com.joy.vo.OrderInfoVO;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

public class PreOrderAddDTO {

    @ApiModelProperty(value = "业主代码", required = true)
    @NotBlank(message = "业主代码不能为空")
    private String userCode;

    @ApiModelProperty(value = "房间代码", required = true)
    @NotBlank(message = "房间代码不能为空")
    private String roomCode;

    @ApiModelProperty(value = "开始日期", required = true)
    @NotBlank(message = "开始日期不能为空")
    private Date beginDate;

    @ApiModelProperty(value = "截止日期", required = true)
    @NotBlank(message = "截止日期不能为空")
    private Date endDate;

    @ApiModelProperty(value = "应缴总金额", required = true)
    @NotBlank(message = "应缴总金额不能为空")
    private Double totalMoney;

    @ApiModelProperty(value = "账单详情", required = true)
    @NotBlank(message = "账单详情不能为空")
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
