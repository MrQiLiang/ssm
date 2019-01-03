<%--
  Created by IntelliJ IDEA.
  User: qi_liang
  Date: 2018/6/9
  Time: 下午9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>cms 系统信息管理</title>
    <style>
        body{
            background-color: #e9edf6;

        }
        .body-content{
            background-color: #FFFFFF;
            width: 100%;
            height: 100%;
        }
        .content-row{
            float: left;
            background-color: #ffffff;
            width: 40%;
            height: 200px;
            margin: 5px 0px 5px 20px;
        }
        .row-title{
            background-color: #f5f5f5;

        }
        .row-message-talbe{
            width: 100%;
            height: 100%;
        }
        .row-message-talbe-td-title{

        }
    </style>
</head>
<body>
<div class="body-content">
    <div class="content-row">
        <div class ="row-title"> 环境 信息</div>
        <div class="row-message">
            <table class="row-message-talbe" border="1" >
                <tr>
                    <td class="row-message-talbe-td-title">JAVA版本:</td>
                    <td class="row-message-talbe-td-content">${sysInfoVo.jvmInfo.version}</td>
                </tr>
                <tr>
                    <td>数据库版本:</td>
                    <td>${sysInfoVo.dbInfo.name} ${sysInfoVo.dbInfo.version}</td>
                </tr>
                <tr>
                    <td>WEB服务器:</td>
                    <td>${sysInfoVo.serverInfo}</td>
                </tr>
                <tr>
                    <td>CPU个数:</td>
                    <td>${sysInfoVo.jvmInfo.cupNum}</td>
                </tr>
                <tr>
                    <td>虚拟机内存总量</td>
                    <td>${sysInfoVo.jvmInfo.totalMemory/1024/1024}M</td>
                </tr>
            </table>

        </div>
    </div>

    <div class="content-row">
        <div class ="row-title"> 系统 信息</div>
        <div class="row-message">
            <table border="1">
                <tr>
                    <td class="row-message-talbe-td-title">客户端IP:</td>
                    <td class="row-message-talbe-td-content">${sysInfoVo.userIP}</td>
                </tr>
                <tr>
                    <td>服务器IP:</td>
                    <td>${sysInfoVo.sysIp}</td>
                </tr>
                <tr>
                    <td>操作系统:</td>
                    <td>${sysInfoVo.osInfo.osName} ${sysInfoVo.osInfo.osVersion}</td>
                </tr>
            </table>

        </div>
    </div>



</div>
</body>
</html>