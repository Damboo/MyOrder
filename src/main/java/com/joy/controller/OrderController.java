package com.joy.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.joy.api.PreOrderAPI;
import com.joy.constant.OrderConstant;
import com.joy.core.Result;
import com.joy.core.SafeKit;
import com.joy.dto.PreOrderAddDTO;
import com.joy.service.PreOrderService;
import com.joy.vo.OrderInfoVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/propertyfee")
@Api(value = "测试接口Controller")
public class OrderController implements PreOrderAPI {

    @Autowired
    private PreOrderService preOrderService;
    private Result result;

    @Override
    @PostMapping(value = "createPreOrder")
    public Result createPreOrder(@Valid @RequestBody PreOrderAddDTO preOrderAddDTO, BindingResult bindingResult) {
        //若有为空的参数
        if (bindingResult.hasErrors()) {
            return Result.fail(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        Map<String, Object> resultMap = preOrderService.createPreOrder(preOrderAddDTO);
        if (resultMap != null && !resultMap.isEmpty()) {
            if (!SafeKit.getBoolean(resultMap.get("isSuccess"))) {
                String errorMsg = SafeKit.getString(resultMap.get("errorMsg"));
                return Result.fail(errorMsg);
            } else {
                result.setData(resultMap.get("billNo"));
                return result;
            }
        }
        return Result.fail("创建预缴订单失败");
    }

    @Override
    @GetMapping(value = "preOrderList")
    public Result preOrderList(String userCode, Integer orderStatus, Integer orderTime) {
        if (SafeKit.isEmpty(userCode)) {
            return Result.fail("业主代码不能为空");
        }
        if (null != orderStatus) {
            if (!orderStatus.equals(OrderConstant.TOBEPAID_CODE) && !orderStatus.equals(OrderConstant.PAID_CODE) && !orderStatus.equals(OrderConstant.CANCEL_CODE)) {
                return Result.fail("请输入正确的订单状态");
            }
        }
        if (null != orderTime) {
            if (!orderTime.equals(OrderConstant.THREEMONTH_CODE) || !orderTime.equals(OrderConstant.SIXMONTH_CODE) || !orderTime.equals(OrderConstant.ONEYEAR_CODE)) {
                return Result.fail("查询最近月份仅限3月,6月,1年,请检查时间参数是否正确");
            }
        }
        List<OrderInfoVO> orderInfoVOList = preOrderService.getPreOrderList(userCode, orderStatus, orderTime);
        result = Result.success();
        result.setData(orderInfoVOList);
        return result;
    }
}
