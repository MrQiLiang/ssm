<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../common/import-tag.jsp" %>
<!DOCTYPE html>
<html>
<head>

    <title>角色列表</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/code/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/code/easyui/themes/icon.css" />
    <script type="text/javascript" src="${ctx}/resources/code/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${ctx}/resources/code/easyui/jquery.easyui.min.1.2.2.js"></script>
    <script type="text/javascript">
        $(function() {// 初始化内容

            $("#dataList").datagrid({
                url:'list',
                pagination :"true",
                columns:[[
                    {field:'id',title:'编号',width:100},
                    {field:'roleName',title:'角色名称',width:100},
                    {field:'createTimeStr',title:'创建时间',width:100},
                    {field:'updateTimeStr',title:'更新时间',width:100},
                    /* formatter 不能重复field,否则会失效**/
                    {field:'editId',title:'编辑',width:100,formatter:function (value,row,index) {
                        var html="<a href='#' onclick='openEdit(\"编辑\","+row.id+")'>编辑</a>&nbsp&nbsp";
                        html+="<a href='#' onclick='del("+row.id+")'>删除</a>&nbsp&nbsp";
                        html+="<a href='#' onclick='openPermission("+row.id+")'>权限</a>";
                        if (row.roleName == 'admin'){html = '';}
                        return html;
                    }}
                ]],
                toolbar: [{
                    iconCls: 'icon-add',
                    handler: function(){openEdit('新增',null)}
                }]

            })

        });



    </script>
</head>
<body>
<table id="dataList"></table>
<div id="editDate"></div>
<div id="permissionEditId" ></div>
</body>
<script type="text/javascript">
    function openEdit(title,id) {
        var url='edit';
        if(id!=null){
            url=url+'?id='+id;
        }
        $("#editDate").dialog({
            title:title,
            width:400,
            height:400,
            closed:false,
            cache:false,
            href:url,
            model:true,
            buttons:[
                {text:'保存',handler:function () {
                    var id = $("#id").val();
                    if(id == null || id ==''){
                        save();
                    }
                    else{
                        update();
                    }
                }},{
                    text:'取消',handler:function () {
                        $("#editDate").dialog('close');
                    }
                },
            ]

        });
        $("#editDate").dialog('open').dialog('refresh',url);

    }

    function save() {
        var url = 'save';
        var data = getData();
        post(data,url);
    }

    function update() {
        var url = 'update';
        var data = getData();
        post(data,url);
    }

    function getData() {
        var obj=new Object();
        obj.id=$("#id").val();
        obj.roleName=$("#roleName").val();
        return obj;
    }



    function post(data, url) {

        $.ajax({
            url: url,
            dataType:"json",
            type:"post",
            data:data,
            success: function(result){
                if(result.success==true){
                    $.messager.alert('提醒','提交成功','warning');
                    $("#editDate").dialog('close');
                    $('#dataList').datagrid('reload',{});
                }
            }});
    }

    function openPermission(id) {
        var url='permissionEdit?roleId='+id;
        $("#permissionEditId").dialog({
            title:'权限管理',
            width:400,
            height:400,
            closed:false,
            cache:false,
            href:url,
            model:true,
            buttons:[{text:'保存',handler:function () {
                var nodes=$("#ztree").tree('getChecked');
                var objList=new Array();
                for (var i=0;i<nodes.length;i++){
                    var obj=new Object();
                    obj.roleId=id;
                    var id_permissionIdStr=nodes[i].attributes.id_permissionId;
                    var strArray=id_permissionIdStr.split("_");
                    obj.resourceId=parseInt(strArray[0]);
                    obj.permissionId=parseInt(strArray[1]);
                    objList.push(obj);
                }
                //提交数据
                updatePermission(objList,id);
                $("#permissionEditId").dialog('close');
            }},{text:'关闭',handler:function () {
                $("#permissionEditId").dialog('close');
            }},]

        });
        $("#permissionEditId").dialog('refresh',url);
    }

    function updatePermission(datalist,sessionRoleId) {
        var data=new Object();
        data.voArray=datalist;
        $.ajax({
            url: "updatePermission",
            contentType:'application/json;charset=utf-8',
            dataType:"json",
            type:"post",
            data:JSON.stringify(datalist),
            success: function(result){
                if(result.success==true){
                    $.messager.alert('提醒','提交成功','warning');
                    $("#editDate").dialog('close');
                    $('#dataList').datagrid('reload',{});
                }
            }});
    }

    function del(parameters) {
        var obj=new Object();
        obj.id=parameters;
        $.messager.confirm('消息提醒','确定是否删除该项数据？',function (result) {
            if (result){
                $.ajax({
                    url: "delete",
                    dataType:"json",
                    type:"post",
                    data:obj,
                    success: function(result){
                        if(result.success==true){
                            $.messager.alert('提醒','删除成功','warning');
                            $('#dataList').datagrid('reload',{});
                        }else{
                            $.messager.alert('操作失败','删除失败','error');
                        }
                    }});
            }
        })

    }

</script>
</html>
