package com.bwtservice.mapper;

import com.bwtservice.entity.AssetsideWithBLOBs;
import org.apache.ibatis.jdbc.SQL;

public class AssetsideSqlProvider {

    public String insertSelective(AssetsideWithBLOBs record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("assetside");
        
        if (record.getAssetside_id() != null) {
            sql.VALUES("assetside_id", "#{assetside_id,jdbcType=INTEGER}");
        }
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCorp_name() != null) {
            sql.VALUES("corp_name", "#{corp_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCorp_no() != null) {
            sql.VALUES("corp_no", "#{corp_no,jdbcType=CHAR}");
        }
        
        if (record.getCorp_img() != null) {
            sql.VALUES("corp_img", "#{corp_img,jdbcType=VARCHAR}");
        }
        
        if (record.getReg_cap() != null) {
            sql.VALUES("reg_cap", "#{reg_cap,jdbcType=VARCHAR}");
        }
        
        if (record.getFoundingtime() != null) {
            sql.VALUES("foundingtime", "#{foundingtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLegal_rep() != null) {
            sql.VALUES("legal_rep", "#{legal_rep,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getQualification() != null) {
            sql.VALUES("qualification", "#{qualification,jdbcType=VARCHAR}");
        }
        
        if (record.getBankname() != null) {
            sql.VALUES("bankname", "#{bankname,jdbcType=VARCHAR}");
        }
        
        if (record.getBankaccount() != null) {
            sql.VALUES("bankaccount", "#{bankaccount,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.VALUES("createtime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getPartner() != null) {
            sql.VALUES("partner", "#{partner,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getTeam() != null) {
            sql.VALUES("team", "#{team,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getContactinfo() != null) {
            sql.VALUES("contactinfo", "#{contactinfo,jdbcType=LONGVARCHAR}");
        }

        return sql.toString();
    }

    public String selectPersonLike(AssetsideWithBLOBs ass) {
        return new SQL() {{
            SELECT("assetside_id, name, corp_name, corp_no, corp_img, reg_cap, foundingtime, legal_rep,address, qualification, bankname, bankaccount, createtime, status, partner,team, contactinfo");
            FROM("assetside");
            if (ass.getAssetside_id()!=null) {
                WHERE("assetside_id = #{assetside_id}");
            }
            if (ass.getName() != null) {
                WHERE("name like CONCAT('%',#{name},'%')");
            }
            if (ass.getCorp_name() != null) {
                WHERE("corp_name like CONCAT('%',#{corp_name},'%')");
            }
            if (ass.getCorp_no()!=null) {
                WHERE("corp_no = #{corp_no}");
            }
            if (ass.getCorp_img()!=null) {
                WHERE("corp_img = #{corp_img}");
            }
            if (ass.getReg_cap()!=null) {
                WHERE("reg_cap = #{reg_cap}");
            } if (ass.getFoundingtime()!=null) {
                WHERE("foundingtime = #{foundingtime}");
            }
            if (ass.getLegal_rep()!=null) {
                WHERE("legal_rep = #{legal_rep}");
            }
            if (ass.getAddress()!=null) {
                WHERE("address like CONCAT('%',#{address},'%')");
            } if (ass.getQualification()!=null) {
                WHERE("qualification = #{qualification}");
            }
            if (ass.getBankname()!=null) {
                WHERE("bankname like CONCAT('%',#{bankname},'%')");
            } if (ass.getCreatetime()!=null) {
                WHERE("createtime = #{createtime}");
            } if (ass.getStatus()!=null) {
                WHERE("status = #{status}");
            } if (ass.getPartner()!=null) {
                WHERE("partner = #{partner}");
            } if (ass.getTeam()!=null) {
                WHERE("team = #{team}");
            }if (ass.getContactinfo()!=null) {
            WHERE("contactinfo = #{contactinfo}");
        }
            ORDER_BY("assetside_id desc");
        }}.toString();
    }


    public String updateByPrimaryKeySelective(AssetsideWithBLOBs record) {
        SQL sql = new SQL();
        sql.UPDATE("assetside");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCorp_name() != null) {
            sql.SET("corp_name = #{corp_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCorp_no() != null) {
            sql.SET("corp_no = #{corp_no,jdbcType=CHAR}");
        }
        
        if (record.getCorp_img() != null) {
            sql.SET("corp_img = #{corp_img,jdbcType=VARCHAR}");
        }
        
        if (record.getReg_cap() != null) {
            sql.SET("reg_cap = #{reg_cap,jdbcType=VARCHAR}");
        }
        
        if (record.getFoundingtime() != null) {
            sql.SET("foundingtime = #{foundingtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLegal_rep() != null) {
            sql.SET("legal_rep = #{legal_rep,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getQualification() != null) {
            sql.SET("qualification = #{qualification,jdbcType=VARCHAR}");
        }
        
        if (record.getBankname() != null) {
            sql.SET("bankname = #{bankname,jdbcType=VARCHAR}");
        }
        
        if (record.getBankaccount() != null) {
            sql.SET("bankaccount = #{bankaccount,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.SET("createtime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getPartner() != null) {
            sql.SET("partner = #{partner,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getTeam() != null) {
            sql.SET("team = #{team,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getContactinfo() != null) {
            sql.SET("contactinfo = #{contactinfo,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("assetside_id = #{assetside_id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}