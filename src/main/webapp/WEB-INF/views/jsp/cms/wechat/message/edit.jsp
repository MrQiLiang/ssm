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

        <tr>
            <td>消息内容:</td>
            <td><input class="easyui-textbox" type="text" id="content" data-options="required:true" value="${wechatMessage.content}"/></td>
        </tr>

        <tr>
            <td>素材ID:</td>
            <td><input class="easyui-textbox" type="text" id="imageUrl" data-options="required:true'" value="${wechatMessage.mediaId}"/></td>
        </tr>

        <tr>
            <td>消息跳转链接:</td>
            <td><input class="easyui-textbox" type="text" id="mediaId" data-options="required:true" value="${wechatMessage.toUrl}" /></td>
        </tr>

    </table>
</div>
</body>
</html>
