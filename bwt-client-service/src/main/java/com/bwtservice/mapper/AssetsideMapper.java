package com.bwtservice.mapper;

import com.bwtservice.entity.Assetside;
import com.bwtservice.entity.AssetsideWithBLOBs;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface AssetsideMapper {
    @Delete({
            "delete from assetside",
            "where assetside_id = #{assetside_id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer assetside_id);

    @Insert({
            "insert into assetside (assetside_id, name, ",
            "corp_name, corp_no, ",
            "corp_img, reg_cap, ",
            "foundingtime, legal_rep, ",
            "address, qualification, ",
            "backname, backaccount, ",
            "createtime, status, ",
            "partner, team, ",
            "contactinfo)",
            "values (#{assetside_id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
            "#{corp_name,jdbcType=VARCHAR}, #{corp_no,jdbcType=CHAR}, ",
            "#{corp_img,jdbcType=VARCHAR}, #{reg_cap,jdbcType=VARCHAR}, ",
            "#{foundingtime,jdbcType=TIMESTAMP}, #{legal_rep,jdbcType=VARCHAR}, ",
            "#{address,jdbcType=VARCHAR}, #{qualification,jdbcType=VARCHAR}, ",
            "#{backname,jdbcType=VARCHAR}, #{backaccount,jdbcType=VARCHAR}, ",
            "#{createtime,jdbcType=TIMESTAMP}, #{status,jdbcType=TINYINT}, ",
            "#{partner,jdbcType=LONGVARCHAR}, #{team,jdbcType=LONGVARCHAR}, ",
            "#{contactinfo,jdbcType=LONGVARCHAR})"
    })
    int insert(AssetsideWithBLOBs record);

    @InsertProvider(type = AssetsideSqlProvider.class, method = "insertSelective")
//    @SelectKey(statement="select  as id", keyProperty="record.assetside_id", before=true, statementType= StatementType.STATEMENT,resultType=String.class)
    @Options(useGeneratedKeys=true, keyProperty="assetside_id", keyColumn="assetside_id")
    int insertSelective(AssetsideWithBLOBs record);

    @Select({
            "select",
            "assetside_id, name, corp_name, corp_no, corp_img, reg_cap, foundingtime, legal_rep, ",
            "address, qualification, backname, backaccount, createtime, status, partner, ",
            "team, contactinfo",
            "from assetside",
            "where assetside_id = #{assetside_id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "assetside_id", property = "assetside_id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "corp_name", property = "corp_name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "corp_no", property = "corp_no", jdbcType = JdbcType.CHAR),
            @Result(column = "corp_img", property = "corp_img", jdbcType = JdbcType.VARCHAR),
            @Result(column = "reg_cap", property = "reg_cap", jdbcType = JdbcType.VARCHAR),
            @Result(column = "foundingtime", property = "foundingtime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "legal_rep", property = "legal_rep", jdbcType = JdbcType.VARCHAR),
            @Result(column = "address", property = "address", jdbcType = JdbcType.VARCHAR),
            @Result(column = "qualification", property = "qualification", jdbcType = JdbcType.VARCHAR),
            @Result(column = "backname", property = "backname", jdbcType = JdbcType.VARCHAR),
            @Result(column = "backaccount", property = "backaccount", jdbcType = JdbcType.VARCHAR),
            @Result(column = "createtime", property = "createtime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
            @Result(column = "partner", property = "partner", jdbcType = JdbcType.LONGVARCHAR),
            @Result(column = "team", property = "team", jdbcType = JdbcType.LONGVARCHAR),
            @Result(column = "contactinfo", property = "contactinfo", jdbcType = JdbcType.LONGVARCHAR)
    })
    AssetsideWithBLOBs selectByPrimaryKey(Integer assetside_id);

    /**
     * 模糊查询
     *
     * @param ass
     * @return
     */
    @SelectProvider(type = AssetsideSqlProvider.class, method = "selectPersonLike")
    List<AssetsideWithBLOBs> selectByExample(AssetsideWithBLOBs ass);

    @UpdateProvider(type = AssetsideSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AssetsideWithBLOBs record);

    @Update({
            "update assetside",
            "set name = #{name,jdbcType=VARCHAR},",
            "corp_name = #{corp_name,jdbcType=VARCHAR},",
            "corp_no = #{corp_no,jdbcType=CHAR},",
            "corp_img = #{corp_img,jdbcType=VARCHAR},",
            "reg_cap = #{reg_cap,jdbcType=VARCHAR},",
            "foundingtime = #{foundingtime,jdbcType=TIMESTAMP},",
            "legal_rep = #{legal_rep,jdbcType=VARCHAR},",
            "address = #{address,jdbcType=VARCHAR},",
            "qualification = #{qualification,jdbcType=VARCHAR},",
            "backname = #{backname,jdbcType=VARCHAR},",
            "backaccount = #{backaccount,jdbcType=VARCHAR},",
            "createtime = #{createtime,jdbcType=TIMESTAMP},",
            "status = #{status,jdbcType=TINYINT},",
            "partner = #{partner,jdbcType=LONGVARCHAR},",
            "team = #{team,jdbcType=LONGVARCHAR},",
            "contactinfo = #{contactinfo,jdbcType=LONGVARCHAR}",
            "where assetside_id = #{assetside_id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(AssetsideWithBLOBs record);

    @Update({
            "update assetside",
            "set name = #{name,jdbcType=VARCHAR},",
            "corp_name = #{corp_name,jdbcType=VARCHAR},",
            "corp_no = #{corp_no,jdbcType=CHAR},",
            "corp_img = #{corp_img,jdbcType=VARCHAR},",
            "reg_cap = #{reg_cap,jdbcType=VARCHAR},",
            "foundingtime = #{foundingtime,jdbcType=TIMESTAMP},",
            "legal_rep = #{legal_rep,jdbcType=VARCHAR},",
            "address = #{address,jdbcType=VARCHAR},",
            "qualification = #{qualification,jdbcType=VARCHAR},",
            "backname = #{backname,jdbcType=VARCHAR},",
            "backaccount = #{backaccount,jdbcType=VARCHAR},",
            "createtime = #{createtime,jdbcType=TIMESTAMP},",
            "status = #{status,jdbcType=TINYINT}",
            "where assetside_id = #{assetside_id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Assetside record);
}