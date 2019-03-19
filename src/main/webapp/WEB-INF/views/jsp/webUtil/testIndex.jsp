<%--
  Created by IntelliJ IDEA.
  User: qi
  Date: 2017/7/29
  Time: 1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/import-tag.jsp" %>
<html>
<head>
    <title>测试标题</title>
    <script type="text/javascript" src="${ctx}/resources/code/js/jquery-2.2.4.min.js"></script>
</head>
<body>

 <div class="shar">测试标题</div>
<c:import url="../common/share2017.jsp?ctx=${ctx}&content=诚意推荐&pic=http://www.baidu.com"></c:import>
</body>
</html>
