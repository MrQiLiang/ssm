<%--
  Created by IntelliJ IDEA.
  User: qi
  Date: 2019/1/4
  Time: 11:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../common/import-tag.jsp" %>
<html>
<head>
    <title>微信公众号管理后台-消息</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/code/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/code/easyui/themes/icon.css" />
    <script type="text/javascript" src="${ctx}/resources/code/js/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="${ctx}/resources/code/easyui/jquery.easyui.min.1.2.2.js"></script>
    <script type="text/javascript" src="${ctx}/resources/plugins/layer/layer.js"></script>
</head>
<script type="text/javascript">
    $(function () {
        $("#dataList").datagrid({
            url:'list',
            pagination :"true",
            columns:[[
                {field:'id',title:'编号',width:35},
                {field:'messageType',title:'消息类型',width:100},
                {field:'title',title:'消息标题',width:100},
                {field:'content',title:'消息内容',width:100},
                {field:'imageUrl',title:'图片路径',width:100},
                {field:'mediaId',title:'素材ID',width:100},
                {field:'toUrl',title:'跳转路径',width:100},
                {field:'createTimeStr',title:'创建时间',width:150},
                {field:'editId',title:'编辑',width:200,formatter:function (value,row,index) {
                        var html="<a href='#' onclick='openEdit(\"编辑\","+row.id+")'>编辑</a>&nbsp&nbsp";
                        html+="<a href='#' onclick='del("+row.id+")'>删除</a>&nbsp&nbsp";
                        return html;
                    }}
            ]],
            toolbar: [{
                iconCls: 'icon-add',
                handler: function(){openEdit('新增',null)}
            }]

        });
    })
</script>
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
            width:400,
            height:400,
            closed:false,
            cache:false,
            href:url,
            model:true,
            buttons:[
                {text:'保存',handler:function () {
                        if (id==null){
                            save();
                        }else {
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
        var obj = new Object();
        obj = attrObj(obj);
        post(url,obj);
    }

    function update() {
        var url = 'update';
        var obj = new Object();
        obj.id = $("#id").val();
        obj = attrObj(obj);
        post(url,obj);
    }

    function attrObj(obj) {
        obj.messageType = $("#messageType").val();
        obj.title = $("#title").val();
        obj.content = $("#content").val();
        obj.imageUrl = $("#imageUrl").val();
        obj.mediaId = $("#mediaId").val();
        obj.toUrl = $("#toUrl").val();
        return obj;
    }

    function post(url,obj) {
        $.ajax({
            url: url,
            dataType:"json",
            type:"post",
            data:obj,
            success: function(result){
                if(result.success==true){
                    $.messager.alert('提醒','提交成功','warning');
                    $("#editDate").dialog('close');
                    $('#dataList').datagrid('reload',{});
                }
            }});
    }

</script>
</html>
