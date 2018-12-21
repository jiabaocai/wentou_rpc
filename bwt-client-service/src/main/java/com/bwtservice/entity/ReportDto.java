package com.bwtservice.entity;

import lombok.Data;

/**
 * @program: wentou_rpc
 * @Version 1.0.0
 * @description:
 * @author: Mr.cai
 * @create: 2018-12-11 21:56
 * @CopyRight 本内容仅限于北境内部传阅，禁止外泄以及用于其他的商业目的
 **/
@Data
public class ReportDto {
    //资产端名称
    private String name;
    //订单编号
    private String order_no;
    //订单生成时间
    private String createtime;
    //放款金额
    private Long loan_sum;
    //放款状态
    private Integer status;
    //放款状态中文名称
    private String status_name;
    //计息开始时间
    private String interest_start;
    //计息结束时间
    private String interst_end;
    //合同生效日期
    private String signdate;
    //本期本金
    private Long rp_capital;
    //本期利息
    private Long rp_interest;
    //本期应回款金额
    private Long rp_amount;
    //回款状态
    private Integer loan_status;
    //回款状态1
    private Integer received_status;
    private String received_status_name;
    //汇款状态中文名称
    private String loan_status_name;
    //还款状态
    private Integer rp_status;
    //还款状态中文名称
    private String rp_status_name;

    private String current_interest_start;

    private String current_interest_end;
}


 
