<%--
  Created by IntelliJ IDEA.
  User: Jzw
  Date: 2017/12/31
  Time: 15:37
  展示单个商品的详情页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <base href="<%@include file="../../common/base.jsp"%>">

        <link href="images/favicon.ico" rel="icon" type="image/x-icon" />
        <link href="images/favicon.ico" rel="shortcut icon" type="image/x-icon" />
        <title>飞凡网上书店 - 书籍详情</title>
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
                <div class="banner left" style="height: 45px"><h2 style="text-align: left">商品详情</h2></div>
            </div>

            <div class="order02 pb10">

                <dl class="findbook">
                    <dt class="left"><img src="image/traget.controller?bookId=${ShowBookDeatils.bookId}" /></dt>
                    <dd class="right">
                        <h4>${ShowBookDeatils.bookName}</h4>
                        <p><strong>作者：</strong>${ShowBookDeatils.bookAuthor}</p>
                        <p><strong>价格：</strong>￥${ShowBookDeatils.bookPrice}</p>
                        <p><strong>出版社：</strong>${ShowBookDeatils.bookConcern}</p>
                        <p><strong>书籍简介：</strong>${ShowBookDeatils.bookDetails}</p>
                        <p class="mt10">

                            <!-- TODO 接下来的工作是完成商品加入购物车，直接结算。 -->
                            <a href="shopping/addshopping.controller?bookId=${ShowBookDeatils.bookId}"><img src="images/btn_shopping.png" /></a>
                            <a href="#"><img src="images/btn_accounts.png" /></a>
                        </p>
                    </dd>
                    <div class="fixed"></div>
                </dl>

            </div>

        </div>

    </div>

</body>
</html>
