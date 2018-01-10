package com.jzw.book.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDetails implements Serializable {

    private Integer odId;

    private Integer bookId;

    private Integer shopId = 1;

    private Integer orderId;

    private Integer odSum;

    private BigDecimal odPrice;

    public OrderDetails() {

    }

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOdSum() {
        return odSum;
    }

    public void setOdSum(Integer odSum) {
        this.odSum = odSum;
    }

    public BigDecimal getOdPrice() {
        return odPrice;
    }

    public void setOdPrice(BigDecimal odPrice) {
        this.odPrice = odPrice;
    }


}