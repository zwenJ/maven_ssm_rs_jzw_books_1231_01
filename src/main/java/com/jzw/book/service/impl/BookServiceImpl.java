package com.jzw.book.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jzw.book.mapper.BooksMapper;
import com.jzw.book.mapper.ImagesMapper;
import com.jzw.book.model.Books;
import com.jzw.book.service.IBookService;
import com.jzw.book.service.ImagesService;
import com.jzw.book.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/2 16:51
 */
@Service
public class BookServiceImpl implements IBookService {


    @Autowired
    private BooksMapper booksMapper;

    @Autowired
    private ImagesMapper imagesMapper;

    /**
     * 查询一个集合的商品信息
     *
     * @param pageBean
     * @return
     */
    @Override
    public List<Books> showBooks(PageBean pageBean) {
        return booksMapper.showBooks(pageBean);
    }

    /**
     * 根据编号查询单个商品信息
     *
     * @param bookId
     * @return
     */
    @Override
    public Books showBook(Integer bookId) {
        return booksMapper.selectByPrimaryKey(bookId);
    }

    /**
     * 添加一个新的商品
     *
     * @param books
     * @return
     */
    @Override
    public boolean saveBook(Books books) {
        int insertSelective = booksMapper.insertSelective(books);
        if ( insertSelective > 0 ) return true;
        return false;
    }

    /**
     * 根据编号修改商品的相关属性
     *
     * @param books
     * @return
     */
    @Override
    public boolean updateBook(Books books) {
        int updateByPrimaryKeySelective = booksMapper.updateByPrimaryKeySelective(books);
        if (updateByPrimaryKeySelective > 0) return true;
        return false;
    }


    /**
     * 删除商品
     *
     * @param bookId
     * @return
     */
    @Override
    public boolean deleteBook(Integer bookId) {
        int deleteImages = imagesMapper.deleteByPrimaryKey(bookId);
        if (deleteImages > 0) {
            int deleteBook = booksMapper.deleteByPrimaryKey(bookId);
            if ( deleteBook > 0 ) return true;
        }
        return false;
    }

}
