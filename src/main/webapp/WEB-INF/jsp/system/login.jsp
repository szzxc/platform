<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/3/17
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>

</head>
<body>
<div class="container">
    <form:form commandName="loginVo" action="/login" method="post">
        <div class="form-group">
            <label for="account">帐号</label>
            <form:input path="account" cssClass="form-control" placeHolder="Account"/>
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <form:input path="password" cssClass="form-control" placeHolder="Password"/>
        </div>
        <input type="submit" class="btn btn-default" value="登录">
    </form:form>
</div>
</body>
</html>
