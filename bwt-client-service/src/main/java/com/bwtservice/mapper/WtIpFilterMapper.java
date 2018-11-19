package com.bwtservice.mapper;

import com.bwtservice.entity.WtIpFilter;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface WtIpFilterMapper {
    @Delete({
        "delete from wt_ip_filter",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into wt_ip_filter (id, ip, ",
        "module, mark, ctime, ",
        "cuser, utime, ",
        "label)",
        "values (#{id,jdbcType=INTEGER}, #{ip,jdbcType=VARCHAR}, ",
        "#{module,jdbcType=VARCHAR}, #{mark,jdbcType=INTEGER}, #{ctime,jdbcType=TIMESTAMP}, ",
        "#{cuser,jdbcType=VARCHAR}, #{utime,jdbcType=TIMESTAMP}, ",
        "#{label,jdbcType=VARCHAR})"
    })
    int insert(WtIpFilter record);

    @InsertProvider(type=WtIpFilterSqlProvider.class, method="insertSelective")
    int insertSelective(WtIpFilter record);

    @Select({
        "select",
        "id, ip, module, mark, ctime, cuser, utime, label",
        "from wt_ip_filter",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="module", property="module", jdbcType=JdbcType.VARCHAR),
        @Result(column="mark", property="mark", jdbcType=JdbcType.INTEGER),
        @Result(column="ctime", property="ctime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="cuser", property="cuser", jdbcType=JdbcType.VARCHAR),
        @Result(column="utime", property="utime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="label", property="label", jdbcType=JdbcType.VARCHAR)
    })
    WtIpFilter selectByPrimaryKey(Integer id);


    @SelectProvider(type = WtIpFilterSqlProvider.class,method = "selectWtIpFilter")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
            @Result(column="module", property="module", jdbcType=JdbcType.VARCHAR),
            @Result(column="mark", property="mark", jdbcType=JdbcType.INTEGER),
            @Result(column="ctime", property="ctime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="cuser", property="cuser", jdbcType=JdbcType.VARCHAR),
            @Result(column="utime", property="utime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="label", property="label", jdbcType=JdbcType.VARCHAR)
    })
    List<WtIpFilter> selectWtIpFilter(WtIpFilter ass);

    @UpdateProvider(type=WtIpFilterSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WtIpFilter record);

    @Update({
        "update wt_ip_filter",
        "set ip = #{ip,jdbcType=VARCHAR},",
          "module = #{module,jdbcType=VARCHAR},",
          "mark = #{mark,jdbcType=INTEGER},",
          "ctime = #{ctime,jdbcType=TIMESTAMP},",
          "cuser = #{cuser,jdbcType=VARCHAR},",
          "utime = #{utime,jdbcType=TIMESTAMP},",
          "label = #{label,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(WtIpFilter record);
}