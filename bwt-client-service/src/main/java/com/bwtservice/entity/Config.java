package com.bwtservice.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Config implements Serializable {
    private Integer id;

    private String telname;

    private String state;

    private Date cime;

    private String current;

    private String remark;

    private String url;

    private String level;


}