<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../common/import-tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>权限</title>
    <script type="text/javascript">
        var unSelectList=new Array();
        $(function () {
            var data=JSON.parse('${permissionList}');
           $("#ztree").tree({
               data:data,
               checkbox:true,
               cascadeCheck:false,
               loader:false,
               dnd:false,

           });
        });

    </script>
</head>

<body>

   <ul id="ztree"></ul>

</body>
</html>
