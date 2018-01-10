<%--
  Created by IntelliJ IDEA.
  User: Jzw
  Date: 2018/1/2
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../common/head"%>
    <title>飞凡网上书店 - 后台首页</title>
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
</head>
<body>
    <!--top-->
        <jsp:include page="../common/head.jsp"/>
    <!--end top-->

<!--content-->
<div class="w960 mt10">
    <div class="breadcrumb"></div>
</div>

<div class="w960">
    <!-- 左边的栏目 -->
    <jsp:include page="left.jsp"/>

    <div class="w740 right" style="text-align: center;height: 200px">
        <span style="line-height: 100%;text-align: center">欢迎你！管理员</span>
    </div>

    <div class="fixed"></div>
</div>
<!--end content-->

<!--footer-->

<div id="footer_wrap">
    <p>Copyright ©2014 飞凡教育，版权所有</p>
</div>

<!--end footer-->
</body>
</html>

