package com.jzw.book.mapper;

import com.jzw.book.model.Books;
import com.jzw.book.util.PageBean;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

public interface BooksMapper {

    int deleteByPrimaryKey(Integer bookId);


    int insert(Books record);


    int insertSelective(Books record);

    Books selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Books record);

    int updateByPrimaryKey(Books record);



    /**
     * 查询一个集合的商品信息
     * @param pageBean
     * @return
     */
    @Cacheable(value = "books", condition = "true")
    public List<Books> showBooks(PageBean pageBean);




}