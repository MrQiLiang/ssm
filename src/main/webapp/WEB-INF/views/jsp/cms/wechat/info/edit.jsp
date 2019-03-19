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
    <title>微信公众号详情编辑</title>
</head>
<body>
<div style="margin:20px 0;"></div>
<div style="padding:10px 60px 20px 60px">
    <table cellpadding="4">
        <input type="hidden" value="${wechatInfo.id}" id="id">
        <tr>
            <td>微信名称:</td>
            <td>
                <input  type="text" id ="wechatName" value="${wechatInfo.wechatName}">
            </td>
        </tr>

        <tr>
            <td>微信openId:</td>
            <td>
                <input  type="text" id ="wechatOpenId" value="${wechatInfo.wechatOpenId}">
            </td>
        </tr>

        <tr>
            <td>appId:</td>
            <td><input class="easyui-textbox" type="text" id="appId" data-options="required:true" value="${wechatInfo.appId}"/></td>
        </tr>

        <tr>
            <td>appSecpet:</td>
            <td><input class="easyui-textbox" type="text" id="appSecpet" data-options="required:true'" value="${wechatInfo.appSecpet}"/></td>
        </tr>

        <tr>
            <td>token:</td>
            <td><input class="easyui-textbox" type="text" id="token" data-options="required:true" value="${wechatInfo.token}" /></td>
        </tr>


        <tr>
            <td>消息加密类型:</td>
            <td>
                <select id="encodingType" >
                    <c:forEach items="${encodingTypeMap}" var="encoding">
                        <option <c:if test="${wechatInfo.encodingType == encoding.key}">selected</c:if> value="${encoding.key}">${encoding.value}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>消息加密key:</td>
            <td><input class="easyui-textbox" type="text" id="encodingAesKey" data-options="required:true" value="${wechatInfo.encodingAesKey}" /></td>
        </tr>
        <tr>
            <td>url:</td>
            <td><input class="easyui-textbox" type="text" id="url" data-options="required:true" value="${wechatInfo.url}" /></td>
        </tr>

        <tr>
            <td>公众号类型:</td>
            <td>
                <select id="wechatInfoType" >
                    <c:forEach items="${wechatInfoTypeMap}" var="wechatInfoType">
                        <option <c:if test="${wechatInfo.wechatInfoType == wechatInfoType.key}">selected</c:if> value="${wechatInfoType.key}">${wechatInfoType.value}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

    </table>
</div>
</body>
</html>
