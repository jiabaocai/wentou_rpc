package com.bwtservice.mapper;

import com.bwtservice.entity.ReportDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: wentou_rpc
 * @Version 1.0.0
 * @description: orm层
 * @author: Mr.cai
 * @create: 2018-12-11 22:09
 * @CopyRight 本内容仅限于北境内部传阅，禁止外泄以及用于其他的商业目的
 **/
public interface ReportMapper {

    @Select({"<script>" +
            " select * from (SELECT a.assetside_id ," +
            " a.name ," +
            " DATE_FORMAT(d.interest_start,'%Y-%m-%d')  current_interest_start," +
            " DATE_FORMAT(d.interest_end,'%Y-%m-%d') current_interest_end," +
            " b.order_no , " +
            "  DATE_FORMAT(b.createtime,'%Y-%m-%d') createtime , " +
            " b.loan_sum , " +
            " CASE " +
            "  b.status  " +
            "  WHEN '1' THEN " +
            "  '初始状态'  " +
            "  WHEN '2' THEN " +
            "  '待放款'  " +
            "  WHEN '3' THEN " +
            "  '已放款'  " +
            "  WHEN '4' THEN " +
            "  '订单终止'  " +
            "  WHEN '5' THEN " +
            "  '订单中止'  " +
            "  WHEN '6' THEN " +
            "  '订单结束' ELSE '未知'  " +
            " END status_name,b.status, " +
            " b.interest_start , " +
            " b.interst_end , " +
            "  DATE_FORMAT(c.signdate,'%Y-%m-%d') signdate , " +
            " d.rp_capital , " +
            " d.rp_interest , " +
            " d.rp_amount , " +
            " CASE " +
            "  d.loan_status  " +
            "  WHEN '1' THEN " +
            "  '未还款'  " +
            "  WHEN '2' THEN " +
            "  '已还款' ELSE '未知'  " +
            " END loan_status_name, d.loan_status," +
            " CASE " +
            "  b.received_status  " +
            "  WHEN '1' THEN " +
            "  '未放款'  " +
            "  WHEN '2' THEN " +
            "  '回款正常'  " +
            "  WHEN '3' THEN " +
            "  '逾期'  " +
            "  WHEN '4' THEN " +
            "  '结束' ELSE '未知'  " +
            " END received_status_name, b.received_status," +
            " CASE " +
            "  d.rp_status  " +
            "  WHEN '1' THEN " +
            "  '未导入'  " +
            "  WHEN '2' THEN " +
            "  '已导入确认' ELSE '未知'  " +
            " END  rp_status_name, d.rp_status ,d.id plan_id,b.id product_order_id " +
            " FROM " +
            " assetside a " +
            " LEFT JOIN product_order b ON a.assetside_id = b.assetside_id " +
            " LEFT JOIN contract c ON b.id = c.order_id " +
            " LEFT JOIN order_plan d ON b.id = d.order_id and d.interest_start &lt;= NOW() and d.interest_end &gt;=NOW()) as e" +
            " where 1=1 " +
            "  <if test=\"assetside_id !=null and assetside_id !=''\">" +
            "    AND e.assetside_id = #{assetside_id}" +
            "  </if> " +
            "  <if test=\"status !=null\">" +
            "    AND e.status = #{status}" +
            "  </if> " +
            "  <if test=\"loan_status !=null\">" +
            "    AND e.loan_status = #{loan_status}" +
            "  </if> " +
            "  <if test=\"rp_status !=null \">" +
            "    AND e.rp_status = #{rp_status}" +
            "  </if> " +
            "  <if test=\"type !=null and type == 1 \">" +
            "    AND e.createtime between #{startDate} and  #{endDate}" +
            "  </if> " +
            "  <if test=\"type !=null and type == 2 \">" +
            "    AND e.createtime &gt;= #{startDate}" +
            "  </if> " +
            "  <if test=\"type !=null and type == 3 \">" +
            "    AND e.createtime &lt;= #{endDate}" +
            "  </if> " +
            "</script>"})
    List<ReportDto> getReportListByExample(@Param("assetside_id") Integer assetside_id,
                                           @Param("status") Integer status,
                                           @Param("startDate") String startDate,
                                           @Param("endDate") String endDate,
                                           @Param("loan_status") Integer loan_status,
                                           @Param("rp_status") Integer rp_status,
                                           @Param("contract_start") String contract_start,
                                           @Param("contract_end") String contract_end, @Param("type") Integer type);
}


 
