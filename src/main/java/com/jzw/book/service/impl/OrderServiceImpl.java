package com.jzw.book.service.impl;

import com.jzw.book.mapper.*;
import com.jzw.book.model.Books;
import com.jzw.book.model.OrderDetails;
import com.jzw.book.model.Orders;
import com.jzw.book.service.IBaseService;
import com.jzw.book.util.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/5 21:10
 */
@Service("OrderServiceImpl")
public class OrderServiceImpl implements IBaseService<Orders> {

    private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private ShoppingsMapper shoppingsMapper;

    @Autowired
    private BooksMapper booksMapper;

    /**
     * 查询的方法
     *
     * @param orders
     * @return
     */
    @Override
    public List<Orders> showAll(Orders orders) {
        return null;
    }


    /**
     * 查询的方法
     *
     * @param pageBean
     * @return
     */
    public List<Orders> showAll(PageBean pageBean) {
        return  ordersMapper.selectByPrimaryKey(pageBean);
    }


    /**
     * 查询单个
     *
     * @param integer
     * @return
     */
    @Override
    public Orders showSole(Integer integer) {
        return null;
    }

    /**
     * 添加保存的方法
     *
     * @param orders
     * @return
     */
    @Override
    public boolean saveObj(Orders orders) {
        //1 保存地址信息
        int insertAddress = addressMapper.insert(orders.getAddress());
        if (insertAddress > 0) {
            //2 保存订单信息
            int insert = ordersMapper.insert(orders);
            if (insert > 0) {
                //3 保存订单项信息
                for (OrderDetails orderDetails : orders.getOrderDetailsList()) {
                    orderDetails.setOrderId(orders.getOrderId());  //设置订单编号
                    int saveObjOrderDeat = orderDetailsMapper.insert(orderDetails);
                    if (saveObjOrderDeat < 0) {
                        logger.error("执行保存订单项信息出现错误，事务回滚！");
                        return false;
                    }
                    else {
                        //4 修改商品的库存
                        Books selectByPrimaryKey = booksMapper.selectByPrimaryKey(orderDetails.getBookId());
                        selectByPrimaryKey.setBookStock(selectByPrimaryKey.getBookStock() - orderDetails.getOdSum());
                        if (selectByPrimaryKey.getBookStock() < 0) {
                            logger.error("执行修改商品库存的时候出现错误! 商品库存："+selectByPrimaryKey.getBookStock() );
                            return false;
                        }
                        booksMapper.updateByPrimaryKey(selectByPrimaryKey);
                    }
                }
                //5 删除用户购物车信息
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("userId", orders.getUserId());
                map.put("allDel",false);  //删除该用户全部的购物车
                int deleteShopping = shoppingsMapper.deleteByPrimaryKey(map);
                if (deleteShopping >0) {
                    return true;
                }
            }
            logger.error("保存订单出现错误！");
        }
        logger.error("保存地址信息出现错误");
        return false;
    }

    /**
     * 修改的方法
     *
     * @param orders
     * @return
     */
    @Override
    public boolean updateObj(Orders orders) {

        //用户撤销订单，回滚商品库存
        if (7 == orders.getOrderStatus()) {
            //根据订单编号，查询出订单项集合
            orders.setOrderDetailsList(orderDetailsMapper.selectOrderId(orders.getOrderId()));
            //
            for (OrderDetails orderDetails : orders.getOrderDetailsList()) {
                //遍历查询订单项中的商品，根据编号查询到商品
                Books books = booksMapper.selectByPrimaryKey(orderDetails.getBookId());
                //商品的库存为原基础上加上订单项的商品数量
                books.setBookStock(books.getBookStock()+orderDetails.getOdSum());
                //修改商品的库存
                int updateByPrimaryKey = booksMapper.updateByPrimaryKey(books);
                if (updateByPrimaryKey == 0) {
                    logger.error("用户撤单，回滚商品库存失败！");
                    return false;
                }
            }
        }

        int updateByPrimaryKeySelective = ordersMapper.updateByPrimaryKeySelective(orders);
        if (updateByPrimaryKeySelective > 0) {
            return true;
        }

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
