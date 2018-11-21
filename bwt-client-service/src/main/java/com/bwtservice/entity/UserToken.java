package com.bwtservice.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserToken implements Serializable {
    private Long id;

    private Long user_id;

    private Integer expire_time;

    private Integer token_status;

    private String token;

    private String device_code;

    private String device_type;

    private Integer create_time;


}