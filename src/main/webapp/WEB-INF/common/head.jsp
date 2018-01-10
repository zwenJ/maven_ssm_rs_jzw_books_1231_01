<%--
  Created by IntelliJ IDEA.
  User: Jzw
  Date: 2017/12/31
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%@include file="../../common/base.jsp"%>">
</head>
<body>
<div id="top_div">
    <p class="left">您好，欢迎来到飞凡网上书店 ！</p>
    <c:if test="${empty BooksZxPtUser}">
        <p class="right">
            <a href="base/home/login.controller">登陆</a> |
            <a href="base/home/register.controller">注册</a> |
            <a href="base/home/login.controller">我的购物车</a> |
            <a href="base/home.controller">网站首页</a>
        </p>
    </c:if>
    <c:if test="${not empty BooksZxPtUser}">
        <p class="right">
            <a href="base/user/console.controller" title="点我进入个人中心"><shiro:principal/></a> |
            <a href="user/exitlogin.controller">退出系统</a> |
            <!-- 管理员权限进入 -->
            <shiro:hasRole name="RootUser">
                <a href="base/manager/console.controller">后台管理</a> |
            </shiro:hasRole>
            <!-- 已登录用户权限进入 -->
            <shiro:hasRole name="PtUser">
                <a href="shopping/toshopping.controller">我的购物车</a> |
            </shiro:hasRole>
            <a href="base/home.controller">网站首页</a>
        </p>
    </c:if>
    <div class="fixed"></div>
</div>

<div id="header_div">
    <div id="search">
        <!--下面form标签的id属性不能修改，因为在css中使用了一个id选择器-->
        <form:form id="form" action="book/select/home/find_book.controller" method="post" modelAttribute="AllPageBean">
            <table width="413" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td>
                        <form:input type="text" path="likeText" id="input" />
                    </td>
                    <td>
                        <input type="image" name="imageField" src="images/btn_search.png" />
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</div>

<!--nav-->
<div id="nav">
    <ul id="menu"></ul>
</div>
<!--end nav-->

</body>
</html>
