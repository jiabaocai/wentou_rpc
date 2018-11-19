package com.bwtservice.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class LoanOrder implements Serializable {
    private Long id;

    private String loan_id;

    private String phone;

    private String user_id;

    private String product_code;

    private String third_order_id;

    private String finance_order_id;

    private String market_channel;

    private Date close_time;

    private BigDecimal amount;

    private String state;

    private String type;

    private String withhold_contract_url;

    private Date withhold_contract_time;

    private Integer stages;

    private Long audit_id;

    private Date created_at;

    private Date update_at;

    private String source;

    private String flag;

    private String related_loan_id;

    private String unit;
}