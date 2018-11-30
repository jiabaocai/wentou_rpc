package com.bwtservice.mapper;

import com.bwtservice.entity.Product;
import com.bwtservice.entity.ProductDto;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ProductMapper {
    @Delete({
            "delete from product",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into product (id, product_no, ",
            "assetside_id, rdg_id, ",
            "goods_group_id, contract_id, ",
            "tc, ibm, year_rate, ",
            "ffr, lineup, linedown, ",
            "total, warning_line, ",
            "disposal_plan, contact_id, ",
            "createtime, status,product_name)",
            "values (#{id,jdbcType=INTEGER}, #{product_no,jdbcType=CHAR}, ",
            "#{assetside_id,jdbcType=INTEGER}, #{rdg_id,jdbcType=INTEGER}, ",
            "#{goods_group_id,jdbcType=INTEGER}, #{contract_id,jdbcType=INTEGER}, ",
            "#{tc,jdbcType=TINYINT}, #{ibm,jdbcType=TINYINT}, #{year_rate,jdbcType=DECIMAL}, ",
            "#{ffr,jdbcType=DECIMAL}, #{lineup,jdbcType=DECIMAL}, #{linedown,jdbcType=DECIMAL}, ",
            "#{total,jdbcType=INTEGER}, #{warning_line,jdbcType=DECIMAL}, ",
            "#{disposal_plan,jdbcType=TINYINT}, #{contact_id,jdbcType=VARCHAR}, ",
            "#{createtime,jdbcType=TIMESTAMP}, #{status,jdbcType=TINYINT},#{product_name,jdbcType=VARCHAR})"
    })
    int insert(Product record);

    @InsertProvider(type = ProductSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertSelective(Product record);

    @Select({
            "select",
            "id, product_no, assetside_id, rdg_id, goods_group_id, contract_id, tc, ibm, ",
            "year_rate, ffr, lineup, linedown, total, warning_line, disposal_plan, contact_id, ",
            "createtime, status ,product_name ",
            "from product",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "product_no", property = "product_no", jdbcType = JdbcType.CHAR),
            @Result(column = "assetside_id", property = "assetside_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "rdg_id", property = "rdg_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "goods_group_id", property = "goods_group_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "contract_id", property = "contract_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "tc", property = "tc", jdbcType = JdbcType.TINYINT),
            @Result(column = "ibm", property = "ibm", jdbcType = JdbcType.TINYINT),
            @Result(column = "year_rate", property = "year_rate", jdbcType = JdbcType.DECIMAL),
            @Result(column = "ffr", property = "ffr", jdbcType = JdbcType.DECIMAL),
            @Result(column = "lineup", property = "lineup", jdbcType = JdbcType.DECIMAL),
            @Result(column = "linedown", property = "linedown", jdbcType = JdbcType.DECIMAL),
            @Result(column = "total", property = "total", jdbcType = JdbcType.INTEGER),
            @Result(column = "warning_line", property = "warning_line", jdbcType = JdbcType.DECIMAL),
            @Result(column = "disposal_plan", property = "disposal_plan", jdbcType = JdbcType.TINYINT),
            @Result(column = "contact_id", property = "contact_id", jdbcType = JdbcType.VARCHAR),
            @Result(column = "createtime", property = "createtime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "product_name", property = "product_name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT)
    })
    Product selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, product_no, assetside_id, rdg_id, goods_group_id, contract_id, tc, ibm, ",
            "year_rate, ffr, lineup, linedown, total, warning_line, disposal_plan, contact_id, ",
            "createtime, status ,product_name ",
            "from product",
            "where product_no = #{productNo,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "product_no", property = "product_no", jdbcType = JdbcType.CHAR),
            @Result(column = "assetside_id", property = "assetside_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "rdg_id", property = "rdg_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "goods_group_id", property = "goods_group_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "contract_id", property = "contract_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "tc", property = "tc", jdbcType = JdbcType.TINYINT),
            @Result(column = "ibm", property = "ibm", jdbcType = JdbcType.TINYINT),
            @Result(column = "year_rate", property = "year_rate", jdbcType = JdbcType.DECIMAL),
            @Result(column = "ffr", property = "ffr", jdbcType = JdbcType.DECIMAL),
            @Result(column = "lineup", property = "lineup", jdbcType = JdbcType.DECIMAL),
            @Result(column = "linedown", property = "linedown", jdbcType = JdbcType.DECIMAL),
            @Result(column = "total", property = "total", jdbcType = JdbcType.INTEGER),
            @Result(column = "warning_line", property = "warning_line", jdbcType = JdbcType.DECIMAL),
            @Result(column = "disposal_plan", property = "disposal_plan", jdbcType = JdbcType.TINYINT),
            @Result(column = "contact_id", property = "contact_id", jdbcType = JdbcType.VARCHAR),
            @Result(column = "createtime", property = "createtime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "product_name", property = "product_name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT)
    })
    Product selectByPrimaryByProductNo(@Param("productNo")Integer productNo);

    @Select({
            "select",
            "a.id, a.product_no, a.assetside_id, a.rdg_id, a.goods_group_id, a.contract_id, a.tc, a.ibm, ",
            "a.year_rate, a.ffr, a.lineup, a.linedown, a.total, a.warning_line, a.disposal_plan, a.contact_id, ",
            "a.createtime, a.status,b.name assetside_name ,c.name goods_group_name,a.product_name ",
            "from product a LEFT JOIN assetside  b on  a.assetside_id=b.assetside_id LEFT JOIN goods_group c on a.goods_group_id=c.id",
            "where a.id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "product_no", property = "product_no", jdbcType = JdbcType.CHAR),
            @Result(column = "assetside_id", property = "assetside_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "rdg_id", property = "rdg_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "goods_group_id", property = "goods_group_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "contract_id", property = "contract_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "tc", property = "tc", jdbcType = JdbcType.TINYINT),
            @Result(column = "ibm", property = "ibm", jdbcType = JdbcType.TINYINT),
            @Result(column = "year_rate", property = "year_rate", jdbcType = JdbcType.DECIMAL),
            @Result(column = "ffr", property = "ffr", jdbcType = JdbcType.DECIMAL),
            @Result(column = "lineup", property = "lineup", jdbcType = JdbcType.DECIMAL),
            @Result(column = "linedown", property = "linedown", jdbcType = JdbcType.DECIMAL),
            @Result(column = "total", property = "total", jdbcType = JdbcType.INTEGER),
            @Result(column = "warning_line", property = "warning_line", jdbcType = JdbcType.DECIMAL),
            @Result(column = "disposal_plan", property = "disposal_plan", jdbcType = JdbcType.TINYINT),
            @Result(column = "contact_id", property = "contact_id", jdbcType = JdbcType.VARCHAR),
            @Result(column = "createtime", property = "createtime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
            @Result(column = "assetside_name", property = "assetside_name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "goods_group_name", property = "goods_group_name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_name", property = "product_name", jdbcType = JdbcType.VARCHAR)
    })
    ProductDto selectProductById(@Param("id") Integer id);

    @Select({"<script> " +
            "SELECT a.id, a.product_no, a.assetside_id, a.rdg_id, a.goods_group_id, a.contract_id, a.tc, a.ibm, " +
            "a.year_rate, a.ffr, a.lineup, a.linedown, a.total, a.warning_line, a.disposal_plan, a.contact_id, ",
            "a.createtime, a.status,b.name assetside_name ,c.name goods_group_name,a.product_name ",
            "from product a " +
                    "LEFT JOIN assetside  b on  a.assetside_id=b.assetside_id " +
                    "LEFT JOIN goods_group c on a.goods_group_id=c.id " +
                    "where 1=1 " +
                    "  <if test=\"product_no !=null and product_no !=''\">" +
                    "    AND a.product_no = #{product_no}" +
                    "  </if> " +
                    "  <if test=\"product_name !=null and product_name !=''\">" +
                    "    AND a.product_name like CONCAT('%', #{product_name}, '%')" +
                    "  </if> " +
                    "  <if test=\"rdg_id !=null and rdg_id !=''\">" +
                    "    AND a.rdg_id = #{rdg_id}" +
                    "  </if> " +
                    "  <if test=\"status !=null and status !=''\">" +
                    "    AND a.status = #{status}" +
                    "  </if> " +
                    "            <if test=\"startDate != null and startDate != '' and endDate != null and endDate != ''\">" +
                    "               AND a.createtime BETWEEN #{startDate} AND #{endDate} " +
                    "            </if> " +
                    "  <if test=\"assetside_name !=null and assetside_name !=''\">" +
                    "    AND b.name like CONCAT('%', #{assetside_name}, '%')" +
                    "  </if> " +
                    "  <if test=\"goods_group_name !=null and goods_group_name !=''\">" +
                    "    AND c.name like CONCAT('%', #{goods_group_name}, '%')" +
                    "  </if> " +
                    "       ORDER BY a.id desc " +
                    "</script>"})
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "product_no", property = "product_no", jdbcType = JdbcType.CHAR),
            @Result(column = "assetside_id", property = "assetside_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "rdg_id", property = "rdg_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "goods_group_id", property = "goods_group_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "contract_id", property = "contract_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "tc", property = "tc", jdbcType = JdbcType.TINYINT),
            @Result(column = "ibm", property = "ibm", jdbcType = JdbcType.TINYINT),
            @Result(column = "year_rate", property = "year_rate", jdbcType = JdbcType.DECIMAL),
            @Result(column = "ffr", property = "ffr", jdbcType = JdbcType.DECIMAL),
            @Result(column = "lineup", property = "lineup", jdbcType = JdbcType.DECIMAL),
            @Result(column = "linedown", property = "linedown", jdbcType = JdbcType.DECIMAL),
            @Result(column = "total", property = "total", jdbcType = JdbcType.INTEGER),
            @Result(column = "warning_line", property = "warning_line", jdbcType = JdbcType.DECIMAL),
            @Result(column = "disposal_plan", property = "disposal_plan", jdbcType = JdbcType.TINYINT),
            @Result(column = "contact_id", property = "contact_id", jdbcType = JdbcType.VARCHAR),
            @Result(column = "createtime", property = "createtime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "status", property = "status", jdbcType = JdbcType.TINYINT),
            @Result(column = "assetside_name", property = "assetside_name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "goods_group_name", property = "goods_group_name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "product_name", property = "product_name", jdbcType = JdbcType.VARCHAR)
    })
    List<ProductDto> selectProductByExample(@Param("product_no") String product_no, @Param("rdg_id") Integer rdg_id, @Param("status") Integer status, @Param("startDate") String startDate, @Param("endDate") String endDate, @Param("assetside_name") String assetside_name, @Param("goods_group_name") String goods_group_name,@Param("product_name")String product_name);


    @UpdateProvider(type = ProductSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Product record);

    @Update({
            "update product",
            "set product_no = #{product_no,jdbcType=CHAR},",
            "assetside_id = #{assetside_id,jdbcType=INTEGER},",
            "rdg_id = #{rdg_id,jdbcType=INTEGER},",
            "goods_group_id = #{goods_group_id,jdbcType=INTEGER},",
            "contract_id = #{contract_id,jdbcType=INTEGER},",
            "tc = #{tc,jdbcType=TINYINT},",
            "ibm = #{ibm,jdbcType=TINYINT},",
            "year_rate = #{year_rate,jdbcType=DECIMAL},",
            "ffr = #{ffr,jdbcType=DECIMAL},",
            "lineup = #{lineup,jdbcType=DECIMAL},",
            "linedown = #{linedown,jdbcType=DECIMAL},",
            "total = #{total,jdbcType=INTEGER},",
            "warning_line = #{warning_line,jdbcType=DECIMAL},",
            "disposal_plan = #{disposal_plan,jdbcType=TINYINT},",
            "contact_id = #{contact_id,jdbcType=VARCHAR},",
            "createtime = #{createtime,jdbcType=TIMESTAMP},",
            "status = #{status,jdbcType=TINYINT}",
            "product_name = #{product_name,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Product record);
}