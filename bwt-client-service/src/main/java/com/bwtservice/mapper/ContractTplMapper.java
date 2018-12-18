//package com.bwtservice.mapper;
//
//import com.bwtservice.entity.ContractDto;
//import com.bwtservice.entity.ContractTpl;
//import com.bwtservice.entity.ContractTplDto;
//import com.bwtservice.entity.ContractTplResp;
//import org.apache.ibatis.annotations.*;
//import org.apache.ibatis.type.JdbcType;
//
//import java.util.List;
//
//public interface ContractTplMapper {
//    @Delete({
//        "delete from contract_tpl",
//        "where tpl_id = #{tpl_id,jdbcType=INTEGER}"
//    })
//    int deleteByPrimaryKey(Integer tpl_id);
//
//    @Insert({
//        "insert into contract_tpl (tpl_id, tpl_name, ",
//        "remark, create_uid, ",
//        "update_uid, create_time, ",
//        "update_time, times, ",
//        "content)",
//        "values (#{tpl_id,jdbcType=INTEGER}, #{tpl_name,jdbcType=VARCHAR}, ",
//        "#{remark,jdbcType=VARCHAR}, #{create_uid,jdbcType=INTEGER}, ",
//        "#{update_uid,jdbcType=INTEGER}, #{create_time,jdbcType=TIMESTAMP}, ",
//        "#{update_time,jdbcType=TIMESTAMP}, #{times,jdbcType=INTEGER}, ",
//        "#{content,jdbcType=LONGVARCHAR})"
//    })
//    int insert(ContractTpl record);
//
//    @InsertProvider(type=ContractTplSqlProvider.class, method="insertSelective")
//    @Options(useGeneratedKeys=true, keyProperty="tpl_id", keyColumn="tpl_id")
//    int insertSelective(ContractTpl record);
//
//    @Select({
//        "select",
//        "tpl_id, tpl_name, remark, create_uid, update_uid, create_time, update_time, ",
//        "times, content",
//        "from contract_tpl",
//        "where tpl_id = #{tpl_id,jdbcType=INTEGER}"
//    })
//    @Results({
//        @Result(column="tpl_id", property="tpl_id", jdbcType=JdbcType.INTEGER, id=true),
//        @Result(column="tpl_name", property="tpl_name", jdbcType=JdbcType.VARCHAR),
//        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
//        @Result(column="create_uid", property="create_uid", jdbcType=JdbcType.INTEGER),
//        @Result(column="update_uid", property="update_uid", jdbcType=JdbcType.INTEGER),
//        @Result(column="create_time", property="create_time", jdbcType=JdbcType.TIMESTAMP),
//        @Result(column="update_time", property="update_time", jdbcType=JdbcType.TIMESTAMP),
//        @Result(column="times", property="times", jdbcType=JdbcType.INTEGER),
//        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
//    })
//    ContractTpl selectByPrimaryKey(Integer tpl_id);
//
//    @UpdateProvider(type=ContractTplSqlProvider.class, method="updateByPrimaryKeySelective")
//    int updateByPrimaryKeySelective(ContractTpl record);
//
//    @Update({
//        "update contract_tpl",
//        "set tpl_name = #{tpl_name,jdbcType=VARCHAR},",
//          "remark = #{remark,jdbcType=VARCHAR},",
//          "create_uid = #{create_uid,jdbcType=INTEGER},",
//          "update_uid = #{update_uid,jdbcType=INTEGER},",
//          "create_time = #{create_time,jdbcType=TIMESTAMP},",
//          "update_time = #{update_time,jdbcType=TIMESTAMP},",
//          "times = #{times,jdbcType=INTEGER},",
//          "content = #{content,jdbcType=LONGVARCHAR}",
//        "where tpl_id = #{tpl_id,jdbcType=INTEGER}"
//    })
//    int updateByPrimaryKeyWithBLOBs(ContractTpl record);
//
//    @Update({
//        "update contract_tpl",
//        "set tpl_name = #{tpl_name,jdbcType=VARCHAR},",
//          "remark = #{remark,jdbcType=VARCHAR},",
//          "create_uid = #{create_uid,jdbcType=INTEGER},",
//          "update_uid = #{update_uid,jdbcType=INTEGER},",
//          "create_time = #{create_time,jdbcType=TIMESTAMP},",
//          "update_time = #{update_time,jdbcType=TIMESTAMP},",
//          "times = #{times,jdbcType=INTEGER}",
//        "where tpl_id = #{tpl_id,jdbcType=INTEGER}"
//    })
//    int updateByPrimaryKey(ContractTpl record);
//
//    @SelectProvider(type = ContractTplSqlProvider.class,method = "selectContractTpl")
////@Select({"<script> " +
////        "SELECT " +
////        "a.tpl_id, " +
////        "a.tpl_name, " +
////        "a.remark, " +
////        "a.content, " +
////        "a.create_uid, " +
////        "a.update_uid, " +
////        "a.create_time, " +
////        "a.update_time, " +
////        "a.times, " +
////        "( SELECT b.real_name FROM `user` b WHERE id = create_uid )  create_user, " +
////        "( SELECT b.real_name FROM `user` b WHERE id = update_uid )  update_user " +
////        "FROM " +
////        "contract_tpl a" +
////        "where 1=1 " +
////        "  <if test=\"tpl_name !=null and tpl_name !=''\">" +
////        "    AND a.tpl_name like CONCAT('%', #{tpl_name}, '%')" +
////        "  </if> " +
////        "  <if test=\"startDate !=null and startDate !='' \">" +
////        "  <if test=\"endDate !=null and endDate !=''\">" +
////        "    AND a.create_time between  #{startDate} and #{endDate}" +
////        "  </if> " +
////        "    AND a.assetside_id = #{assetside_id}" +
////        "  </if> " +
////        "       ORDER BY a.id desc " +
////        "</script>"})
////
//////  if (ass.getTpl_name() != null) {
//////        WHERE("tpl_name like CONCAT('%',#{tpl_name},'%')");
//////    }
//////            if (ass.getStartDate() != null && ass.getEndDate() != null) {
//////        WHERE("create_time  between  #{startDate} and  #{endDate}");
//////    } else {
//////        if (ass.getStartDate() != null) {
//////            WHERE("create_time >= #{startDate}");
//////        } else if( ass.getEndDate() != null){
//////            WHERE("create_time <= #{endDate}");
//////        }
//////    }
//////    ORDER_BY("tpl_id desc");
//    List<ContractTplResp> getContractTplList(ContractTplDto ass);
//}