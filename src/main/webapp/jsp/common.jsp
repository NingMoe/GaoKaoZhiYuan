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
        <link type="text/css" href="../images/icons/css/font-awesome.css" rel="stylesheet">
        <link type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600'
              rel='stylesheet'>
    </head>
<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-inverse-collapse">
                <i class="icon-reorder shaded"></i></a><a class="brand" >${user.realName}</a>
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
                            <li><a href="${pageContext.request.contextPath}/jsp/userBaseInfo.jsp">个人基本信息</a></li>
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
    <div class="container">
        <div class="row">
            <div class="span3">
                <div class="sidebar">
                    <ul class="widget widget-menu unstyled">
                        <li class="active"><a id="collegeAll"><i class="menu-icon icon-dashboard"></i>查询高校信息
                        </a></li>
                        <li><a id="majorAll"><i class="menu-icon icon-bullhorn"></i>查询专业信息</a>
                        </li>
                    </ul>

                    <ul class="widget widget-menu unstyled">
                        <li><a href="ui-button-icon.html"><i class="menu-icon icon-bold"></i> 查询往年一分一段表 </a></li>
                        <li><a href="ui-typography.html"><i class="menu-icon icon-book"></i>查询往年高校招生计划 </a></li>
                        <li><a href="ui-typography.html"><i class="menu-icon icon-book"></i>填报志愿 </a></li>
                    </ul>
                </div>
                <!--/.sidebar-->
            </div>
            <!--/.span3-->
            <div class="span9">
                <div class="content">
                    <div class="btn-controls">


                        <!--/.module-->
                        <div class="module hide">
                            <div class="module-head">
                                <h3>
                                    Adjust Budget Range</h3>
                            </div>
                            <div class="module-body">
                                <div class="form-inline clearfix">
                                    <a href="#" class="btn pull-right">Update</a>
                                    <label for="amount">
                                        Price range:</label>
                                    &nbsp;
                                    <input type="text" id="amount" class="input-" />
                                </div>
                                <hr />
                                <div class="slider-range">
                                </div>
                            </div>
                        </div>
                    </div>
                        <div class="module">
                            <div class="module-head" id="table_head">
                            </div>
                            <div class="module-body table">
                                <table cellpadding="0" cellspacing="0" border="0" class="datatable-1 table table-bordered table-striped	 display"
                                       width="100%">
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
    <script src="../scripts/js/common.js" type="text/javascript"></script>
    <script src="../scripts/js/college.js" type="text/javascript"></script>
    <script src="../scripts/js/major.js" type="text/javascript"></script>
    <script src="../scripts/datatables/jquery.dataTables.js" type="text/javascript"></script>
</body>
