<%--
  Created by IntelliJ IDEA.
  User: qi_liang
  Date: 2018/1/25
  Time: 下午10:46
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../common/import-tag.jsp" %>
<!DOCTYPE html>
<html>
<head>

    <title>用户列表</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/code/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/code/easyui/themes/icon.css" />
    <script type="text/javascript" src="${ctx}/resources/code/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${ctx}/resources/code/easyui/jquery.easyui.min.1.2.2.js"></script>
    <script type="text/javascript" src="${ctx}/resources/code/js/ajaxfileupload.js"></script>
    <script type="text/javascript">
        $(function() {// 初始化内容

            $("#dataList").datagrid({
                url:'list',
                pagination :"true",
                columns:[[
                    {field:'id',title:'编号',width:50},
                    {field:'loginName',title:'登陆名称',width:60},
                    {field:'remarks',title:'备注',width:150},
                    {field:'createTimeStr',title:'创建时间',width:150},
                    {field:'updateTimeStr',title:'更新时间',width:150},
                    {field:'lastLoginTimeStr',title:'最后登录时间',width:150},
                    {field:'email',title:'电子邮件',width:150},
                    {field:'imgUrl',title:'头像',width:50,formatter:function(value,row,index){
                        return "<img src=\"${ctx}/loadFile/"+value+"\" style=\"width: 30px;height: 30px;border-radius:5px\">";
                    }},
                    /* formatter 不能重复field,否则会失效**/
                    {field:'editId',title:'编辑',width:100,formatter:function (value,row,index) {
                        if(row.loginName =='admin'){
                            return "";
                        }
                        var html="<a href='#' onclick='openEdit(\"编辑\","+row.id+")'>编辑</a>&nbsp&nbsp";
                        html+="<a href='#' onclick='del("+row.id+")'>删除</a>";
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

</body>
<script type="text/javascript">
    function openEdit(title,id) {
        var url='edit';
        if(id!=null){
            url=url+'?id='+id;
        }
        $("#editDate").dialog({
            title:title,
            width:500,
            height:500,
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
        var obj=getData();
        post(obj,url);
    }

    function update() {
        var url = 'update';
        var obj = getData();
        post(obj,url);

    }

    function getData() {
        var obj=new Object();
        obj.id=$("#id").val();
        obj.roleList=getRoleArray();
        obj.loginName=$("#loginName").val();
        obj.password=$("#password").val();
        obj.name=$("#name").val();
        obj.remarks=$("#remarks").val();
        obj.email=$("#email").val();
        obj.imgUrl=$("#imgUrl").val();
        return obj;
    }

    function post(data,url) {
        $.ajaxFileUpload({
            url: url,
            dataType:"json",
            type:"post",
            data:data,
            fileElementId:"file",
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

    function getRoleArray() {
        var roleList=new Array();
        $("input[name='roleIds']").each(function() {
            if ($(this).attr('checked') ==true) {
                roleList.push($(this).val());
            }
        });
        return roleList;
    }

</script>
</html>
