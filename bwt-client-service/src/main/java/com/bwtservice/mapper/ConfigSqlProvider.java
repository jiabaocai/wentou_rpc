package com.bwtservice.mapper;

import com.bwtservice.entity.Config;
import org.apache.ibatis.jdbc.SQL;

public class ConfigSqlProvider {

    public String insertSelective(Config record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("config");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTelname() != null) {
            sql.VALUES("telname", "#{telname,jdbcType=VARCHAR}");
        }
        
        if (record.getState() != null) {
            sql.VALUES("state", "#{state,jdbcType=VARCHAR}");
        }
        
        if (record.getCime() != null) {
            sql.VALUES("cime", "#{cime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCurrent() != null) {
            sql.VALUES("current", "#{current,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.VALUES("url", "#{url,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel() != null) {
            sql.VALUES("level", "#{level,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Config record) {
        SQL sql = new SQL();
        sql.UPDATE("config");
        
        if (record.getTelname() != null) {
            sql.SET("telname = #{telname,jdbcType=VARCHAR}");
        }
        
        if (record.getState() != null) {
            sql.SET("state = #{state,jdbcType=VARCHAR}");
        }
        
        if (record.getCime() != null) {
            sql.SET("cime = #{cime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCurrent() != null) {
            sql.SET("current = #{current,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.SET("url = #{url,jdbcType=VARCHAR}");
        }
        
        if (record.getLevel() != null) {
            sql.SET("level = #{level,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}