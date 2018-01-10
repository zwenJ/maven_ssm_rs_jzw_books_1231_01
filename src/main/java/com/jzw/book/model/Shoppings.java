package com.jzw.book.model;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.Serializable;
import java.util.Date;

public class Shoppings implements Serializable {

    /**
     * 购物车商品编号
     */
    private Integer shoppingId;

    private Books books;
    private Integer bookId;

    private Integer shopId;

    private Integer bookSum;

    private Date shoppingDate;

    private Integer userId;

    private Integer shoppingStatus;


    public Shoppings() {

    }

    public Integer getShoppingStatus() {
        return shoppingStatus;
    }

    public void setShoppingStatus(Integer shoppingStatus) {
        this.shoppingStatus = shoppingStatus;
    }

    public Shoppings(Integer userId) {
        this.userId = userId;
    }

    public Shoppings(Integer userId, Integer shoppingStatus) {
        this.userId = userId;
        this.shoppingStatus = shoppingStatus;
    }

    public Integer getShoppingId() {
        return shoppingId;
    }

    public void setShoppingId(Integer shoppingId) {
        this.shoppingId = shoppingId;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
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

    public Integer getBookSum() {
        return bookSum;
    }

    public void setBookSum(Integer bookSum) {
        this.bookSum = bookSum;
    }

    public Date getShoppingDate() {
        return shoppingDate;
    }

    public void setShoppingDate(Date shoppingDate) {
        this.shoppingDate = shoppingDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Shoppings{" +
                "shoppingId=" + shoppingId +
                ", books=" + books +
                ", shopId=" + shopId +
                ", bookSum=" + bookSum +
                ", shoppingDate=" + shoppingDate +
                ", userId=" + userId +
                '}';
    }
}