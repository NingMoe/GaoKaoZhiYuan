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
                                    专业信息</h3>
                            </div>
                            <div class="module-body table">
                                <table cellpadding="0" cellspacing="0" border="0" class="datatable-1 table table-bordered table-striped	 display"
                                       width="100%">
                                    <thead>
                                    <tr>
                                        <th>
                                            专业代码
                                        </th>
                                        <th>
                                            专业名称
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${majorList}" var="major">
                                    <tr>
                                        <td>${major.id}</td>
                                        <td>${major.name}</td>
                                    </tr>
                                    </c:forEach>

                                    </tfoot>
                                </table>
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
