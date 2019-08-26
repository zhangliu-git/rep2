package com.ssm.beans;

import java.math.BigDecimal;

public class Orderitem {
    private String iid;

    private BigDecimal count;

    private BigDecimal subtotal;

    private String ooid;

    private String bid;

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid == null ? null : iid.trim();
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public String getOoid() {
        return ooid;
    }

    public void setOoid(String ooid) {
        this.ooid = ooid == null ? null : ooid.trim();
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid == null ? null : bid.trim();
    }
}