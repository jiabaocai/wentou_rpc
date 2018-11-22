package com.bwtservice.mapper;

import com.bwtservice.entity.Product;
import org.apache.ibatis.jdbc.SQL;

public class ProductSqlProvider {

    public String insertSelective(Product record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("product");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getProduct_no() != null) {
            sql.VALUES("product_no", "#{product_no,jdbcType=CHAR}");
        }
        
        if (record.getAssetside_id() != null) {
            sql.VALUES("assetside_id", "#{assetside_id,jdbcType=INTEGER}");
        }
        
        if (record.getRdg_id() != null) {
            sql.VALUES("rdg_id", "#{rdg_id,jdbcType=INTEGER}");
        }
        
        if (record.getGoods_group_id() != null) {
            sql.VALUES("goods_group_id", "#{goods_group_id,jdbcType=INTEGER}");
        }
        
        if (record.getContract_id() != null) {
            sql.VALUES("contract_id", "#{contract_id,jdbcType=INTEGER}");
        }
        
        if (record.getTc() != null) {
            sql.VALUES("tc", "#{tc,jdbcType=TINYINT}");
        }
        
        if (record.getIbm() != null) {
            sql.VALUES("ibm", "#{ibm,jdbcType=TINYINT}");
        }
        
        if (record.getDay_rate() != null) {
            sql.VALUES("day_rate", "#{day_rate,jdbcType=DECIMAL}");
        }
        
        if (record.getFfr() != null) {
            sql.VALUES("ffr", "#{ffr,jdbcType=DECIMAL}");
        }
        
        if (record.getLineup() != null) {
            sql.VALUES("lineup", "#{lineup,jdbcType=DECIMAL}");
        }
        
        if (record.getLinedown() != null) {
            sql.VALUES("linedown", "#{linedown,jdbcType=DECIMAL}");
        }
        
        if (record.getTotal() != null) {
            sql.VALUES("total", "#{total,jdbcType=INTEGER}");
        }
        
        if (record.getWarning_line() != null) {
            sql.VALUES("warning_line", "#{warning_line,jdbcType=DECIMAL}");
        }
        
        if (record.getDisposal_plan() != null) {
            sql.VALUES("disposal_plan", "#{disposal_plan,jdbcType=TINYINT}");
        }
        
        if (record.getContact_id() != null) {
            sql.VALUES("contact_id", "#{contact_id,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.VALUES("createtime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Product record) {
        SQL sql = new SQL();
        sql.UPDATE("product");
        
        if (record.getProduct_no() != null) {
            sql.SET("product_no = #{product_no,jdbcType=CHAR}");
        }
        
        if (record.getAssetside_id() != null) {
            sql.SET("assetside_id = #{assetside_id,jdbcType=INTEGER}");
        }
        
        if (record.getRdg_id() != null) {
            sql.SET("rdg_id = #{rdg_id,jdbcType=INTEGER}");
        }
        
        if (record.getGoods_group_id() != null) {
            sql.SET("goods_group_id = #{goods_group_id,jdbcType=INTEGER}");
        }
        
        if (record.getContract_id() != null) {
            sql.SET("contract_id = #{contract_id,jdbcType=INTEGER}");
        }
        
        if (record.getTc() != null) {
            sql.SET("tc = #{tc,jdbcType=TINYINT}");
        }
        
        if (record.getIbm() != null) {
            sql.SET("ibm = #{ibm,jdbcType=TINYINT}");
        }
        
        if (record.getDay_rate() != null) {
            sql.SET("day_rate = #{day_rate,jdbcType=DECIMAL}");
        }
        
        if (record.getFfr() != null) {
            sql.SET("ffr = #{ffr,jdbcType=DECIMAL}");
        }
        
        if (record.getLineup() != null) {
            sql.SET("lineup = #{lineup,jdbcType=DECIMAL}");
        }
        
        if (record.getLinedown() != null) {
            sql.SET("linedown = #{linedown,jdbcType=DECIMAL}");
        }
        
        if (record.getTotal() != null) {
            sql.SET("total = #{total,jdbcType=INTEGER}");
        }
        
        if (record.getWarning_line() != null) {
            sql.SET("warning_line = #{warning_line,jdbcType=DECIMAL}");
        }
        
        if (record.getDisposal_plan() != null) {
            sql.SET("disposal_plan = #{disposal_plan,jdbcType=TINYINT}");
        }
        
        if (record.getContact_id() != null) {
            sql.SET("contact_id = #{contact_id,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.SET("createtime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}