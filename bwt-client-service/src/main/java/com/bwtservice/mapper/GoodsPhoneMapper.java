package com.bwtservice.mapper;

import com.bwtservice.entity.GoodsPhone;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface GoodsPhoneMapper {
    @Delete({
        "delete from goods_phone",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into goods_phone (id, category_id, ",
        "band, model, color, ",
        "memory, storage, ",
        "size, unique_code, ",
        "order_id)",
        "values (#{id,jdbcType=INTEGER}, #{category_id,jdbcType=INTEGER}, ",
        "#{band,jdbcType=VARCHAR}, #{model,jdbcType=VARCHAR}, #{color,jdbcType=VARCHAR}, ",
        "#{memory,jdbcType=VARCHAR}, #{storage,jdbcType=VARCHAR}, ",
        "#{size,jdbcType=VARCHAR}, #{unique_code,jdbcType=VARCHAR}, ",
        "#{order_id,jdbcType=INTEGER})"
    })
    int insert(GoodsPhone record);

    @InsertProvider(type=GoodsPhoneSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertSelective(GoodsPhone record);

    @Select({
        "select",
        "id, category_id, band, model, color, memory, storage, size, unique_code, order_id",
        "from goods_phone",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="category_id", property="category_id", jdbcType=JdbcType.INTEGER),
        @Result(column="band", property="band", jdbcType=JdbcType.VARCHAR),
        @Result(column="model", property="model", jdbcType=JdbcType.VARCHAR),
        @Result(column="color", property="color", jdbcType=JdbcType.VARCHAR),
        @Result(column="memory", property="memory", jdbcType=JdbcType.VARCHAR),
        @Result(column="storage", property="storage", jdbcType=JdbcType.VARCHAR),
        @Result(column="size", property="size", jdbcType=JdbcType.VARCHAR),
        @Result(column="unique_code", property="unique_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.INTEGER)
    })
    GoodsPhone selectByPrimaryKey(Integer id);

    @UpdateProvider(type=GoodsPhoneSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GoodsPhone record);

    @Update({
        "update goods_phone",
        "set category_id = #{category_id,jdbcType=INTEGER},",
          "band = #{band,jdbcType=VARCHAR},",
          "model = #{model,jdbcType=VARCHAR},",
          "color = #{color,jdbcType=VARCHAR},",
          "memory = #{memory,jdbcType=VARCHAR},",
          "storage = #{storage,jdbcType=VARCHAR},",
          "size = #{size,jdbcType=VARCHAR},",
          "unique_code = #{unique_code,jdbcType=VARCHAR},",
          "order_id = #{order_id,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(GoodsPhone record);
}