package com.bwtservice.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Contract implements Serializable {
    private Integer id;

    private String contract_no;

    private String contract_start;

    private String contract_end;

    private Integer assetside_id;

    private String client_name;

    private Integer order_id;

    private Date signdate;


}