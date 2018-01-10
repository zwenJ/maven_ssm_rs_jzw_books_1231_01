<%--
  Created by IntelliJ IDEA.
  User: Jzw
  Date: 2017/12/31
  Time: 14:36
  用户登陆的页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%@include file="../../common/base.jsp"%>">
    <link href="images/favicon.ico" rel="icon" type="image/x-icon" />
    <link href="images/favicon.ico" rel="shortcut icon" type="image/x-icon" />
    <title>飞凡网上书店-用户登陆</title>
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <!-- JQuery集合 -->
    <script type="text/javascript" src="/books/mylib/js/jquery/jquery-3.2.1.js"></script>

    <script>
        function fun_login_validate() {
            var ff_name = false;
            var ff_pwd = false;
            var user_name = $("#login_name").val();
            var user_pwd = $("#login_pwd").val();
            if (null != user_name && "" != user_name) {
                ff_name = true;
                $("#div_name_validata").html("");
            }
            else {
                ff_name = false;
                $("#div_name_validata").html("<span style='color: red;'>用户名不能为空！</span>")
            }

            if (null != user_pwd && "" != user_pwd) {
                ff_pwd = true;
                $("#div_pwd_validata").html("");
            }
            else {
                ff_pwd = false;
                $("#div_pwd_validata").html("<span style='color: red;'>密码不能为空！</span>")
            }
            return ff_name&&ff_pwd;
        }
    </script>
</head>

<body>
<!--top-->
 <jsp:include page="../common/head.jsp"/>
<!--end top-->

<!--content-->
<div class="logoin_wrap mt30">
    <h2>用户登陆</h2>
    <div id="table">
        <form:form action="user/login.controller" method="post" onsubmit="return fun_login_validate()" modelAttribute="LoginUser">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr><td height="30px"></td></tr>
            </table>
            <table width="100%" height="35" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="44%" align="right" valign="middle" class="f14">账&nbsp;号：</td>
                    <td width="56%" align="left" valign="middle">
                        <form:input type="text" path="userName" value="" id="login_name" class="input w180"/>
                    </td>
                </tr>
                <tr style="height: auto">
                    <td colspan="2">
                        <div id="div_name_validata" style="text-align: center;font-size: 12px;"></div>
                    </td>
                </tr>
            </table>
            <table width="100%" height="35" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="44%" align="right" valign="middle" class="f14">密&nbsp;码：</td>
                    <td width="56%" align="left" valign="middle">
                        <input type="password" name="userPwd" value="" id="login_pwd" class="input w180"/>
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
                    <td width="44%" align="right" valign="middle" class="f14"></td>
                    <td width="56%" align="left" valign="middle">
                        <!-- 图片按钮，与type=submit按钮的效果是一样，也可以用来提交表单 -->
                        <input type="image" src="images/admin_dl.png" />
                    </td>
                </tr>
            </table>

            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr><td>&nbsp;</td></tr>
            </table>
        </form:form>
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

