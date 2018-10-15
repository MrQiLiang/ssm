 <%--
  Created by IntelliJ IDEA.
  User: qi_liang
  Date: 2018/4/28
  Time: 下午5:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../common/import-tag.jsp" %>
<html>
<head>
    <title></title>
    <link href="${ctx}/resources/plugins/tab/css/import_basic.css" type="text/css" rel="stylesheet">
    <link  rel="stylesheet" type="text/css" id="skin" prePath="${ctx}/resources/plugins/tab/" />
</head>
<body>
    <div id="tab_menu" style="height: 30px;"></div>
    <div style="width: 100%">
        <div id="page" style="width: 100%;height: 100%"></div>
    </div>

</body>
<script type="text/javascript" src="${ctx}/resources/plugins/tab/js/jquery-1.7.2.js"></script>
<!-- framework.js 只能用上面版本的jquery，请勿更换-->
<script type="text/javascript" src="${ctx}/resources/plugins/tab/js/framework.js"></script>
<script type="text/javascript" src="${ctx}/resources/plugins/tab/js/tab.js"></script>
<script type="text/javascript">
 var tab;
 $(function () {
     tab = new TabView({
         containerId : 'tab_menu',
         pageid :'page',
         cid:'tab1',
         position:'top'
     });

     tab.add({
         id:'tab1_index1',
         title:'主页',
         url:'${ctx}/cms/sysInfo',
         isClosed:false
     });

 })
 function cmainFrameT(){
            var hmainT = document.getElementById("page");
            var bheightT = document.documentElement.clientHeight;
            console.log(bheightT);
            hmainT .style.width = '100%';
            hmainT .style.height = (bheightT  - 51) + 'px';
        }
 cmainFrameT();
 window.onresize=function(){
            cmainFrameT();
 };
 function tabHandler(mid,mtilte,murl) {
     var obj = new Object();
     obj.id = mid;
     obj.title = mtilte;
     obj.url = murl;
     obj.isClosed = true;

     tab.update({
         id:mid,
         title:mtilte,
         url:murl,
         isClosed:true
     });
     tab.add({
         id:mid,
         title:mtilte,
         url:murl,
         isClosed:true
     });
 }

</script>

</html>
