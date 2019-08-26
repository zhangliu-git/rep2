package com.ssm.beans;

import com.ssm.validation.validationGroup1;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class Book {
    private String bid;
    //校验
    //message是提示校验出错信息,groups是表示此校验属于哪个分组，可以定义多个分组
    @Size(min=4,max=18,message="{items.name.length.error}",groups = {validationGroup1.class})
    private String bname;
    @NotNull(message="{items.price.isNull}")
    private BigDecimal price;

    private String author;

    private String image;

    private String cid;

    private BigDecimal del;

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid == null ? null : bid.trim();
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public BigDecimal getDel() {
        return del;
    }

    public void setDel(BigDecimal del) {
        this.del = del;
    }
}