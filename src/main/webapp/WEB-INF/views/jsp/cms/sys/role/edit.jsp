<%--
  Created by IntelliJ IDEA.
  User: qi_liang
  Date: 2018/1/28
  Time: 下午10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../common/import-tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>编辑</title>
    <script type="text/javascript">
        $(function () {
            $("#menuIco").val('${sysResource.menuIco}');
        })
    </script>

</head>
<body>
    <div style="margin:20px 0;"></div>
        <div style="padding:10px 60px 20px 60px">
                <table cellpadding="1">
                    <input type="hidden" value="${sysRole.id}" id="id">
                    <tr>
                        <td>角色名称:</td>
                        <td><input class="easyui-textbox" type="text" id="roleName" data-options="required:true" value="${sysRole.roleName}"></input></td>
                    </tr>


                </table>
    </div>
</body>
</html>
