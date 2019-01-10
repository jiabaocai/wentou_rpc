package com.bwtservice.mapper;

import com.bwtservice.entity.ContractTpl;
import org.apache.ibatis.jdbc.SQL;

public class ContractTplSqlProvider {

    public String insertSelective(ContractTpl record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("contract_tpl");
        
        if (record.getTpl_id() != null) {
            sql.VALUES("tpl_id", "#{tpl_id,jdbcType=INTEGER}");
        }
        
        if (record.getTpl_name() != null) {
            sql.VALUES("tpl_name", "#{tpl_name,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCreate_uid() != null) {
            sql.VALUES("create_uid", "#{create_uid,jdbcType=INTEGER}");
        }
        
        if (record.getUpdate_uid() != null) {
            sql.VALUES("update_uid", "#{update_uid,jdbcType=INTEGER}");
        }
        
        if (record.getCreate_time() != null) {
            sql.VALUES("create_time", "#{create_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdate_time() != null) {
            sql.VALUES("update_time", "#{update_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTimes() != null) {
            sql.VALUES("times", "#{times,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ContractTpl record) {
        SQL sql = new SQL();
        sql.UPDATE("contract_tpl");
        
        if (record.getTpl_name() != null) {
            sql.SET("tpl_name = #{tpl_name,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCreate_uid() != null) {
            sql.SET("create_uid = #{create_uid,jdbcType=INTEGER}");
        }
        
        if (record.getUpdate_uid() != null) {
            sql.SET("update_uid = #{update_uid,jdbcType=INTEGER}");
        }
        
        if (record.getCreate_time() != null) {
            sql.SET("create_time = #{create_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdate_time() != null) {
            sql.SET("update_time = #{update_time,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTimes() != null) {
            sql.SET("times = #{times,jdbcType=INTEGER}");
        }
        
        sql.WHERE("tpl_id = #{tpl_id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}