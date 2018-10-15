<%--
  Created by IntelliJ IDEA.
  User: qi_liang
  Date: 2018/5/30
  Time: 下午9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../common/import-tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>微信回复管理</title>

    <!-- 引入 WeUI -->

</head>
<style>
    body{margin:50px}
    .head{
        background-color:#FFFFFF;
    }
    .button{
        background-color:	#FFFFFF;
        height: 35px;
        border-radius:5px;
        color:#9E9E9E;
        margin:20px 60px 40px 60px; /** 上 右 下 左**/

    }
    .click{

        background-color:#1E90FF;
        color:#FFFFFF;
        outline: none;
    }
    .weixin-checkbox{
        background-color:#C9C9C9;
        border-radius:20px;
        width: 50px;
        height: 30px;
        float:left;
        margin-left: 10px;

    }
    .weixin-checkbox-Check{
        background-color:#1AAD19;


    }
    .checkBox-div{
        background-color:#FFFFFF;
        border-radius:20px;
        width: 30px;
        height: 30px;

    }

    .checkBox-div-Check{

        margin-left: 20px;

    }
    .hr1{     margin-top: 24px;
        border-top: 1px solid #E4E8EB;
    }

    .addhead{
        float:right;
        height: 70px;
    }
    .addhead button{
        background-color:#1AAD19;
        color:#FFFFFF;
        border-radius:9px;
        width: 80px;
        height: 50px;
        margin:10px 0px 10px 0px; /** 上 右 下 左**/
        outline:none
    }
    .content1{
        background-color:#FFFFFF;
        width: 100%;
        height: 400px;

    }
    .content2{
        background-color:#DB7093;
        width: 100%;
        height: 400px;

    }
    .content3{
        background-color:#FFFFFF;
        width: 100%;
        height: 400px;

    }
    .weui-desktop-msg-sender {
        border: 1px solid #E4E8EB;
        background-color: #FFFFFF;
    }
    .weui-desktop-msg-sender__tabs{
        padding-left: 0;
        list-style-type: none;
        line-height: 38px;
        background-color: #FFFFFF;
    }
    table{
        width: 100%;
    }
    .table_the{
        background-color: #F6F8F9;
        color: #9A9A9A;
        width: 100%;
    }
    .row{
        margin: 30px 0px 10px 0px; /** 上 右 下 左**/
    }
    .lable_title{
        margin: 0px 50px 0px 50px; /** 上 右 下 左**/
    }
    .rule-input{
        width: 60%;
        height:33px ;
        border-radius:4px;
    }
    .keyword-select{
        margin-left: 13px;
        width: 37%;
        height:33px ;
        border-radius:4px;

    }
    .keyword-input{
        margin-left: 5px;
        width: 37%;
        height:30px ;
        border-radius:4px;

    }
    .keyword-add{
        width: 20px;
        height: 20px;
        background-color: #FFFFFF;
        border-radius: 20px;
        border:2px solid #E4E8EB;
        text-align:center;


    }
    .keyword-del{
        width: 20px;
        height: 20px;
        background-color: #FFFFFF;
        border-radius: 20px;
        border:2px solid #E4E8EB;
        text-align:center;

    }
    .keyword-add-title{
        margin: 0px 0px 0px -5px; /** 上 右 下 左**/
        text-decoration:none;
        color: black;
    }

    .keyword-del-title{
        margin: 0px 0px 0px -5px; /** 上 右 下 左**/
        text-decoration:none;
        color: black;
    }

    .rule-save{
        margin: 0px 0px 0px 350px;
        background-color: #1AAD19;
        width: 140px;
        height: 40px;
        color: #ffff;
        border-radius: 7px;
    }

    .rule-canle{
        margin: 0px 0px 0px 5px;
        background-color: #ffffff;
        width: 140px;
        height: 40px;
        color: #353535;
        border-radius: 7px;
    }

    .keyword-content{
        width:80%;
        float:left;
    }
    .keyword-cotent-title{
        float:left;
    }
    .content2{
        background-color:#FFFFFF;
        width: 100%;
        height: 400px;

    }
    .li{
        display: inline;
        margin-left: 20px;
    }

    .li:hover{
        color:#44B549;
    }

    .li-title{
        margin:0px 0px -5px 3px; /** 上 右 下 左**/
    }
    .text-input{
        position: relative;
        border: 1px solid #E4E8EB;
        height: 250px;

    }
    .text-arce{
        width: 100%;
        height: 100%;
    }
    .imager-input{
        position: relative;
        border: 1px solid #E4E8EB;
        height: 250px;
        display:none;
    }
    .editor_tip {
        float: right;
        color: #9A9A9A;
    }
    .receive_message-save{
        margin: 61px 0px 0px 350px;
        background-color: #1AAD19;
        width: 140px;
        height: 40px;
        color: #ffff;
        border-radius: 7px;

    }
    .receive_message-del{
        margin: 61px 0px 0px 5px;
        background-color: #ffffff;
        width: 140px;
        height: 40px;
        color: #353535;
        border-radius: 7px;

    }
    .li-click{
        color:#44B549;
    }
    .receive_message_content{
        border: 1px solid #E4E8EB;
        width: 100%;
        height: 350px;
        margin-top: 50px;


    }
    /** 更新      end**/

</style>
<body>

<div class="head">
    <button class="button click" id="button1">关键词回复</button> <button class="button" id="button2">收到消息回复</button> <button class="button" id="button3">被关注回复</button>
</div>
<div><h4>自动回复功能开启/关闭</h4></div>
<div>
    <div style="float:left;"><span>开启/关闭自动回复之后，将立即对所有用户生效</span></div>
    <div class="weixin-checkbox" id="weixincheckBoxId"><div class="checkBox-div"></div>
    </div>
    <div id="id4" style="clear:both"></div>
</div>
<br />
<div class="hr1"></div>
<div  style="clear:both"></div>
<div class="content1" id="content1">
    <div class="addhead"><button id="button4">添加回复</button></div>
    <div  style="clear:both"></div>
    <table>
        <thead class="table_the">
        <tr>
            <th style="width: 25%;">规则名称</th>
            <th style="width: 25%;">关键词</th>
            <th style="width: 25%;">回复内容</th>
            <th style="width: 25%;">操作</th>
        </tr>
        </thead>
        <c:forEach var="vo" items="${adminWechatRuleVoList}">
            <thead >
            <tr>
                <th style="width: 25%;">${vo.ruleName}</th>
                <th style="width: 25%;">
                    <c:forEach var="keywordList" items="${vo.keywordList}">
                        ${keywordList.keyword}
                    </c:forEach>
                </th>
                <th style="width: 25%;">回复内容</th>
                <th style="width: 25%;">操作</th>
            </tr>
            </thead>

        </c:forEach>

    </table>

</div>
<div class="content2" id="content2">
    <input type="hidden" id = "defaultMessageId" value="${defaultMessage.id}" >
    <div class="receive_message_content">
        <ul class="weui-desktop-msg-sender__tabs">
            <li class="li li-click" onclick="showTextOrImager('text',this)" ><a class="li-title">文字</a></li>
            <li class="li" onclick="showTextOrImager('imager',this)" > <a class="li-title">图片</a></li>
        </ul>
        <!-- 文字 输入div -->
        <div class="text-input">
            <div class="text-arce" id="text-arce" contenteditable="true">${defaultMessage.content}</div>

        </div>

        <!-- 图片上传 div -->
        <div class="imager-input">
            <div class="imager-upload"></div>

        </div>
        <button class="receive_message-save" id="message-save">保存</button>
        <button class="receive_message-del" id="message-del">删除回复</button>
    </div>
</div>


<div class="content3" id="content3">
    <input type="hidden" id = "subscribeMessageId" value="${subscribeMessage.id}" >
    <div class="receive_message_content">
        <ul class="weui-desktop-msg-sender__tabs">
            <li class="li li-click" onclick="showTextOrImager('text',this)" ><a class="li-title">文字</a></li>
            <li class="li" onclick="showTextOrImager('imager',this)" > <a class="li-title">图片</a></li>
        </ul>
        <!-- 文字 输入div -->
        <div class="text-input">
            <div class="text-arce" id="subscribe-arce" contenteditable="true">${subscribeMessage.content}</div>

        </div>

        <!-- 图片上传 div -->
        <div class="imager-input">
            <div class="imager-upload"></div>

        </div>
        <button class="receive_message-save" id="subscribe-save">保存</button>
        <button class="receive_message-del" id="subscribe-del">删除回复</button>
    </div>


</div>
<div class="content4" id="content4" >
    <div class="row">
        <label class="lable_title">规则名称</label><input class="rule-input" id="ruleName" type="text" placeholder="请输入规则名称" />
    </div>

    <div class="row" id="row2">
        <label class="lable_title keyword-cotent-title">关键词</label>
        <div class="keyword-content" id="keyword">
            <div class="keyword-content-row">
                <select class="keyword-select"><option value="completely">全匹配</option><option value="contain">半匹配</option></select><input type="text" class="keyword-input" placeholder="请输入关键字" />
                <button class="keyword-add" onclick="addkeyword()"><a href="#" class="keyword-add-title" >十</a></button>
                <button class="keyword-del" onclick="delkeyword(this)"><a href="#" class="keyword-del-title">一</a></button>
            </div>
        </div>

    </div>
    <div  style="clear:both"></div>
    <div class="row">
        <label class="lable_title">回复内容</label>
        <button class="keyword-add"><a href="#" class="keyword-add-title">十</a></button>
        <button class="keyword-del"><a href="#" class="keyword-del-title">一</a></button>
    </div>

    <div class="row">
        <label class="lable_title">回复方式</label>
        <input type="radio" id="replyType" name="replyType" value="whole" />全回复 <input id="replyType" type="radio" name="replyType" value="random" checked="checked" /> 随机回复
    </div>

    <div class="row">
        <button class="rule-save">保存</button>
        <button class="rule-canle">取消</button>
    </div>



</div>
</body>
<script type="text/javascript" src="${ctx}/resources/code/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/plugins/layer/layer.js"></script>
<script type="text/javascript">
    var isCheck = true;
    var addkeywordRowHtml = $("#keyword").html();
    var wechatInfoId = '${weChatInfo.id}';
    $(function(){
        if(isCheck){
            $("#weixincheckBoxId").addClass("weixin-checkbox-Check");
            $(".checkBox-div").addClass("checkBox-div-Check");
            showContent(1);
        }else{
            showContent(0);
        }

        $("#weixincheckBoxId").click(function(){
            if(!isCheck){
                $(this).addClass("weixin-checkbox-Check");
                $(".checkBox-div").addClass("checkBox-div-Check");
                isCheck=true;
                var buttonid = $(".click").attr('id');
                $("#"+buttonid).trigger("click");
            }
            else{
                $(".weixin-checkbox-Check").removeClass("weixin-checkbox-Check");
                $(".checkBox-div-Check").removeClass("checkBox-div-Check");
                showContent(0);
                isCheck=false;
            }

            var data =new Object();
            if(isCheck==true){
                data.isReply = 0;
            }else{
                data.isReply = 1;
            }
            data.wechatInfoId = wechatInfoId;
            $.ajax({
                type:"post",
                url:"${ctx}/admin/wechat/updateIsReply.htm",
                data:data,
                dataType:"json",
                success:function(result){

                }
            });


        });

        /** 显示div**/
        function showContent(index){
            $("#content1").hide();
            $("#content2").hide();
            $("#content3").hide();
            $("#content4").hide();
            $("#content"+index).show();

        }

        function showButton(obj){
            $(".click").removeClass("click");
            $(obj).addClass("click");
        }

        $("#button1").click(function(){
            showButton(this);

            if(isCheck){
                showContent(1);
            }


        });
        $("#button2").click(function(){
            showButton(this);
            if(isCheck){
                showContent(2);

            }
        });
        $("#button3").click(function(){
            showButton(this);
            if(isCheck){
                showContent(3);

            }
        });
        $("#button4").click(function(){
            if(isCheck){
                showContent(4);
            }
        });

        $(".rule-save").click(function(){
            var data = new Object();
            data.ruleName = $("#ruleName").val();
            var keywordList = $(".keyword-content-row");
            var keywordObjeList =new Array();
            keywordList.each(function(index,obj){
                var matchinType = $(obj).find('.keyword-select').val();
                var keywordContent = $(obj).find('.keyword-input').val();
                var wechatKeyWord = new Object();
                wechatKeyWord.keyword =  keywordContent;
                wechatKeyWord.matchinType = matchinType;
                keywordObjeList.push(wechatKeyWord);
            });
            data.keywordListStr = JSON.stringify(keywordObjeList);
            data.replyType = $("#replyType").val();
            data.wechatInfoId = wechatInfoId;
            $.ajax({
                type:"post",
                url:"${ctx}/admin/wechat/saveWechatRule.htm",
                traditional:true,
                data:data,
                dataType:"json",
                success:function(result){
                    if(result.success==true){
                        $("#button1").trigger("click");
                        location.reload();
                    }else{
                        alert("添加失败");
                    }
                }
            });

        });

        $(".rule-canle").click(function(){
            $("#button1").trigger("click");
            $("#keyword").html('');
            $("#keyword").append(addkeywordRowHtml);
            $("#ruleName").val('');
        });

        $("#message-save").click(function(){
            var data = new Object();
            var messageContent = $("#text-arce").html();
            data.content = messageContent;
            data.wechatInfoId = wechatInfoId;
            data.status = 0;
            data.purpose = 'defaultRule';
            data.id = $("#defaultMessageId").val();
            createOrUpdateMessage(data);
        });

        $("#message-del").click(function(){
            $("#text-arce").html("");
            var data = new Object();
            data.status = 1;
            data.purpose = 'defaultRule';
            data.wechatInfoId = wechatInfoId;
            data.id = $("#defaultMessageId").val();
            createOrUpdateMessage(data);

        });
    });


    function addkeyword(){
        $("#keyword").append(addkeywordRowHtml);
    }

    function delkeyword(obj){
        var lastId = $(obj).parent();
        $(lastId).remove();
    }

    function showTextOrImager(type,obj){
        $(".li-click").removeClass("li-click");
        $(obj).addClass("li-click");
        $(".text-input").hide();
        $(".imager-input").hide();

        if(type == 'text'){
            $(".text-input").show();

        }
        if(type == 'imager'){
            alert("待开发功能");
            $(".imager-input").show();

        }
    }

    function createOrUpdateMessage(data){
        $.ajax({
            type:"post",
            url:"${ctx}/admin/wechat/saveOrUpdateMessage.htm",
            traditional:true,
            data:data,
            dataType:"json",
            success:function(result){
                if(result.success==true){
                    layer.msg('操作成功');
                }else{
                    layer.msg('保存失败');
                }
            }
        });
    }

</script>
</html>
