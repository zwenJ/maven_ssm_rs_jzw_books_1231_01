<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Jzw
  Date: 2018/1/2
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>飞凡网上书店 - 后台 - 新增图书</title>
    <%@include file="../common/head"%>
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

    <div class="w740 right">
        <div class="o-mt">
            <h2>书籍新增</h2>
        </div>
        <div class="order02 pb10">
            <!-- TODO 书籍新增 表单验证尚未完成 -->
            <form:form action="book/addbook.controller" method="post" modelAttribute="AddBook">
                <table width="738" align="center" cellpadding="0" cellspacing="0">
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">书名</td>
                        <td width="80%"  align="left" class="bd1 pl9" >
                            <form:input type="text" path="bookName" class="input w300"/><span class="required">*</span>
                        </td>
                        <td>
                            <form:errors path="bookName"/>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">类别</td>
                        <td width="80%"  align="left" class="bd1 pl9">

                            <form:select name="" style="width:300px;" path="typeId">
                                <option value="">--请选择--</option>
                                <form:options items="${TypesList}" itemValue="typeId" itemLabel="typeName"></form:options>
                            </form:select><span class="required">*</span>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">作者</td>
                        <td width="80%"  align="left" class="bd1 pl9" >
                            <form:input type="text" path="bookAuthor" class="input w300"/><span class="required">*</span>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">价格</td>
                        <td width="80%"  align="left" class="bd1 pl9" >
                            <form:input type="text" path="bookPrice"  class="input w300"/><span class="required">*</span>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">数量</td>
                        <td width="80%"  align="left" class="bd1 pl9" >
                            <form:input type="text" path="bookStock"  class="input w300"/><span class="required">*</span>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">出版社</td>
                        <td width="80%"  align="left" class="bd1 pl9" >
                            <form:input type="text" path="bookConcern" class="input w300"/><span class="required">*</span>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">简介</td>
                        <td width="80%"  align="left" class="bd1 pl9" rowspan="3">
                            <form:textarea path="bookDetails" rows="6" class="w300"></form:textarea><span class="required">*</span>
                        </td>
                    </tr>
                    <tr class="">
                        <th width="20%" align="center" class="bd2"></td>
                    </tr>
                    <tr class="">
                        <th width="20%" align="center" class="bd2"></td>
                    </tr>
                </table>

                <table width="738" border="0" cellspacing="0" cellpadding="0" class="mt10" align="center">
                    <tr>
                        <td width="20%" align="center" class="bd2"></td>
                        <td width="80%" align="left" class="pl9" >
                            <input type="submit" value="确定" class="btn"/>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
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

