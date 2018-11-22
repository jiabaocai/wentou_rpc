package com.bwtservice.mapper;

import com.bwtservice.entity.Category;
import com.bwtservice.entity.CategoryDto;
import org.apache.ibatis.jdbc.SQL;

public class CategorySqlProvider {

    public String insertSelective(Category record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("category");

        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }

        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }

        if (record.getGoods_group_id() != null) {
            sql.VALUES("goods_group_id", "#{goods_group_id,jdbcType=INTEGER}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Category record) {
        SQL sql = new SQL();
        sql.UPDATE("category");

        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }

        if (record.getGoods_group_id() != null) {
            sql.SET("goods_group_id = #{goods_group_id,jdbcType=INTEGER}");
        }

        sql.WHERE("id = #{id,jdbcType=INTEGER}");

        return sql.toString();
    }

//    public  String selectByIdANdName(Category category){
//        SQL sql=new SQL();
//        sql.SELECT("category");
//        if(category.getName()!=null){
//            sql.SET("name like CONCAT('%',#{name},'%')");
//        }
//        if(category.getGoods_group_id()!=null){
//            sql.SET("goods_group_id=#{goods_group_id,jdbcType=INTEGER}");
//        }
//        return sql.toString();
//    }
}