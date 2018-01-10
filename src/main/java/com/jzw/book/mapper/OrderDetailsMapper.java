package com.jzw.book.mapper;

import com.jzw.book.model.OrderDetails;

import java.util.List;

public interface OrderDetailsMapper {

    int deleteByPrimaryKey(Integer odId);

    int insert(OrderDetails record);

    int insertSelective(OrderDetails record);

    OrderDetails selectByPrimaryKey(Integer odId);

    int updateByPrimaryKeySelective(OrderDetails record);

    int updateByPrimaryKey(OrderDetails record);

    /**
     * 根据订单编号，查询订单项
     * @param orderId
     * @return
     */
    List<OrderDetails> selectOrderId(Integer orderId);

}