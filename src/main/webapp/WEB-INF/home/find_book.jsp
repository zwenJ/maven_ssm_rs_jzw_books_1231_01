<%--
  Created by IntelliJ IDEA.
  User: Jzw
  Date: 2017/12/31
  Time: 15:21
  展示 查询（分类）的结果页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%@include file="../../common/base.jsp"%>">

    <link href="images/favicon.ico" rel="icon" type="image/x-icon" />
    <link href="images/favicon.ico" rel="shortcut icon" type="image/x-icon" />
    <title>飞凡网上书店 - 书籍分类</title>
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
        <div class="order02 pb10">

            <c:if test="${empty SelectBookList}">
                <h3 style="text-align: center; width: 100%;">暂无该分类数据！</h3>
            </c:if>

            <c:if test="${not empty SelectBookList}">

                <c:forEach items="${SelectBookList}" var="bookFind">
                    <dl class="findbook">
                        <dt class="left"><img src="image/traget.controller?bookId=${bookFind.bookId}" /></dt>
                        <dd class="right">
                            <p><strong>作者：</strong>${bookFind.bookAuthor}</p>
                            <p><strong>价格：</strong>￥${bookFind.bookPrice}</p>
                            <p><strong>出版社：</strong>${bookFind.bookConcern}</p>
                            <p><strong>书籍简介：</strong>${bookFind.bookDetails}</p>
                            <p class="mt10">

                                <!-- TODO 接下来的工作是完成商品加入购物车，直接结算。 -->
                                <a href="shopping/addshopping.controller?bookId=${bookFind.bookId}"><img src="images/btn_shopping.png" /></a>
                                <a href="#"><img src="images/btn_accounts.png" /></a>
                            </p>
                        </dd>
                        <div class="fixed"></div>
                    </dl>
                </c:forEach>

            </c:if>

        </div>

        <c:if test="${not empty SelectBookList}">
            <jsp:include page="../common/page.jsp" flush="true">
                <jsp:param name="pathPage" value="book/select/home/find_book.controller"/>
            </jsp:include>
        </c:if>

    </div>
    <div class="fixed"></div>
</div>
<!--end con-->
<!--end con-->

<!--footer-->

    <div id="footer_wrap">
        <p>Copyright ©2014 飞凡教育，版权所有</p>
    </div>

<!--end footer-->
</body>
</html>

