package com.bwtservice.mapper;

import com.bwtservice.entity.ProductOrder;
import com.bwtservice.entity.ProductOrderReq;
import org.apache.ibatis.jdbc.SQL;

public class ProductOrderSqlProvider {

    public String insertSelective(ProductOrder record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("product_order");

        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }

        if (record.getProduct_id() != null) {
            sql.VALUES("product_id", "#{product_id,jdbcType=INTEGER}");
        }

        if (record.getOrder_no() != null) {
            sql.VALUES("order_no", "#{order_no,jdbcType=CHAR}");
        }

        if (record.getAssetside_id() != null) {
            sql.VALUES("assetside_id", "#{assetside_id,jdbcType=INTEGER}");
        }

        if (record.getInterest_start() != null) {
            sql.VALUES("interest_start", "#{interest_start,jdbcType=TIMESTAMP}");
        }

        if (record.getInterst_end() != null) {
            sql.VALUES("interst_end", "#{interst_end,jdbcType=TIMESTAMP}");
        }

        if (record.getLoan_sum() != null) {
            sql.VALUES("loan_sum", "#{loan_sum,jdbcType=DECIMAL}");
        }

        if (record.getContract_sum() != null) {
            sql.VALUES("contract_sum", "#{contract_sum,jdbcType=DECIMAL}");
        }

        if (record.getTotal_period() != null) {
            sql.VALUES("total_period", "#{total_period,jdbcType=TINYINT}");
        }

        if (record.getReceived_period() != null) {
            sql.VALUES("received_period", "#{received_period,jdbcType=TINYINT}");
        }

        if (record.getReceived_status() != null) {
            sql.VALUES("received_status", "#{received_status,jdbcType=TINYINT}");
        }

        if (record.getOverdue_day() != null) {
            sql.VALUES("overdue_day", "#{overdue_day,jdbcType=TINYINT}");
        }

        if (record.getContract_id() != null) {
            sql.VALUES("contract_id", "#{contract_id,jdbcType=INTEGER}");
        }

        if (record.getDp_sum() != null) {
            sql.VALUES("dp_sum", "#{dp_sum,jdbcType=DECIMAL}");
        }

        if (record.getUnique_code() != null) {
            sql.VALUES("unique_code", "#{unique_code,jdbcType=CHAR}");
        }

        if (record.getExpress_no() != null) {
            sql.VALUES("express_no", "#{express_no,jdbcType=CHAR}");
        }

        if (record.getClient_id() != null) {
            sql.VALUES("client_id", "#{client_id,jdbcType=INTEGER}");
        }

        if (record.getClient_name() != null) {
            sql.VALUES("client_name", "#{client_name,jdbcType=VARCHAR}");
        }

        if (record.getClient_mobile() != null) {
            sql.VALUES("client_mobile", "#{client_mobile,jdbcType=VARCHAR}");
        }

        if (record.getClient_idno() != null) {
            sql.VALUES("client_idno", "#{client_idno,jdbcType=CHAR}");
        }

        if (record.getClient_address() != null) {
            sql.VALUES("client_address", "#{client_address,jdbcType=VARCHAR}");
        }

        if (record.getPhone_band() != null) {
            sql.VALUES("phone_band", "#{phone_band,jdbcType=VARCHAR}");
        }

        if (record.getPhone_model() != null) {
            sql.VALUES("phone_model", "#{phone_model,jdbcType=VARCHAR}");
        }

        if (record.getPhone_color() != null) {
            sql.VALUES("phone_color", "#{phone_color,jdbcType=VARCHAR}");
        }

        if (record.getPhone_memory() != null) {
            sql.VALUES("phone_memory", "#{phone_memory,jdbcType=VARCHAR}");
        }

        if (record.getPhone_size() != null) {
            sql.VALUES("phone_size", "#{phone_size,jdbcType=VARCHAR}");
        }

        if (record.getPhone_storage() != null) {
            sql.VALUES("phone_storage", "#{phone_storage,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
 if (record.getCreatetime() != null) {
            sql.VALUES("createtime", "#{createtime,jdbcType=VARCHAR}");
        }
        if (record.getCredit_score() != null) {
            sql.VALUES("credit_score", "#{credit_score,jdbcType=VARCHAR}");
        }
        if (record.getAssetside_score() != null) {
            sql.VALUES("assetside_score", "#{assetside_score,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ProductOrder record) {
        SQL sql = new SQL();
        sql.UPDATE("product_order");

        if (record.getProduct_id() != null) {
            sql.SET("product_id = #{product_id,jdbcType=INTEGER}");
        }

        if (record.getOrder_no() != null) {
            sql.SET("order_no = #{order_no,jdbcType=CHAR}");
        }

        if (record.getAssetside_id() != null) {
            sql.SET("assetside_id = #{assetside_id,jdbcType=INTEGER}");
        }

        if (record.getInterest_start() != null) {
            sql.SET("interest_start = #{interest_start,jdbcType=TIMESTAMP}");
        }

        if (record.getInterst_end() != null) {
            sql.SET("interst_end = #{interst_end,jdbcType=TIMESTAMP}");
        }

        if (record.getLoan_sum() != null) {
            sql.SET("loan_sum = #{loan_sum,jdbcType=DECIMAL}");
        }

        if (record.getContract_sum() != null) {
            sql.SET("contract_sum = #{contract_sum,jdbcType=DECIMAL}");
        }

        if (record.getTotal_period() != null) {
            sql.SET("total_period = #{total_period,jdbcType=TINYINT}");
        }

        if (record.getReceived_period() != null) {
            sql.SET("received_period = #{received_period,jdbcType=TINYINT}");
        }

        if (record.getReceived_status() != null) {
            sql.SET("received_status = #{received_status,jdbcType=TINYINT}");
        }

        if (record.getOverdue_day() != null) {
            sql.SET("overdue_day = #{overdue_day,jdbcType=TINYINT}");
        }

        if (record.getContract_id() != null) {
            sql.SET("contract_id = #{contract_id,jdbcType=INTEGER}");
        }

        if (record.getDp_sum() != null) {
            sql.SET("dp_sum = #{dp_sum,jdbcType=DECIMAL}");
        }

        if (record.getUnique_code() != null) {
            sql.SET("unique_code = #{unique_code,jdbcType=CHAR}");
        }

        if (record.getExpress_no() != null) {
            sql.SET("express_no = #{express_no,jdbcType=CHAR}");
        }

        if (record.getClient_id() != null) {
            sql.SET("client_id = #{client_id,jdbcType=INTEGER}");
        }

        if (record.getClient_name() != null) {
            sql.SET("client_name = #{client_name,jdbcType=VARCHAR}");
        }

        if (record.getClient_mobile() != null) {
            sql.SET("client_mobile = #{client_mobile,jdbcType=VARCHAR}");
        }

        if (record.getClient_idno() != null) {
            sql.SET("client_idno = #{client_idno,jdbcType=CHAR}");
        }

        if (record.getClient_address() != null) {
            sql.SET("client_address = #{client_address,jdbcType=VARCHAR}");
        }

        if (record.getPhone_band() != null) {
            sql.SET("phone_band = #{phone_band,jdbcType=VARCHAR}");
        }

        if (record.getPhone_model() != null) {
            sql.SET("phone_model = #{phone_model,jdbcType=VARCHAR}");
        }

        if (record.getPhone_color() != null) {
            sql.SET("phone_color = #{phone_color,jdbcType=VARCHAR}");
        }

        if (record.getPhone_memory() != null) {
            sql.SET("phone_memory = #{phone_memory,jdbcType=VARCHAR}");
        }

        if (record.getPhone_size() != null) {
            sql.SET("phone_size = #{phone_size,jdbcType=VARCHAR}");
        }

        if (record.getPhone_storage() != null) {
            sql.SET("phone_storage = #{phone_storage,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
if (record.getCreatetime() != null) {
            sql.SET("createtime = #{createtime,jdbcType=VARCHAR}");
        }
        if (record.getAssetside_score() != null) {
            sql.SET("assetside_score = #{assetside_score,jdbcType=VARCHAR}");
        }
        if (record.getCredit_score() != null) {
            sql.SET("credit_score = #{credit_score,jdbcType=VARCHAR}");
        }

        sql.WHERE("id = #{id,jdbcType=INTEGER}");

        return sql.toString();
    }
//    credit_score,assetside_score

    public String selectProductOrderByExampleOrLike(ProductOrderReq ass) {
        return new SQL() {{
            SELECT(" id, product_id, order_no, assetside_id, interest_start, interst_end, loan_sum, " +
                    "contract_sum, total_period, received_period, received_status, overdue_day, contract_id, " +
                    "dp_sum, unique_code, express_no, client_id, client_name, client_mobile, client_idno, " +
                    "client_address, phone_band, phone_model, phone_color, phone_memory, phone_size, phone_storage, status,createtime,credit_score,assetside_score ");
            FROM("product_order");
            if (ass.getAssetside_id() != null) {
                WHERE("assetside_id = #{assetside_id}");
            }
            if (ass.getOrder_no() != null) {
                WHERE("order_no like CONCAT('%',#{order_no},'%')");
            }
            if (ass.getEndLoanSum() != null && ass.getStartLoanSum() != null) {
                WHERE("loan_sum  between  #{startLoanSum} and  #{endLoanSum}");
            } else {
                if (ass.getStartLoanSum() != null) {
                    WHERE("loan_sum >= #{startLoanSum}");
                } else if(ass.getEndLoanSum()!=null) {
                    WHERE("loan_sum <= #{endLoanSum}");
                }
            }
            if (ass.getStatus() != null) {
                WHERE("status = #{status}");
            }
            if (ass.getReceived_status() != null) {
                WHERE("received_status = #{received_status}");
            }
            if (ass.getClient_id() != null) {
                WHERE("client_id=#{client_id}");
            }
            ORDER_BY("id desc");
        }}.toString();
    }
}