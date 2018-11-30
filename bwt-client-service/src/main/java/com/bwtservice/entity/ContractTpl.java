package com.bwtservice.entity;

import java.io.Serializable;
import java.util.Date;

public class ContractTpl implements Serializable {
    private Integer tpl_id;

    private String tpl_name;

    private String remark;

    private Integer create_uid;

    private Integer update_uid;

    private Date create_time;

    private Date update_time;

    private Integer times;

    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getTpl_id() {
        return tpl_id;
    }

    public void setTpl_id(Integer tpl_id) {
        this.tpl_id = tpl_id;
    }

    public String getTpl_name() {
        return tpl_name;
    }

    public void setTpl_name(String tpl_name) {
        this.tpl_name = tpl_name == null ? null : tpl_name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getCreate_uid() {
        return create_uid;
    }

    public void setCreate_uid(Integer create_uid) {
        this.create_uid = create_uid;
    }

    public Integer getUpdate_uid() {
        return update_uid;
    }

    public void setUpdate_uid(Integer update_uid) {
        this.update_uid = update_uid;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tpl_id=").append(tpl_id);
        sb.append(", tpl_name=").append(tpl_name);
        sb.append(", remark=").append(remark);
        sb.append(", create_uid=").append(create_uid);
        sb.append(", update_uid=").append(update_uid);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append(", times=").append(times);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}