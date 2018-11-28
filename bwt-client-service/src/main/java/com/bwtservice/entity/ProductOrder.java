package com.bwtservice.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProductOrder implements Serializable {
    private Integer id;

    private Integer product_id;

    private String order_no;

    private Integer assetside_id;

    private Date interest_start;

    private Date interst_end;

    private BigDecimal loan_sum;

    private BigDecimal contract_sum;

    private Byte total_period;

    private Byte received_period;

    private Byte received_status;

    private Byte overdue_day;

    private Integer contract_id;

    private BigDecimal dp_sum;

    private String unique_code;

    private String express_no;

    private Integer client_id;

    private String client_name;

    private String client_mobile;

    private String client_idno;

    private String client_address;

    private String phone_band;

    private String phone_model;

    private String phone_color;

    private String phone_memory;

    private String phone_size;

    private String phone_storage;

    private Byte status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no == null ? null : order_no.trim();
    }

    public Integer getAssetside_id() {
        return assetside_id;
    }

    public void setAssetside_id(Integer assetside_id) {
        this.assetside_id = assetside_id;
    }

    public Date getInterest_start() {
        return interest_start;
    }

    public void setInterest_start(Date interest_start) {
        this.interest_start = interest_start;
    }

    public Date getInterst_end() {
        return interst_end;
    }

    public void setInterst_end(Date interst_end) {
        this.interst_end = interst_end;
    }

    public BigDecimal getLoan_sum() {
        return loan_sum;
    }

    public void setLoan_sum(BigDecimal loan_sum) {
        this.loan_sum = loan_sum;
    }

    public BigDecimal getContract_sum() {
        return contract_sum;
    }

    public void setContract_sum(BigDecimal contract_sum) {
        this.contract_sum = contract_sum;
    }

    public Byte getTotal_period() {
        return total_period;
    }

    public void setTotal_period(Byte total_period) {
        this.total_period = total_period;
    }

    public Byte getReceived_period() {
        return received_period;
    }

    public void setReceived_period(Byte received_period) {
        this.received_period = received_period;
    }

    public Byte getReceived_status() {
        return received_status;
    }

    public void setReceived_status(Byte received_status) {
        this.received_status = received_status;
    }

    public Byte getOverdue_day() {
        return overdue_day;
    }

    public void setOverdue_day(Byte overdue_day) {
        this.overdue_day = overdue_day;
    }

    public Integer getContract_id() {
        return contract_id;
    }

    public void setContract_id(Integer contract_id) {
        this.contract_id = contract_id;
    }

    public BigDecimal getDp_sum() {
        return dp_sum;
    }

    public void setDp_sum(BigDecimal dp_sum) {
        this.dp_sum = dp_sum;
    }

    public String getUnique_code() {
        return unique_code;
    }

    public void setUnique_code(String unique_code) {
        this.unique_code = unique_code == null ? null : unique_code.trim();
    }

    public String getExpress_no() {
        return express_no;
    }

    public void setExpress_no(String express_no) {
        this.express_no = express_no == null ? null : express_no.trim();
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name == null ? null : client_name.trim();
    }

    public String getClient_mobile() {
        return client_mobile;
    }

    public void setClient_mobile(String client_mobile) {
        this.client_mobile = client_mobile == null ? null : client_mobile.trim();
    }

    public String getClient_idno() {
        return client_idno;
    }

    public void setClient_idno(String client_idno) {
        this.client_idno = client_idno == null ? null : client_idno.trim();
    }

    public String getClient_address() {
        return client_address;
    }

    public void setClient_address(String client_address) {
        this.client_address = client_address == null ? null : client_address.trim();
    }

    public String getPhone_band() {
        return phone_band;
    }

    public void setPhone_band(String phone_band) {
        this.phone_band = phone_band == null ? null : phone_band.trim();
    }

    public String getPhone_model() {
        return phone_model;
    }

    public void setPhone_model(String phone_model) {
        this.phone_model = phone_model == null ? null : phone_model.trim();
    }

    public String getPhone_color() {
        return phone_color;
    }

    public void setPhone_color(String phone_color) {
        this.phone_color = phone_color == null ? null : phone_color.trim();
    }

    public String getPhone_memory() {
        return phone_memory;
    }

    public void setPhone_memory(String phone_memory) {
        this.phone_memory = phone_memory == null ? null : phone_memory.trim();
    }

    public String getPhone_size() {
        return phone_size;
    }

    public void setPhone_size(String phone_size) {
        this.phone_size = phone_size == null ? null : phone_size.trim();
    }

    public String getPhone_storage() {
        return phone_storage;
    }

    public void setPhone_storage(String phone_storage) {
        this.phone_storage = phone_storage == null ? null : phone_storage.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", product_id=").append(product_id);
        sb.append(", order_no=").append(order_no);
        sb.append(", assetside_id=").append(assetside_id);
        sb.append(", interest_start=").append(interest_start);
        sb.append(", interst_end=").append(interst_end);
        sb.append(", loan_sum=").append(loan_sum);
        sb.append(", contract_sum=").append(contract_sum);
        sb.append(", total_period=").append(total_period);
        sb.append(", received_period=").append(received_period);
        sb.append(", received_status=").append(received_status);
        sb.append(", overdue_day=").append(overdue_day);
        sb.append(", contract_id=").append(contract_id);
        sb.append(", dp_sum=").append(dp_sum);
        sb.append(", unique_code=").append(unique_code);
        sb.append(", express_no=").append(express_no);
        sb.append(", client_id=").append(client_id);
        sb.append(", client_name=").append(client_name);
        sb.append(", client_mobile=").append(client_mobile);
        sb.append(", client_idno=").append(client_idno);
        sb.append(", client_address=").append(client_address);
        sb.append(", phone_band=").append(phone_band);
        sb.append(", phone_model=").append(phone_model);
        sb.append(", phone_color=").append(phone_color);
        sb.append(", phone_memory=").append(phone_memory);
        sb.append(", phone_size=").append(phone_size);
        sb.append(", phone_storage=").append(phone_storage);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}