<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="/jsp/common.jsp" %>
    </head>
<body>

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
                        <div class="module">
                            <div class="module-head">
                                <h3>
                                    高校信息</h3>
                            </div>
                            <div class="module-body table">
                                <tr>
                                    <td>
                                        账号名
                                    </td>
                                    <td>${user.loginName}</td>
                                </tr>
                                <tr>
                                    <td>
                                        真实姓名
                                    </td>
                                    <td>${user.realName}</td>
                                </tr>
                                <tr>
                                    <td>
                                        住址
                                    </td>
                                    <td>${user.address}</td>
                                </tr>
                                <tr>
                                    <td>
                                        电话
                                    </td>
                                    <td>${user.phone}</td>
                                </tr>
                                <tr>
                                    <td>
                                        性别
                                    </td>
                                    <td>${user.sex}</td>
                                </tr>

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


</body>
