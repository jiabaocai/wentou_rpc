package com.bwtservice.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Product implements Serializable {
    private Integer id;

    private String product_no;

    private Integer assetside_id;

    private Integer rdg_id;

    private Integer goods_group_id;

    private Integer contract_id;

    private Byte tc;

    private Byte ibm;

    private BigDecimal day_rate;

    private BigDecimal ffr;

    private BigDecimal lineup;

    private BigDecimal linedown;

    private Integer total;

    private BigDecimal warning_line;

    private Byte disposal_plan;

    private String contact_id;

    private Date createtime;

    private Byte status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct_no() {
        return product_no;
    }

    public void setProduct_no(String product_no) {
        this.product_no = product_no == null ? null : product_no.trim();
    }

    public Integer getAssetside_id() {
        return assetside_id;
    }

    public void setAssetside_id(Integer assetside_id) {
        this.assetside_id = assetside_id;
    }

    public Integer getRdg_id() {
        return rdg_id;
    }

    public void setRdg_id(Integer rdg_id) {
        this.rdg_id = rdg_id;
    }

    public Integer getGoods_group_id() {
        return goods_group_id;
    }

    public void setGoods_group_id(Integer goods_group_id) {
        this.goods_group_id = goods_group_id;
    }

    public Integer getContract_id() {
        return contract_id;
    }

    public void setContract_id(Integer contract_id) {
        this.contract_id = contract_id;
    }

    public Byte getTc() {
        return tc;
    }

    public void setTc(Byte tc) {
        this.tc = tc;
    }

    public Byte getIbm() {
        return ibm;
    }

    public void setIbm(Byte ibm) {
        this.ibm = ibm;
    }

    public BigDecimal getDay_rate() {
        return day_rate;
    }

    public void setDay_rate(BigDecimal day_rate) {
        this.day_rate = day_rate;
    }

    public BigDecimal getFfr() {
        return ffr;
    }

    public void setFfr(BigDecimal ffr) {
        this.ffr = ffr;
    }

    public BigDecimal getLineup() {
        return lineup;
    }

    public void setLineup(BigDecimal lineup) {
        this.lineup = lineup;
    }

    public BigDecimal getLinedown() {
        return linedown;
    }

    public void setLinedown(BigDecimal linedown) {
        this.linedown = linedown;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public BigDecimal getWarning_line() {
        return warning_line;
    }

    public void setWarning_line(BigDecimal warning_line) {
        this.warning_line = warning_line;
    }

    public Byte getDisposal_plan() {
        return disposal_plan;
    }

    public void setDisposal_plan(Byte disposal_plan) {
        this.disposal_plan = disposal_plan;
    }

    public String getContact_id() {
        return contact_id;
    }

    public void setContact_id(String contact_id) {
        this.contact_id = contact_id == null ? null : contact_id.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", product_no=").append(product_no);
        sb.append(", assetside_id=").append(assetside_id);
        sb.append(", rdg_id=").append(rdg_id);
        sb.append(", goods_group_id=").append(goods_group_id);
        sb.append(", contract_id=").append(contract_id);
        sb.append(", tc=").append(tc);
        sb.append(", ibm=").append(ibm);
        sb.append(", day_rate=").append(day_rate);
        sb.append(", ffr=").append(ffr);
        sb.append(", lineup=").append(lineup);
        sb.append(", linedown=").append(linedown);
        sb.append(", total=").append(total);
        sb.append(", warning_line=").append(warning_line);
        sb.append(", disposal_plan=").append(disposal_plan);
        sb.append(", contact_id=").append(contact_id);
        sb.append(", createtime=").append(createtime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}