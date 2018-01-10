<%--
  Created by IntelliJ IDEA.
  User: Jzw
  Date: 2017/12/31
  Time: 16:00
  我的购物车页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%@include file="../../common/base.jsp"%>">
    <title>飞凡网上书店-我的购物车</title>
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <meta http-equiv="pragma" content="no-cache">
    <link href="images/favicon.ico" rel="icon" type="image/x-icon" />
    <link href="images/favicon.ico" rel="shortcut icon" type="image/x-icon" />
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <!-- JQuery集合 -->
    <script type="text/javascript" src="/books/mylib/js/jquery/jquery-3.2.1.js"></script>
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
        <div class="order02">

            <c:if test="${not empty ShoppingCatRequest}">

                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <th width="20%" class="bd2">书名</th>
                        <th width="20%" class="bd2">单价</th>
                        <th width="20%" class="bd2">数量</th>
                        <th width="20%" class="bd2">小计</th>
                        <th width="20%" class="bd2">操作</th>
                    </tr>

                    <c:forEach items="${ShoppingCatRequest}" var="shopping">
                        <!-- 商品的库存大于或等于购物车商品的数量 -->
                        <c:if test="${shopping.books.bookStock ge shopping.bookSum}">
                            <tr style="font-size: 12px">
                                <td width="20%" class="text">${shopping.books.bookName}</td>
                                <td width="20%" class="text">${shopping.books.bookPrice}</td>
                                <td width="20%" class="text">
                                    <input class="input"
                                           style="width: 50px;text-align: center;" type="text"
                                           id="${shopping.books.bookName}"
                                           value="${shopping.bookSum}"
                                           onchange="fun_update_shopping('${shopping.shoppingId}','${shopping.books.bookName}');">
                                </td>
                                <td width="20%" class="text">${shopping.books.bookPrice * shopping.bookSum}</td>
                                <td width="20%" class="text">
                                    <a href="shopping/remove.controller?shoppingId=${shopping.shoppingId}&pages=22">移除</a>
                                </td>
                            </tr>
                            <!-- 用于计算购物车总价值 -->
                            <c:set var="ShoppingSumPri" scope="page" value="${shopping.books.bookPrice * shopping.bookSum + ShoppingSumPri}"/>
                        </c:if>
                        <!-- 商品库存小于购物车的商品数量 -->
                        <c:if test="${shopping.books.bookStock lt shopping.bookSum}">
                            <tr style="font-size: 12px;color: darkgrey">
                                <td width="20%" class="text">${shopping.books.bookName}</td>
                                <td width="20%" class="text">${shopping.books.bookPrice}</td>
                                <td width="20%" class="text">
                                    <input class="input"
                                           style="width: 50px;text-align: center;" type="text"
                                           id="${shopping.books.bookName}"
                                           value="${shopping.bookSum}"
                                           onchange="fun_update_shopping('${shopping.shoppingId}','${shopping.books.bookName}');">
                                </td>
                                <td width="20%" class="text">${shopping.books.bookPrice * shopping.bookSum}</td>
                                <td width="20%" class="text">
                                    <a href="shopping/remove.controller?shoppingId=${shopping.shoppingId}&pages=22">移除</a>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>

                </table>

                <table width="100%" border="0" cellspacing="0" cellpadding="0"  class="bd2">
                    <tr bgcolor="#fefcea">
                        <td width="80%" align="right"><strong>购物车总价：</strong></td>
                        <td width="20%" align="left"><strong><span class="STYLE1">${ShoppingSumPri}</span></strong></td>
                    </tr>
                </table>

                <table width="738" border="0" cellspacing="0" cellpadding="0" class="mt10">
                    <tr>
                        <td width="5%" align="center" ></td>
                        <td width="30%" align="center" >
                            <a href="shopping/remove.controller?shoppingId=32&pages=32" onclick="return !confirm('客官不再看看吗？')"><img src="images/btn_shoppingcart.png"/></a>
                        </td>
                        <td width="30%" align="center" >
                            <a href="base/home.controller"><img src="images/btn_jxgm.png"/></a>
                        </td>
                        <td width="30%" align="center" >
                            <a href="base/user/add_order.controller"><img src="images/btn_accounts.png"/></a>
                        </td>
                        <td width="5%"></td>
                    </tr>
                </table>
                <script>
                    function fun_update_shopping(shoid,bookName){
                        var sizes = document.getElementById(bookName).value;
                        $.post("shopping/updatesize.controller",{
                            shoppingId:shoid,
                            bookSum:sizes
                        },function(_result){
                            _result = _result.trim();
                            if ("success"==_result) {
                                location.reload();
                            }
                        });
                    }
                </script>
            </c:if>

            <c:if test="${empty ShoppingCatRequest}">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td colspan="5" style="text-align: center">
                            <h2>你还没有选中任何商品加入购物车哦！<a href="base/home.controller">去看看吧！</a></h2>
                        </td>
                    </tr>
                </table>
            </c:if>

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

