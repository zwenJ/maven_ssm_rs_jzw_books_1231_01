<%--
  Created by IntelliJ IDEA.
  User: Jzw
  Date: 2018/1/5
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../common/head"%>
    <title>飞凡网上书店 - 个人中心</title>
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
        <div class="o-mt">
            <h2>提交订单</h2>
        </div>
        <div class="order02 pb10">
            <form action="order/addorder.controller" method="post">
                <table width="738" align="center" cellpadding="0" cellspacing="0">
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">收货人</td>
                        <td width="80%"  align="left" class="bd1 pl9" >
                            <input type="text" name="address.addressUsername" class="input w300"><span class="required">*</span>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">收货人电话</td>
                        <td width="80%"  align="left" class="bd1 pl9" >
                            <input type="text" name="address.addressPhone" class="input w300"><span class="required">*</span>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">收货人邮编</td>
                        <td width="80%"  align="left" class="bd1 pl9" >
                            <input type="text" name="address.addressCode" class="input w300"><span class="required">*</span>
                        </td>
                    </tr>
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">收货人地址</td>
                        <td width="80%"  align="left" class="bd1 pl9" >
                            <input type="text" name="address.addressName" class="input w300"><span class="required">*</span>
                        </td>
                    </tr>

                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">发货方式</td>
                        <td width="80%"  align="left" class="bd1 pl9">
                            <select name="orderSendType" style="width:305px;">
                                <option value="1">--请选择--</option>
                                <option value="1">平邮</option>
                                <option value="2">快递</option>
                            </select><span class="required">*</span>
                        </td>
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
            </form>
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
