package com.bwtservice.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WtIpFilter implements Serializable {
    private Integer id;

    private String ip;

    private String module;

    private Integer mark;

    private Date ctime;

    private String cuser;

    private Date utime;

    private String label;


}