package com.jzw.book.service.impl;

import com.jzw.book.mapper.UsersMapper;
import com.jzw.book.model.Users;
import com.jzw.book.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2017/12/31 18:00
 */
@Service("UserServiceImpl")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UsersMapper usersMapper;

    /**
     * 用户注册
     *
     * @param users
     * @return
     */
    @Override
    public boolean doRegister(Users users) {

        //执行插入用户的语句
        int i = usersMapper.insert(users);

        if (i > 0) return true;

        return false;
    }

    /**
     * 用户登陆
     *
     * @param users
     * @return
     */
    @Override
    public Users doLogin(Users users) {
        return usersMapper.logins(users);
    }

    /**
     * 判断用户名称是否存在
     * 存在 返回 true
     * 不存在 返回 false
     * @param name
     * @return
     */
    @Override
    public boolean doCheckName(String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("strCol","user_name");
        map.put("strVal", name);
        int i = usersMapper.checkExist(map);
        if (i > 0) return true;
        return false;
    }

    /**
     * 判断手机号是否存在
     *
     * @param phone
     * @return
     */
    @Override
    public boolean doCheckPhone(String phone) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("strCol","user_phone");
        map.put("strVal", phone);
        int i = usersMapper.checkExist(map);
        if (i > 0) return true;
        return false;
    }



}
