<%--
  Created by IntelliJ IDEA.
  User: Jzw
  Date: 2017/12/31
  Time: 14:57
  用户注册的页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>飞凡网上书店 - 用户注册</title>
    <base href="<%@include file="../../common/base.jsp"%>">
    <link href="images/favicon.ico" rel="icon" type="image/x-icon" />
    <link href="images/favicon.ico" rel="shortcut icon" type="image/x-icon" />
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">

    <!-- JQuery集合 -->
    <script type="text/javascript" src="/books/mylib/js/jquery/jquery-3.2.1.js"></script>

</head>

<body>
    <!--top-->
        <jsp:include page="../common/head.jsp"/>
    <!--end top-->

    <script>

         var name_validata_A = false;
         var phone_validata_B = false;

        /**
         * 用户名验证
         */
        function fun_name_validata() {
            var names = $("#regis_name").val();
            if (null != names && "" != names){
                $.post("user/checkname.controller",{
                    name:names
                },function (_result) {
                    if ("true" == _result.trim()) {
                        $("#div_name_validate").html("<span style='color: red;'>用户名已经存在！</span>");
                        name_validata_A = false;
                    }
                    else
                    {
                        $("#div_name_validate").html("<span style='color: green;'>用户名可用！</span>");
                        name_validata_A = true;
                    }
                });
            }
            $("#div_name_validate").html("<span style='color: red;'>用户名不能为空！</span>");
            name_validata_A = false;
        }

        /**
         * 验证手机号
         */
        function fun_phone_validata() {
            var phones = $("#regis_phone").val();
            if (null != phones && "" != phones) {
                $.post("user/checkphone.controller",{
                    name:phones
                },function (_result) {
                    if ("true" == _result.trim()){
                        $("#div_phone_validata").html("<span style='color: red;'>手机号已经存在！</span>");
                        phone_validata_B = false;
                    }
                    else
                    {
                        $("#div_phone_validata").html("<span style='color: green;'>手机号可用！</span>");
                        phone_validata_B = true;
                    }
                });
            }
            $("#div_phone_validata").html("<span style='color: red;'>手机号不能为空！</span>");
            phone_validata_B = false;
        }


        /**
         * 验证密码
         */
        function fun_pwd_validata(){
            var userpwd = $("#pwd").val();
            if (null != userpwd && "" != userpwd) {
                $("#div_pwd_validata").html("<span style='color: green;'>密码可用！</span>");
                return true;
            }

            $("#div_pwd_validata").html("<span style='color: red;'>密码不能为空！</span>");
            return false;
        }

        /**
         * 验证两次密码是否一致
         */
        function fun_pwds_validata(){
            var userpwd = $("#pwds").val();
            if (null != userpwd && "" !=userpwd) {
                if (userpwd == $("#pwd").val()){
                    $("#div_pwds_validata").html("<span style='color: green;'>正常！</span>");
                    return true;
                }
                else {
                    $("#div_pwds_validata").html("<span style='color: red;'>两次密码不一致！</span>");
                    return false;
                }
            }
            $("#div_pwds_validata").html("<span style='color: red;'>请确认密码！</span>");
            return false;
        }


        //表单验证
        function fun_form_validate(){
            if (name_validata_A) {
                if (fun_pwd_validata()) {
                    if (fun_pwds_validata()) {
                        if (phone_validata_B) {
                            return true;
                        }
                        else {
                            fun_phone_validata();
                            return false;
                        }
                    }
                }
            }
            else {
                fun_name_validata();
                return false;
            }
            return false;
        }

    </script>


    <!--content-->
<div class="logoin_wrap mt30">
    <h2>用户注册</h2>
    <div id="table">
        <form action="user/register.controller" method="post" enctype="application/x-www-form-urlencoded" onsubmit="return fun_form_validate()">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr><td height="30px"></td></tr>
            </table>
            <table width="100%" height="35" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="44%" align="right" valign="middle" class="f14">用户名：</td>
                    <td width="56%" align="left" valign="middle">
                        <input type="text"
                               id="regis_name"
                               name="userName"
                               class="input w180"
                               onchange="fun_name_validata()"/>
                    </td>
                </tr>
                <tr style="height: auto">
                    <td colspan="2">
                        <div id="div_name_validate" style="text-align: center;font-size: 12px;"></div>
                    </td>
                </tr>
            </table>
            <table width="100%" height="35" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="44%" align="right" valign="middle" class="f14">密&nbsp;码：</td>
                    <td width="56%" align="left" valign="middle">
                        <input type="password"
                               id="pwd"
                               name="userPwd"
                               class="input w180" onchange="fun_pwd_validata()"/>
                    </td>
                </tr>
                <tr style="height: auto">
                    <td colspan="2">
                        <div id="div_pwd_validata" style="text-align: center;font-size: 12px;"></div>
                    </td>
                </tr>
            </table>
            <table width="100%" height="35" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="44%" align="right" valign="middle" class="f14">确认密码：</td>
                    <td width="56%" align="left" valign="middle">
                        <input type="password"
                               id="pwds"
                               name="userPwds"
                               class="input w180"
                               onchange="fun_pwds_validata()">
                    </td>
                </tr>
                <tr style="height: auto">
                    <td colspan="2">
                        <div id="div_pwds_validata" style="text-align: center;font-size: 12px;"></div>
                    </td>
                </tr>
            </table>
            <table width="100%" height="35" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="44%" align="right" valign="middle" class="f14">手机号：</td>
                    <td width="56%" align="left" valign="middle">
                        <input type="text"
                               id="regis_phone"
                               name="userPhone"
                               class="input w180"
                               onchange="fun_phone_validata()"/>
                    </td>
                </tr>
                <tr style="height: auto">
                    <td colspan="2">
                        <div id="div_phone_validata" style="text-align: center;font-size: 12px;"></div>
                    </td>
                </tr>
            </table>
            <table width="100%" height="35" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="44%" align="right" valign="middle" class="f14"></td>
                    <td width="56%" align="left" valign="middle">
                        <!-- 图片按钮，与type=submit按钮的效果是一样，也可以用来提交表单 -->
                        <input type="image" src="images/admin_zc.png" />
                    </td>
                </tr>
            </table>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr><td>&nbsp;</td></tr>
            </table>
        </form>
    </div>
</div>
<!--end content-->

<!--footer-->

<div id="footer_wrap">
    <p>Copyright ©2014 飞凡教育，版权所有</p>
</div>

<!--end footer-->
</body>
</html>

