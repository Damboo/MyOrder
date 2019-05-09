package com.joy.core;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Map;

@ApiModel
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -4569216979022946969L;
    @ApiModelProperty(
            notes = "返回数据",
            required = true
    )
    private T data;

    @ApiModelProperty(
            notes = "返回结果",
            example = "200",
            required = true
    )
    private Integer resultCode = 500;

    @ApiModelProperty(
            notes = "结果信息",
            example = "成功",
            required = true
    )
    private String resultMsg = "失败";

    public Result() {
    }

    public static Result fail() {
        return new Result();
    }

    public static Result fail(String msg) {
        Result result = fail();
        result.setResultMsg(msg);
        return result;
    }

    public static Result success(String msg) {
        Result result = success();
        result.setResultMsg(msg);
        return result;
    }

    public static Result success() {
        return success(new Result());
    }

    public static Result success(Result result) {
        if (result == null) {
            result = new Result();
        }
        result.setResultMsg("成功");
        result.setResultCode(200);
        return result;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Result clearData() {
        this.data = null;
        return this;
    }
}