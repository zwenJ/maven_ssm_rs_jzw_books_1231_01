package com.jzw.book.service;

import com.jzw.book.model.Books;
import com.jzw.book.model.Shoppings;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/5 13:44
 */
public class IShoppingServiceTest extends BaseTest {

    @Autowired
    private IShoppingService iShoppingService;


    @Test
    public void saveShopping() throws Exception {

        Shoppings shoppings = new Shoppings();

        shoppings.setShopId(1);

        Books books = new Books();
        books.setBookId(2);
        shoppings.setBooks(books);

        shoppings.setBookSum(2);
        shoppings.setUserId(2);
        shoppings.setShoppingDate(new Date());


        System.out.println("添加结果：\n"+iShoppingService.saveShopping(shoppings));

    }

    @Test
    public void showAll() throws Exception {



    }

    @Test
    public void updateShopping() throws Exception {
    }

    @Test
    public void deleteShoppping() throws Exception {
    }

}