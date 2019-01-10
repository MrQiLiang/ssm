<%--
  Created by IntelliJ IDEA.
  User: qi
  Date: 2017/7/19
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/import-tag.jsp" %>
<html>
<head>
    <title>堂吉诃德网</title>
    <link href="${ctx}/resources/plugins/umeditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="${ctx}/resources/plugins/umeditor/third-party/jquery.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/resources/plugins/umeditor/umeditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/resources/plugins/umeditor/umeditor.min.js"></script>
    <script type="text/javascript" src="${ctx}/resources/plugins/umeditor/lang/zh-cn/zh-cn.js"></script>
</head>

<body>
<!--<script id="container" name="content" type="text/plain">

</script>-->

<button id="openBtn">打开App</button>

</body>
<!-- 配置文件-->
<script type="text/javascript">
   // window.um = UM.getEditor("container");
   var ua = navigator.userAgent.toLowerCase();

   var config = {
       scheme_IOS: 'myscheme://myhost:1024/main',
       scheme_Adr: 'myscheme://myhost:1024/main',
       download_url: 'http://a.app.qq.com/o/simple.jsp?pkgname=aa.bbxxx',
       timeout: 3000
   }

   $(function () {
        plus
        $("#openBtn").on("click",function(){
            location.href="myscheme://myhost:1024/main";
        });

    });

   function  openClient() {
       var  startTime = Date.now();

       var ifr = document.createElement('iframe');
       ifr.src = ua.indexOf('OS')>0?config.scheme_IOS:config.scheme_Adr;
       ifr.style.display='none';
       document.body.appendChild(ifr);

       var t = setTimeout(function(){
           var endTime = Date.now();
           if(!startTime||endTime-startTime<config.timeout+200){
               window.location = config.download_url;
           }else {

           }
       },config.timeout);

       window.onblur = function () {
           clearTimeout(t);
       }
   }

   window.addEventListener("DOMContentLoaded",function () {

   },false);

</script>
</html>
