package com.jzw.book.model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户表
 * @author Jzw
 */
@Component
public class Users implements Serializable {


    public interface Login{}

    public interface Register{}

    private Integer userId;

    private String userNumber;

    @NotBlank(message = "密码不能为空！", groups = {Login.class,Register.class})
    private String userPwd;

    @NotBlank(message = "用户名不能为空！", groups = {Login.class,Register.class})
    private String userName;

    @NotBlank(message = "手机号不能为空！", groups = {Register.class})
    private String userPhone;

    private Integer roleId;


    public Users() {
    }

    public Users(@NotBlank(message = "用户名不能为空！", groups = {Login.class, Register.class}) String userName) {
        this.userName = userName;
    }

    public Users( @NotBlank(message = "用户名不能为空！", groups = {Login.class, Register.class}) String userName, @NotBlank(message = "密码不能为空！", groups = {Login.class, Register.class}) String userPwd) {
        this.userPwd = userPwd;
        this.userName = userName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber == null ? null : userNumber.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userNumber='" + userNumber + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", roleId=" + roleId +
                '}';
    }


}