<%--
  Created by IntelliJ IDEA.
  User: melot
  Date: 2018/4/12
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edmin</title>
    <link type="text/css" href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" href="../bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link type="text/css" href="../css/theme.css" rel="stylesheet">
    <link type="text/css" href="../images/icons/css/font-awesome.css" rel="stylesheet">
    <link type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600' rel='stylesheet'>
</head>
<body>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-inverse-collapse">
                <i class="icon-reorder shaded"></i>
            </a>

            <a class="brand" href="index.html">
                高考志愿填报系统
            </a>

            <div class="nav-collapse collapse navbar-inverse-collapse">

                <ul class="nav pull-right">

                </ul>
            </div><!-- /.nav-collapse -->
        </div>
    </div><!-- /navbar-inner -->
</div><!-- /navbar -->



<div class="wrapper">
    <div class="container">
        <div class="row">
            <div class="module module-login span4 offset4">
                <form class="form-vertical" action="../register/userRegister.do" method="post" id="registerForm">
                    <div class="module-head">
                        <h3>Sign up</h3>
                    </div>
                    <div class="module-body">
                        <div class="control-group">
                            <div class="controls row-fluid">
                                <input class="span12" type="text" name="loginName" placeholder="loginName" id="loginName">
                                <span id="userspan"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls row-fluid">
                                <input class="span12" type="password" name="passwd" placeholder="passwd">
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls row-fluid">
                                <input class="span12" type="text" name="realName" placeholder="realName">
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls row-fluid">
                                <input class="span12" type="text" name="phone" placeholder="phone">
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls row-fluid">
                                <input class="span12" type="text" name="sex" placeholder="sex">
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls row-fluid">
                                <input class="span12" type="text" name="mathScore" placeholder="数学分数">
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls row-fluid">
                                <input class="span12" type="text" name="engScore" placeholder="外语分数">
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls row-fluid">
                                <input class="span12" type="text" name="cnScore" placeholder="语文分数">
                            </div>
                        </div>
                        <div class="control-group">
                            <select class="selectpicker" id="subSelect1" name="subSelect1"
                                    data-width="100%" style="width: 60px;margin-right:  10px">
                                <optgroup label="类别">
                                    <option>物理</option>
                                    <option>化学</option>
                                    <option>生物</option>
                                    <option>技术</option>
                                    <option>政治</option>
                                    <option>历史</option>
                                    <option>地理</option>
                                </optgroup>
                            </select>
                            <div class="controls row-fluid">
                                <input class="span12" type="text" name="xkkmScore1" placeholder="选考科目1成绩">
                            </div>
                        </div>
                        <div class="control-group">
                            <select class="selectpicker" id="subSelect2" name="subSelect2"
                                    data-width="100%" style="width: 60px;margin-right:  10px">
                                <optgroup label="类别">
                                    <option>物理</option>
                                    <option>化学</option>
                                    <option>生物</option>
                                    <option>技术</option>
                                    <option>政治</option>
                                    <option>历史</option>
                                    <option>地理</option>
                                </optgroup>
                            </select>
                            <div class="controls row-fluid">
                                <input class="span12" type="text" name="xkkmScore2" placeholder="选考科目2成绩">
                            </div>
                        </div>
                        <div class="control-group">
                            <select class="selectpicker" id="subSelect3" name="subSelect3"
                                    data-width="100%" style="width: 60px;margin-right:  10px">
                                <optgroup label="类别">
                                    <option>物理</option>
                                    <option>化学</option>
                                    <option>生物</option>
                                    <option>技术</option>
                                    <option>政治</option>
                                    <option>历史</option>
                                    <option>地理</option>
                                </optgroup>
                            </select>
                            <div class="controls row-fluid">
                                <input class="span12" type="text" name="xkkmScore3" placeholder="选考科目3成绩">
                            </div>
                        </div>
                    </div>
                    <div class="module-foot">
                        <div class="control-group">
                            <div class="controls clearfix">
                                <button type="submit" class="btn btn-primary pull-right" id="registerButton">register</button>
                                <label class="checkbox">
                                    <input type="checkbox"> Remember me
                                </label>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div><!--/.wrapper-->

<div class="footer">
    <div class="container">


        <b class="copyright">高考志愿填报系统 </b> All rights reserved.
    </div>
</div>
<script src="../scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="../scripts/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
<script src="../bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../scripts/js/register.js" type="text/javascript"></script>
</body>
</html>
