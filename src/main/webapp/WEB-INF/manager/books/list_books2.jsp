<%--
  Created by IntelliJ IDEA.
  User: Jzw
  Date: 2018/1/2
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../../common/head"%>
    <title>飞凡网上书店 - 后台管理 - 已上架书籍</title>
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
</head>
<body>
<!--top-->
    <jsp:include page="../../common/head.jsp"/>
<!--end top-->

<!--content-->
<div class="w960 mt10">
    <div class="breadcrumb"></div>
</div>

<div class="w960">
    <!-- 左边的栏目 -->
    <jsp:include page="../left.jsp"/>

    <div class="w740 right">
        <div class="o-mt">
            <h2>已上架书籍</h2>
        </div>

        <!-- 查询栏 -->
        <jsp:include page="select_book.jsp" flush="true">
            <jsp:param name="SelectBookJsp" value="book/select/manager/books/list_books2.controller?status=2"/>
        </jsp:include>

        <div class="order02">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <th width="15%" class="bd2">书名</th>
                    <th width="15%" class="bd2">作者</th>
                    <th width="15%" class="bd2">价格</th>
                    <th width="25%" class="bd2">出版社</th>
                    <th width="30%" class="bd2">操作</th>
                </tr>

                <c:if test="${empty SelectBookList}">
                    <tr style="font-size: 12px">
                        <td colspan="5" style="text-align: center">暂无已上架书籍</td>
                    </tr>
                </c:if>
                <c:if test="${not empty SelectBookList}">
                    <c:forEach items="${SelectBookList}" var="book">
                        <tr style="font-size: 12px">
                            <td width="15%" class="text">${book.bookName}</td>
                            <td width="15%" class="text">${book.bookAuthor}</td>
                            <td width="15%" class="text">
                                    ${book.bookPrice}
                            </td>
                            <td width="25%" class="text">${book.bookConcern}</td>
                            <td width="30%" class="text" style="font-size: 12px">
                                <a href="javascript:fun_update('${book.bookId}', 3)">下架</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>

                <script type="text/javascript" src="mylib/js/me/function_me.js"></script>
            </table>
        </div>

        <jsp:include page="../../common/page.jsp" flush="true">
            <jsp:param name="pathPage" value="book/select/manager/books/list_books2.controller"/>
        </jsp:include>

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

