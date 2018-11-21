package com.bwtservice.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsPhone implements Serializable {
    private Integer id;

    private Integer category_id;

    private String band;

    private String model;

    private String color;

    private String memory;

    private String storage;

    private String size;

    private String unique_code;

    private Integer order_id;


}