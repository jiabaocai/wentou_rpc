package com.bwtservice.mapper;

import com.bwtservice.entity.Client;
import com.bwtservice.entity.ClientDto;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ClientMapper {
    @Delete({
        "delete from client",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into client (id, name, ",
        "idnumber, mobile, report,credit_score,assetside_score)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{idnumber,jdbcType=CHAR}, #{mobile,jdbcType=CHAR}, #{report,jdbcType=LONGVARCHAR}, #{credit_score,jdbcType=VARCHAR}, #{assetside_score,jdbcType=VARCHAR})"
    })
    int insert(Client record);

    @InsertProvider(type=ClientSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertSelective(Client record);

    @Select({
        "select",
        "id, name, idnumber, mobile, report,credit_score,assetside_score",
        "from client",
        "where idnumber = #{idnumber,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="idnumber", property="idnumber", jdbcType=JdbcType.CHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.CHAR),
        @Result(column="report", property="report", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="credit_score", property="credit_score", jdbcType=JdbcType.VARCHAR),
        @Result(column="assetside_score", property="assetside_score", jdbcType=JdbcType.VARCHAR)
    })
    Client selectByPrimaryByIdNumber(String idnumber);

    @UpdateProvider(type=ClientSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Client record);

    @SelectProvider(type=ClientSqlProvider.class, method="getClientByExample")
    List<ClientDto> getClientByExample(Client record);

    @SelectProvider(type=ClientSqlProvider.class, method="getClientByExample")
    List<Client> getClientByExample1(Client record);

    @Update({
        "update client",
        "set name = #{name,jdbcType=VARCHAR},",
          "idnumber = #{idnumber,jdbcType=CHAR},",
          "mobile = #{mobile,jdbcType=CHAR},",
          "report = #{report,jdbcType=LONGVARCHAR},",
          "credit_score = #{credit_score,jdbcType=VARCHAR},",
          "assetside_score = #{assetside_score,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Client record);

    @Update({
        "update client",
        "set name = #{name,jdbcType=VARCHAR},",
          "idnumber = #{idnumber,jdbcType=CHAR},",
          "mobile = #{mobile,jdbcType=CHAR},",
          "credit_score = #{credit_score,jdbcType=VARCHAR},",
          "assetside_score = #{assetside_score,jdbcType=VARCHAR} ",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Client record);
}