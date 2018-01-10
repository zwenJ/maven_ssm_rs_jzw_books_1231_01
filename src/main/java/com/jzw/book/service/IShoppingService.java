package com.jzw.book.service;

import com.jzw.book.model.OrderDetails;
import com.jzw.book.model.Shoppings;

import java.util.List;
import java.util.Map;

/**
 * 说明：Shopping
 *
 * @author Jzw
 * @date 2018/1/5 13:06
 */
public interface IShoppingService {


    /**
     * 新增购物车的商品
     * @param shoppings
     * @return
     */
    public boolean saveShopping(Shoppings shoppings);


    /**
     * 获取一个用户的购物车
     * @param shoppings
     * @return
     */
    public List<Shoppings> showAll(Shoppings shoppings);


    /**
     * 修改购物车的信息
     * @param shoppings
     * @return
     */
    public boolean updateShopping(Shoppings shoppings);


    /**
     * 删除购物车
     * @param map
     * @return
     */
    public boolean deleteShoppping(Map<String, Object> map);


}
