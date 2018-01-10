package com.jzw.book.controller;

import com.jzw.book.model.Users;
import com.jzw.book.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SubjectFactory;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * 说明： 用户 Controller
 *
 * @author Jzw
 * @date 2017/12/31 17:19
 */
@RequestMapping(value = "/user", method = RequestMethod.POST)
public class UserController extends ParentController{

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 注入用户Service层对象
     */
    @Autowired
    private IUserService iUserService;

    /**
     * 用户注册
     * @param users
     * @return
     */
    @RequestMapping(value = "/register.controller")
    public String register(@ModelAttribute("form") Users users, HttpServletRequest request) {

        logger.debug("本次注册的用户为：========================================================");
        logger.debug(users.toString());
        logger.debug("========================================================================");

        //将手机号添加为用户的账号
        users.setUserNumber(users.getUserPhone());
        //通知Service
        boolean doRegister = iUserService.doRegister(users);

        if (!doRegister){
            request.setAttribute("RegisterCommand",users);
            logger.debug("注册失败！，转发到原页面!  home/register");
            return "redirect:/base/home/register.controller";
        }

        //注册成功重定向到用户登录的页面
        return "redirect:/base/home/login.controller";
    }


    /**
     * 用户登陆
     * @param users
     * @return
     */
    @RequestMapping(value = "/login.controller")
    public String login(@Validated(value = {Users.Login.class}) @ModelAttribute("form") Users users,
                        BindingResult bindingResult,
                        Model model,
                        HttpServletRequest request) {

        logger.debug("用户登陆请求，\n"+users);

        if (bindingResult.hasErrors()) {
            logger.debug("验证出现错误");
            //验证失败！
            model.addAttribute("LoginUser",users);
            return "home/login";
        }

        //获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        //获取认证令牌对象
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(users.getUserName(), users.getUserPwd());
        try{
            logger.debug("开始认证");
            subject.login(usernamePasswordToken);
            logger.debug("认证通过");

            //查询到用户的编号
            Users users1 = iUserService.doLogin(users);
            request.getSession().setAttribute("BooksZxPtUser", users1.getUserId());

        } catch (Exception e){
            logger.error("用户认证错误：",e);
            //登录失败，或者是密码错误!
            logger.debug("用户"+users.getUserName()+"登录失败,");
            model.addAttribute("LoginUser",users);
            model.addAttribute("loginUserErrorMessage","用户名或者密码错误！");
            return "home/login";
        }

        //重定向到首页
        return "redirect:/base/home/index.controller";
    }



    /**
     * 用户登出方法
     * @param request
     * @return
     */
    @RequestMapping(value = "/exitlogin.controller", method = RequestMethod.GET)
    public String exitLogin(HttpServletRequest request) {

        try{

            //用户登出
            Subject subject = SecurityUtils.getSubject();
            subject.logout();

            //将当前登陆的用户设置为NULL
            request.getSession().setAttribute("BooksZxPtUser",null);


        } catch (Exception e){
          e.printStackTrace();
          logger.error("用户登出错误，",e);
        }

        return "redirect:/base/home.controller";
    }


    /**
     * 检查用户名是否存在
     * @param name
     * @return
     */
    @RequestMapping(value = "/checkname.controller")
    @ResponseBody
    public String checkName(@ModelAttribute("name") String name) {
        boolean b = iUserService.doCheckName(name);
        return b+"";
    }



    /**
     * 判断手机号是否存在
     * @param name
     * @return
     */
    @RequestMapping(value = "/checkphone.controller")
    @ResponseBody
    public String checkPhone(@ModelAttribute("name") String name) {
        boolean b = iUserService.doCheckPhone(name);
        return ""+b;
    }







}
