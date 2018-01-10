<%--
  Created by IntelliJ IDEA.
  User: Jzw
  Date: 2018/1/3
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div class="side left">

    <h4>订单管理</h4>
    <ul class="classify E6">
        <li>&nbsp;&nbsp;<a href="order/showorder/user/orders/order.controller?status=1&bookType=${BooksZxPtUser}">待付款</a></li>
        <li>&nbsp;&nbsp;<a href="order/showorder/user/orders/order1.controller?status=2&bookType=${BooksZxPtUser}">未发货</a></li>
        <li>&nbsp;&nbsp;<a href="order/showorder/user/orders/order2.controller?status=3&bookType=${BooksZxPtUser}">已发货</a></li>
        <li>&nbsp;&nbsp;<a href="order/showorder/user/orders/order3.controller?status=4&bookType=${BooksZxPtUser}">已签收</a></li>
        <div class="fixed"></div>
    </ul>
    <!--end nav-->

</div>
</body>
</html>
