package com.bwtservice.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Category implements Serializable {
    private Integer id;

    private String name;

    private Integer goods_group_id;


}