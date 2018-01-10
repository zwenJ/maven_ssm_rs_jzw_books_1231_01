package com.jzw.book.util;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * 说明：查询分页的工具类
 *
 * @author Jzw
 * @date 2018/1/3 14:57
 */
@Component
public class PageBean extends PageInfo {

    //当前页
    private int pageNum = 1;

    //每页的数量
    private int pageSize = 5;

    /**
     * 查询热门数据， 默认false不查询
     */
    private boolean mtod = false;

    /**
     * 查询最近的数据
     */
    private boolean recently = false;

    /**
     * 查询的数据状态
     */
    private Integer status = 2;

    /**
     * 查询的关键字
     */
    private String likeText = "";

    /**
     * 分类查询关键字
     */
    private Integer bookType;


    public PageBean() {

    }

    public Integer getBookType() {
        return bookType;
    }

    public void setBookType(Integer bookType) {
        this.bookType = bookType;
    }

    @Override
    public int getPageNum() {
        return pageNum;
    }

    @Override
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isMtod() {
        return mtod;
    }

    public void setMtod(boolean mtod) {
        this.mtod = mtod;
    }

    public boolean isRecently() {
        return recently;
    }

    public void setRecently(boolean recently) {
        this.recently = recently;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLikeText() {
        return likeText;
    }

    public void setLikeText(String likeText) {
        this.likeText = likeText;
    }


    @Override
    public String toString() {
        return "PageBean{" +
                ", mtod=" + mtod +
                ", recently=" + recently +
                ", status=" + status +
                ", likeText='" + likeText + '\'' +
                '}';
    }



}
