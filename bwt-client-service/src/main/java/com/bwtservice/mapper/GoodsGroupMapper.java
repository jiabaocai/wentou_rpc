package com.bwtservice.mapper;

import com.bwtservice.entity.GoodsGroup;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface GoodsGroupMapper {
    @Delete({
        "delete from goods_group",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Select("select * from goods_group")
    List<GoodsGroup> getAll();
    @Insert({
        "insert into goods_group (id, name)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(GoodsGroup record);

    @InsertProvider(type=GoodsGroupSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertSelective(GoodsGroup record);

    @Select({
        "select",
        "id, name",
        "from goods_group",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    GoodsGroup selectByPrimaryKey(Integer id);

    @UpdateProvider(type=GoodsGroupSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GoodsGroup record);


    @SelectProvider(type=GoodsGroupSqlProvider.class, method="selectGoodsGroupLike")
    List<GoodsGroup> selectByexample(GoodsGroup goodsGroup);

    @Update({
        "update goods_group",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(GoodsGroup record);
}