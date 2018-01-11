package com.jzw.book.service;

import com.jzw.book.BaseTest;
import com.jzw.book.model.Users;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2017/12/31 18:20
 */
public class UserServiceTest extends BaseTest {


    @Autowired
    private IUserService iUserService;

    @Test
    public void doRegister() throws Exception {

        Users users = new Users();
        users.setUserName("tk");
        users.setUserNumber("13838381438");
        users.setUserPhone(users.getUserNumber());
        users.setUserPwd("666666");

        iUserService.doRegister(users);

        System.out.println("成功添加的用户编号为："+users.getUserId());

    }

    @Test
    public void doLogin() throws Exception {

        Users users = new Users();
        users.setUserNumber("17769310562");
        users.setUserPwd("123456");
        System.out.println(iUserService.doLogin(users));

    }

    @Test
    public void doCheckName() throws Exception {

        System.out.println(iUserService.doCheckName("admin"));
    }

    @Test
    public void doCheckPhone() throws Exception {
        System.out.println(iUserService.doCheckPhone("177693107562"));
    }

}