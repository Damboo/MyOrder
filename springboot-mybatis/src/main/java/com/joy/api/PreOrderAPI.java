package com.joy.api;

import com.joy.core.Result;
import com.joy.dto.PreOrderAddDTO;
import com.joy.vo.OrderInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Map;

@Api(tags = "PreOrderManage", description = "预缴订单相关服务")
public interface PreOrderAPI {

    /******************************生成预缴订单接口*****************************/
    @ApiOperation(value = "生成预缴订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "preOrderAddDTO", dataType = "PreOrderAddDTO", value = "预缴订单添加DTO", paramType = "body"),
    })
    Result<Map<String,Object>> createPreOrder(PreOrderAddDTO preOrderAddDTO);


    /******************************查询预缴费订单列表接口*****************************/
    @ApiOperation(value = "查询预缴费订单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userCode", dataType = "String", value = "业主代码", paramType = "query"),
            @ApiImplicitParam(name = "orderStatus", dataType = "String", value = "状态筛选", paramType = "query"),
            @ApiImplicitParam(name = "orderTime", dataType = "String", value = "时间筛选", paramType = "query"),
    })
    Result<List<OrderInfoVO>> preOrderList(String userCode, String orderStatus, String orderTime);

}
