package com.joy.example;

/**
 * 订单下的账单详情信息(一个订单对应多个账单项目)
 */
public class BillInfoExample {

    public static final String N_ID = "ID主键自增";
    public static final String E_ID = "1";

    public static final String N_PKCHARGEITEM = "收费项目主键";
    public static final String E_PKCHARGEITEM = "10011A100000Z001W001";

    public static final String N_CHARGEITEM = "收费项目";
    public static final String E_CHARGEITEM = "物业服务费";

    public static final String N_FEETYPE = "收费标准类型";
    public static final String E_FEETYPE = "0";

    public static final String N_NPRICE = "单价";
    public static final String E_NPRICE = "200.00";

    public static final String N_ADVANCEMONEY = "试算金额";
    public static final String E_ADVANCEMONEY = "3060.00";

    public static final String N_DISCOUNTMONEY = "折扣金额";
    public static final String E_DISCOUNTMONEY = "200.00";

    public static final String N_DISCOUNT = "折扣";
    public static final String E_DISCOUNT = "0.8";

    public static final String N_CHARGEMONEY = "优惠后金额";
    public static final String E_CHARGEMONEY = "2860.00";

    public static final String N_NCPKSTD = "收费标准主键";
    public static final String E_NCPKSTD = "10011A100000Z001W001";

    public static final String N_NCPKDISCOUNT = "折扣方案主键";
    public static final String E_NCPKDISCOUNT = "10011A100000000J2FF7";

    public static final String N_DISCOUNTNAME = "折扣方案名称";
    public static final String E_DISCOUNTNAME = "空置房折扣";

}
