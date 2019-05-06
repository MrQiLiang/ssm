<%--
  Created by IntelliJ IDEA.
  User: qi_liang
  Date: 2018/6/3
  Time: 下午5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../common/import-tag.jsp" %>
<html>
<head>
    <title>微信公众号管理</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/code/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/code/easyui/themes/icon.css" />
    <script type="text/javascript" src="${ctx}/resources/code/js/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="${ctx}/resources/code/easyui/jquery.easyui.min.1.2.2.js"></script>
    <script type="text/javascript" src="${ctx}/resources/plugins/layer/layer.js"></script>
    <script type="text/javascript">
        $(function(){

            $("#dataList").datagrid({
                url:'list',
                pagination :"true",
                columns:[[
                    {field:'editId',title:'编辑',width:130,formatter:function (value,row,index) {
                           console.log(row);
                            var html="<a href='#' onclick='openEdit(\"编辑\","+row.id+")'>编辑</a>&nbsp&nbsp";
                            html+="<a href='#' onclick='del("+row.id+")'>删除</a>&nbsp&nbsp";
                            if (row.wechatInfoType!=1){
                                html+="<a href='#' onclick='openMenu("+row.id+")'>菜单</a>&nbsp&nbsp";
                            }
                            html+="<a href='#' onclick='openRule("+row.id+")'>回复</a>&nbsp&nbsp";
                            return html;
                        }},
                    {field:'id',title:'编号',width:35},
                    {field:'wechatName',title:'微信名称',width:100},
                    {field:'wechatOpenId',title:'微信openId',width:100},
                    {field:'appId',title:'appId',width:120},
                    {field:'appSecpet',title:'开发者密码',width:200},
                    {field:'token',title:'令牌',width:100},
                    {field:'wechatInfoTypeStr',title:'类型',width:80},
                    {field:'encodingTypeStr',title:'消息模式',width:100},
                    {field:'encodingAesKey',title:'消息加密key',width:100},
                    {field:'createTimeStr',title:'创建时间',width:130},
                    {field:'url',title:'对接url',width:300},
                ]],
                toolbar: [{
                    iconCls: 'icon-add',
                    handler: function(){openEdit('新增',null)}
                }]

            });
        });
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
         //   obj.id = $("#id").val();
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
            obj.wechatOpenId = $("#wechatOpenId").val();
            obj.wechatName = $("#wechatName").val();
            obj.appId = $("#appId").val();
            obj.appSecpet = $("#appSecpet").val();
            obj.url = $("#url").val();
            obj.token = $("#token").val();
            obj.encodingType = $("#encodingType").val();
            obj.encodingAesKey = $("#encodingAesKey").val();
            obj.wechatInfoType = $("#wechatInfoType").val();
            return obj;
        }

        function del(id) {
            var url = 'delete';
            var obj = new Object();
            obj.id = id;
            post(url,obj);
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

        /**
         *  打开回复编辑
         * @param id
         */
        function openRule(id) {
            layer.open({
                type: 2,
                title: '微信消息回复',
                shadeClose: true,
                shade: 0.9,
                area: ['90%', '90%'],
                content: '${ctx}/cms/wechat/rule/index' //iframe的url
            });
        }
        /**
         * 打开自定义菜单
         */
        function openMenu(id) {

        }
    </script>
</head>
<body>
    <table id="dataList"></table>
    <div id="editDate"></div>
</body>
</html>
