package com.bwtservice.mapper;

import com.bwtservice.entity.AssetsideProperty;
import com.bwtservice.entity.AssetsidePropertyWithBLOBs;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface AssetsidePropertyMapper {
    @Delete({
        "delete from assetside_property",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into assetside_property (id, assetside_id, ",
        "bs_enddate, bs_al, ",
        "bs_deposit, bs_npm, ",
        "pi_productname, pi_productsum, ",
        "pi_al, pi_contactterm, ",
        "pi_weightingterm, pi_rate, ",
        "charge_way, repay_way, ",
        "feature, rg_way, ",
        "fund_term, fund_flow, ",
        "al_tunnel, repay_tunnel, ",
        "sign_way, risk_feature, ",
        "capital_list, outer_list)",
        "values (#{id,jdbcType=INTEGER}, #{assetside_id,jdbcType=INTEGER}, ",
        "#{bs_enddate,jdbcType=TIMESTAMP}, #{bs_al,jdbcType=VARCHAR}, ",
        "#{bs_deposit,jdbcType=VARCHAR}, #{bs_npm,jdbcType=VARCHAR}, ",
        "#{pi_productname,jdbcType=VARCHAR}, #{pi_productsum,jdbcType=VARCHAR}, ",
        "#{pi_al,jdbcType=VARCHAR}, #{pi_contactterm,jdbcType=TIMESTAMP}, ",
        "#{pi_weightingterm,jdbcType=TIMESTAMP}, #{pi_rate,jdbcType=VARCHAR}, ",
        "#{charge_way,jdbcType=VARCHAR}, #{repay_way,jdbcType=VARCHAR}, ",
        "#{feature,jdbcType=VARCHAR}, #{rg_way,jdbcType=VARCHAR}, ",
        "#{fund_term,jdbcType=VARCHAR}, #{fund_flow,jdbcType=VARCHAR}, ",
        "#{al_tunnel,jdbcType=VARCHAR}, #{repay_tunnel,jdbcType=VARCHAR}, ",
        "#{sign_way,jdbcType=VARCHAR}, #{risk_feature,jdbcType=VARCHAR}, ",
        "#{capital_list,jdbcType=LONGVARCHAR}, #{outer_list,jdbcType=LONGVARCHAR})"
    })
    int insert(AssetsidePropertyWithBLOBs record);

    @InsertProvider(type=AssetsidePropertySqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insertSelective(AssetsidePropertyWithBLOBs record);

    @Select({
        "select",
        "id, assetside_id, bs_enddate, bs_al, bs_deposit, bs_npm, pi_productname, pi_productsum, ",
        "pi_al, pi_contactterm, pi_weightingterm, pi_rate, charge_way, repay_way, feature, ",
        "rg_way, fund_term, fund_flow, al_tunnel, repay_tunnel, sign_way, risk_feature, ",
        "capital_list, outer_list",
        "from assetside_property",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="assetside_id", property="assetside_id", jdbcType=JdbcType.INTEGER),
        @Result(column="bs_enddate", property="bs_enddate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="bs_al", property="bs_al", jdbcType=JdbcType.VARCHAR),
        @Result(column="bs_deposit", property="bs_deposit", jdbcType=JdbcType.VARCHAR),
        @Result(column="bs_npm", property="bs_npm", jdbcType=JdbcType.VARCHAR),
        @Result(column="pi_productname", property="pi_productname", jdbcType=JdbcType.VARCHAR),
        @Result(column="pi_productsum", property="pi_productsum", jdbcType=JdbcType.VARCHAR),
        @Result(column="pi_al", property="pi_al", jdbcType=JdbcType.VARCHAR),
        @Result(column="pi_contactterm", property="pi_contactterm", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pi_weightingterm", property="pi_weightingterm", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="pi_rate", property="pi_rate", jdbcType=JdbcType.VARCHAR),
        @Result(column="charge_way", property="charge_way", jdbcType=JdbcType.VARCHAR),
        @Result(column="repay_way", property="repay_way", jdbcType=JdbcType.VARCHAR),
        @Result(column="feature", property="feature", jdbcType=JdbcType.VARCHAR),
        @Result(column="rg_way", property="rg_way", jdbcType=JdbcType.VARCHAR),
        @Result(column="fund_term", property="fund_term", jdbcType=JdbcType.VARCHAR),
        @Result(column="fund_flow", property="fund_flow", jdbcType=JdbcType.VARCHAR),
        @Result(column="al_tunnel", property="al_tunnel", jdbcType=JdbcType.VARCHAR),
        @Result(column="repay_tunnel", property="repay_tunnel", jdbcType=JdbcType.VARCHAR),
        @Result(column="sign_way", property="sign_way", jdbcType=JdbcType.VARCHAR),
        @Result(column="risk_feature", property="risk_feature", jdbcType=JdbcType.VARCHAR),
        @Result(column="capital_list", property="capital_list", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="outer_list", property="outer_list", jdbcType=JdbcType.LONGVARCHAR)
    })
    AssetsidePropertyWithBLOBs selectByPrimaryKey(Integer id);



    @Select({
            "select",
            "id, assetside_id, bs_enddate, bs_al, bs_deposit, bs_npm, pi_productname, pi_productsum, ",
            "pi_al, pi_contactterm, pi_weightingterm, pi_rate, charge_way, repay_way, feature, ",
            "rg_way, fund_term, fund_flow, al_tunnel, repay_tunnel, sign_way, risk_feature, ",
            "capital_list, outer_list",
            "from assetside_property",
            "where assetside_id = #{AssetsideId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="assetside_id", property="assetside_id", jdbcType=JdbcType.INTEGER),
            @Result(column="bs_enddate", property="bs_enddate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="bs_al", property="bs_al", jdbcType=JdbcType.VARCHAR),
            @Result(column="bs_deposit", property="bs_deposit", jdbcType=JdbcType.VARCHAR),
            @Result(column="bs_npm", property="bs_npm", jdbcType=JdbcType.VARCHAR),
            @Result(column="pi_productname", property="pi_productname", jdbcType=JdbcType.VARCHAR),
            @Result(column="pi_productsum", property="pi_productsum", jdbcType=JdbcType.VARCHAR),
            @Result(column="pi_al", property="pi_al", jdbcType=JdbcType.VARCHAR),
            @Result(column="pi_contactterm", property="pi_contactterm", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="pi_weightingterm", property="pi_weightingterm", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="pi_rate", property="pi_rate", jdbcType=JdbcType.VARCHAR),
            @Result(column="charge_way", property="charge_way", jdbcType=JdbcType.VARCHAR),
            @Result(column="repay_way", property="repay_way", jdbcType=JdbcType.VARCHAR),
            @Result(column="feature", property="feature", jdbcType=JdbcType.VARCHAR),
            @Result(column="rg_way", property="rg_way", jdbcType=JdbcType.VARCHAR),
            @Result(column="fund_term", property="fund_term", jdbcType=JdbcType.VARCHAR),
            @Result(column="fund_flow", property="fund_flow", jdbcType=JdbcType.VARCHAR),
            @Result(column="al_tunnel", property="al_tunnel", jdbcType=JdbcType.VARCHAR),
            @Result(column="repay_tunnel", property="repay_tunnel", jdbcType=JdbcType.VARCHAR),
            @Result(column="sign_way", property="sign_way", jdbcType=JdbcType.VARCHAR),
            @Result(column="risk_feature", property="risk_feature", jdbcType=JdbcType.VARCHAR),
            @Result(column="capital_list", property="capital_list", jdbcType=JdbcType.LONGVARCHAR),
            @Result(column="outer_list", property="outer_list", jdbcType=JdbcType.LONGVARCHAR)
    })
    AssetsidePropertyWithBLOBs selectByPrimaryAssId(Integer AssetsideId);

    @UpdateProvider(type=AssetsidePropertySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AssetsidePropertyWithBLOBs record);

    @Update({
        "update assetside_property",
        "set assetside_id = #{assetside_id,jdbcType=INTEGER},",
          "bs_enddate = #{bs_enddate,jdbcType=TIMESTAMP},",
          "bs_al = #{bs_al,jdbcType=VARCHAR},",
          "bs_deposit = #{bs_deposit,jdbcType=VARCHAR},",
          "bs_npm = #{bs_npm,jdbcType=VARCHAR},",
          "pi_productname = #{pi_productname,jdbcType=VARCHAR},",
          "pi_productsum = #{pi_productsum,jdbcType=VARCHAR},",
          "pi_al = #{pi_al,jdbcType=VARCHAR},",
          "pi_contactterm = #{pi_contactterm,jdbcType=TIMESTAMP},",
          "pi_weightingterm = #{pi_weightingterm,jdbcType=TIMESTAMP},",
          "pi_rate = #{pi_rate,jdbcType=VARCHAR},",
          "charge_way = #{charge_way,jdbcType=VARCHAR},",
          "repay_way = #{repay_way,jdbcType=VARCHAR},",
          "feature = #{feature,jdbcType=VARCHAR},",
          "rg_way = #{rg_way,jdbcType=VARCHAR},",
          "fund_term = #{fund_term,jdbcType=VARCHAR},",
          "fund_flow = #{fund_flow,jdbcType=VARCHAR},",
          "al_tunnel = #{al_tunnel,jdbcType=VARCHAR},",
          "repay_tunnel = #{repay_tunnel,jdbcType=VARCHAR},",
          "sign_way = #{sign_way,jdbcType=VARCHAR},",
          "risk_feature = #{risk_feature,jdbcType=VARCHAR},",
          "capital_list = #{capital_list,jdbcType=LONGVARCHAR},",
          "outer_list = #{outer_list,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(AssetsidePropertyWithBLOBs record);

    @Update({
        "update assetside_property",
        "set assetside_id = #{assetside_id,jdbcType=INTEGER},",
          "bs_enddate = #{bs_enddate,jdbcType=TIMESTAMP},",
          "bs_al = #{bs_al,jdbcType=VARCHAR},",
          "bs_deposit = #{bs_deposit,jdbcType=VARCHAR},",
          "bs_npm = #{bs_npm,jdbcType=VARCHAR},",
          "pi_productname = #{pi_productname,jdbcType=VARCHAR},",
          "pi_productsum = #{pi_productsum,jdbcType=VARCHAR},",
          "pi_al = #{pi_al,jdbcType=VARCHAR},",
          "pi_contactterm = #{pi_contactterm,jdbcType=TIMESTAMP},",
          "pi_weightingterm = #{pi_weightingterm,jdbcType=TIMESTAMP},",
          "pi_rate = #{pi_rate,jdbcType=VARCHAR},",
          "charge_way = #{charge_way,jdbcType=VARCHAR},",
          "repay_way = #{repay_way,jdbcType=VARCHAR},",
          "feature = #{feature,jdbcType=VARCHAR},",
          "rg_way = #{rg_way,jdbcType=VARCHAR},",
          "fund_term = #{fund_term,jdbcType=VARCHAR},",
          "fund_flow = #{fund_flow,jdbcType=VARCHAR},",
          "al_tunnel = #{al_tunnel,jdbcType=VARCHAR},",
          "repay_tunnel = #{repay_tunnel,jdbcType=VARCHAR},",
          "sign_way = #{sign_way,jdbcType=VARCHAR},",
          "risk_feature = #{risk_feature,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AssetsideProperty record);
}