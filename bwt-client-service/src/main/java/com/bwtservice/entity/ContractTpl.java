package com.bwtservice.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ContractTpl implements Serializable {
    private Integer tpl_id;

    private String tpl_name;

    private String remark;

    private String content;

    private Integer create_uid;

    private Integer update_uid;

    private String create_time;

    private String update_time;

    private Integer times;

    private static final long serialVersionUID = 1L;

}