<%--
  Created by IntelliJ IDEA.
  User: Jzw
  Date: 2018/1/3
  Time: 0:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../../common/head"%>
    <title>飞凡网上书店 - 个人中心 - 已发货</title>
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
    <jsp:include page="../common/left.jsp"/>

    <div class="w740 right">
        <div class="o-mt">
            <h2>已发货订单</h2>
        </div>

        <!-- 查询栏 -->
        <jsp:include page="../../common/select_order.jsp" flush="true">
            <jsp:param name="SelectOrder" value="order/showorder/user/orders/order2.controller?status=3&bookType=${BooksZxPtUser}"/>
        </jsp:include>

        <div class="order02">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <th width="10%" class="bd2">下单日期</th>
                    <th width="15%" class="bd2">收货人</th>
                    <th width="15%" class="bd2">收货人电话</th>
                    <th width="15%" class="bd2">收货人邮编</th>
                    <th width="15%" class="bd2">收货人地址</th>
                    <th width="10%" class="bd2">发货方式</th>
                    <th width="10%" class="bd2">订单总价</th>
                    <th width="10%" class="bd2">操作</th>
                </tr>

                <c:if test="${not empty MyOrderList}">

                    <c:forEach items="${MyOrderList}" var="order">
                        <tr style="font-size: 12px">
                            <td width="10%" class="text">${order.orderDate}</td>
                            <td width="15%" class="text">${order.address.addressUsername}</td>
                            <td width="15%" class="text">${order.address.addressPhone}</td>
                            <td width="15%" class="text">${order.address.addressCode}</td>
                            <td width="15%" class="text">${order.address.addressName}</td>
                            <td width="10%" class="text">

                                    ${order.orderSendType}


                            </td>
                            <td width="10%" class="text">￥${order.orderPrice}</td>
                            <td width="10%" class="text">
                                <a href="javascript:fun_update_order('${order.orderId}',4);">确认收货</a>
                            </td>
                        </tr>
                    </c:forEach>

                    <script>
                        function fun_update_order(orderid, value){
                            $.post("/books/order/updateorder.controller",{
                                orderId: orderid,
                                orderStatus: value
                            },function(_result){
                                _result = _result.trim();
                                if ("success" == _result) {
                                    alert("操作成功！");
                                    location.replace("/books/order/showorder/user/orders/order3.controller?status=4&bookType=${BooksZxPtUser}");
                                }
                                else {
                                    alert("操作失败！");
                                }
                            });
                        }
                    </script>

                </c:if>

                <c:if test="${empty MyOrderList}">
                    <tr style="font-size: 12px">
                        <td colspan="5" style="text-align: center">暂无待付款订单</td>
                    </tr>
                </c:if>


            </table>
        </div>

        <c:if test="${not empty MyOrderList}">
            <jsp:include page="../../common/page.jsp" flush="true">
                <jsp:param name="pathPage" value="order/showorder/user/orders/order2.controller?status=3&bookType=${BooksZxPtUser}"/>
            </jsp:include>
        </c:if>

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

