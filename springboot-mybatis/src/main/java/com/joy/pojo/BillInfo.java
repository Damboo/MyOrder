package com.joy.pojo;

import com.joy.core.Column;
import com.joy.core.MySqlTypeConst;
import com.joy.core.TableInfo;
import com.joy.core.Transient;

import static com.joy.example.BillInfoExample.*;

@TableInfo(tableName = BillInfo.TABLE_NAME, pkName = "id")
public class BillInfo {

    @Transient
    public static final String TABLE_NAME = "property_pre_payment_option";

    @Column(length = 10, defaultValue = "", autoIncrement = true, comment = N_ID)
    private Integer id;

    @Column(notNull = true, length = 255, comment = N_PKCHARGEITEM)
    private String pkChargeItem;

    @Column(notNull = true, length = 100, comment = N_CHARGEITEM)
    private String chargeItem;

    @Column(notNull = true, length = 11, comment = N_FEETYPE)
    private Integer feeType;

    @Column(type = MySqlTypeConst.DECIMAL, length = 11, comment = N_NPRICE)
    private Double nprice;

    @Column(type = MySqlTypeConst.DECIMAL, length = 11, comment = N_ADVANCEMONEY)
    private Double advanceMoney;

    @Column(type = MySqlTypeConst.DECIMAL, length = 11, comment = N_DISCOUNTMONEY)
    private Double discountMoney;

    @Column(type = MySqlTypeConst.DECIMAL, length = 11, comment = N_DISCOUNT)
    private Double discount;

    @Column(notNull = true, type = MySqlTypeConst.DECIMAL, length = 11, comment = N_CHARGEMONEY)
    private Double chargeMoney;

    @Column(length = 255, comment = N_NCPKSTD)
    private String ncPkStd;

    @Column(length = 255, comment = N_NCPKDISCOUNT)
    private String ncPkDiscount;

    @Column(length = 255, comment = N_DISCOUNTNAME)
    private String discountName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPkChargeItem() {
        return pkChargeItem;
    }

    public void setPkChargeItem(String pkChargeItem) {
        this.pkChargeItem = pkChargeItem;
    }

    public String getChargeItem() {
        return chargeItem;
    }

    public void setChargeItem(String chargeItem) {
        this.chargeItem = chargeItem;
    }

    public Integer getFeeType() {
        return feeType;
    }

    public void setFeeType(Integer feeType) {
        this.feeType = feeType;
    }

    public Double getNprice() {
        return nprice;
    }

    public void setNprice(Double nprice) {
        this.nprice = nprice;
    }

    public Double getAdvanceMoney() {
        return advanceMoney;
    }

    public void setAdvanceMoney(Double advanceMoney) {
        this.advanceMoney = advanceMoney;
    }

    public Double getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(Double discountMoney) {
        this.discountMoney = discountMoney;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getChargeMoney() {
        return chargeMoney;
    }

    public void setChargeMoney(Double chargeMoney) {
        this.chargeMoney = chargeMoney;
    }

    public String getNcPkStd() {
        return ncPkStd;
    }

    public void setNcPkStd(String ncPkStd) {
        this.ncPkStd = ncPkStd;
    }

    public String getNcPkDiscount() {
        return ncPkDiscount;
    }

    public void setNcPkDiscount(String ncPkDiscount) {
        this.ncPkDiscount = ncPkDiscount;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }
}
