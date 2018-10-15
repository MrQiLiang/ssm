<%--
  Created by IntelliJ IDEA.
  User: qi_liang
  Date: 2018/1/28
  Time: 下午7:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>403 - 您没有权限进行此操作</title>
</head>
<body>
    <h2>403 - 您没有权限进行此操作</h2>
    <p>
        <a href="${ctx}/cms/login/index">返回登陆页面</a>
    </p>

</body>
</html>
