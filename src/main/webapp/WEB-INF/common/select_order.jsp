<%--
  Created by IntelliJ IDEA.
  User: Jzw
  Date: 2018/1/6
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <div class="order01">
        <form name="" method="post" action="<%=request.getParameter("SelectOrder")%>">
            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
                <tr>
                    <td width="15%" align="right">收货人电话：</td>
                    <td width="15%">
                        <input type="text" name="likeText" value="" class="w110 input">
                    </td>
                    <td width="15%" align="right"></td>
                    <td width="15%">
                        <input type="image" name="imageField2" src="images/btn_cx.png" />
                    </td>
                    <td width="15%" align="right"></td>
                    <td width="25%"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
