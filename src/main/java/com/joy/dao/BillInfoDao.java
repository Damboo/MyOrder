package com.joy.dao;

import com.joy.pojo.BillInfo;
import com.joy.pojo.PreOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BillInfoDao {
    @Insert(" insert into property_pre_payment_option " +
            "  (pkChargeItem,chargeItem,feeType,nprice,advanceMoney,discountMoney,discount,chargeMoney,ncPkStd,ncPkDiscount,discountName)" +
            " values (#{pkChargeItem},#{chargeItem},#{feeType},#{nprice},#{advanceMoney},#{discountMoney},#{discount},#{chargeMoney},#{ncPkStd},#{ncPkDiscount},#{discountName})")
    void save(BillInfo billInfo);

}
