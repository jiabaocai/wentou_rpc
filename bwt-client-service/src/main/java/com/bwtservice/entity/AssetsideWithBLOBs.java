package com.bwtservice.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class AssetsideWithBLOBs extends Assetside implements Serializable {
    private String partner;

    private String team;

    private String contactinfo;

}