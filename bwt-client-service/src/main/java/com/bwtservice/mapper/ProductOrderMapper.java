package com.bwtservice.mapper;

import com.bwtservice.entity.ProductOrder;
import com.bwtservice.entity.ProductOrderReq;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ProductOrderMapper {
    @Delete({
        "delete from product_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into product_order (id, product_id, ",
        "order_no, assetside_id, ",
        "interest_start, interst_end, ",
        "loan_sum, contract_sum, ",
        "total_period, received_period, ",
        "received_status, overdue_day, ",
        "contract_id, dp_sum, ",
        "unique_code, express_no, ",
        "client_id, client_name, ",
        "client_mobile, client_idno, ",
        "client_address, phone_band, ",
        "phone_model, phone_color, ",
        "phone_memory, phone_size, ",
        "phone_storage, status)",
        "values (#{id,jdbcType=INTEGER}, #{product_id,jdbcType=INTEGER}, ",
        "#{order_no,jdbcType=CHAR}, #{assetside_id,jdbcType=INTEGER}, ",
        "#{interest_start,jdbcType=TIMESTAMP}, #{interst_end,jdbcType=TIMESTAMP}, ",
        "#{loan_sum,jdbcType=DECIMAL}, #{contract_sum,jdbcType=DECIMAL}, ",
        "#{total_period,jdbcType=TINYINT}, #{received_period,jdbcType=TINYINT}, ",
        "#{received_status,jdbcType=TINYINT}, #{overdue_day,jdbcType=TINYINT}, ",
        "#{contract_id,jdbcType=INTEGER}, #{dp_sum,jdbcType=DECIMAL}, ",
        "#{unique_code,jdbcType=CHAR}, #{express_no,jdbcType=CHAR}, ",
        "#{client_id,jdbcType=INTEGER}, #{client_name,jdbcType=VARCHAR}, ",
        "#{client_mobile,jdbcType=VARCHAR}, #{client_idno,jdbcType=CHAR}, ",
        "#{client_address,jdbcType=VARCHAR}, #{phone_band,jdbcType=VARCHAR}, ",
        "#{phone_model,jdbcType=VARCHAR}, #{phone_color,jdbcType=VARCHAR}, ",
        "#{phone_memory,jdbcType=VARCHAR}, #{phone_size,jdbcType=VARCHAR}, ",
        "#{phone_storage,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT})"
    })
    int insert(ProductOrder record);

    @InsertProvider(type=ProductOrderSqlProvider.class, method="insertSelective")
    int insertSelective(ProductOrder record);

    @Select({
        "select",
        "id, product_id, order_no, assetside_id, interest_start, interst_end, loan_sum, ",
        "contract_sum, total_period, received_period, received_status, overdue_day, contract_id, ",
        "dp_sum, unique_code, express_no, client_id, client_name, client_mobile, client_idno, ",
        "client_address, phone_band, phone_model, phone_color, phone_memory, phone_size, ",
        "phone_storage, status",
        "from product_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="product_id", property="product_id", jdbcType=JdbcType.INTEGER),
        @Result(column="order_no", property="order_no", jdbcType=JdbcType.CHAR),
        @Result(column="assetside_id", property="assetside_id", jdbcType=JdbcType.INTEGER),
        @Result(column="interest_start", property="interest_start", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="interst_end", property="interst_end", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="loan_sum", property="loan_sum", jdbcType=JdbcType.DECIMAL),
        @Result(column="contract_sum", property="contract_sum", jdbcType=JdbcType.DECIMAL),
        @Result(column="total_period", property="total_period", jdbcType=JdbcType.TINYINT),
        @Result(column="received_period", property="received_period", jdbcType=JdbcType.TINYINT),
        @Result(column="received_status", property="received_status", jdbcType=JdbcType.TINYINT),
        @Result(column="overdue_day", property="overdue_day", jdbcType=JdbcType.TINYINT),
        @Result(column="contract_id", property="contract_id", jdbcType=JdbcType.INTEGER),
        @Result(column="dp_sum", property="dp_sum", jdbcType=JdbcType.DECIMAL),
        @Result(column="unique_code", property="unique_code", jdbcType=JdbcType.CHAR),
        @Result(column="express_no", property="express_no", jdbcType=JdbcType.CHAR),
        @Result(column="client_id", property="client_id", jdbcType=JdbcType.INTEGER),
        @Result(column="client_name", property="client_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="client_mobile", property="client_mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="client_idno", property="client_idno", jdbcType=JdbcType.CHAR),
        @Result(column="client_address", property="client_address", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone_band", property="phone_band", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone_model", property="phone_model", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone_color", property="phone_color", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone_memory", property="phone_memory", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone_size", property="phone_size", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone_storage", property="phone_storage", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    ProductOrder selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "sum(loan_sum) loamSum ",
            "from product_order",
            "where order_no = #{orderNo,jdbcType=INTEGER} and product_id =#{productId,jdbcType=INTEGER}"
    })
    double selectSumByProductIdAndOrderNo(@Param("orderNo")Integer orderNo,@Param("productId")Integer productId);

    @Select({
            "select",
            "id, product_id, order_no, assetside_id, interest_start, interst_end, loan_sum, ",
            "contract_sum, total_period, received_period, received_status, overdue_day, contract_id, ",
            "dp_sum, unique_code, express_no, client_id, client_name, client_mobile, client_idno, ",
            "client_address, phone_band, phone_model, phone_color, phone_memory, phone_size, ",
            "phone_storage, status",
            "from product_order",
            "where order_no = #{orderNo,jdbcType=INTEGER} and product_id =#{productId,jdbcType=INTEGER} limit 1"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="product_id", property="product_id", jdbcType=JdbcType.INTEGER),
            @Result(column="order_no", property="order_no", jdbcType=JdbcType.CHAR),
            @Result(column="assetside_id", property="assetside_id", jdbcType=JdbcType.INTEGER),
            @Result(column="interest_start", property="interest_start", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="interst_end", property="interst_end", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="loan_sum", property="loan_sum", jdbcType=JdbcType.DECIMAL),
            @Result(column="contract_sum", property="contract_sum", jdbcType=JdbcType.DECIMAL),
            @Result(column="total_period", property="total_period", jdbcType=JdbcType.TINYINT),
            @Result(column="received_period", property="received_period", jdbcType=JdbcType.TINYINT),
            @Result(column="received_status", property="received_status", jdbcType=JdbcType.TINYINT),
            @Result(column="overdue_day", property="overdue_day", jdbcType=JdbcType.TINYINT),
            @Result(column="contract_id", property="contract_id", jdbcType=JdbcType.INTEGER),
            @Result(column="dp_sum", property="dp_sum", jdbcType=JdbcType.DECIMAL),
            @Result(column="unique_code", property="unique_code", jdbcType=JdbcType.CHAR),
            @Result(column="express_no", property="express_no", jdbcType=JdbcType.CHAR),
            @Result(column="client_id", property="client_id", jdbcType=JdbcType.INTEGER),
            @Result(column="client_name", property="client_name", jdbcType=JdbcType.VARCHAR),
            @Result(column="client_mobile", property="client_mobile", jdbcType=JdbcType.VARCHAR),
            @Result(column="client_idno", property="client_idno", jdbcType=JdbcType.CHAR),
            @Result(column="client_address", property="client_address", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone_band", property="phone_band", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone_model", property="phone_model", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone_color", property="phone_color", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone_memory", property="phone_memory", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone_size", property="phone_size", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone_storage", property="phone_storage", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    ProductOrder selectByPrimaryByOrderNoAndProductNo(@Param("orderNo")Integer orderNo,@Param("productId")Integer productId);

    @UpdateProvider(type=ProductOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProductOrder record);

    @Update({
        "update product_order",
        "set product_id = #{product_id,jdbcType=INTEGER},",
          "order_no = #{order_no,jdbcType=CHAR},",
          "assetside_id = #{assetside_id,jdbcType=INTEGER},",
          "interest_start = #{interest_start,jdbcType=TIMESTAMP},",
          "interst_end = #{interst_end,jdbcType=TIMESTAMP},",
          "loan_sum = #{loan_sum,jdbcType=DECIMAL},",
          "contract_sum = #{contract_sum,jdbcType=DECIMAL},",
          "total_period = #{total_period,jdbcType=TINYINT},",
          "received_period = #{received_period,jdbcType=TINYINT},",
          "received_status = #{received_status,jdbcType=TINYINT},",
          "overdue_day = #{overdue_day,jdbcType=TINYINT},",
          "contract_id = #{contract_id,jdbcType=INTEGER},",
          "dp_sum = #{dp_sum,jdbcType=DECIMAL},",
          "unique_code = #{unique_code,jdbcType=CHAR},",
          "express_no = #{express_no,jdbcType=CHAR},",
          "client_id = #{client_id,jdbcType=INTEGER},",
          "client_name = #{client_name,jdbcType=VARCHAR},",
          "client_mobile = #{client_mobile,jdbcType=VARCHAR},",
          "client_idno = #{client_idno,jdbcType=CHAR},",
          "client_address = #{client_address,jdbcType=VARCHAR},",
          "phone_band = #{phone_band,jdbcType=VARCHAR},",
          "phone_model = #{phone_model,jdbcType=VARCHAR},",
          "phone_color = #{phone_color,jdbcType=VARCHAR},",
          "phone_memory = #{phone_memory,jdbcType=VARCHAR},",
          "phone_size = #{phone_size,jdbcType=VARCHAR},",
          "phone_storage = #{phone_storage,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProductOrder record);


    /**
     * 模糊查询
     *
     * @param ass
     * @return
     */
    @SelectProvider(type = ProductOrderSqlProvider.class, method = "selectProductOrderByExampleOrLike")
    List<ProductOrder> selectProductOrderByExampleOrLike(ProductOrderReq ass);
}