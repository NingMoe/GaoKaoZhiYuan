<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>高考志愿填报</title>
        <link type="text/css" href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link type="text/css" href="../bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link type="text/css" href="../css/theme.css" rel="stylesheet">
        <link type="text/css" href="../css/page.css" rel="stylesheet">
        <link type="text/css" href="../images/icons/css/font-awesome.css" rel="stylesheet">
        <link type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600'
              rel='stylesheet'>
    </head>
<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-inverse-collapse">
                <i class="icon-reorder shaded"></i></a><a class="brand" >${admin.loginName}</a>
            <span id="userInfoId" style="display: none">${admin.id}</span>
            <div class="nav-collapse collapse navbar-inverse-collapse">
                <ul class="nav nav-icons">
                    <li class="active"><a href="#"><i class="icon-envelope"></i></a></li>
                    <li><a href="#"><i class="icon-eye-open"></i></a></li>
                    <li><a href="#"><i class="icon-bar-chart"></i></a></li>
                </ul>
                <form class="navbar-search pull-left input-append" action="#">
                    <input type="text" class="span3">
                    <button class="btn" type="button">
                        <i class="icon-search"></i>
                    </button>
                </form>
                <ul class="nav pull-right">
                    <li class="nav-user dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="../images/user.png" class="nav-avatar" />
                        <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a id="userInfo" >个人基本信息</a></li>
                            <li><a href="${pageContext.request.contextPath}/jsp/changeInfo.jsp">修改账号密码</a></li>
                            <li class="divider"></li>
                            <li><a href="#">注销</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.nav-collapse -->
        </div>
    </div>
    <!-- /navbar-inner -->
</div>
<!-- /navbar -->
<div class="wrapper">
    <div class="container" style="width: 1770px">
        <div class="row">
            <div class="span3">
                <div class="sidebar">
                    <ul class="widget widget-menu unstyled">
                        <li class="active"><a id="collegeAll"><i class="menu-icon icon-dashboard"></i>高校信息管理
                        </a></li>
                        <li><a id="majorAll"><i class="menu-icon icon-bullhorn"></i>专业信息管理</a>
                        </li>
                    </ul>

                    <ul class="widget widget-menu unstyled">
                        <li><a id="planAll"><i class="menu-icon icon-bold"></i> 高校招生计划管理 </a></li>
                        <li><a id="rankAll"><i class="menu-icon icon-bold"></i> 高校排名管理 </a></li>
                        <li><a id="policyAll"><i class="menu-icon icon-bold"></i> 政策信息管理 </a></li>
                        <li><a id="userAll"><i class="menu-icon icon-bold"></i> 用户信息管理 </a></li>
                    </ul>
                </div>
                <!--/.sidebar-->
            </div>
            <!--/.span3-->
            <div class="span9" style="width: 1470px">
                <div class="content">
                    <div class="btn-controls">
                    </div>
                    <form class="navbar-search pull-left input-append" action="#" style="float: right;">
                        <div class="form-group" style="float:  left;">
                            <%--<label for="rankSelect" class="col-sm-3 control-label" style="float:  left;">排名</label>--%>
                            <div class="col-sm-9">
                                <select class="selectpicker" id="rankSelect" name="rankSelect"
                                        data-width="100%" style="width:  100px;margin-right:  50px">
                                    <optgroup label="类别">
                                        <option>综合</option>
                                        <option>法学</option>
                                        <option>工学</option>
                                        <option>管理学</option>
                                        <option>教育学</option>
                                        <option>经济学</option>
                                        <option>理学</option>
                                        <option>历史学</option>
                                        <option>农学</option>
                                        <option>文学</option>
                                        <option>医学</option>
                                        <option>哲学</option>
                                    </optgroup>
                                </select>
                            </div>
                        </div>
                        <input style="height: 30px;" type="text" class="span3" id="searchInput" placeholder="高校名查询">
                        <button class="btn" type="button" id="searchBtn">
                            <i class="icon-search"></i>
                        </button>
                        <button class="btn" style="margin-left: 10px;" type="button" id="compareBtn">
                            高校对比
                        </button>
                        <button class="btn" style="margin-left: 10px;" type="button" id="addBtn">
                            新增
                        </button>
                        <button class="btn" style="margin-left: 10px;" type="button" id="homeBtn">
                            回到首页
                        </button>
                    </form>
                    <div id="talkdiv" style="display: none">
                        Welcome<br/><textarea id="text" type="text"></textarea>
                        <button onclick="send()">发送消息</button>
                        <hr/>
                        <button onclick="closeWebSocket()">关闭WebSocket连接</button>
                        <hr/>
                        <p id = "pid">${user.realName}</p>
                        <div id="message" style="width: 500px;;height:500px; overflow:auto;"></div>
                    </div>
                    <div>
                        <form id="addForm" action="#" method="post" style="display: none">
                            <table id = "addTable"  cellpadding="0" cellspacing="0" border="0" class="datatable-1 table table-bordered table-striped	 display"
                                   width="100%" style="table-layout:  fixed;">

                            </table>
                        </form>
                        <form id="updateForm" action="#" method="post" style="display: none">
                            <table id = "updateTable"  cellpadding="0" cellspacing="0" border="0" class="datatable-1 table table-bordered table-striped	 display"
                                   width="100%" style="table-layout:  fixed;">

                            </table>
                        </form>
                    </div>
                    <div class="module">
                        <div class="module-head" id="table_head">
                        </div>
                        <div class="module-body table">
                            <table cellpadding="0" cellspacing="0" border="0" class="datatable-1 table table-bordered table-striped	 display"
                                   width="100%" style="table-layout:  fixed;">
                                <thead>

                                </thead>

                                <tbody>

                                </tbody>
                                <tfoot>
                                </tfoot>
                            </table>

                            <div id="pageCount"></div>
                        </div>
                    </div>
                    <!--/.module-->
                </div>
                <!--/.content-->
            </div>
            <!--/.span9-->
        </div>
    </div>
    <!--/.container-->
</div>
<!--/.wrapper-->
<div class="footer">
</div>

<script src="../scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="../scripts/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
<script src="../bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../scripts/flot/jquery.flot.js" type="text/javascript"></script>
<script src="../scripts/flot/jquery.flot.resize.js" type="text/javascript"></script>
<script src="../scripts/js/admin/common_admin.js" type="text/javascript"></script>
<script src="../scripts/js/admin/userShow.js" type="text/javascript"></script>
<script src="../scripts/js/admin/college.js" type="text/javascript"></script>
<script src="../scripts/js/admin/major.js" type="text/javascript"></script>
<script src="../scripts/js/admin/collegePlan.js" type="text/javascript"></script>
<script src="../scripts/datatables/jquery.dataTables.js" type="text/javascript"></script>
</body>
