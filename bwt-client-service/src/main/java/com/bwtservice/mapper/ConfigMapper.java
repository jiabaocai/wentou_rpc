package com.bwtservice.mapper;

import com.bwtservice.entity.Config;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ConfigMapper {
    @Delete({
        "delete from config",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into config (id, telname, ",
        "state, cime, current, ",
        "remark, url, level)",
        "values (#{id,jdbcType=INTEGER}, #{telname,jdbcType=VARCHAR}, ",
        "#{state,jdbcType=VARCHAR}, #{cime,jdbcType=TIMESTAMP}, #{current,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, #{level,jdbcType=VARCHAR})"
    })
    int insert(Config record);

    @InsertProvider(type=ConfigSqlProvider.class, method="insertSelective")
    int insertSelective(Config record);

    @Select({
        "select",
        "id, telname, state, cime, current, remark, url, level",
        "from config",
        "where current=#{current,jdbcType=VARCHAR} and telname=#{telname,jdbcType=VARCHAR} and state=#{state,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="telname", property="telname", jdbcType=JdbcType.VARCHAR),
        @Result(column="state", property="state", jdbcType=JdbcType.VARCHAR),
        @Result(column="cime", property="cime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="current", property="current", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="level", property="level", jdbcType=JdbcType.VARCHAR)
    })
    List<Config> selectByPrimary(@Param("state")String state,@Param("telname")String telname, @Param("current")String current);

    @UpdateProvider(type=ConfigSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Config record);

    @Update({
        "update config",
        "set telname = #{telname,jdbcType=VARCHAR},",
          "state = #{state,jdbcType=VARCHAR},",
          "cime = #{cime,jdbcType=TIMESTAMP},",
          "current = #{current,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "level = #{level,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Config record);
}