package com.joy.controller;

import java.util.List;
import java.util.Map;

import com.joy.api.PreOrderAPI;
import com.joy.core.Result;
import com.joy.core.SafeKit;
import com.joy.dto.PreOrderAddDTO;
import com.joy.exception.ServiceException;
import com.joy.service.PreOrderService;
import com.joy.vo.OrderInfoVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/propertyfee")
@Api(value = "测试接口Controller")
public class OrderController implements PreOrderAPI {

    @Autowired
    private PreOrderService preOrderService;

    @Override
    @PostMapping(value = "createPreOrder")
    public Result createPreOrder(@Valid @RequestBody PreOrderAddDTO preOrderAddDTO) {
        Map<String, Object> resultMap = preOrderService.createPreOrder(preOrderAddDTO);
        if (resultMap != null && !resultMap.isEmpty()) {
            if (!SafeKit.getBoolean(resultMap.get("isSuccess"))) {
                String errorMsg = SafeKit.getString(resultMap.get("errorMsg"));
                return Result.fail(errorMsg);
            } else {
                Result result = Result.success();
                result.setData(resultMap.get("billNo"));
                return result;
            }
        }
        return Result.fail();
    }

    @Override
    @GetMapping(value = "preOrderList")
    public Result<List<OrderInfoVO>> preOrderList(String userCode, Integer orderStatus, Integer orderTime) {
        if (SafeKit.isEmpty(userCode)) {
            throw new ServiceException("业主代码不能为空");
        }
        List<OrderInfoVO> orderInfoVOList = preOrderService.getPreOrderList(userCode, orderStatus, orderTime);
        Result<List<OrderInfoVO>> result = Result.success();
        result.setData(orderInfoVOList);
        return result;
    }
}
