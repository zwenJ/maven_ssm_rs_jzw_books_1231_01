package com.jzw.book.mapper;

import com.jzw.book.model.Books;
import com.jzw.book.util.PageBean;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

public interface BooksMapper {

    /**
     * 说明：@CacheEvict
     *     value   缓存的名字，必须在spring配置文件中指定一个，如mybatis的别名
     *     key   缓存的key
     *     allEntries  是否在方法执行完成之后清空缓存  默认为 false
     *     beforeInvocation  是否在方法执行前清空缓存，默认 为false
     * @param bookId
     * @return
     */
    @CacheEvict(value = "books", condition = "true", allEntries = true)
    int deleteByPrimaryKey(Integer bookId);

    @CachePut(value = "books", condition = "true")
    int insert(Books record);

    @CachePut(value = "books", condition = "true")
    int insertSelective(Books record);

    @Cacheable(value = "books", condition = "true")
    Books selectByPrimaryKey(Integer bookId);

    /**
     * 说明：  @CachePut  常用于 新增、修改方法前
     * @param record
     * @return
     */
    @CachePut(value = "books", condition = "true")
    int updateByPrimaryKeySelective(Books record);

    @CachePut(value = "books", condition = "true")
    int updateByPrimaryKey(Books record);

    /**
     * 查询一个集合的商品信息
     * @param pageBean
     * @return
     */
    @Cacheable(value = "books", condition = "true")
    public List<Books> showBooks(PageBean pageBean);

}