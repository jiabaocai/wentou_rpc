package com.bwtservice.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class AssetsidePropertyWithBLOBs extends AssetsideProperty implements Serializable {
    private String capital_list;

    private String outer_list;

}