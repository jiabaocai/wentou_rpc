package com.bwtservice.mapper;

import com.bwtservice.entity.Category;
import com.bwtservice.entity.CategoryDto;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface CategoryMapper {
    @Delete({
        "delete from category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Select("select * from category")
    List<Category> getAll();

    @Insert({
        "insert into category (id, name, ",
        "goods_group_id)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{goods_group_id,jdbcType=INTEGER})"
    })
    int insert(Category record);

    @InsertProvider(type=CategorySqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertSelective(Category record);

    @Select({
        "select ",
        "category.id, category.name, category.goods_group_id,goods_group.name goods_group_name ",
        "from category left join goods_group on category.goods_group_id=goods_group.id ",
        "where category.id = #{id,jdbcType=INTEGER} "
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="goods_group_id", property="goods_group_id", jdbcType=JdbcType.INTEGER),
        @Result(column="goods_group_name", property="goods_group_name", jdbcType=JdbcType.VARCHAR)
    })
    CategoryDto selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Category record);

    @Update({
        "update category",
        "set name = #{name,jdbcType=VARCHAR},",
          "goods_group_id = #{goods_group_id,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Category record);
}