<%--
  Created by IntelliJ IDEA.
  User: qi_liang
  Date: 2018/4/28
  Time: 下午4:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="sidebar" id="sidebar">
    <script type="text/javascript">
        try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
    </script>

    <div class="sidebar-shortcuts" id="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="icon-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="icon-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="icon-group"></i>
            </button>

            <button class="btn btn-danger">
                <i class="icon-cogs"></i>
            </button>
        </div>

        <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div><!-- #sidebar-shortcuts -->

    <ul class="nav nav-list">
        <c:forEach var="menuItem" items="${menusList}">
            <li>
                <a href="#" class="dropdown-toggle">
                    <i class="${menuItem.icon}"></i>
                    <span class="menu-text"> ${menuItem.menuname} </span>

                    <b class="arrow icon-angle-down"></b>
                </a>

                <ul class="submenu">
                    <c:forEach var="menu" items="${menuItem.menus}">
                        <li>
                            <a href="#" onclick="openTagWin('${menu.menuid}','${menu.menuname}','${menu.url}')">
                                <i class="icon-double-angle-right"></i>
                                    ${menu.menuname}
                            </a>
                        </li>
                    </c:forEach>

                </ul>
            </li>
        </c:forEach>


    </ul><!-- /.nav-list -->

    <div class="sidebar-collapse" id="sidebar-collapse">
        <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
    </div>

    <script type="text/javascript">
        try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
    </script>
    <script type="text/javascript">
        function openTagWin(id,menuName,url) {
        //    alert(url);
            mainFrame.window.tabHandler(id,menuName,url);
        }
    </script>
</div>