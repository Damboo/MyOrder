package com.joy.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@ApiModel
public class PreOrder {

    @ApiModelProperty(value = "预缴订单id", name = "id", required = true)
    private Integer id;

    @ApiModelProperty(value = "业主代码", required = true)
    @NotBlank(message = "业主代码不能为空")
    private String userCode;

    @ApiModelProperty(value = "房间代码", required = true)
    @NotBlank(message = "房间代码不能为空")
    private String roomCode;

    @ApiModelProperty(value = "开始日期", required = true)
    @NotBlank(message = "开始日期不能为空")
    @Pattern(regexp = "1\\d{10}", message = "开始日期格式错误")
    private String beginDate;

    @ApiModelProperty(value = "截止日期", required = true)
    @NotBlank(message = "截止日期不能为空")
    @Pattern(regexp = "1\\d{10}", message = "截止日期格式错误")
    private String endDate;

    @ApiModelProperty(value = "应缴总金额", required = true)
    @NotBlank(message = "应缴总金额不能为空")
    private Integer totalMoney;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }
}
