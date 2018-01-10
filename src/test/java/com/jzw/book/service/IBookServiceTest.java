package com.jzw.book.service;

import com.jzw.book.model.Books;
import com.jzw.book.util.PageBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/2 17:03
 */
public class IBookServiceTest extends BaseTest {


    @Autowired
    private IBookService iBookService;

    @Test
    public void showBooks() throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mtod",true);

        System.out.println(iBookService.showBooks(null));

    }

    @Test
    public void showBook() throws Exception {

        //热销
        PageBean pageBean = new PageBean();
        pageBean.setStatus(2);

        pageBean.setMtod(true);
        List<Books> bookMtodList = iBookService.showBooks(pageBean);

        System.out.println("热销图书================================");
        for (Books books : bookMtodList) {
            System.out.println(books);
        }

        System.out.println("=======================================================");

        //新书上架
        pageBean.setRecently(true);
        pageBean.setMtod(false);
        List<Books> bookRecentlyList = iBookService.showBooks(pageBean);
        System.out.println("新书上架====================================");
        for (Books books : bookRecentlyList) {
            System.out.println(books);
        }

        System.out.println("=======================================================");

        pageBean.setRecently(false);
        pageBean.setLikeText("一");
        List<Books> bookLikeList = iBookService.showBooks(pageBean);
        System.out.println("模糊查询====================================");
        for (Books books : bookLikeList) {
            System.out.println(books);
        }

    }

    @Test
    public void saveBook() throws Exception {
    }

    @Test
    public void updateBook() throws Exception {
    }

}