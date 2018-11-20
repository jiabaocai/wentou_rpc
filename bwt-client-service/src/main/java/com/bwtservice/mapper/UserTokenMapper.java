package com.bwtservice.mapper;

import com.bwtservice.entity.UserToken;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserTokenMapper {
    @Delete({
        "delete from user_token",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into user_token (id, user_id, ",
        "expire_time, token_status, ",
        "token, device_code, ",
        "device_type, create_time)",
        "values (#{id,jdbcType=BIGINT}, #{user_id,jdbcType=BIGINT}, ",
        "#{expire_time,jdbcType=INTEGER}, #{token_status,jdbcType=INTEGER}, ",
        "#{token,jdbcType=VARCHAR}, #{device_code,jdbcType=VARCHAR}, ",
        "#{device_type,jdbcType=VARCHAR}, #{create_time,jdbcType=INTEGER})"
    })
    int insert(UserToken record);

    @InsertProvider(type=UserTokenSqlProvider.class, method="insertSelective")
    int insertSelective(UserToken record);

    @Select({
        "select",
        "id, user_id, expire_time, token_status, token, device_code, device_type, create_time",
        "from user_token",
        "where token = #{token,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.BIGINT),
        @Result(column="expire_time", property="expire_time", jdbcType=JdbcType.INTEGER),
        @Result(column="token_status", property="token_status", jdbcType=JdbcType.INTEGER),
        @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR),
        @Result(column="device_code", property="device_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="device_type", property="device_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="create_time", jdbcType=JdbcType.INTEGER)
    })
    UserToken selectByPrimaryToken(String token);

    @UpdateProvider(type=UserTokenSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserToken record);

    @Update({
        "update user_token",
        "set user_id = #{user_id,jdbcType=BIGINT},",
          "expire_time = #{expire_time,jdbcType=INTEGER},",
          "token_status = #{token_status,jdbcType=INTEGER},",
          "token = #{token,jdbcType=VARCHAR},",
          "device_code = #{device_code,jdbcType=VARCHAR},",
          "device_type = #{device_type,jdbcType=VARCHAR},",
          "create_time = #{create_time,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserToken record);
}