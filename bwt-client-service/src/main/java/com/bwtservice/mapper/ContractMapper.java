package com.bwtservice.mapper;

import com.bwtservice.entity.Contract;
import com.bwtservice.entity.ContractDto;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

public interface ContractMapper {
    @Delete({
            "delete from contract",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Select({"<script> " +
            "SELECT * from ( " +
            " SELECT " +
            "  a.id, " +
            "  a.contract_no, " +
            "  b.id order_id, " +
            "  a.contract_start, " +
            "  a.contract_end, " +
            "  b.assetside_id, " +
            "  a.client_name, " +
            "  a.signdate, " +
            "  b.product_id, " +
            "  b.interest_start, " +
            "  b.interst_end, " +
            "  b.loan_sum, " +
            "  b.contract_sum, " +
            "  b.total_period, " +
            "  b.received_period, " +
            " CASE " +
            "   b.received_status  " +
            "   WHEN '1' THEN " +
            "   '未放款'  " +
            "   WHEN '2' THEN " +
            "   '回款正常'  " +
            "   WHEN '3' THEN " +
            "   '逾期'  " +
            "   WHEN '4' THEN " +
            "   '结束' ELSE '未知'  " +
            "  END received_status, " +
            " b.overdue_day, " +
            " b.dp_sum, " +
            " b.unique_code, " +
            " b.express_no, " +
            " b.client_id, " +
            " b.client_mobile, " +
            " b.client_idno, " +
            " b.client_address, " +
            " b.phone_band, " +
            " b.phone_model, " +
            " b.phone_color, " +
            " b.phone_memory, " +
            " b.phone_size, " +
            " b.phone_storage, " +
            " b.`status` product_order_status, " +
            " c.`name`, " +
            " c.corp_name, " +
            " c.corp_no, " +
            " c.corp_img, " +
            " c.reg_cap, " +
            " c.foundingtime, " +
            " c.legal_rep, " +
            " c.partner, " +
            " c.team, " +
            " c.address, " +
            " c.qualification, " +
            " c.bankname, " +
            " c.contactinfo, " +
            " c.bankaccount, " +
            " c.createtime, " +
            " c.`status` AS assetside_status, " +
            " a.id AS contract_id, " +
            " b.order_no, " +
            " b.id AS product_order_id, " +
            " d.period current_period, " +
            " d.rp_amount current_period_amount, " +
            " d.rp_capital current_period_capital, " +
            " d.rp_interest current_period_interest, " +
            " b.credit_score, " +
            " b.assetside_score " +
            "FROM " +
            "product_order b " +
            " LEFT JOIN contract AS a ON a.order_id = b.id " +
            " LEFT JOIN assetside AS c ON b.assetside_id = c.assetside_id " +
            " LEFT JOIN order_plan d ON " +
            " d.assetside_id = b.assetside_id  " +
            " AND  " +
            " d.order_id =b.id and d.interest_start &lt;= NOW() and d.interest_end &gt;=NOW() " +
            " ) as e" +
            "      WHERE  1=1" +
            "  <if test=\"contract_no !=null and contract_no !=''\">" +
            "    AND e.contract_no = like CONCAT('%', #{contract_no}, '%')" +
            "  </if> " +
            "  <if test=\"contract_start !=null and contract_start !=''\">" +
            "    AND e.signdate between #{contract_start} and #{contract_end}" +
            "    and   e.`start`  &lt;=  e.signdate and e.signdate &lt;=e.`end` "+
            "  </if> " +
            "  <if test=\"client_name !=null and client_name !=''\">" +
            "    AND e.client_name like CONCAT('%', #{client_name}, '%')" +
            "  </if> " +
            "  <if test=\"assetside_id !=null and assetside_id !=''\">" +
            "    AND e.assetside_id = #{assetside_id}" +
            "  </if> " +
            "  <if test=\"order_no !=null and order_no !=''\">" +
            "    AND e.order_no =  = like CONCAT('%', #{order_no}, '%')" +
            "  </if> " +
            "  <if test=\"id !=null and id !=''\">" +
            "    AND e.id = #{id}" +
            "  </if> " +
            "  <if test=\"client_address !=null and client_address !=''\">" +
            "    AND b.client_address like CONCAT('%', #{client_address}, '%')" +
            "  </if> " +
            "  <if test=\"client_idno !=null and client_idno !=''\">" +
            "    AND b.client_idno =#{client_idno}" +
            "  </if> " +
            "  <if test=\"client_mobile !=null and client_mobile !=''\">" +
            "    AND b.client_mobile =#{client_mobile}" +
            "  </if> " +
            "  <if test=\"phone_band !=null and phone_band !=''\">" +
            "    AND b.phone_band =#{phone_band}" +
            "  </if> " +
            "  <if test=\"phone_model !=null and phone_model !=''\">" +
            "    AND b.phone_model =#{phone_model}" +
            "  </if> " +
            "  <if test=\"phone_color !=null and phone_color !=''\">" +
            "    AND b.phone_color =#{phone_color}" +
            "  </if> " +
            "  <if test=\"phone_memory !=null and phone_memory !=''\">" +
            "    AND b.phone_memory =#{phone_memory}" +
            "  </if> " +
            "  <if test=\"phone_size !=null and phone_size !=''\">" +
            "    AND b.phone_size =#{phone_size}" +
            "  </if> " +
            "  <if test=\"phone_storage !=null and phone_storage !=''\">" +
            "    AND b.phone_storage =#{phone_storage}" +
            "  </if> " +
            "       ORDER BY e.id desc " +
            "</script>"})
    List<ContractDto> list(@Param("contract_no") String contract_no, @Param("contract_start") String contract_start, @Param("contract_end") String contract_end,
                           @Param("assetside_id") Integer assetside_id, @Param("client_name") String client_name, @Param("order_no") Integer order_no,
                           @Param("id")Integer id,
                           @Param("client_address")String client_address,
                           @Param("client_idno")String client_idno,
                           @Param("client_mobile")String client_mobile,
                           @Param("phone_band")String phone_band,
                           @Param("phone_model")String phone_model,
                           @Param("phone_color")String phone_color,
                           @Param("phone_memory")String phone_memory ,
                           @Param("phone_size")String phone_size,
                           @Param("phone_storage")String phone_storage);

// @Select({"<script> " +
//            "SELECT " +
//            "a.contract_no, a.order_id," +
//            "a.contract_start, " +
//            "a.contract_end, " +
//            "a.assetside_id, " +
//            "a.client_name, " +
//            "a.signdate, " +
//            "b.product_id, " +
//            "b.interest_start, " +
//            "b.interst_end, " +
//            "b.loan_sum, " +
//            "b.contract_sum, " +
//            "b.total_period, " +
//            "b.received_period, " +
//            "b.received_status, " +
//            "b.overdue_day, " +
//            "b.dp_sum, " +
//            "b.unique_code, " +
//            "b.express_no, " +
//            "b.client_id, " +
//            "b.client_mobile, " +
//            "b.client_idno, " +
//            "b.client_address, " +
//            "b.phone_band, " +
//            "b.phone_model, " +
//            "b.phone_color, " +
//            "b.phone_memory, " +
//            "b.phone_size, " +
//            "b.phone_storage, " +
//            "b.`status` product_order_status, " +
//            "c.`name`, " +
//            "c.corp_name, " +
//            "c.corp_no, " +
//            "c.corp_img, " +
//            "c.reg_cap, " +
//            "c.foundingtime, " +
//            "c.legal_rep, " +
//            "c.partner, " +
//            "c.team, " +
//            "c.address, " +
//            "c.qualification, " +
//            "c.bankname, " +
//            "c.contactinfo, " +
//            "c.bankaccount, " +
//            "c.createtime, " +
//            "c.`status` AS assetside_status, " +
//            "a.id AS contract_id, " +
//            "b.order_no, " +
//            "b.id AS product_order_id " +
//            "FROM " +
//            "contract AS a " +
//            "LEFT JOIN product_order AS b " +
//            "ON a.order_id = b.id  " +
//            "LEFT JOIN assetside AS c " +
//            "ON a.assetside_id = c.assetside_id " +
//            "where 1=1 " +
//            "  <if test=\"contract_no !=null and contract_no !=''\">" +
//            "    AND a.contract_no = #{contract_no}" +
//            "  </if> " +
//            "  <if test=\"contract_start !=null and contract_start !=''\">" +
//            "    AND a.contract_start = #{contract_start}" +
//            "  </if> " +
//            "  <if test=\"contract_end !=null and contract_end !=''\">" +
//            "    AND a.contract_end = #{contract_end}" +
//            "  </if> " +
//            "  <if test=\"client_name !=null and client_name !=''\">" +
//            "    AND a.client_name like CONCAT('%', #{client_name}, '%')" +
//            "  </if> " +
//            "  <if test=\"assetside_id !=null and assetside_id !=''\">" +
//            "    AND a.assetside_id = #{assetside_id}" +
//            "  </if> " +
//            "  <if test=\"order_no !=null and order_no !=''\">" +
//            "    AND b.order_no = #{order_no}" +
//            "  </if> " +
//            "  <if test=\"id !=null and id !=''\">" +
//            "    AND a.id = #{id}" +
//            "  </if> " +
//            "       ORDER BY a.id desc " +
//            "</script>"})
//    List<ContractDto> list(@Param("contract_no") String contract_no, @Param("contract_start") String contract_start, @Param("contract_end") String contract_end, @Param("assetside_id") Integer assetside_id, @Param("client_name") String client_name, @Param("order_no") Integer order_no,@Param("id")Integer id);
//

    @Insert({
            "insert into contract (id, contract_no, ",
            "contract_start, contract_end, ",
            "assetside_id, client_name, ",
            "order_id, signdate)",
            "values (#{id,jdbcType=INTEGER}, #{contract_no,jdbcType=CHAR}, ",
            "#{contract_start,jdbcType=TIMESTAMP}, #{contract_end,jdbcType=TIMESTAMP}, ",
            "#{assetside_id,jdbcType=INTEGER}, #{client_name,jdbcType=VARCHAR}, ",
            "#{order_id,jdbcType=INTEGER}, #{signdate,jdbcType=TIMESTAMP})"
    })
    int insert(Contract record);

    @InsertProvider(type = ContractSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertSelective(Contract record);

    @Select({
            "select",
            "id, contract_no, contract_start, contract_end, assetside_id, client_name, order_id, ",
            "signdate",
            "from contract",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "contract_no", property = "contract_no", jdbcType = JdbcType.CHAR),
            @Result(column = "contract_start", property = "contract_start", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "contract_end", property = "contract_end", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "assetside_id", property = "assetside_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "client_name", property = "client_name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "order_id", property = "order_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "signdate", property = "signdate", jdbcType = JdbcType.TIMESTAMP)
    })
    Contract selectByPrimaryKey(Integer id);

    @UpdateProvider(type = ContractSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Contract record);

    @Update({
            "update contract",
            "set contract_no = #{contract_no,jdbcType=CHAR},",
            "contract_start = #{contract_start,jdbcType=TIMESTAMP},",
            "contract_end = #{contract_end,jdbcType=TIMESTAMP},",
            "assetside_id = #{assetside_id,jdbcType=INTEGER},",
            "client_name = #{client_name,jdbcType=VARCHAR},",
            "order_id = #{order_id,jdbcType=INTEGER},",
            "signdate = #{signdate,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Contract record);
}