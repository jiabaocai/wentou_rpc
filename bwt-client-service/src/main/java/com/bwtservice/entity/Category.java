package com.bwtservice.entity;

import java.io.Serializable;

public class Category implements Serializable {
    private Integer id;

    private String name;

    private Integer goods_group_id;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGoods_group_id() {
        return goods_group_id;
    }

    public void setGoods_group_id(Integer goods_group_id) {
        this.goods_group_id = goods_group_id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", goods_group_id=").append(goods_group_id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}