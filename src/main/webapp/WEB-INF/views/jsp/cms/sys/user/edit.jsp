<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../common/import-tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>编辑</title>
    <script type="text/javascript">
        $(function () {
            $("#image_td").hide();
            $("#menuIco").val('${sysResource.menuIco}');

            $('#file').change(function () {
                var imgPath = getObjectURL(this.files[0]);
                $("#imageShow").attr("src",imgPath);
                $("#image_td").show();
            });

            var userImageUrl = '${sysUser.imgUrl}';
            if (userImageUrl!=null&&userImageUrl!=''){
                $("#imageShow").attr("src",'${ctx}/loadFile/'+userImageUrl);
                $("#image_td").show();
            }
        });

        //构建本地图片路径
        function getObjectURL(file) {
            var url = null ;
            if (window.createObjectURL!=undefined) {
                url = window.createObjectURL(file) ;
            } else if (window.URL!=undefined) {
                url = window.URL.createObjectURL(file) ;
            } else if (window.webkitURL!=undefined) {
                url = window.webkitURL.createObjectURL(file) ;
            }
            return url ;
        }
    </script>
</head>
<body>
    <div style="margin:20px 0;"></div>
        <div style="padding:10px 60px 20px 60px">
                <table cellpadding="5">
                    <input type="hidden" value="${sysUser.id}" id="id">

                    <tr>
                        <td>用户名:</td>
                        <td><input class="easyui-textbox" type="text" id="loginName" data-options="required:true" value="${sysUser.loginName}"></input></td>
                    </tr>
                   <c:if test="${sysUser==null}">
                    <tr>
                        <td>密码:</td>
                        <td><input class="easyui-textbox" type="password" id="password" data-options="required:true" value="${sysUser.password}"></input></td>
                    </tr>
                   </c:if>
                    <tr>
                        <td>电子邮箱:</td>
                        <td><input class="easyui-textbox" type="text" id="email" data-options="multiline:true,required:true" value="${sysUser.email}" ></input></td>
                    </tr>

                    <tr  >
                        <td>头像:</td>
                        <td><input  type="file" name="file" id="file" data-options="multiline:true,required:true"  ></input></td>
                    </tr>
                    <tr id="image_td">
                        <td  colspan="2" align="center">
                            <img src="" id="imageShow" width="100" height="100">
                        </td>
                    </tr>

                    <tr>
                        <td>备注:</td>
                        <td><input class="easyui-textbox" type="text" id="remarks" data-options="multiline:true,required:true" value="${sysUser.remarks}" ></input></td>
                    </tr>

                </table>
            <div class="easyui-accordion">
                <div title="角色" style="padding: 10px">
                    <c:forEach items="${roleList}" var="role">
                        <input  name="roleIds" type="checkbox" value="${role.roleId}" <c:if test="${role.userId!=null}">checked</c:if> >${role.roleName}
                    </c:forEach>
                </div>

            </div>


    </div>
</body>
</html>
