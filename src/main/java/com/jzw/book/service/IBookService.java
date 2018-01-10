package com.jzw.book.service;

import com.jzw.book.model.Books;
import com.jzw.book.util.PageBean;

import java.util.List;
import java.util.Map;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/2 16:45
 */
public interface IBookService {


    /**
     * 查询一个集合的商品信息
     * @param pageBean
     * @return
     */
    public List<Books> showBooks(PageBean pageBean);



    /**
     * 根据编号查询单个商品信息
     * @param bookId
     * @return
     */
    public Books showBook(Integer bookId);



    /**
     * 添加一个新的商品
     * @param books
     * @return
     */
    public boolean saveBook(Books books);



    /**
     * 根据编号修改商品的相关属性
     * @param books
     * @return
     */
    public boolean updateBook(Books books);


    /**
     * 删除商品
     * @param bookId
     * @return
     */
    public boolean deleteBook(Integer bookId);



}
