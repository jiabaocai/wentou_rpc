package com.bwtservice.mapper;

import com.bwtservice.entity.OrderPlan;
import org.apache.ibatis.jdbc.SQL;

public class OrderPlanSqlProvider {

    public String insertSelective(OrderPlan record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("order_plan");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getPeriod() != null) {
            sql.VALUES("period", "#{period,jdbcType=TINYINT}");
        }
        
        if (record.getLoan_amount() != null) {
            sql.VALUES("loan_amount", "#{loan_amount,jdbcType=DECIMAL}");
        }
        
        if (record.getInterest_start() != null) {
            sql.VALUES("interest_start", "#{interest_start,jdbcType=TIMESTAMP}");
        }
        
        if (record.getInterest_end() != null) {
            sql.VALUES("interest_end", "#{interest_end,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDays() != null) {
            sql.VALUES("days", "#{days,jdbcType=TINYINT}");
        }
        
        if (record.getLoan_status() != null) {
            sql.VALUES("loan_status", "#{loan_status,jdbcType=TINYINT}");
        }
        
        if (record.getRp_amount() != null) {
            sql.VALUES("rp_amount", "#{rp_amount,jdbcType=DECIMAL}");
        }
        
        if (record.getRp_amount2() != null) {
            sql.VALUES("rp_amount2", "#{rp_amount2,jdbcType=DECIMAL}");
        }
        
        if (record.getRp_interest() != null) {
            sql.VALUES("rp_interest", "#{rp_interest,jdbcType=DECIMAL}");
        }
        
        if (record.getRp_capital() != null) {
            sql.VALUES("rp_capital", "#{rp_capital,jdbcType=DECIMAL}");
        }
        
        if (record.getCash_balance() != null) {
            sql.VALUES("cash_balance", "#{cash_balance,jdbcType=DECIMAL}");
        }
        
        if (record.getRp_status() != null) {
            sql.VALUES("rp_status", "#{rp_status,jdbcType=TINYINT}");
        }
        
        if (record.getOrder_id() != null) {
            sql.VALUES("order_id", "#{order_id,jdbcType=INTEGER}");
        }
        
        if (record.getAssetside_id() != null) {
            sql.VALUES("assetside_id", "#{assetside_id,jdbcType=INTEGER}");
        }
        
        if (record.getBalance() != null) {
            sql.VALUES("balance", "#{balance,jdbcType=DECIMAL}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OrderPlan record) {
        SQL sql = new SQL();
        sql.UPDATE("order_plan");
        
        if (record.getPeriod() != null) {
            sql.SET("period = #{period,jdbcType=TINYINT}");
        }
        
        if (record.getLoan_amount() != null) {
            sql.SET("loan_amount = #{loan_amount,jdbcType=DECIMAL}");
        }
        
        if (record.getInterest_start() != null) {
            sql.SET("interest_start = #{interest_start,jdbcType=TIMESTAMP}");
        }
        
        if (record.getInterest_end() != null) {
            sql.SET("interest_end = #{interest_end,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDays() != null) {
            sql.SET("days = #{days,jdbcType=TINYINT}");
        }
        
        if (record.getLoan_status() != null) {
            sql.SET("loan_status = #{loan_status,jdbcType=TINYINT}");
        }
        
        if (record.getRp_amount() != null) {
            sql.SET("rp_amount = #{rp_amount,jdbcType=DECIMAL}");
        }
        
        if (record.getRp_amount2() != null) {
            sql.SET("rp_amount2 = #{rp_amount2,jdbcType=DECIMAL}");
        }
        
        if (record.getRp_interest() != null) {
            sql.SET("rp_interest = #{rp_interest,jdbcType=DECIMAL}");
        }
        
        if (record.getRp_capital() != null) {
            sql.SET("rp_capital = #{rp_capital,jdbcType=DECIMAL}");
        }
        
        if (record.getCash_balance() != null) {
            sql.SET("cash_balance = #{cash_balance,jdbcType=DECIMAL}");
        }
        
        if (record.getRp_status() != null) {
            sql.SET("rp_status = #{rp_status,jdbcType=TINYINT}");
        }
        
        if (record.getOrder_id() != null) {
            sql.SET("order_id = #{order_id,jdbcType=INTEGER}");
        }
        
        if (record.getAssetside_id() != null) {
            sql.SET("assetside_id = #{assetside_id,jdbcType=INTEGER}");
        }
        
        if (record.getBalance() != null) {
            sql.SET("balance = #{balance,jdbcType=DECIMAL}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}