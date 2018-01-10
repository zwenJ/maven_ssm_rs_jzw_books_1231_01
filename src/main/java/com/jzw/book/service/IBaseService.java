package com.jzw.book.service;

import com.jzw.book.util.PageBean;

import java.util.List;

/**
 * 说明：基本的Service层
 *
 * @author Jzw
 * @date 2018/1/5 20:42
 */
public interface IBaseService<T> {

    /**
     * 查询的方法
     * @param t
     * @return
     */
    public List<T> showAll(T t);


    /**
     * 查询的方法
     * @param pageBean
     * @return
     */
    public List<T> showAll(PageBean pageBean);



    /**
     * 查询单个
     * @param integer
     * @return
     */
    public T showSole(Integer integer);


    /**
     * 添加保存的方法
     * @param t
     * @return
     */
    public boolean saveObj(T t);


    /**
     * 修改的方法
     * @param t
     * @return
     */
    public boolean updateObj(T t);


    /**
     * 删除的方法
     * @param integer
     * @return
     */
    public boolean deleteObj(Integer integer);


}
