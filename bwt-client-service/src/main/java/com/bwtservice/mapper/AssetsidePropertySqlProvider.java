package com.bwtservice.mapper;

import com.bwtservice.entity.AssetsidePropertyWithBLOBs;
import org.apache.ibatis.jdbc.SQL;

public class AssetsidePropertySqlProvider {

    public String insertSelective(AssetsidePropertyWithBLOBs record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("assetside_property");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getAssetside_id() != null) {
            sql.VALUES("assetside_id", "#{assetside_id,jdbcType=INTEGER}");
        }
        
        if (record.getBs_enddate() != null) {
            sql.VALUES("bs_enddate", "#{bs_enddate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBs_al() != null) {
            sql.VALUES("bs_al", "#{bs_al,jdbcType=VARCHAR}");
        }
        
        if (record.getBs_deposit() != null) {
            sql.VALUES("bs_deposit", "#{bs_deposit,jdbcType=VARCHAR}");
        }
        
        if (record.getBs_npm() != null) {
            sql.VALUES("bs_npm", "#{bs_npm,jdbcType=VARCHAR}");
        }
        
        if (record.getPi_productname() != null) {
            sql.VALUES("pi_productname", "#{pi_productname,jdbcType=VARCHAR}");
        }
        
        if (record.getPi_productsum() != null) {
            sql.VALUES("pi_productsum", "#{pi_productsum,jdbcType=VARCHAR}");
        }
        
        if (record.getPi_al() != null) {
            sql.VALUES("pi_al", "#{pi_al,jdbcType=VARCHAR}");
        }
        
        if (record.getPi_contactterm() != null) {
            sql.VALUES("pi_contactterm", "#{pi_contactterm,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPi_weightingterm() != null) {
            sql.VALUES("pi_weightingterm", "#{pi_weightingterm,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPi_rate() != null) {
            sql.VALUES("pi_rate", "#{pi_rate,jdbcType=VARCHAR}");
        }
        
        if (record.getCharge_way() != null) {
            sql.VALUES("charge_way", "#{charge_way,jdbcType=VARCHAR}");
        }
        
        if (record.getRepay_way() != null) {
            sql.VALUES("repay_way", "#{repay_way,jdbcType=VARCHAR}");
        }
        
        if (record.getFeature() != null) {
            sql.VALUES("feature", "#{feature,jdbcType=VARCHAR}");
        }
        
        if (record.getRg_way() != null) {
            sql.VALUES("rg_way", "#{rg_way,jdbcType=VARCHAR}");
        }
        
        if (record.getFund_term() != null) {
            sql.VALUES("fund_term", "#{fund_term,jdbcType=VARCHAR}");
        }
        
        if (record.getFund_flow() != null) {
            sql.VALUES("fund_flow", "#{fund_flow,jdbcType=VARCHAR}");
        }
        
        if (record.getAl_tunnel() != null) {
            sql.VALUES("al_tunnel", "#{al_tunnel,jdbcType=VARCHAR}");
        }
        
        if (record.getRepay_tunnel() != null) {
            sql.VALUES("repay_tunnel", "#{repay_tunnel,jdbcType=VARCHAR}");
        }
        
        if (record.getSign_way() != null) {
            sql.VALUES("sign_way", "#{sign_way,jdbcType=VARCHAR}");
        }
        
        if (record.getRisk_feature() != null) {
            sql.VALUES("risk_feature", "#{risk_feature,jdbcType=VARCHAR}");
        }
        
        if (record.getCapital_list() != null) {
            sql.VALUES("capital_list", "#{capital_list,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getOuter_list() != null) {
            sql.VALUES("outer_list", "#{outer_list,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(AssetsidePropertyWithBLOBs record) {
        SQL sql = new SQL();
        sql.UPDATE("assetside_property");
        
//        if (record.getAssetside_id() != null) {
//            sql.SET("assetside_id = #{assetside_id,jdbcType=INTEGER}");
//        }
        
        if (record.getBs_enddate() != null) {
            sql.SET("bs_enddate = #{bs_enddate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBs_al() != null) {
            sql.SET("bs_al = #{bs_al,jdbcType=VARCHAR}");
        }
        
        if (record.getBs_deposit() != null) {
            sql.SET("bs_deposit = #{bs_deposit,jdbcType=VARCHAR}");
        }
        
        if (record.getBs_npm() != null) {
            sql.SET("bs_npm = #{bs_npm,jdbcType=VARCHAR}");
        }
        
        if (record.getPi_productname() != null) {
            sql.SET("pi_productname = #{pi_productname,jdbcType=VARCHAR}");
        }
        
        if (record.getPi_productsum() != null) {
            sql.SET("pi_productsum = #{pi_productsum,jdbcType=VARCHAR}");
        }
        
        if (record.getPi_al() != null) {
            sql.SET("pi_al = #{pi_al,jdbcType=VARCHAR}");
        }
        
        if (record.getPi_contactterm() != null) {
            sql.SET("pi_contactterm = #{pi_contactterm,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPi_weightingterm() != null) {
            sql.SET("pi_weightingterm = #{pi_weightingterm,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPi_rate() != null) {
            sql.SET("pi_rate = #{pi_rate,jdbcType=VARCHAR}");
        }
        
        if (record.getCharge_way() != null) {
            sql.SET("charge_way = #{charge_way,jdbcType=VARCHAR}");
        }
        
        if (record.getRepay_way() != null) {
            sql.SET("repay_way = #{repay_way,jdbcType=VARCHAR}");
        }
        
        if (record.getFeature() != null) {
            sql.SET("feature = #{feature,jdbcType=VARCHAR}");
        }
        
        if (record.getRg_way() != null) {
            sql.SET("rg_way = #{rg_way,jdbcType=VARCHAR}");
        }
        
        if (record.getFund_term() != null) {
            sql.SET("fund_term = #{fund_term,jdbcType=VARCHAR}");
        }
        
        if (record.getFund_flow() != null) {
            sql.SET("fund_flow = #{fund_flow,jdbcType=VARCHAR}");
        }
        
        if (record.getAl_tunnel() != null) {
            sql.SET("al_tunnel = #{al_tunnel,jdbcType=VARCHAR}");
        }
        
        if (record.getRepay_tunnel() != null) {
            sql.SET("repay_tunnel = #{repay_tunnel,jdbcType=VARCHAR}");
        }
        
        if (record.getSign_way() != null) {
            sql.SET("sign_way = #{sign_way,jdbcType=VARCHAR}");
        }
        
        if (record.getRisk_feature() != null) {
            sql.SET("risk_feature = #{risk_feature,jdbcType=VARCHAR}");
        }
        
        if (record.getCapital_list() != null) {
            sql.SET("capital_list = #{capital_list,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getOuter_list() != null) {
            sql.SET("outer_list = #{outer_list,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("assetside_id = #{assetside_id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}