package com.jzw.book.controller;

import com.jzw.book.model.Books;
import com.jzw.book.model.Shoppings;
import com.jzw.book.model.Users;
import com.jzw.book.service.IShoppingService;
import com.jzw.book.util.IntegerUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：购物车的业务
 *
 * @author Jzw
 * @date 2018/1/5 13:03
 */
@RequestMapping(value = "/shopping", method = RequestMethod.POST)
public class ShoppingController  extends ParentController{

    @Autowired
    private IShoppingService iShoppingService;


    /**
     * 进入购物车页面
     * @param request
     * @return
     */
    @RequestMapping(value = "/toshopping.controller", method = RequestMethod.GET)
    public String showShopping(HttpServletRequest request){

        if (!SecurityUtils.getSubject().hasRole("PtUser")) {
            return "redirect:/html/unauthorized.html";
        }

        Integer userId = (Integer) request.getSession().getAttribute("BooksZxPtUser");

        //用户值为NULL，跳转登陆
        if (null == userId || 0 == userId) {
            return "home/login";
        }

        //通知业务逻辑层查询
        List<Shoppings> shoppingsList = iShoppingService.showAll(new Shoppings(userId));

        //保存到request作用域中
        request.setAttribute("ShoppingCatRequest", shoppingsList);

        return "user/shopping_car";
    }


    /**
     * 将商品加入购物车
     * @param shoppings
     * @param request
     * @return
     */
    @RequestMapping(value = "/addshopping.controller", method = RequestMethod.GET)
    public String addShopping(Shoppings shoppings,
                              HttpServletRequest request){

        //获取用户信息
        Integer userId = (Integer) request.getSession().getAttribute("BooksZxPtUser");

        //用户未登陆
        if (null == userId || 0 == userId) {
            return "redirect:/base/home/login.controller";
        }

        //如果上传的商品编号为NULL说明有问题，待处理
        if (null == shoppings.getBookId()) {
            //暂定跳转首页
            return "redirect:/base/home.controller";
        }

        //配置相关参数
        shoppings.setUserId(userId);   //用户编号
        shoppings.setShoppingDate(new Date());    //加入购物车时间
        shoppings.setBookSum(1);                  //初始数量
        shoppings.setShopId(1);                   //店铺

        //查询判断用户是否已经有了该商品
        List<Shoppings> showShopping = iShoppingService.showAll(shoppings);
        if (null != showShopping && showShopping.size() > 0) {
            /**
             * 该用户已将此商品加入购物车，则再其基础的数量上加 1 即可
             */
            Shoppings shoppings1 = showShopping.get(0);
            //商品数量加 1
            shoppings1.setBookSum(shoppings1.getBookSum()+1);
            //修改购物车商品的数量
            iShoppingService.updateShopping(shoppings1);
        }

        /**
         * 该用户还未添加该商品到购物车中 则进行数据库保存
         */
        iShoppingService.saveShopping(shoppings);

        //跳转到购物车页面
        return "redirect:/shopping/toshopping.controller";
    }


    /**
     * 移除购物车中的数据
     * @param shoppingId
     * @param pages        用于标记是否移除全部 1 移除全部  2移除部分
     * @param request
     * @return
     */
    @RequestMapping(value = "/remove.controller", method = RequestMethod.GET)
    public String removeShopping(@ModelAttribute("shoppingId") Integer shoppingId,
                                 @ModelAttribute("pages") Integer pages,
                                 HttpServletRequest request) {

        if (shoppingId != null && shoppingId != 0 && pages != null) {

            Integer usersId = (Integer) request.getSession().getAttribute("BooksZxPtUser");
            if (null == usersId || 0 == usersId) {
                return "redirect:/base/home/login.controller";
            }

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userId", usersId);
            map.put("shoppingId", shoppingId);
            map.put("allDel",true);

            //删除全部
            if (32 == pages) {
                map.put("allDel",false);
            }

            boolean deleteShoppping = iShoppingService.deleteShoppping(map);
            // TODO 移除购物车中的商品尚未进行提示
        }

        //重定向回购物车
        return "redirect:/shopping/toshopping.controller";
    }



    // TODO 修改购物车中的商品数量
    @RequestMapping("/updatesize.controller")
    @ResponseBody
    public String updateShoppingNumber(@ModelAttribute("shoppings") Shoppings shoppings,
                                       HttpServletRequest request){

        //进行修改
        if (IntegerUtil.isNotNull(shoppings.getShoppingId())) {
            if (IntegerUtil.isNotNull(shoppings.getBookSum())) {

                //修改购物车商品的数量
                boolean updateShopping = iShoppingService.updateShopping(shoppings);
                //修改成功
                if (updateShopping) {return "success";}

            }
        }

        //修改失败
        return "error";
    }




}
