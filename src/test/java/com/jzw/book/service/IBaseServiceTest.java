package com.jzw.book.service;

import com.jzw.book.BaseTest;
import com.jzw.book.model.Orders;
import com.jzw.book.util.PageBean;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/6 10:36
 */
public class IBaseServiceTest extends BaseTest {


    @Resource(name = "OrderServiceImpl")
    private IBaseService<Orders> ordersIBaseService;

    @Test
    public void showAll() throws Exception {

        PageBean pageBean = new PageBean();
        pageBean.setStatus(1);
        pageBean.setBookType(2);

        System.out.println(ordersIBaseService.showAll(pageBean));
    }

}