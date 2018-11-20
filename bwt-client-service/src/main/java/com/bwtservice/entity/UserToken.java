package com.bwtservice.entity;

import java.io.Serializable;

public class UserToken implements Serializable {
    private Long id;

    private Long user_id;

    private Integer expire_time;

    private Integer token_status;

    private String token;

    private String device_code;

    private String device_type;

    private Integer create_time;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Integer getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(Integer expire_time) {
        this.expire_time = expire_time;
    }

    public Integer getToken_status() {
        return token_status;
    }

    public void setToken_status(Integer token_status) {
        this.token_status = token_status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getDevice_code() {
        return device_code;
    }

    public void setDevice_code(String device_code) {
        this.device_code = device_code == null ? null : device_code.trim();
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type == null ? null : device_type.trim();
    }

    public Integer getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Integer create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", user_id=").append(user_id);
        sb.append(", expire_time=").append(expire_time);
        sb.append(", token_status=").append(token_status);
        sb.append(", token=").append(token);
        sb.append(", device_code=").append(device_code);
        sb.append(", device_type=").append(device_type);
        sb.append(", create_time=").append(create_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}