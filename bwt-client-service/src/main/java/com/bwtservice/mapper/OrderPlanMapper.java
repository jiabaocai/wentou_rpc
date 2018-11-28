package com.bwtservice.mapper;

import com.bwtservice.entity.OrderPlan;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface OrderPlanMapper {
    @Delete({
        "delete from order_plan",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into order_plan (id, period, ",
        "loan_amount, interest_start, ",
        "interest_end, days, ",
        "loan_status, rp_amount, ",
        "rp_amount2, rp_interest, ",
        "rp_capital, cash_balance, ",
        "rp_status, order_id, ",
        "assetside_id, balance)",
        "values (#{id,jdbcType=INTEGER}, #{period,jdbcType=TINYINT}, ",
        "#{loan_amount,jdbcType=DECIMAL}, #{interest_start,jdbcType=TIMESTAMP}, ",
        "#{interest_end,jdbcType=TIMESTAMP}, #{days,jdbcType=TINYINT}, ",
        "#{loan_status,jdbcType=TINYINT}, #{rp_amount,jdbcType=DECIMAL}, ",
        "#{rp_amount2,jdbcType=DECIMAL}, #{rp_interest,jdbcType=DECIMAL}, ",
        "#{rp_capital,jdbcType=DECIMAL}, #{cash_balance,jdbcType=DECIMAL}, ",
        "#{rp_status,jdbcType=TINYINT}, #{order_id,jdbcType=INTEGER}, ",
        "#{assetside_id,jdbcType=INTEGER}, #{balance,jdbcType=DECIMAL})"
    })
    int insert(OrderPlan record);

    @InsertProvider(type=OrderPlanSqlProvider.class, method="insertSelective")
    int insertSelective(OrderPlan record);

    @Select({
        "select",
        "id, period, loan_amount, interest_start, interest_end, days, loan_status, rp_amount, ",
        "rp_amount2, rp_interest, rp_capital, cash_balance, rp_status, order_id, assetside_id, ",
        "balance",
        "from order_plan",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="period", property="period", jdbcType=JdbcType.TINYINT),
        @Result(column="loan_amount", property="loan_amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="interest_start", property="interest_start", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="interest_end", property="interest_end", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="days", property="days", jdbcType=JdbcType.TINYINT),
        @Result(column="loan_status", property="loan_status", jdbcType=JdbcType.TINYINT),
        @Result(column="rp_amount", property="rp_amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="rp_amount2", property="rp_amount2", jdbcType=JdbcType.DECIMAL),
        @Result(column="rp_interest", property="rp_interest", jdbcType=JdbcType.DECIMAL),
        @Result(column="rp_capital", property="rp_capital", jdbcType=JdbcType.DECIMAL),
        @Result(column="cash_balance", property="cash_balance", jdbcType=JdbcType.DECIMAL),
        @Result(column="rp_status", property="rp_status", jdbcType=JdbcType.TINYINT),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.INTEGER),
        @Result(column="assetside_id", property="assetside_id", jdbcType=JdbcType.INTEGER),
        @Result(column="balance", property="balance", jdbcType=JdbcType.DECIMAL)
    })
    OrderPlan selectByPrimaryKey(Integer id);


    @Select({
            "select",
            "count(1) ",
            "from order_plan",
            "where order_id = #{order_id,jdbcType=INTEGER}"
    })

    Integer selectByPrimaryByOrderId(@Param("order_id") Integer order_id);

    @UpdateProvider(type=OrderPlanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderPlan record);

    @Update({
        "update order_plan",
        "set period = #{period,jdbcType=TINYINT},",
          "loan_amount = #{loan_amount,jdbcType=DECIMAL},",
          "interest_start = #{interest_start,jdbcType=TIMESTAMP},",
          "interest_end = #{interest_end,jdbcType=TIMESTAMP},",
          "days = #{days,jdbcType=TINYINT},",
          "loan_status = #{loan_status,jdbcType=TINYINT},",
          "rp_amount = #{rp_amount,jdbcType=DECIMAL},",
          "rp_amount2 = #{rp_amount2,jdbcType=DECIMAL},",
          "rp_interest = #{rp_interest,jdbcType=DECIMAL},",
          "rp_capital = #{rp_capital,jdbcType=DECIMAL},",
          "cash_balance = #{cash_balance,jdbcType=DECIMAL},",
          "rp_status = #{rp_status,jdbcType=TINYINT},",
          "order_id = #{order_id,jdbcType=INTEGER},",
          "assetside_id = #{assetside_id,jdbcType=INTEGER},",
          "balance = #{balance,jdbcType=DECIMAL}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OrderPlan record);
}