package com.jzw.book.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jzw.book.model.OrderDetails;
import com.jzw.book.model.Orders;
import com.jzw.book.model.Shoppings;
import com.jzw.book.model.Users;
import com.jzw.book.service.IBaseService;
import com.jzw.book.service.IShoppingService;
import com.jzw.book.util.PageBean;
import org.apache.ibatis.annotations.Results;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/5 12:27
 */
@RequestMapping(value = "/order", method = RequestMethod.POST)
public class OrderController  extends ParentController{

    @Resource(name = "OrderServiceImpl")
    private IBaseService orderService;


    @Autowired
    private IShoppingService iShoppingService;

    /**
     * 新增订单
     * @param orders
     * @return
     */
    @RequestMapping("/addorder.controller")
    public String addorder(@Validated @ModelAttribute("form") Orders orders,
                           HttpServletRequest request) {

        //获取用户信息 和 用户购物车信息，设置到订单项和订单中
        //获取用户信息
        Integer usersId = (Integer) request.getSession().getAttribute("BooksZxPtUser");
        orders.setUserId(usersId);  //设置用户编号

        //获取用户购物车信息(库存充足的商品)
        List<Shoppings> shoppingsList = iShoppingService.showAll(new Shoppings(usersId,1));

        //订单项详情
        List<OrderDetails> orderDetailsList = new ArrayList<OrderDetails>(shoppingsList.size());
        for (Shoppings shoppings : shoppingsList) {
            //实列化一个订单项
            OrderDetails orderDetails = new OrderDetails();
            //设置商品编号
            orderDetails.setBookId(shoppings.getBooks().getBookId());
            //设置商品数量
            orderDetails.setOdSum(shoppings.getBookSum());
            //设置商品总价格
            orderDetails.setOdPrice(shoppings.getBooks().getBookPrice().multiply(new BigDecimal(shoppings.getBookSum())));
            //加入集合
            orderDetailsList.add(orderDetails);
        }

        orders.setOrderDetailsList(orderDetailsList);   //设置订单项
        orders.setOrderDate(new Date());   //下单时间


        //持久层保存地址、订单、订单项、删除用户购物车
        boolean saveObjOrder = orderService.saveObj(orders);
        if (saveObjOrder) {
            //成功跳转到个人订单页面
            return "redirect:/order/showorder/user/orders/order.controller?status=1";
        }

        //失败，跳转购物车
        return "redirect:/shopping/toshopping.controller";
    }


    /**
     * 显示我的订单
     * @param pageBean
     * @param request
     * @return
     */
    @RequestMapping(value = "/showorder/{dir}/{cli}/{page}.controller", method = RequestMethod.GET)
    public String showOrder(@ModelAttribute("pageBean") PageBean pageBean,
                            @PathVariable("dir") String dir,
                            @PathVariable("cli") String cli,
                            @PathVariable("page") String page,
                            HttpServletRequest request){
        /**
         * 权限认证
         */
        if ("manager".equalsIgnoreCase(dir)) {
            if (!SecurityUtils.getSubject().hasRole("RootUser")) {
                return "redirect:/html/unauthorized.html";
            }
        }
        if ("user".equalsIgnoreCase(dir)) {
            if (!SecurityUtils.getSubject().hasRole("PtUser")) {
                return "redirect:/html/unauthorized.html";
            }
        }

        if (null != pageBean) {
            //开始分页
            PageHelper.startPage(pageBean);
            //业务查询
            List showAllOrder = orderService.showAll(pageBean);
            //分页数据处理
            PageInfo pageInfo = new PageInfo(showAllOrder);
            pageBean.setPages(pageInfo.getPages());
            pageBean.setTotal(pageInfo.getTotal());

            request.getSession().setAttribute("PageBean", pageBean);
            request.setAttribute("MyOrderList", showAllOrder);
        }

        //返回到相关页面
        return dir+"/"+cli+"/"+page;
    }


    /**
     * 修改订单状态
     * @param orders
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateorder.controller", method = RequestMethod.GET)
    public String updateOrder(@ModelAttribute("orders") Orders orders,
                              HttpServletRequest request){

        boolean updateOrder = orderService.updateObj(orders);
        if (updateOrder) {
            return "redirect:/base/toJs.controller?result=success";
        }

        return "redirect:/base/toJs.controller?result=error";
    }







}
