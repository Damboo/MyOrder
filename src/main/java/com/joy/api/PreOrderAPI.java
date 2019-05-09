package com.joy.api;

import com.joy.core.Result;
import com.joy.dto.PreOrderAddDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;


@Api(tags = "PreOrderManage", description = "预缴订单相关服务")
public interface PreOrderAPI {

    /******************************生成预缴订单接口*****************************/
    @ApiOperation(value = "生成预缴订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "preOrderAddDTO", dataType = "PreOrderAddDTO", value = "预缴订单添加DTO", paramType = "body"),
    })
    Result createPreOrder(PreOrderAddDTO preOrderAddDTO, BindingResult bindingResult);


    /******************************查询预缴费订单列表接口*****************************/
    @ApiOperation(value = "查询预缴费订单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userCode", dataType = "String", value = "业主代码", paramType = "query"),
            @ApiImplicitParam(name = "orderStatus", dataType = "Integer", value = "状态筛选", paramType = "query"),
            @ApiImplicitParam(name = "orderTime", dataType = "Integer", value = "时间筛选", paramType = "query"),
    })
    Result preOrderList(String userCode, Integer orderStatus, Integer orderTime);

}
