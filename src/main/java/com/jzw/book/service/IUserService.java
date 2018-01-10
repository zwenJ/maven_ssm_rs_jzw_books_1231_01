package com.jzw.book.service;

import com.jzw.book.model.Users;

/**
 * 说明：用户 Service Interface
 *
 * @author Jzw
 * @date 2017/12/31 17:53
 */
public interface IUserService {


    /**
     * 用户注册
     * @param users
     * @return
     */
    public boolean doRegister(Users users);


    /**
     * 用户登陆
     * @param users
     * @return
     */
    public Users doLogin(Users users);


    /**
     * 判断用户名称是否存在
     * @param name
     * @return
     */
    public boolean doCheckName(String name);


    /**
     * 判断手机号是否存在
     * @param phone
     * @return
     */
    public boolean doCheckPhone(String phone);



}
