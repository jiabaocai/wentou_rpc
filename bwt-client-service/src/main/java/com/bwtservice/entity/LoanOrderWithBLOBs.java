package com.bwtservice.entity;

import java.io.Serializable;

public class LoanOrderWithBLOBs extends LoanOrder implements Serializable {
    private String remark;

    private String loan_info;

    private String goods_info;

    private String bankCard_info;

    private String rate;

    private static final long serialVersionUID = 1L;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getLoan_info() {
        return loan_info;
    }

    public void setLoan_info(String loan_info) {
        this.loan_info = loan_info == null ? null : loan_info.trim();
    }

    public String getGoods_info() {
        return goods_info;
    }

    public void setGoods_info(String goods_info) {
        this.goods_info = goods_info == null ? null : goods_info.trim();
    }

    public String getBankCard_info() {
        return bankCard_info;
    }

    public void setBankCard_info(String bankCard_info) {
        this.bankCard_info = bankCard_info == null ? null : bankCard_info.trim();
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate == null ? null : rate.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", remark=").append(remark);
        sb.append(", loan_info=").append(loan_info);
        sb.append(", goods_info=").append(goods_info);
        sb.append(", bankCard_info=").append(bankCard_info);
        sb.append(", rate=").append(rate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}