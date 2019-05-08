package com.joy.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import static com.joy.example.BillInfoExample.*;

@ApiModel(description = "账单详情展示对象")
public class BillInfoVO {

    @ApiModelProperty(notes = N_PKCHARGEITEM, example = E_PKCHARGEITEM)
    private String pkChargeItem;

    @ApiModelProperty(notes = N_CHARGEITEM, example = E_CHARGEITEM)
    private String chargeItem;

    @ApiModelProperty(notes = N_FEETYPE, example = E_FEETYPE)
    private Integer feeType;

    @ApiModelProperty(notes = N_NPRICE, example = E_NPRICE)
    private Double nprice;

    @ApiModelProperty(notes = N_ADVANCEMONEY, example = E_ADVANCEMONEY)
    private Double advanceMoney;

    @ApiModelProperty(notes = N_DISCOUNTMONEY, example = E_DISCOUNTMONEY)
    private Double discountMoney;

    @ApiModelProperty(notes = N_DISCOUNT, example = E_DISCOUNT)
    private Double discount;

    @ApiModelProperty(notes = N_CHARGEMONEY, example = E_CHARGEMONEY)
    private Double chargeMoney;

    @ApiModelProperty(notes = N_NCPKSTD, example = E_NCPKSTD)
    private String ncPkStd;

    @ApiModelProperty(notes = N_NCPKDISCOUNT, example = E_NCPKDISCOUNT)
    private String ncPkDiscount;

    @ApiModelProperty(notes = N_DISCOUNTNAME, example = E_DISCOUNTNAME)
    private String discountName;

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
