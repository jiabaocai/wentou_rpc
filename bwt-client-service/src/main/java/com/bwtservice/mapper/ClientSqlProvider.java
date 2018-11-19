package com.bwtservice.mapper;

import com.bwtservice.entity.Client;
import org.apache.ibatis.jdbc.SQL;

public class ClientSqlProvider {

    public String insertSelective(Client record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("client");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIdnumber() != null) {
            sql.VALUES("idnumber", "#{idnumber,jdbcType=CHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.VALUES("mobile", "#{mobile,jdbcType=CHAR}");
        }
        
        if (record.getReport() != null) {
            sql.VALUES("report", "#{report,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Client record) {
        SQL sql = new SQL();
        sql.UPDATE("client");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIdnumber() != null) {
            sql.SET("idnumber = #{idnumber,jdbcType=CHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.SET("mobile = #{mobile,jdbcType=CHAR}");
        }
        
        if (record.getReport() != null) {
            sql.SET("report = #{report,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}