<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/3/17
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
    <a class="btn btn-default" href="/knowledgeType/create">新增</a>
    <table class="table table-striped table-condensed">
        <thead>
        <tr>
            <th>ID号</th>
            <th>名称</th>
            <th>说明</th>
            <th>创建时间</th>
            <th>更新时间</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${knowledgeTypeVoList}" var="knowledgeTypeVo">
            <tr>
                <td>${knowledgeTypeVo.id}</td>
                <td>${knowledgeTypeVo.name}</td>
                <td>${knowledgeTypeVo.remark}</td>
                <td>${knowledgeTypeVo.createTime}</td>
                <td>${knowledgeTypeVo.updateTime}</td>
                <td><small><a href="/knowledgeType/edit/${knowledgeTypeVo.id}">修改</a>
                <a href="/knowledgeType/delete/${knowledgeTypeVo.id}">删除</a></small></td>
            </tr>
        </c:forEach></tbody>
    </table>
</div>
</body>
</html>
