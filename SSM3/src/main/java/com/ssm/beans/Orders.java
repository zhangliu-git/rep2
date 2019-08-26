package com.ssm.beans;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {
    private String ooid;

    private Date ordertime;

    private BigDecimal total;

    private Short state;

    private String uuid;

    private String address;

    public String getOoid() {
        return ooid;
    }

    public void setOoid(String ooid) {
        this.ooid = ooid == null ? null : ooid.trim();
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}