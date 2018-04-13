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
                        修改账号密码</h3>
                </div>
                <div class="module-body table">
                    <form name="form1" action="${pageContext.request.contextPath}/user/changeInfo.do" method="post">
                        <table cellpadding="0" cellspacing="0" border="0" class="datatable-1 table table-bordered table-striped	 display"
                           width="100%">

                            <tr>
                                <td>用户名:</td>
                                <td><input type="text" name="loginName" placeholder=${user.loginName}>
                                </td>
                            </tr>
                            <tr>
                                <td>密码:</td>
                                <td><input  type="password" name="passwd" placeholder="${user.passwd}"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type="submit" name="submit" value="修改"/>
                                </td>

                            </tr>
                         </table>
                    </form>
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
