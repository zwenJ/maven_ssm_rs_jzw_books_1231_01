<%--
  Created by IntelliJ IDEA.
  User: Jzw
  Date: 2018/1/3
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="page" uri="http://jiangzwen.com" %>
<base href="<%@include file="../../common/base.jsp"%>">

<page:page items="${PageBean}" path="<%=request.getParameter(\"pathPage\")%>" />


