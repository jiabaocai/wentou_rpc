package com.bwtservice.mapper;

import com.bwtservice.entity.GoodsGroup;
import org.apache.ibatis.jdbc.SQL;

public class GoodsGroupSqlProvider {

    public String insertSelective(GoodsGroup record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("goods_group");

        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }

        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(GoodsGroup record) {
        SQL sql = new SQL();
        sql.UPDATE("goods_group");

        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }

        sql.WHERE("id = #{id,jdbcType=INTEGER}");

        return sql.toString();
    }

    public String selectGoodsGroupLike(GoodsGroup goodsGroup) {
        return new SQL() {{
            SELECT("id, name");
            FROM("goods_group");
            if (goodsGroup.getName() != null) {
                WHERE("name like CONCAT('%',#{name},'%')");
            }
            ORDER_BY("id desc");
        }}.toString();
    }
}