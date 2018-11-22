package com.bwtservice.entity;

import lombok.Data;

@Data
public class ProductDto extends  Product {
    private String assetside_name;
    private String goods_group_name;
}
