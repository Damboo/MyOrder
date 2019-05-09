package com.joy.dao;

import com.joy.pojo.BillInfo;
import com.joy.pojo.PreOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Title:
 * Description:
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: MyOrder
 * Author: KylerTien
 * Create Time:19-5-9 00:06
 */
@Mapper
@Repository
public interface BillInfoDao {
    @Insert(" insert into property_pre_payment_option " +
            "  (pkChargeItem,chargeItem,feeType,nprice,advanceMoney,discountMoney,discount,chargeMoney,ncPkStd,ncPkDiscount,discountName)" +
            " values (#{pkChargeItem},#{chargeItem},#{feeType},#{nprice},#{advanceMoney},#{discountMoney},#{discount},#{chargeMoney},#{ncPkStd},#{ncPkDiscount},#{discountName})")
    void save(BillInfo billInfo);

}
