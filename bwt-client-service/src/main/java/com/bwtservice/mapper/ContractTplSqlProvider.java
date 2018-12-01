package com.bwtservice.mapper;

import com.bwtservice.entity.ContractTpl;
import com.bwtservice.entity.ContractTplDto;
import com.bwtservice.entity.ProductOrderReq;
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

        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=LONGVARCHAR}");
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

        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=LONGVARCHAR}");
        }

        sql.WHERE("tpl_id = #{tpl_id,jdbcType=INTEGER}");

        return sql.toString();
    }

    public String selectContractTpl(ContractTplDto ass) {
        return new SQL() {{
            SELECT(" tpl_id, tpl_name, remark, create_uid, update_uid, create_time, update_time,times, content,( SELECT b.real_name FROM `user` b WHERE id = create_uid )  create_user,( SELECT b.real_name FROM `user` b WHERE id = update_uid )  update_user");
            FROM("contract_tpl");

            if (ass.getTpl_name() != null) {
                WHERE("tpl_name like CONCAT('%',#{tpl_name},'%')");
            }
            if (ass.getStartDate() != null && ass.getEndDate() != null) {
                WHERE("create_time  between  #{startDate} and  #{endDate}");
            } else {
                if (ass.getStartDate() != null) {
                    WHERE("create_time >= #{startDate}");
                } else if( ass.getEndDate() != null){
                    WHERE("create_time <= #{endDate}");
                }
            }
            ORDER_BY("tpl_id desc");
        }}.toString();
    }
}