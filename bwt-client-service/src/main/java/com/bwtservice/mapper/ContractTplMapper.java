package com.bwtservice.mapper;

import com.bwtservice.entity.ContractTpl;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ContractTplMapper {
    @Delete({
        "delete from contract_tpl",
        "where tpl_id = #{tpl_id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tpl_id);

    @Insert({
        "insert into contract_tpl (tpl_id, tpl_name, ",
        "remark, content, ",
        "create_uid, update_uid, ",
        "create_time, update_time, ",
        "times)",
        "values (#{tpl_id,jdbcType=INTEGER}, #{tpl_name,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{content,jdbcType=VARCHAR}, ",
        "#{create_uid,jdbcType=INTEGER}, #{update_uid,jdbcType=INTEGER}, ",
        "#{create_time,jdbcType=TIMESTAMP}, #{update_time,jdbcType=TIMESTAMP}, ",
        "#{times,jdbcType=INTEGER})"
    })
    int insert(ContractTpl record);

    @InsertProvider(type=ContractTplSqlProvider.class, method="insertSelective")
    int insertSelective(ContractTpl record);

    @Select({
        "select",
        "tpl_id, tpl_name, remark, content, create_uid, update_uid, create_time, update_time, ",
        "times",
        "from contract_tpl",
        "where tpl_id = #{tpl_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="tpl_id", property="tpl_id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tpl_name", property="tpl_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_uid", property="create_uid", jdbcType=JdbcType.INTEGER),
        @Result(column="update_uid", property="update_uid", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="create_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="update_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="times", property="times", jdbcType=JdbcType.INTEGER)
    })
    ContractTpl selectByPrimaryKey(Integer tpl_id);

    @UpdateProvider(type=ContractTplSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ContractTpl record);

    @Update({
        "update contract_tpl",
        "set tpl_name = #{tpl_name,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "create_uid = #{create_uid,jdbcType=INTEGER},",
          "update_uid = #{update_uid,jdbcType=INTEGER},",
          "create_time = #{create_time,jdbcType=TIMESTAMP},",
          "update_time = #{update_time,jdbcType=TIMESTAMP},",
          "times = #{times,jdbcType=INTEGER}",
        "where tpl_id = #{tpl_id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ContractTpl record);
}