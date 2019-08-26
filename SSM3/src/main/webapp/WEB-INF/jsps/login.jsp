<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/24
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %><!--不加的话不识别el表达式-->
<html>
<head>
    <title>登录</title>
</head>
<body>

    <form action="<c:url value='/login.action'/>" method="post">
        用户名：<input type="text" name="username"/><br/>
        密　码：<input type="password" name="upassword"/><br/>
        <input type="submit" value="登录"/>
    </form>
</body>
</html>
