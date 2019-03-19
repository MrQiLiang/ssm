<%--
  Created by IntelliJ IDEA.
  User: qi_liang
  Date: 2018/5/10
  Time: 下午9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/import-tag.jsp" %>
<html>
<head>
    <title>手机版网页</title>
    <meta name="apple-itunes-app" content="app-id=432547565">
    <script src="${ctx}/resources/code/js/jquery-1.3.2.min.js" type="text/javascript"></script>
</head>
<body>
    <a href="toapp://aa.bb" id="webtoapp"> 打开手机app</a><br>
    <a href="#" id="webtoapp2"> 打开手机app2</a>
    <script>
        var ua = navigator.userAgent.toLowerCase();
        $(function () {
            var config = {
                scheme_ios : 'myapp://test.com',
                scheme_adr : 'toapp://aa.bb',
                download_url : 'http://192.168.99.135/ssm',
                timeout :3000
            }

            function openClient() {
                //当前时间
                var starTime = Date.now();

                var ifr = document.createElement('iframe');
                ifr.src = ua.indexOf('os')>0 ? config.scheme_ios:config.scheme_adr;
                ifr.style.display = 'none';
                document.body.appendChild(ifr);
                var t = setTimeout(function(){
                   var endTime = Date.now();
                   if (!starTime||endTime-starTime<config.timeout+200){
                       window.location = config.download_url;
                   }
                },config.timeout);
            }

            window.onblur = function () {
                clearTimeout(t);
            }

            $("#webtoapp2").click(function () {
                openClient();
            })
        })



    </script>
</body>

</html>
