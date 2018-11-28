package com.bwtservice.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Product implements Serializable {
    private Integer id;

    private String product_no;

    private Integer assetside_id;

    private Integer rdg_id;

    private Integer goods_group_id;

    private Integer contract_id;

    private Byte tc;

    private Byte ibm;

    private BigDecimal year_rate;

    private BigDecimal ffr;

    private BigDecimal lineup;

    private BigDecimal linedown;

    private Integer total;

    private BigDecimal warning_line;

    private String product_name;

    private Byte disposal_plan;

    private String contact_id;

    private Date createtime;

    private Byte status;
}