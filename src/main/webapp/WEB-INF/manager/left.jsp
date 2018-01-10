<%--
  Created by IntelliJ IDEA.
  User: Jzw
  Date: 2018/1/2
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <div class="side left">


        <!--nav-->
        <h4>书籍管理</h4>
        <ul class="classify E6">
            <li>&nbsp;&nbsp;<a href="base/manager/add_book.controller">新&nbsp;增</a></li>
            <li>&nbsp;&nbsp;<a href="book/select/manager/books/list_books1.controller?status=1">未上架</a></li>
            <li>&nbsp;&nbsp;<a href="book/select/manager/books/list_books2.controller?status=2">已上架</a></li>
            <li>&nbsp;&nbsp;<a href="book/select/manager/books/list_books3.controller?status=3">已下架</a></li>
            <div class="fixed"></div>
        </ul>
        <h4>订单管理</h4>
        <ul class="classify E6">
            <li>&nbsp;&nbsp;<a href="order/showorder/manager/order/order1.controller?status=2">未发货</a></li>
            <li>&nbsp;&nbsp;<a href="order/showorder/manager/order/order2.controller?status=3">已发货</a></li>
            <li>&nbsp;&nbsp;<a href="order/showorder/manager/order/order3.controller?status=4">已签收</a></li>

            <div class="fixed"></div>
        </ul>
        <!--end nav-->

    </div>
</body>
</html>
