package com.jzw.book.shiro;

import com.jzw.book.model.Users;
import com.jzw.book.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * 说明：用户认证 和 授权
 *
 * @author Jzw
 * @date 2018/1/7 9:09
 */
@Component
public class UserRealm extends AuthorizingRealm {


    @Autowired
    private IUserService iUserService;

    private Logger logger = LoggerFactory.getLogger(UserRealm.class);


    /**
     * 用户 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取传入的用户名
        String primaryPrincipalUserName = (String) principalCollection.getPrimaryPrincipal();
        System.out.println("授权方法：\n"+primaryPrincipalUserName);

        //根据用户名查询出该用户在数据库中的权限、角色
        Users users = iUserService.doLogin(new Users(primaryPrincipalUserName));
        Integer roleId = users.getRoleId();
        //存放角色
        ArrayList<String> roleUser = new ArrayList<String>();
        //存放权限
        ArrayList<String> authUser = new ArrayList<String>();

        //设置普通用户的角色
        roleUser.add("PtUser");
        //店主的角色
        if (2 == roleId) {
            roleUser.add("ShopUser");
        }
        //管理员的角色
        else if (3 == roleId) {
            roleUser.add("RootUser");
        }

        //这边使用Shiro进行权限认证，授权，让其访问相关页面
        //授权
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(roleUser);
        authorizationInfo.addStringPermissions(authUser);

        return authorizationInfo;
    }


    /**
     * 用户 权限认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //获取用户令牌
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        logger.debug("获取认证的用户名："+token.getUsername());

        //认证
        SimpleAuthenticationInfo authenticationInfo = null;

        try{
            String userName = token.getUsername();
            String userPwd = String.valueOf(token.getPassword());

            //通知数据库查询
            Users doLogin = iUserService.doLogin(new Users(userName, userPwd));
            authenticationInfo = new SimpleAuthenticationInfo(doLogin.getUserName(),
                                                            doLogin.getUserPwd(),
                                                            this.getName());
        } catch (Exception e){
            e.printStackTrace();
          logger.error("权限认证",e);
        }

        return authenticationInfo;
    }


}
