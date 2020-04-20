<%--
  Created by IntelliJ IDEA.
  User: 12193
  Date: 2020-4-20
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="/register"method="post" style="padding-top:-700px;">
    输入姓名:<input name="name" type="text"><br><br>
    输入密码:<input name="password" type="password"><br><br>
    <input type="reset"value="重置"><input type="submit"value="注册">
</form>
</body>
</html>
