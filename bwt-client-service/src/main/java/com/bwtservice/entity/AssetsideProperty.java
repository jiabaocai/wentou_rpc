package com.bwtservice.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AssetsideProperty implements Serializable {
    private Integer id;

    private Integer assetside_id;

    private Date bs_enddate;

    private String bs_al;

    private String bs_deposit;

    private String bs_npm;

    private String pi_productname;

    private String pi_productsum;

    private String pi_al;

    private Date pi_contactterm;

    private Date pi_weightingterm;

    private String pi_rate;

    private String charge_way;

    private String repay_way;

    private String feature;

    private String rg_way;

    private String fund_term;

    private String fund_flow;

    private String al_tunnel;

    private String repay_tunnel;

    private String sign_way;

    private String risk_feature;
}