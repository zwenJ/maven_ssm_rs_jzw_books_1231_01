package com.jzw.book.service.impl;

import com.jzw.book.mapper.OrderDetailsMapper;
import com.jzw.book.model.OrderDetails;
import com.jzw.book.service.IBaseService;
import com.jzw.book.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/5 21:24
 */
@Service("OrderDetailsServiceImpl")
public class OrderDetailsServiceImpl implements IBaseService<OrderDetails> {


    @Autowired
    private OrderDetailsMapper orderDetailsMapper;


    /**
     * 查询的方法
     *
     * @param orderDetails
     * @return
     */
    @Override
    public List<OrderDetails> showAll(OrderDetails orderDetails) {
        return null;
    }

    /**
     * 查询的方法
     *
     * @param pageBean
     * @return
     */
    @Override
    public List<OrderDetails> showAll(PageBean pageBean) {
        return null;
    }

    /**
     * 查询单个
     *
     * @param integer
     * @return
     */
    @Override
    public OrderDetails showSole(Integer integer) {
        return null;
    }

    /**
     * 添加保存的方法
     *
     * @param orderDetails
     * @return
     */
    @Override
    public boolean saveObj(OrderDetails orderDetails) {

        int insert = orderDetailsMapper.insert(orderDetails);
        if (insert > 0) return true;

        return false;
    }

    /**
     * 修改的方法
     *
     * @param orderDetails
     * @return
     */
    @Override
    public boolean updateObj(OrderDetails orderDetails) {
        return false;
    }

    /**
     * 删除的方法
     *
     * @param integer
     * @return
     */
    @Override
    public boolean deleteObj(Integer integer) {
        return false;
    }
}
