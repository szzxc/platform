<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/3/19
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>

    <script type="text/javascript">
        $(document).ready(function () {
            $('.selectpicker').selectpicker();
        });
    </script>
</head>
<body>
<div class="container">
    <form:form action="/knowledge/create" commandName="knowledgeVo" method="post">
        <div class="form-group">
            <label for="knowledgeTypeVo.id">知识分类</label>
            <form:select path="knowledgeTypeVo.id" itemLabel="name" itemValue="id"
                         cssClass="selectpicker form-control" items="${knowledgeTypeVoList}"
                         data-live-search="true" />
        </div>
        <div class="form-group">
            <label for="title">标题</label>
            <form:input path="title" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="content">内容</label>
            <form:textarea path="content" cssClass="form-control ckeditor"/>
        </div>
        <input type="submit" name="save" id="save" value="保存" class="btn btn-default"/>
    </form:form>
</div>
</body>
</html>
