<%--
  Created by IntelliJ IDEA.
  User: qi
  Date: 2017/7/19
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/import-tag.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>test</title>
 <!--   <link rel="stylesheet" href="https://test.com/index.css" />-->
</head>
<body>
<div class="app">
    <h1>webview-wechat-detail</h1>
    <p>
        detail
    </p>
    <button type="button" id="btn">返回小程序</button>
</div>
<script src="${ctx}/resources/code/js/jquery-2.2.4.min.js"></script>
<script src="https://res.wx.qq.com/open/js/jweixin-1.3.0.js"></script>
<script>
    /* eslint-disable */
    $(function(){
    //    doucument.cookie = 'bb=bbbbbb';
        $("#btn").click(function () {
            alert("测试!");
            wx.miniProgram.navigateTo({
                url:'/pages/test/test',
                success: function(){
                    console.log('success')
                },
                fail: function(){
                    console.log('fail');
                },
                complete:function(){
                    console.log('complete');
                }

            });
        })

    });
</script>
</body>
</html>
