package com.bwtservice.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderPlan implements Serializable {
    private Integer id;

    private Byte period;

    private BigDecimal loan_amount;

    private Date interest_start;

    private Date interest_end;

    private Byte days;

    private Byte loan_status;

    private BigDecimal rp_amount;

    private BigDecimal rp_amount2;

    private BigDecimal rp_interest;

    private BigDecimal rp_capital;

    private BigDecimal cash_balance;

    private Byte rp_status;

    private Integer order_id;

    private Integer assetside_id;

    private BigDecimal balance;
    
}