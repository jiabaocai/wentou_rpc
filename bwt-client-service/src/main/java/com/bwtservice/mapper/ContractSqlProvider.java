package com.bwtservice.mapper;

import com.bwtservice.entity.Contract;
import org.apache.ibatis.jdbc.SQL;

public class ContractSqlProvider {

    public String insertSelective(Contract record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("contract");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getContract_no() != null) {
            sql.VALUES("contract_no", "#{contract_no,jdbcType=CHAR}");
        }
        
        if (record.getContract_start() != null) {
            sql.VALUES("contract_start", "#{contract_start,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContract_end() != null) {
            sql.VALUES("contract_end", "#{contract_end,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAssetside_id() != null) {
            sql.VALUES("assetside_id", "#{assetside_id,jdbcType=INTEGER}");
        }
        
        if (record.getClient_name() != null) {
            sql.VALUES("client_name", "#{client_name,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_id() != null) {
            sql.VALUES("order_id", "#{order_id,jdbcType=INTEGER}");
        }
        
        if (record.getSigndate() != null) {
            sql.VALUES("signdate", "#{signdate,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Contract record) {
        SQL sql = new SQL();
        sql.UPDATE("contract");
        
        if (record.getContract_no() != null) {
            sql.SET("contract_no = #{contract_no,jdbcType=CHAR}");
        }
        
        if (record.getContract_start() != null) {
            sql.SET("contract_start = #{contract_start,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContract_end() != null) {
            sql.SET("contract_end = #{contract_end,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAssetside_id() != null) {
            sql.SET("assetside_id = #{assetside_id,jdbcType=INTEGER}");
        }
        
        if (record.getClient_name() != null) {
            sql.SET("client_name = #{client_name,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_id() != null) {
            sql.SET("order_id = #{order_id,jdbcType=INTEGER}");
        }
        
        if (record.getSigndate() != null) {
            sql.SET("signdate = #{signdate,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}