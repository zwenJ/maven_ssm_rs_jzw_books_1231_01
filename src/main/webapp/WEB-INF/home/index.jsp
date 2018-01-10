<%--
  Created by IntelliJ IDEA.
  User: Jzw
  Date: 2017/12/31
  Time: 9:45
  这是本网站的首页
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%@include file="../../common/base.jsp"%>">
    <link href="images/favicon.ico" rel="icon" type="image/x-icon" />
    <link href="images/favicon.ico" rel="shortcut icon" type="image/x-icon" />
    <title>飞凡网上书店-首页</title>
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
</head>

<body>
<!--top-->
    <jsp:include page="../common/head.jsp"/>
<!--end top-->

<!--con-->
<div class="w960 mt10">
    <!-- left div -->
    <jsp:include page="../common/left.jsp"/>

    <div class="w740 right">
        <div class="main_div">
            <div class="banner left"><img src="images/banner.png" /></div>
            <div class="fixed"></div>
        </div>

        <div class="main_div mt10">
            <h2>
                <cite class="left">新书上架</cite>
                <div class="fixed"></div>
            </h2>

            <ul class="arivals">

                <c:forEach items="${BookRecentlyList}" var="booksRec">
                    <li>
                        <a href="book/details.controller?bookId=${booksRec.bookId}">
                            <img src="image/traget.controller?bookId=${booksRec.bookId}" />
                            <p>${booksRec.bookName}</p>
                            <p class="red">￥${booksRec.bookPrice}</p>
                        </a>
                    </li>
                </c:forEach>

                <div class="fixed"></div>
            </ul>
        </div>

        <div class="main_div mt10">
            <h2>
                <cite class="left">热销图书</cite>
                <div class="fixed"></div>
            </h2>

            <ul class="arivals">

                <c:forEach items="${BookMtodList}" var="booksMtod">
                    <li>
                        <a href="book/details.controller?bookId=${booksMtod.bookId}">
                            <img src="image/traget.controller?bookId=${booksMtod.bookId}" />
                            <p>${booksMtod.bookName}</p>
                            <p class="red">￥${booksMtod.bookPrice}</p>
                        </a>
                    </li>
                </c:forEach>

                <div class="fixed"></div>
            </ul>
        </div>
    </div>
    <div class="fixed"></div>
</div>
<!--end con-->

<!--footer-->

<div id="footer_wrap">
    <p>Copyright ©2014 飞凡教育，版权所有</p>
</div>

<!--end footer-->
</body>
</html>

