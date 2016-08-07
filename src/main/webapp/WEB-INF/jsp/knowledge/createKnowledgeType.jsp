<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/3/18
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
    <form:form action="/knowledgeType/create" commandName="knowledgeTypeVo" method="post">
        <div class="form-group">
            <label for="name">标题</label>
            <form:input path="name" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="remark">说明</label>
            <form:input path="remark" cssClass="form-control"/>
        </div>
        <input type="submit" name="save" id="save" value="保存" class="btn btn-default"/>
    </form:form>
</body>
</html>
