<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../common/import-tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>日志列表</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/code/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/code/easyui/themes/icon.css" />
</head>
<body>
<table id="dataList"></table>
</body>
<script type="text/javascript" src="${ctx}/resources/code/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/code/easyui/jquery.easyui.min.1.2.2.js"></script>
<script type="text/javascript">
    $(function() {// 初始化内容
        $("#dataList").datagrid({
            url:'list',
            pagination :"true",
            columns:[[
                {field:'id',title:'编号',width:100},
                {field:'userIp',title:'用户ip',width:100},
                {field:'createTimeStr',title:'创建时间',width:150},
                {field:'url',title:'访问路径',width:300}
            ]]
        })
    });
</script>
</html>
