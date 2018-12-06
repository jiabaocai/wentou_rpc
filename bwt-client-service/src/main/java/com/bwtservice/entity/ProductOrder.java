package com.bwtservice.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductOrder implements Serializable {
    private Integer id;

    private Integer product_id;

    private String order_no;

    private Integer assetside_id;

    private Date interest_start;

    private Date interst_end;

    private BigDecimal loan_sum;

    private BigDecimal contract_sum;

    private Integer total_period;

    private Integer received_period;

    private Integer received_status;

    private Integer overdue_day;

    private Integer contract_id;

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

    private Integer status;
    private String createtime;
    private String credit_score;
    private String assetside_score;


}