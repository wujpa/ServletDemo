<%--
  Created by IntelliJ IDEA.
  User: wujiaqi
  Date: 2020-4-10
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/servlet/servletdemo4" method="post">
    用户名：<input type="text" name="name"><br/>
    密码：<input type="password" name="password"><br/>
    <input type="submit" value="提交">
</form>

<form action="register.jsp">
    <input type="submit" value="新用户注册">
</form>
</body>
</html>
