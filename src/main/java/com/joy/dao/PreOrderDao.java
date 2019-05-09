package com.joy.dao;

import com.joy.pojo.PreOrder;
import com.joy.vo.OrderInfoVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PreOrderDao {

    @Insert(" insert into property_pre_payment " +
            "  (billNo,billDate,billType,statusCode,createdTime,userCode,roomCode,beginDate,endDate,totalMoney,delFlag)" +
            " values (#{billNo},#{billDate},#{billType},#{statusCode},#{createdTime},#{userCode},#{roomCode},#{beginDate},#{endDate},#{totalMoney},#{delFlag})")
    void save(PreOrder preOrder);

    @Select("SELECT * FROM property_pre_payment WHERE delFlag=0 and statusCode=0 and (userCode = #{userCode} or roomCode = #{roomCode})")
    List<PreOrder> getUserOrder(String userCode, String roomCode);

    @Select("SELECT * FROM property_pre_payment WHERE delFlag=0 and userCode = #{userCode} and statusCode = #{statusCode} and billDate > #{orderTime}")
    List<OrderInfoVO> getPreOrderList1(String userCode, Integer statusCode, String orderTime);

    @Select("SELECT * FROM property_pre_payment WHERE delFlag=0 and userCode = #{userCode} and statusCode = #{statusCode}")
    List<OrderInfoVO> getPreOrderList2(String userCode, Integer statusCode);

    @Select("SELECT * FROM property_pre_payment WHERE delFlag=0 and userCode = #{userCode} and billDate > #{orderTime}")
    List<OrderInfoVO> getPreOrderList3(String userCode, String orderTime);

    @Select("SELECT * FROM property_pre_payment WHERE delFlag=0 and userCode = #{userCode}")
    List<OrderInfoVO> getPreOrderList4(String userCode);

}
