package com.bwtservice.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Assetside implements Serializable {
    private Integer assetside_id;

    private String name;

    private String corp_name;

    private String corp_no;

    private String corp_img;

    private String reg_cap;

    private Date foundingtime;

    private String legal_rep;

    private String address;

    private String qualification;

    private String bankname;

    private String bankaccount;

    private Date createtime;

    private Integer status;
}