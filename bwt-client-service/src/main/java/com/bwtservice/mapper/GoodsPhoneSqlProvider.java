package com.bwtservice.mapper;

import com.bwtservice.entity.GoodsPhone;
import org.apache.ibatis.jdbc.SQL;

public class GoodsPhoneSqlProvider {

    public String insertSelective(GoodsPhone record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("goods_phone");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCategory_id() != null) {
            sql.VALUES("category_id", "#{category_id,jdbcType=INTEGER}");
        }
        
        if (record.getBand() != null) {
            sql.VALUES("band", "#{band,jdbcType=VARCHAR}");
        }
        
        if (record.getModel() != null) {
            sql.VALUES("model", "#{model,jdbcType=VARCHAR}");
        }
        
        if (record.getColor() != null) {
            sql.VALUES("color", "#{color,jdbcType=VARCHAR}");
        }
        
        if (record.getMemory() != null) {
            sql.VALUES("memory", "#{memory,jdbcType=VARCHAR}");
        }
        
        if (record.getStorage() != null) {
            sql.VALUES("storage", "#{storage,jdbcType=VARCHAR}");
        }
        
        if (record.getSize() != null) {
            sql.VALUES("size", "#{size,jdbcType=VARCHAR}");
        }
        
        if (record.getUnique_code() != null) {
            sql.VALUES("unique_code", "#{unique_code,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_id() != null) {
            sql.VALUES("order_id", "#{order_id,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(GoodsPhone record) {
        SQL sql = new SQL();
        sql.UPDATE("goods_phone");
        
        if (record.getCategory_id() != null) {
            sql.SET("category_id = #{category_id,jdbcType=INTEGER}");
        }
        
        if (record.getBand() != null) {
            sql.SET("band = #{band,jdbcType=VARCHAR}");
        }
        
        if (record.getModel() != null) {
            sql.SET("model = #{model,jdbcType=VARCHAR}");
        }
        
        if (record.getColor() != null) {
            sql.SET("color = #{color,jdbcType=VARCHAR}");
        }
        
        if (record.getMemory() != null) {
            sql.SET("memory = #{memory,jdbcType=VARCHAR}");
        }
        
        if (record.getStorage() != null) {
            sql.SET("storage = #{storage,jdbcType=VARCHAR}");
        }
        
        if (record.getSize() != null) {
            sql.SET("size = #{size,jdbcType=VARCHAR}");
        }
        
        if (record.getUnique_code() != null) {
            sql.SET("unique_code = #{unique_code,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_id() != null) {
            sql.SET("order_id = #{order_id,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}