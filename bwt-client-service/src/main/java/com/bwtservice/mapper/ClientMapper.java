package com.bwtservice.mapper;

import com.bwtservice.entity.Client;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ClientMapper {
    @Delete({
        "delete from client",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into client (id, name, ",
        "idnumber, mobile, report)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{idnumber,jdbcType=CHAR}, #{mobile,jdbcType=CHAR}, #{report,jdbcType=LONGVARCHAR})"
    })
    int insert(Client record);

    @InsertProvider(type=ClientSqlProvider.class, method="insertSelective")
    int insertSelective(Client record);

    @Select({
        "select",
        "id, name, idnumber, mobile, report",
        "from client",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="idnumber", property="idnumber", jdbcType=JdbcType.CHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.CHAR),
        @Result(column="report", property="report", jdbcType=JdbcType.LONGVARCHAR)
    })
    Client selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ClientSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Client record);

    @Update({
        "update client",
        "set name = #{name,jdbcType=VARCHAR},",
          "idnumber = #{idnumber,jdbcType=CHAR},",
          "mobile = #{mobile,jdbcType=CHAR},",
          "report = #{report,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Client record);

    @Update({
        "update client",
        "set name = #{name,jdbcType=VARCHAR},",
          "idnumber = #{idnumber,jdbcType=CHAR},",
          "mobile = #{mobile,jdbcType=CHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Client record);
}