package com.bwtservice.mapper;

import com.bwtservice.entity.UserToken;
import org.apache.ibatis.jdbc.SQL;

public class UserTokenSqlProvider {

    public String insertSelective(UserToken record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user_token");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getUser_id() != null) {
            sql.VALUES("user_id", "#{user_id,jdbcType=BIGINT}");
        }
        
        if (record.getExpire_time() != null) {
            sql.VALUES("expire_time", "#{expire_time,jdbcType=INTEGER}");
        }
        
        if (record.getToken_status() != null) {
            sql.VALUES("token_status", "#{token_status,jdbcType=INTEGER}");
        }
        
        if (record.getToken() != null) {
            sql.VALUES("token", "#{token,jdbcType=VARCHAR}");
        }
        
        if (record.getDevice_code() != null) {
            sql.VALUES("device_code", "#{device_code,jdbcType=VARCHAR}");
        }
        
        if (record.getDevice_type() != null) {
            sql.VALUES("device_type", "#{device_type,jdbcType=VARCHAR}");
        }
        
        if (record.getCreate_time() != null) {
            sql.VALUES("create_time", "#{create_time,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserToken record) {
        SQL sql = new SQL();
        sql.UPDATE("user_token");
        
        if (record.getUser_id() != null) {
            sql.SET("user_id = #{user_id,jdbcType=BIGINT}");
        }
        
        if (record.getExpire_time() != null) {
            sql.SET("expire_time = #{expire_time,jdbcType=INTEGER}");
        }
        
        if (record.getToken_status() != null) {
            sql.SET("token_status = #{token_status,jdbcType=INTEGER}");
        }
        
        if (record.getToken() != null) {
            sql.SET("token = #{token,jdbcType=VARCHAR}");
        }
        
        if (record.getDevice_code() != null) {
            sql.SET("device_code = #{device_code,jdbcType=VARCHAR}");
        }
        
        if (record.getDevice_type() != null) {
            sql.SET("device_type = #{device_type,jdbcType=VARCHAR}");
        }
        
        if (record.getCreate_time() != null) {
            sql.SET("create_time = #{create_time,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}