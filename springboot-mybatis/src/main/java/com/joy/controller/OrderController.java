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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/propertyfee")
public class OrderController implements PreOrderAPI {

    @Autowired
    private PreOrderService preOrderService;

    @Override
    @PostMapping(value = "createPreOrder")
    public Result<Map<String, Object>> createPreOrder(@RequestBody PreOrderAddDTO preOrderAddDTO) {
        Map<String, Object> resultMap = preOrderService.createPreOrder(preOrderAddDTO);
        if (!SafeKit.getBoolean(resultMap.get("isSuccess"))) {
            Result result = Result.fail(SafeKit.getString(resultMap.get("errorMsg")));
        } else {

        }
        return Result.success();
    }

    @Override
    @GetMapping(value = "preOrderList")
    public Result<List<OrderInfoVO>> preOrderList(String userCode, String orderStatus, String orderTime) {
        if (SafeKit.isEmpty(userCode)) {
            throw new ServiceException("业主代码不能为空");
        }
        if (SafeKit.isEmpty(orderStatus)) {
            throw new ServiceException("状态不能为空");
        }
        if (SafeKit.isEmpty(orderTime)) {
            throw new ServiceException("订单时间不能为空");
        }
        List<OrderInfoVO> orderInfoVOList = preOrderService.getPreOrderList(userCode, orderStatus, orderTime);
        Result<List<OrderInfoVO>> result = Result.success();
        result.setData(null);
        return result;
    }
}
