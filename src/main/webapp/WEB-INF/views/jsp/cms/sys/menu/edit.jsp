<%--
  Created by IntelliJ IDEA.
  User: qi_liang
  Date: 2018/1/28
  Time: 下午10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../common/import-tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>编辑</title>
    <script type="text/javascript">
        $(function () {
            $("#menuIco").val('${sysResource.menuIco}');
        })
    </script>
    <link rel="stylesheet" href="${ctx}/resources/aceAdmin/assets/css/font-awesome.min.css" />
</head>
<body>
    <div style="margin:20px 0;"></div>
        <div style="padding:10px 60px 20px 60px">
                <table cellpadding="4">
                    <input type="hidden" value="${sysResource.id}" id="id">
                    <tr>
                        <td>上级目录:</td>
                        <td>
                            <select class="easyui-combobox" id="parentId" <c:if test="${sysResource.parentId==0}">disabled="disabled"</c:if>   >
                                <option value="0"  <c:if test="${sysResource.parentId==0}">selected</c:if>   >顶级目录</option>
                                <c:forEach var="menu" items="${menuList}">
                                <option value="${menu.id}"  <c:if test="${menu.id==sysResource.parentId}">selected</c:if>  onclick="showUrlPath()" >${menu.menuName}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr id="tr_urlPath">
                        <td>路径:</td>
                        <td><input class="easyui-textbox" type="text" id="urlPath" data-options="required:true" value="${sysResource.urlPath}"></input></td>
                    </tr>
                    <tr>
                        <td>排序:</td>
                        <td><input class="easyui-textbox" type="text" id="sort" data-options="required:true'" value="${sysResource.sort}"></input></td>
                    </tr>
                    <tr>
                        <td>目录名称:</td>
                        <td><input class="easyui-textbox" type="text" id="menuName" data-options="required:true" value="${sysResource.menuName}" ></input></td>
                    </tr>

                    <tr>
                        <td >目录图标:</td>
                        <td >
                            <select id="menuIco" class="easyui-combobox">

                            </select>
                           <!--
                            <div id="menuIco">

                            </div>
                            -->
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>
                                <i class="icon-pencil"></i>
                        </td>
                    </tr>

                </table>
    </div>
</body>
<script type="text/javascript">
    var selectIco = '${sysResource.menuIco}';

    $(function () {
        addControlFunction();
        appendSelect();
    });
    
    function addControlFunction() {

        $('#parentId').combobox({
            onChange: function (newValue, oldValue) {
                if(newValue==0){
                    $("#tr_urlPath").hide();
                }else{
                    $("#tr_urlPath").show();
                }
            }
        });
    }
    
    function appendSelect() {
        var valArray = new Array(
            'icon-asterisk','icon-ban-circle','icon-bar-chart','icon-barcode','icon-beaker',
            'icon-beer','icon-bell','icon-bell-alt','icon-bolt','icon-book','icon-bookmark',
            'icon-bookmark-empty','icon-briefcase','icon-bullhorn','icon-calendar','icon-camera',
            'icon-camera-retro','icon-certificate','icon-check','icon-check-empty','icon-circle',
            'icon-circle-blank','icon-cloud','icon-cloud-download','icon-cloud-upload','icon-coffee',
            'icon-cog','icon-cogs','icon-comment','icon-comment-alt','icon-comments','icon-comments-alt',
            'icon-credit-card','icon-dashboard','icon-desktop','icon-download','icon-download-alt',
            'icon-edit','icon-envelope','icon-envelope-alt','icon-exchange','icon-exclamation-sign',
            'icon-external-link','icon-eye-close','icon-eye-open','icon-facetime-video','icon-fighter-jet',
            'icon-film','icon-filter','icon-fire','icon-flag','icon-folder-close','icon-folder-open',
            'icon-folder-close-alt','icon-folder-open-alt','icon-food','icon-gift','icon-glass','icon-globe',
            'icon-group','icon-hdd','icon-headphones','icon-heart','icon-heart-empty','icon-home',
            'icon-inbox','icon-info-sign','icon-key','icon-leaf','icon-laptop','icon-legal',
            'icon-lemon','icon-lightbulb','icon-lock','icon-unlock');

        var html = '';
        var  isSelect = '';
        for (var i = 0 ; i <valArray.length ; i++){
            if(selectIco==valArray[i]){
                isSelect = 'selected';
            }else {
                isSelect = '';
            }
           html+= '<option value="'+valArray[i]+'" '+isSelect+'>'+valArray[i]+'</option>';
            // html+= '<i class='+valArray[i]+'></i>';
        }
        $("#menuIco").append(html);
    }

</script>
</html>
