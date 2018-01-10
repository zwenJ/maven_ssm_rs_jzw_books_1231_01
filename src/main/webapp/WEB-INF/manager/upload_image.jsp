<%--
  Created by IntelliJ IDEA.
  User: Jzw
  Date: 2018/1/3
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%@include file="../../common/base.jsp"%>">
    <title>飞凡网上书店 - 后台管理 - 图片上传</title>
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">

    <!-- JQuery集合 -->
    <script type="text/javascript" src="/books/mylib/js/jquery/jquery-3.2.1.js"></script>
    <link href="images/favicon.ico" rel="icon" type="image/x-icon" />
    <link href="images/favicon.ico" rel="shortcut icon" type="image/x-icon" />
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
            <h2>图片上传</h2>
        </div>
        <div class="order02 pb10">
            <form action="image/upload.controller" method="post" enctype="multipart/form-data">
                <table width="738" align="center" cellpadding="0" cellspacing="0">
                    <tr class="bd2">
                        <th width="20%" align="center" class="bd2">图片</td>
                        <td width="80%"  align="left" class="bd1 pl9" >
                            <input type="file" id="file_upload" name="file" class="input w300"/><span class="required">*</span>
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

                <table width="738" border="0" cellspacing="0" cellpadding="0" class="mt10" align="center">
                    <tr>
                        <td colspan="2" align="left" class="pl9" style="text-align: center">
                            <h3>图片展示</h3>
                            <img id="image_change" style="width:200px; height: 250px;" src="image/traget.controller?bookId=${UploadImageSession}"/>
                        </td>
                    </tr>
                </table>

                <!-- js动态展示图片 -->
                <script>

                    $("#file_upload").change(function(){
                        var upload_image = $("#file_upload").val();
                        var upload_image_index = upload_image.lastIndexOf(".");
                        if(upload_image_index!=-1){//后缀为空，说明不合规范
                            var upload_image_type = upload_image.substr(upload_image_index+1).toUpperCase();//不为空，则获取后缀名
                            if("GIF"===upload_image_type||"JPEG"===upload_image_type||"JPG"===upload_image_type||"PNG"===upload_image_type){
                                //获取这个选择文件的input标签中的第一个文件（也就只有一个）
                                var fileInput = $("#file_upload").get(0).files[0];
                                //创建一个对象用来读取选择的这个文件对象
                                var fileObject = new FileReader();
                                //读取这个文件
                                fileObject.readAsDataURL(fileInput);
                                fileObject.onload=function(dd){
                                    //整个读取文件的进度
                                    console.log(dd);
                                    //选择一个img将选择的文件对象放进去显示
                                    $("#image_change").get(0).src = dd.target.result;
                                }
                            }else{
                                alert("只支持.png、.jpeg、.jpg、.gif格式的文件，请重新选择");
                                upload_image.val(null);
                            }
                        }else{
                            alert("请选择正确的文件~");
                            upload_image.val(null);
                        }

                    });

                </script>

            </form>
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

