package com.joy.dao;

import com.joy.pojo.PreOrder;
import com.joy.vo.OrderInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PreOrderDao {

    @Results({
            @Result(property = "userCode", column = "userCode"),
            @Result(property = "roomCode", column = "roomCode"),
    })
    @Select("SELECT * FROM property_pre_payment WHERE delFlag=0 and statusCode=0 and (userCode = #{userCode} or roomCode = #{roomCode})")
    List<PreOrder> getUserOrder(String userCode, String roomCode);

    @Results({
            @Result(property = "userCode", column = "userCode"),
            @Result(property = "statusCode", column = "statusCode"),
    })
    @Select("SELECT * FROM property_pre_payment WHERE delFlag=0 and statusCode=0 and (userCode = #{userCode} or roomCode = #{roomCode})")
    List<OrderInfoVO> getPreOrderList(String userCode, Integer statusCode, Integer orderTime);


}
