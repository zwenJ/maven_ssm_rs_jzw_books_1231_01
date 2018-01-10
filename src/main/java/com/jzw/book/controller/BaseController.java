package com.jzw.book.controller;

import com.jzw.book.model.Books;
import com.jzw.book.model.Types;
import com.jzw.book.model.Users;
import com.jzw.book.service.IBookService;
import com.jzw.book.service.ITypesService;
import com.jzw.book.util.PageBean;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2017/12/31 9:29
 */
@RequestMapping(value = "/base", method = RequestMethod.GET)
public class BaseController extends ParentController{

    private Logger logger = LoggerFactory.getLogger(BaseController.class);
    private final String prefixStr = "=====》》》》  ";
    private final String suffixStr = "  《《《《 =====";


    @Autowired
    private IBookService iBookService;


    /**
     * 进入到首页的跳转方式
     * @return
     */
    @RequestMapping("/home.controller")
    public String baseHome(HttpServletRequest request){

        logger.debug(prefixStr+"进入了 /base/home.controller 并且又转发到 home/index 了"+suffixStr);

        //初始化商品类型
        this.initTypesList(request);
        //热门，新增图书
        initBookList(request);

        return "home/index";
    }


    /**
     * 二级跳转
     * @param dir
     * @param res
     * @param model
     * @return
     */
    @RequestMapping("/{dir}/{res}.controller")
    public String baseHome(@PathVariable("dir") String dir,
                           @PathVariable("res") String res,
                           Model model,
                           HttpServletRequest request){
        logger.debug(prefixStr+"二级跳转  请求转发到指定的页面：/WEB-INF/"+dir+"/"+res+".jsp"+suffixStr);

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

        /**
         * 跳转到注册页面，初始化一个用户对象，保证form表单对象的初始参数域不为null
         */
        if ("register".equalsIgnoreCase(res)) {
            initRegister(model,"RegisterCommand");
        }
        /**
         * 跳转到用户登录页面，防止值的重复出现
         */
        if ("login".equalsIgnoreCase(res)) {
            initRegister(model,"LoginUser");
        }
        /**
         * 新增图书，初始化图书类型
         */
        if ("add_book".equalsIgnoreCase(res)) {
            model.addAttribute("AddBook", new Books());
            initTypesList(request);
        }

        return dir+"/"+res;
    }


    /**
     * 三级跳转
     * @param dir
     * @param res
     * @param cli
     * @param model
     * @return
     */
    @RequestMapping("/{dir}/{res}/{cli}.controller")
    public String baseHome(@PathVariable("dir") String dir,
                           @PathVariable("res") String res,
                           @PathVariable("cli") String cli,
                           Model model){
        logger.debug(prefixStr+"三级跳转 ===== 请求转发到指定的页面：/WEB-INF/"+dir+"/"+res+"/"+cli+".jsp"+suffixStr);

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


        return dir+"/"+res+"/"+cli;
    }



    /**
     * 初始化
     * @param model
     */
    private void initRegister(Model model, String keyName){
        model.addAttribute(keyName,new Users());
    }



    /**
     * 首页显示的商品信息
     * @param request
     */
    private void initBookList(HttpServletRequest request) {


        //热销
        PageBean pageBean = new PageBean();
        pageBean.setStatus(2);

        pageBean.setMtod(true);
        List<Books> bookMtodList = iBookService.showBooks(pageBean);
        request.getSession().setAttribute("BookMtodList", bookMtodList);

        //新书上架
        pageBean.setMtod(false);
        pageBean.setRecently(true);
        List<Books> bookRecentlyList = iBookService.showBooks(pageBean);
        request.getSession().setAttribute("BookRecentlyList", bookRecentlyList);

    }


    /**
     * 将结果转换为JSON返回
     * @return
     */
    @RequestMapping(value = "/toJs.controller", method = RequestMethod.GET)
    @ResponseBody
    public String updateBook(@ModelAttribute("result") String result){
        return result;
    }



}
