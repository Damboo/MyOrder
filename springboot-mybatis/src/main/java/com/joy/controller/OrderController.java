package com.joy.controller;

import java.util.List;

import com.joy.pojo.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joy.pojo.PreOrder;
import com.joy.service.OrderService;

@RestController
@RequestMapping("/propertyfee")
@Api(description = "订单管理")
public class OrderController {

	@Autowired
	private OrderService orderService;

    /**
     * 添加用户
     * @param user
     * @return
     */
    @ApiOperation(value="生成预缴订单", notes="生成预缴订单接口")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "Order")
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody PreOrder user){
        JsonResult r = new JsonResult();
        try {
            users.put(user.getId(), user);
            r.setResult(user.getId());
            r.setResultCode(200);
            r.setMsg("成功");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    @RequestMapping("/userlist")
	public List<PreOrder> queryList(){
		return orderService.queryList();
	}

    @RequestMapping("/queryUser")
    public PreOrder queryUserEntity(long userId){
        PreOrder preOrder = orderService.findById(userId);
        return preOrder;
    }



    @RequestMapping("/insertParam")
    public int insertParam() {
        return orderService.insertParam();
    }

    @RequestMapping("/insertByMap")
    public int insertByMap() {
        return orderService.insertByMap();
    }

    @RequestMapping("/updateEntity")
    public int updateEntity() {
        return orderService.updateEntity();
    }

    @RequestMapping("/deleteEntity")
    public int deleteEntity() {
        return orderService.deleteEntity();
    }
}
