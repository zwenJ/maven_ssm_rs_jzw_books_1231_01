<%--
  Created by IntelliJ IDEA.
  User: Jzw
  Date: 2017/12/31
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<base href="<%@include file="../../common/base.jsp"%>">
<body>
    <div class="side left">
        <h3>图书分类</h3>

        <ul class="classify bgf7e4e4 bdf7e4e4">

            <c:forEach items="${TypesList}" var="type">
                <li> <a href="book/select/home/find_book.controller?status=2&bookType=${type.typeId}">${type.typeName}</a></li>
            </c:forEach>

            <div class="fixed"></div>
        </ul>

    </div>
</body>
</html>
