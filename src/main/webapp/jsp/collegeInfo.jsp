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
                    <table cellpadding="0" cellspacing="0" border="0" class="datatable-1 table table-bordered table-striped	 display"
                           width="100%">
                        <thead>
                        <tr>
                            <th>
                                高校代码
                            </th>
                            <th>
                                高校名称
                            </th>
                            <th>
                                高校所在城市
                            </th>
                            <th>
                                高校详细介绍
                            </th>
                            <th>
                                高校分类
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${collegeList}" var="college">
                        <tr>
                            <td>${college.id}</td>
                            <td>${college.name}</td>
                            <td>${college.sf}</td>
                            <td>${college.detail}</td>
                            <td>${college.type}</td>
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
