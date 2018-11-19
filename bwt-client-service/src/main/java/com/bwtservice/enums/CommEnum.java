package com.bwtservice.enums;

public enum  CommEnum {
    CATEGORY("类目表", "category"),
    GOODS_PHONE("商品手机表", "goods_phone"),
    GOODS_GROUP("商品组", "goods_group");

    private String description;
    private String name;

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    CommEnum(String description, String name) {
        this.description = description;
        this.name = name;
    }
    public static boolean isExit(String name) {
        if (name == null) {
            return false;
        }
        for (CommEnum commEnum : CommEnum.values()) {
            if (name.equals(commEnum.name())) {
                return true;
            }
        }
        return false;
    }
}
