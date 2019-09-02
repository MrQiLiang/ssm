<%--
  Created by IntelliJ IDEA.
  User: qi
  Date: 2019/5/10
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../common/import-tag.jsp" %>
<html>
<head>
    <title>用户资料编辑</title>
    <script type="text/javascript">
        function imageError(imager) {
            imager.setAttribute("src", "${ctx}/resources/code/images/uploadIcon.png");
        }
    </script>
    <style type="text/css">
        .left_td{
            width: 120px;
            text-align:right;
        }
        .right_td{
            padding-left:20px;
        }
    </style>
</head>
<body>

    <table>
        <tr>
            <td class="left_td" >
                用户名:
            </td>
            <td class="right_td">
                <input type="text" name="userName" value="${sysUser.loginName}">
            </td>
        </tr>
        <tr>
            <td class="left_td">
                邮箱:
            </td>
            <td class="right_td">
                <input type="text" name="email" value="${sysUser.email}" >
            </td>
        </tr>
        <tr>
            <td class="left_td">
                头像:
            </td>
            <td class="right_td">
                <img src="${ctx}/loadFile/${sysUser.imgUrl}" border="2"
                   width="100" height="100" style="border-radius:12px;"
                     id="uploadBtn" onerror="imageError(this)">
                <input type="file" style="visibility:hidden;" id="uploadFile">
            </td>
        </tr>
        <tr>
            <td class="left_td">
                备注:
            </td>
            <td>
                <textarea id="" rows="4"> </textarea>
            </td>
        </tr>
    </table>
</body>
<script type="text/javascript" src="${ctx}/resources/code/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/code/js/imageUtil.js"></script>
<script>
    $(function () {
       $("#uploadBtn").click(function () {
           $("#uploadFile").trigger("click");
       });
       $("#uploadFile").change(function () {
           var imageUrl = getObjectURL(this.files[0]);
           $("#uploadBtn").attr("src",imageUrl);
       });
    });

    function postDate() {
        alert("提交数据");
    }

</script>
</html>
