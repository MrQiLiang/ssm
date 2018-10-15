<%--
  Created by IntelliJ IDEA.
  User: qi
  Date: 2017/7/25
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/import-tag.jsp" %>
<html>
<head>
    <title>在线大小转换</title>
</head>
<body >
 <select>
   <option>大写</option>
   <option>小写</option>
 </select><br>
 <div align="center">
 <div align="center" style="display: block;">
 <textarea id="content" style="border: 1px solid #d9d9d9;height: 160px;width: 85%;"></textarea> <br>
 </div>
    <input type="button" value="大写" id="capital">
     <input type="button" value="小写" id="lowercase">
     <input type="button" value="首字母大写" id="firstapital">
     <input type="button" value="首字母小写" id="firstlowercase">
 </div>
</body>
<script type="text/javascript" src="${ctx}/resources/code/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
    //转换大写
    $("#capital").click(function () {
        var content=$("#content" ).val();
        $("#content" ).val(content.toUpperCase());
    })
    //转化小写
    $("#lowercase").click(function () {
        var content=$("#content" ).val();
        $("#content" ).val(content.toLowerCase());
    })
    //首字母大写
    $("#firstapital").click(function () {
        var content=$("#content" ).val();
        var first=content.substr(0,1);
        var other=content.substr(1,content.length);
        $("#content" ).val(first.toUpperCase()+other);
    })

    $("#firstlowercase").click(function () {
        var content=$("#content" ).val();
        var first=content.substr(0,1);
        var other=content.substr(1,content.length);
        $("#content" ).val(first.toLowerCase()+other);
    })


</script>
</html>
