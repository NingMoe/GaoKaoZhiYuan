<%--
  Created by IntelliJ IDEA.
  User: melot
  Date: 2018/4/11
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form name="form1" action="/ga/login/userlogin.do" method="post">
        <table width="300" border="1" align="center">
               <tr>
                 <td colspan="2">登入窗口</td>
               </tr>
               <tr>
                   <td>用户名:</td>
                   <td><input type="text" name="loginName">
                   </td>
               </tr>
               <tr>
                   <td>密码:</td>
                   <td><input  type="password" name="passwd"/>
                   </td>
               </tr>
               <tr>
                 <td colspan="2">
                   <input type="submit" name="submit" value="登录"/>
                 </td>

               </tr>
              </table>
    </form>
</body>
</html>
