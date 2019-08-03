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
    <link href="${ctx}/resources/aceAdmin/assets/css/font-awesome.min.css">
</head>
<body>
    <div style="margin:20px 0;"></div>
        <div style="padding:10px 60px 20px 60px">
                <table cellpadding="4">
                    <input type="hidden" value="${sysPermission.id}" id="id">
                    <tr>
                        <td>菜单目录:</td>
                        <td>
                            <select class="easyui-combobox" id="sysResourceId" >
                                <c:forEach var="menu" items="${menuList}">
                                    <option value="${menu.id}"  <c:if test="${menu.id==sysResource.parentId}">selected</c:if>  onclick="showUrlPath()" >${menu.menuName}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr >
                        <td>权限名称:</td>
                        <td><input class="easyui-textbox" type="text" id="name" data-options="required:true" value="${sysPermission.name}"></input></td>
                    </tr>
                    <tr>
                        <td>菜单键值:</td>
                        <td><input class="easyui-textbox" type="text" id="permissionKey" data-options="required:true'" value="${sysPermission.permissionKey}"></input></td>
                    </tr>
                    <tr>
                        <td>权限类型:</td>
                        <td>
                            <select class="easyui-combobox" id="permissionType" >
                                <c:forEach var="permissionTyp" items="${permissionTypeMap}">
                                    <option value="${permissionTyp.key}"  <c:if test="${permissionTyp.key==sysPermission.permissionType}">selected</c:if>   >${permissionTyp.value}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>


                </table>
    </div>
</body>
<script type="text/javascript">

    $(function () {
    });
    



</script>
</html>
