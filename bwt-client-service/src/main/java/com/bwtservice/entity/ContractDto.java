package com.bwtservice.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ContractDto  {

    private Integer contract_id;

    private String contract_no;

    private String contract_start;

    private String contract_end;

    private Integer order_id;

    private String signdate;

    private Integer assetside_id;

    private String name;

    private String corp_name;

    private String corp_no;

    private String corp_img;

    private String reg_cap;

    private String foundingtime;

    private String legal_rep;

    private String address;

    private String qualification;

    private String bankname;

    private String bankaccount;

    private String createtime;

    private Integer assetside_status;

    private Integer product_order_id;

    private Integer product_id;

    private String order_no;

    private String interest_start;

    private String interst_end;

    private BigDecimal loan_sum;

    private BigDecimal contract_sum;

    private Integer total_period;

    private Integer received_period;

    private String received_status;

    private Integer overdue_day;

    private BigDecimal dp_sum;

    private String unique_code;

    private String express_no;

    private Integer client_id;

    private String client_name;

    private String client_mobile;

    private String client_idno;

    private String client_address;

    private String phone_band;

    private String phone_model;

    private String phone_color;

    private String phone_memory;

    private String phone_size;

    private String phone_storage;

    private Integer product_order_status;

    //新增字段
    private String current_period;
    private String current_period_amount;
    private String current_period_capital;
    private String current_period_interest;
    private String assetside_score;
    private String credit_score;
    private String end;
    private String start;
}
