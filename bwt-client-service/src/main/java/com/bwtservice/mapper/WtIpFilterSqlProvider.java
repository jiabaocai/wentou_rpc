package com.bwtservice.mapper;

import com.bwtservice.entity.WtIpFilter;
import org.apache.ibatis.jdbc.SQL;

public class WtIpFilterSqlProvider {

    public String insertSelective(WtIpFilter record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("wt_ip_filter");

        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }

        if (record.getIp() != null) {
            sql.VALUES("ip", "#{ip,jdbcType=VARCHAR}");
        }

        if (record.getModule() != null) {
            sql.VALUES("module", "#{module,jdbcType=VARCHAR}");
        }

        if (record.getMark() != null) {
            sql.VALUES("mark", "#{mark,jdbcType=INTEGER}");
        }

        if (record.getCtime() != null) {
            sql.VALUES("ctime", "#{ctime,jdbcType=TIMESTAMP}");
        }

        if (record.getCuser() != null) {
            sql.VALUES("cuser", "#{cuser,jdbcType=VARCHAR}");
        }

        if (record.getUtime() != null) {
            sql.VALUES("utime", "#{utime,jdbcType=TIMESTAMP}");
        }

        if (record.getLabel() != null) {
            sql.VALUES("label", "#{label,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(WtIpFilter record) {
        SQL sql = new SQL();
        sql.UPDATE("wt_ip_filter");

        if (record.getIp() != null) {
            sql.SET("ip = #{ip,jdbcType=VARCHAR}");
        }

        if (record.getModule() != null) {
            sql.SET("module = #{module,jdbcType=VARCHAR}");
        }

        if (record.getMark() != null) {
            sql.SET("mark = #{mark,jdbcType=INTEGER}");
        }

        if (record.getCtime() != null) {
            sql.SET("ctime = #{ctime,jdbcType=TIMESTAMP}");
        }

        if (record.getCuser() != null) {
            sql.SET("cuser = #{cuser,jdbcType=VARCHAR}");
        }

        if (record.getUtime() != null) {
            sql.SET("utime = #{utime,jdbcType=TIMESTAMP}");
        }

        if (record.getLabel() != null) {
            sql.SET("label = #{label,jdbcType=VARCHAR}");
        }

        sql.WHERE("id = #{id,jdbcType=INTEGER}");

        return sql.toString();
    }


    public String selectWtIpFilter(WtIpFilter ass) {
        return new SQL() {{
            SELECT("id, ip, module, mark, ctime, cuser, utime, label");
            FROM("wt_ip_filter");
            if (ass.getIp() != null) {
                WHERE("ip = #{ip}");
            }
            if (ass.getModule() != null) {
                WHERE("module =#{module}");

            }
            if (ass.getMark() != null) {
                WHERE("mark =#{mark}");
            }
        }}.toString();
    }


}