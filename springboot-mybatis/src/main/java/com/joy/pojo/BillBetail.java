package com.joy.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

@ApiModel
public class BillBetail {
    @ApiModelProperty(value = "缴费详情id", name = "id", required = true)
    private Integer id;

    @ApiModelProperty(value = "收费项目主键", required = true)
    @NotBlank(message = "收费项目主键不能为空")
    private String userCode;
}
