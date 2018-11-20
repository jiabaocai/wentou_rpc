package com.bwtservice.entity;

import java.io.Serializable;
import java.util.Date;

public class Config implements Serializable {
    private Integer id;

    private String telname;

    private String state;

    private Date cime;

    private String current;

    private String remark;

    private String url;

    private String level;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelname() {
        return telname;
    }

    public void setTelname(String telname) {
        this.telname = telname == null ? null : telname.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getCime() {
        return cime;
    }

    public void setCime(Date cime) {
        this.cime = cime;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current == null ? null : current.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", telname=").append(telname);
        sb.append(", state=").append(state);
        sb.append(", cime=").append(cime);
        sb.append(", current=").append(current);
        sb.append(", remark=").append(remark);
        sb.append(", url=").append(url);
        sb.append(", level=").append(level);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}