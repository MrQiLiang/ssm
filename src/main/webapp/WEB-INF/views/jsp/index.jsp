<%--
  Created by IntelliJ IDEA.
  User: qi
  Date: 2017/7/19
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/import-tag.jsp" %>
<html>
<head>
    <title>堂吉诃德网</title>
</head>

<body>
<script id="container" name="content" type="text/plain">

</script>


</body>
<!-- 配置文件-->
<script type="text/javascript" src="${ctx}/resources/plugins/ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件-->
<script type="text/javascript" src="${ctx}/resources/plugins/ueditor/ueditor.all.js"></script>
<script type="text/javascript">
    var  ue = UE.getEditor("container");
</script>
</html>
