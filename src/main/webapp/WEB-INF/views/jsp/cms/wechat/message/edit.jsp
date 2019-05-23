<%--
  Created by IntelliJ IDEA.
  User: qi_liang
  Date: 2018/6/5
  Time: 下午11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../common/import-tag.jsp"%>
<html>
<head>
    <title>微信公众号消息编辑</title>
</head>
<body>
<div style="margin:20px 0;"></div>
<div style="padding:10px 60px 20px 60px">
    <table cellpadding="4">
        <input type="hidden" value="${wechatMessage.id}" id="id">
        <tr>
            <td>消息类型:</td>
            <td>
                <select id="messageType" >
                    <c:forEach items="${wechatMessageTypeMap}" var="wechatMessageType">
                        <option <c:if test="${wechatMessage.messageType == wechatMessageType.key}">selected</c:if> value="${wechatMessageType.key}">${wechatMessageType.value}</option>
                    </c:forEach>
                </select>
             </td>
        </tr>

        <tr>
            <td>消息标题:</td>
            <td>
                <input  type="text" id ="title" value="${wechatMessage.title}">
            </td>
        </tr>

        <tr id="tr_content">
            <td>文本内容:</td>
            <td>
                <textarea id="content">${wechatMessage.content}</textarea>
               <!-- <input class="easyui-textbox" data-options="multiline:true" value="${wechatMessage.content}" style="width:300px;height:100px">-->
                <!--<input class="easyui-textbox" type="text" id="content" data-options="required:true" value="${wechatMessage.content}"/>-->
            </td>
        </tr>

        <tr id="tr_imageUrl">
            <td>图片文件:</td>
            <td><input class="easyui-textbox" type="file" id="imageUrl" data-options="required:true"/></td>
        </tr>

        <tr id="tr_cropedBigImg">
            <td colspan="2" align="center">
                <img src="" id="cropedBigImg" style="display:none;width: 200px;height: 200px;">
            </td>

        </tr>


        <tr>
            <td>素材ID:</td>
            <td><input class="easyui-textbox" type="text" id="mediaId" data-options="required:true'" value="${wechatMessage.mediaId}"/></td>
        </tr>

        <tr>
            <td>消息跳转链接:</td>
            <td><input class="easyui-textbox" type="text" id="toUrl" data-options="required:true" value="${wechatMessage.toUrl}" /></td>
        </tr>

    </table>
</div>
</body>
<script type="text/javascript">
    $(function () {
        $('#imageUrl').on('change', function() {//当chooseImage的值改变时，执行此函数
            var filePath = $(this).val(), //获取到input的value，里面是文件的路径
                fileFormat = filePath.substring(filePath.lastIndexOf(".")).toLowerCase(),
                src = window.URL.createObjectURL(this.files[0]); //转成可以在本地预览的格式

            // 检查是否是图片
            if(!fileFormat.match(/.png|.jpg|.jpeg/)) {
                layer.msg('上传错误,文件格式必须为：png/jpg/jpeg');
                return;
            }else{
                $('#cropedBigImg').css('display','block');
                $('#cropedBigImg').attr('src', src);
            }
        });
        var messageType = '${wechatMessage.messageType}';
        if (messageType==null||messageType==''){
            messageType = '1';
            $("#messageType").val(messageType);
        }
        showMessageTypeInput(messageType);

        $("#messageType").on("change",function () {
            console.log("================");
            var messageType = $(this).val();
            console.log(messageType);
            showMessageTypeInput(messageType);
        })


    });

    function showMessageTypeInput(messageType) {
        console.log(messageType);
        switch (messageType){
            case '2':
                $("#tr_imageUrl").show();
                $("#tr_cropedBigImg").show();
                $("#tr_content").hide();
                ;break;
            case '1':
                $("#tr_imageUrl").hide();
                $("#tr_content").show();
                $("#tr_cropedBigImg").show();
                ;break;
            case '3':
                $("#tr_imageUrl").show();
                $("#tr_cropedBigImg").show();
                $("#tr_content").show();
                ;break;
        }
    }
</script>
</html>
