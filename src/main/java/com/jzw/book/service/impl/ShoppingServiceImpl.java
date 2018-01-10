package com.jzw.book.service.impl;

import com.jzw.book.mapper.ShoppingsMapper;
import com.jzw.book.model.Shoppings;
import com.jzw.book.service.IShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/5 13:37
 */
@Service
public class ShoppingServiceImpl implements IShoppingService {


    @Autowired
    private ShoppingsMapper shoppingsMapper;


    /**
     * 新增购物车的商品
     *
     * @param shoppings
     * @return
     */
    @Override
    public boolean saveShopping(Shoppings shoppings) {
        int insertShopping = shoppingsMapper.insert(shoppings);
        if (insertShopping > 0) return true;
        return false;
    }

    /**
     * 获取一个用户的购物车
     *
     * @param shoppings
     * @return
     */
    @Override
    public List<Shoppings> showAll(Shoppings shoppings) {
        return shoppingsMapper.selectByPrimaryKey(shoppings);
    }


    /**
     * 修改购物车的信息
     *
     * @param shoppings
     * @return
     */
    @Override
    public boolean updateShopping(Shoppings shoppings) {
        int updateByPrimaryKey = shoppingsMapper.updateByPrimaryKey(shoppings);
        if (updateByPrimaryKey > 0) return true;
        return false;
    }

    /**
     * 删除购物车
     *
     * @param map
     * @return
     */
    @Override
    public boolean deleteShoppping(Map<String, Object> map) {
        int deleteByPrimaryKey = shoppingsMapper.deleteByPrimaryKey(map);
        if (deleteByPrimaryKey > 0) return true;
        return false;
    }


}
