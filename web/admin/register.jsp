<%--@elvariable id="formbean" type="silly.admin.formbean.RegisterFormBean"--%>
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
    <title>注册</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/three/bootstrap-3.3.7-dist/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/three/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="${pageContext.request.contextPath}/three/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/register.css">

    <script type="text/javascript">
        window.onload = function(){
            //获取按钮的对象
            var btn = document.getElementById("btn");
            //为按钮绑定单击响应函数
            btn.onclick = function(){
                //点击以后使按钮不可用
                this.disabled=true;
                //当将提交按钮设置为不可用时，会自动取消它的默认行为
                //手动提交表单
                this.parentNode.submit();
            };
        };
    </script>
</head>
<body>
<div class="div1">
    <form class="div2" action="${pageContext.request.contextPath}/register" method="post">
        <input type="text" class="form-control input_name" placeholder="请输入手机号" aria-describedby="basic-addon1"
               name="user_name" value="${formbean.user_name}">
        <input type="text" class="form-control input_pwd" placeholder="请输入密码" aria-describedby="basic-addon1"
               name="password" value="${formbean.password}">
        <div class="div3">
            <input type="text" class="form-control input_code" placeholder="请输入验证码"
                   aria-describedby="basic-addon1"
                   name="code" value="${formbean.code}">
            <div class="div_space"></div>
            <input type="submit" class="btn btn-default" name="type" value="获取">
        </div>
        <p>${formbean.errors}</p>
        <input type="submit" class="btn btn-default button_register" name="type" value="注册" id="btn">
    </form>
</div>
</body>
</html>
