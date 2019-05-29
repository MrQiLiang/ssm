<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../../../common/import-tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>消息回复</title>
    <link href="${ctx}/resources/cms/wechat/rule/css/index.css" rel="stylesheet" type="text/css">
</head>
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
            <!-- 	 <th style="width: 25%;">回复内容</th> -->
            <th style="width: 25%;">操作</th>
        </tr>
        </thead>
        <c:forEach var="vo" items="${wechatRules}">
            <thead >
            <tr>
                <th style="width: 25%;">${vo.ruleName}</th>
                <th style="width: 25%;">
                    <c:forEach var="keywordList" items="${vo.wechatKeywordList}">
                        ${keywordList.keyword}
                    </c:forEach>
                </th>
                <!-- 	<th style="width: 25%;">回复内容</th> -->
                <th style="width: 25%;"> <a href="javascript:showeditRule('${vo.id}')">编辑</a>  <a href="javascript:delRule('${vo.id}')">删除</a> </th>
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
            <!-- <li class="li" onclick="showTextOrImager('imager',this)" > <a class="li-title">图片</a></li>	-->
        </ul>
        <!-- 文字 输入div -->
        <div class="text-input">
            <div class="text-arce" id="text-arce" contenteditable="true">${defaultMessage.content}</div>
        </div>

        <!-- 图片上传 div -->
        <div class="imager-input">
            <div class="imager-upload"></div>
        </div>
        <div class="tip-text" >
            <p class = "tip-text-message" id ="tip-text-message">还可以输入<a class="text-num">500</a>个字</p>
            <p class = "tip-error-message" id ="tip-error-message">超出字数限制</p>
        </div>
        <button class="receive_message-save" id="message-save">保存</button>
        <button class="receive_message-del" id="message-del">删除回复</button>
    </div>
</div>


<div class="content3" id="content3">
    <input type="hidden" id = "subscribeMessageId" value="${subscribeMessage.id}" >
    <div class="receive_message_content">
        <ul class="weui-desktop-msg-sender__tabs">
            <li class="li contetn3-li-click" onclick="subscribeShow('text',this)" ><a class="li-title">文字</a></li>
            <li class="li" onclick="subscribeShow('imager',this)" > <a class="li-title">图片</a></li>
            <li class="li" onclick="subscribeShow('imager',this)" > <a class="li-title">图文</a></li>
        </ul>
        <!-- 文字 输入div -->
        <div class="text-input" id="subscribeTextInput">
            <div class="text-arce" id="subscribe-arce" contenteditable="true">${subscribeMessage.content}</div>

        </div>

        <!-- 图片上传 div -->
        <div class="imager-input" id="subscribeImageInput">
            <div class="imager-upload"></div>
        </div>
        <div class="tip-text" >
            <p class = "tip-text-message" id ="receive-text-message">还可以输入<a class="text-num">500</a>个字</p>
            <p class = "tip-error-message" id ="receive-error-message">超出字数限制</p>
        </div>
        <button class="receive_message-save" id="subscribe-save">保存</button>
        <button class="receive_message-del" id="subscribe-del">删除回复</button>
    </div>


</div>
<div class="content4" id="content4" >
    <input type="hidden" id = "ruleId">
    <div class="row">
        <label class="lable_title">规则名称</label><input class="rule-input" id="ruleName" type="text" placeholder="请输入规则名称" />
    </div>

    <div class="row" id="row2">
        <label class="lable_title keyword-cotent-title">关键词</label>
        <div class="keyword-content" id="keyword">
            <div class="keyword-content-row">
                <select class="keyword-select">
                    <c:forEach var="wechatKeywordMatchinType" items="${wechatKeywordMatchinTypeMap}"  >
                    <option value="${wechatKeywordMatchinType.key}" >${wechatKeywordMatchinType.value}</option>
                    </c:forEach>
                </select>
                <input type="text" class="keyword-input" placeholder="请输入关键字" />
                <button class="keyword-add" onclick="addkeyword()"><a href="#" class="keyword-add-title" >十</a></button>
                <button class="keyword-del" onclick="delkeyword(this)"><a href="#" class="keyword-del-title">一</a></button>
            </div>
        </div>

    </div>
    <div  style="clear:both"></div>
    <div class="row">
        <label class="lable_title">回复内容</label>
        <!--  <img src="${ctx}/wechat/imager/wx/u1217.png" class="add-icon" id="addIcon" />--> <a id="addIcon" class="add-button-textImage">图文</a> <a id="addText" class="add-button-text">文字</a>
    </div>

    <div class="row">
        <label class="lable_title">回复方式</label>
        <c:forEach items="${wehcatRuleReplyTypeMap}" var="wehcatRuleReplyType" begin="0" varStatus="s">
            <input type="radio"  name="replyType" value="${wehcatRuleReplyType.key}" <c:if test="${s.last}">checked</c:if> />${wehcatRuleReplyType.value}
        </c:forEach>
    </div>

    <div class="row">
        <button class="rule-save">保存</button>
        <button class="rule-canle">取消</button>
    </div>

</div>

</body>
<script type="text/javascript" src="${ctx}/resources/code/js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/plugins/layer/layer.js"></script>
<script type="text/javascript" href="${ctx}/resources/cms/wechat/wechat.js"></script>
<script type="text/javascript">
    var isCheck = ${wechatInfo.openReply==1};
    var addkeywordRowHtml = $("#keyword").html();
    var wechatInfoId = '${wechatInfo.id}';
    var maxInputNum = $(".text-num").html();
    var messageText = '' ;
    var index ;
    var bufferSet = new Set();
    var messageSet = new Set();
    var selectctMessageIdList ;
    $(function(){
        //初始化输入内容字数
        showTextNum("#text-arce","#tip-text-message","#tip-error-message");
        showTextNum("#subscribe-arce","#receive-text-message","#receive-error-message");

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

            var param =new Object();
            if(isCheck==true){
                param.openReply = 1;
            }else{
                param.openReply = 0;
            }
            param.wechatInfoId = wechatInfoId;
            $.ajax({
                type:"post",
                url:"${ctx}/cms/wechat/info/updateOpenReply",
                data:param,
                dataType:"json",
                success:function(result){

                },
            });

        });

        function showButton(obj){
            $(".click").removeClass("click");
            $(obj).addClass("click");
        }

        $("#button1").click(function(){
            showButton(this);

            if(isCheck){
                showContent(1);
            }
            messageSet.clear();

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
            data.id = $("#ruleId").val();
            var ruleName = $("#ruleName").val();
            if(ruleName.length==0||ruleName==''){
                layer.msg('规则名不能为空');
                return ;
            }
            data.ruleName = ruleName;

            var keywordList = $(".keyword-content-row");
            var keywordObjeList =new Array();
            var isNull = false;
            keywordList.each(function(index,obj){
                var matchinType = $(obj).find('.keyword-select').val();
                var keywordContent = $(obj).find('.keyword-input').val();
                var wechatKeyWord = new Object();
                if(keywordContent.length==0||keywordContent==''){
                    isNull = true;
                    return ;
                }
                wechatKeyWord.keyword =  keywordContent;
                wechatKeyWord.matchinType = matchinType;
                keywordObjeList.push(wechatKeyWord);
            });
            if(isNull){
                layer.msg('关键字不能为空');
                return ;
            }

            var messageList = new Array();
            messageSet.forEach(function (element, sameElement, set) {
                messageList.push(element);
            });

            messageSet.clear();
            data.messaegListStr = JSON.stringify(messageList);
            data.keywordListStr = JSON.stringify(keywordObjeList);
            data.replyType =  $("input[name='replyType']:checked").val();
            data.messageText =  messageText;
            data.wechatInfoId = wechatInfoId;
            $.ajax({
                type:"post",
                url:"${ctx}/cms/wechat/rule/save",
                traditional:true,
                data:data,
                dataType:"json",
                success:function(result){
                    if(result.success==true){
                        $("#button1").trigger("click");
                        location.reload();
                        clearEdit();

                    }else{
                        alert("添加失败");
                    }
                }
            });

        });

        $(".rule-canle").click(function(){
            $("#button1").trigger("click");
            messageSet.clear();
            clearEdit();
            $("#keyword").append(addkeywordRowHtml);
        });

        $("#message-save").click(function(){
            var data = new Object();
            var messageContent = $("#text-arce").html();
            data.content = messageContent;
            data.wechatInfoId = wechatInfoId;
            data.status = 0;
            data.messageType = 'text';
            data.purpose = 'defaultRule';
            data.id = $("#defaultMessageId").val();
            if(messageContent.length==0){
                layer.msg('回复内容不能为空');
                return ;

            }
            if(messageContent.length>maxInputNum){
                layer.msg('字数超出限制,不能提交');
                return ;
            }
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

        $("#subscribe-save").click(function(){

            var data = new Object();
            var messageContent = $("#subscribe-arce").html();
            data.content = messageContent;
            data.status = 0;
            data.messageType = 'text';
            data.purpose = 'subscribe';
            data.wechatInfoId = wechatInfoId;
            data.id = $("#subscribeMessageId").val();
            if(messageContent.length==0){
                layer.msg('回复内容不能为空');
                return ;

            }
            if(messageContent.length>maxInputNum){
                layer.msg('字数超出限制,不能提交');
                return ;
            }
            createOrUpdateMessage(data);
        });

        $("#subscribe-del").click(function(){
            $("#subscribe-arce").html("");
            var data = new Object();
            data.status = 1;
            data.purpose = 'subscribe';
            data.wechatInfoId = wechatInfoId;

            data.id = $("#subscribeMessageId").val();
            createOrUpdateMessage(data);

        });

        $("#text-arce").keyup(function(){
            showTextNum("#text-arce","#tip-text-message","#tip-error-message");
        });

        $("#subscribe-arce").keyup(function(){
            showTextNum("#subscribe-arce","#receive-text-message","#receive-error-message");

        });

        $("#addIcon").click(function(){
            var data = new Object();
            data.messageType = 3;
            $.ajax({
                type:"post",
                url:"${ctx}/cms/wechat/message/findMessageDataList",
                traditional:true,
                data:data,
                async:false,
                dataType:"json",
                success:function(result){
                    if(result.success==true){

                        index = layer.open({
                            type: 1,
                            btn:['确定','取消'],
                            btn1:function(index,layero){
                                messageSet = bufferSet;
                                layer.close(index);
                            },

                            skin: 'layui-layer-rim', //加上边框
                            area: ['90%', '80%'], //宽高
                            btnAlign: 'c',
                            content: appendAlertHtml(result.data),
                        });

                    }else{
                        layer.msg('数据加载失败');
                    }
                },
                error:function(){

                },
            });
            //页面层
        });

        //添加文字回复
        $("#addText").click(function(){
            index = layer.open({
                type: 1,
                btn:['确定','取消'],
                btn1:function(index,layero){
                    messageText = $("#input-text").val();
                    layer.close(index);
                },

                skin: 'layui-layer-rim', //加上边框
                area: ['300px', '500px'], //宽高
                btnAlign: 'c',
                content:showeditText(),
            });
        });

    });

    //字数显示
    function showTextNum(textArceId,textMessageId,textErrorId){
        var str = $(textArceId).html();
        if(maxInputNum>=str.length){
            $(textMessageId+" .text-num").html(maxInputNum -str.length);
            $(textMessageId).show();
            $(textErrorId).hide();
        }else{
            $(textMessageId).hide();
            $(textErrorId).show();
        };

    }


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

    function subscribeShow(type,obj){
        $(".contetn3-li-click").removeClass("contetn3-li-click");
        $(obj).addClass("contetn3-li-click");
        $("#subscribeTextInput").hide();
        $("#subscribeImageInput").hide();

        if(type == 'text'){
            $("#subscribeTextInput").show();
        }
        if(type == 'imager'){
            alert("待开发功能");
            $("#subscribeImageInput").show();

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
            },
            error:function(){

            },
        });
    };

    function showeditRule(wechatRuleId) {
        clearEdit();
        var data = new Object();
        data.wechatRuleId = wechatRuleId;
        $.ajax({
            type:"get",
            url:"${ctx}/cms/wechat/rule/getWechatRuleById",
            traditional:true,
            data:data,
            dataType:"json",
            success:function(result){
                if(result.success==true){
                    var ruleData = result.data ;
                    $("#ruleId").val(ruleData.id);
                    $("#ruleName").val(ruleData.ruleName);
                    var keywordList = ruleData.wechatKeywordList;
                    keywordList.forEach(function(value,index,array){
                        appendHtml(value.matchinType,value.keyword);
                    });
                    var replyType = ruleData.replyType;
                    if(replyType=="1"){
                        $("input[name='replyType']:eq(0)").prop("checked",'checked');
                    }
                    if(replyType=="2"){
                        $("input[name='replyType']:eq(1)").prop("checked",'checked');
                    }
                    var messageIdList = ruleData.messageIds;
                    console.log(ruleData);
                    for(var i = 0;i<messageIdList.length;i++){

                        messageSet.add(messageIdList[i]);
                    }
                  //  messageText = ruleData.messageText;
                }
            },
            error:function(){

            },
        });
        showContent(4);

    }

    function appendHtml(selectVal,inputVal) {
        var completelyStr = 'selected' ;
        var containStr = 'selected';
        if(selectVal=='COMPLETELY'){
            containStr = ''
        }else {
            completelyStr = '';
        }

        var html = '<div class="keyword-content-row">'+
            '<select class="keyword-select">' +
            '<option value="completely" '+completelyStr+' >全匹配</option>' +
            '<option value="contain" '+containStr+'>半匹配</option><' +
            '/select>' +
            '<input type="text" class="keyword-input" placeholder="请输入关键字"  value="'+inputVal+'" />' +
            ' <button class="keyword-add" onclick="addkeyword()"><a href="#" class="keyword-add-title" >十</a></button> ' +
            '<button class="keyword-del" onclick="delkeyword(this)"><a href="#" class="keyword-del-title">一</a></button>' +
            '</div>';

        $("#keyword").append(html);


    };
    /** 显示div**/
    function showContent(index){
        $("#content1").hide();
        $("#content2").hide();
        $("#content3").hide();
        $("#content4").hide();
        $("#content"+index).show();

    };

    /**  清空已编辑内容**/
    function clearEdit(){
        $("#ruleId").val('');
        $("#keyword").html('');
        $("#ruleName").val('');
        $("input[name='replyType']:eq(1)").attr("checked",'checked');
        messageText = '';

    }

    function delRule(ruleId){
        var data = new Object();
        data.id = ruleId;

        $.ajax({
            type:"post",
            url:"${ctx}/admin/wechat/delWechatRule.htm",
            traditional:true,
            data:data,
            dataType:"json",
            success:function(result){
                if(result.success==true){

                    location.reload();
                }
            },
            error:function(){

            },
        });

    }

    function appendAlertHtml(data){
        var isShow ;

        var wechatMessageList = data.wechatMessageVoList;
        var html = '<div class="alert"><div class="left-navigation"><p>图文('+data.wechatMessageCount+')</p></div>';
        html += ' <div class="alert-content">';
        for(var i = 0 ;i < wechatMessageList.length;i++){
            var wechatMessage = wechatMessageList[i];
            var content = wechatMessage.content;
            if(content.length>=12){
                content = content.substring(0,8);
            }
            if(messageSet.has(wechatMessage.id)){
                bufferSet.add(wechatMessage.id);
                isShow = 'classShow';
            }else{
                isShow = 'classhide';
            }

            html += ' <div class="message-row" onclick="onMessaegRow(this)">';
            html += '<input type="hidden" value="'+wechatMessage.id+'" />';
            html +='<div class="message-title">'+wechatMessage.title+'</div>';
            html +='<img class="message-image" src="${ctx}/loadFile/'+wechatMessage.imageUrl+'" width="50" height="60">';
            html +='<div class="message-content">'+content +'</div>';
            html +='<div class="message-createTime">更新于 '+wechatMessage.updateTime+' </div>';
            html +='<div class="chekc-Div '+isShow+'" > <img class ="check-image" src="${ctx}/resources/cms/wechat/rule/image/u710.png"></div>';
            html += '</div>';
        }
        html += '</div></div>';
        return html;
    }

    function showeditText(){

        var html = '<div  class="input-text-div"><textarea id = "input-text">'+messageText+'</textarea></div>';
        return html;
    }

    function onMessaegRow(obj){
        var messageid = parseInt($(obj).find('input').val());
        console.log(messageid);
        if ($(obj).find('.chekc-Div').css('display') == 'none') {
            $(obj).find('.chekc-Div').show();
            //  messageSet.add(messageid);
            bufferSet.add(messageid);
        }else{
            $(obj).find('.chekc-Div').hide();
            // var resultFul = messageSet.delete(messageid);
            bufferSet.delete(messageid);
        }
    }
</script>
</html>

