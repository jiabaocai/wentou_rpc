package com.bwtservice.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Client implements Serializable {
    private Integer id;

    private String name;

    private String idnumber;

    private String mobile;

    private String report;
    private String credit_score;
    private String assetside_score;
}