<%--@elvariable id="formbean" type="silly.admin.formbean.LoginFormBean"--%>
<%--
  Created by IntelliJ IDEA.
  User: SillySnnall
  Date: 2018/9/3
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/three/bootstrap-3.3.7-dist/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/three/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="${pageContext.request.contextPath}/three/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/login.css">
</head>
<body>
<div class="div1">
    <form class="div2" action="${pageContext.request.contextPath}/login" method="post">
        <input type="text" class="form-control input_name" placeholder="请输入手机号" aria-describedby="basic-addon1"
               name="user_name" value="${formbean.user_name}">
        <input type="text" class="form-control input_pwd" placeholder="请输入密码" aria-describedby="basic-addon1"
               name="password" value="${formbean.password}">
        <p>${formbean.errors}</p>
        <input type="submit" class="btn btn-default button_login" value="登陆">
    </form>
</div>
</body>
</html>
