package com.bwtservice.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoanOrderWithBLOBs extends LoanOrder implements Serializable {
    private String remark;

    private String loan_info;

    private String goods_info;

    private String bankCard_info;

    private String rate;


}