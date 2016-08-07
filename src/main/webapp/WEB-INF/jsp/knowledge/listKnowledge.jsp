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
            $("body").highlight($("#title").val().split(" "));
        });
    </script>
</head>
<body>
<div class="container">
    <div>
        <form:form action="/knowledge/list" commandName="knowledgeFilter" method="post"
                   class="form-inline">
            <form:select path="knowledgeTypeFilter.id"
                         cssClass="selectpicker form-inline" data-live-search="true">
                <form:option value="" label="查所有分类的知识"/>
                <form:options items="${knowledgeTypeVoList}" itemLabel="name" itemValue="id"/>
            </form:select>
            <form:input path="title" cssClass="form-control" placeholder="关键字"/>
            <input type="submit" class="btn btn-info" value="找找看"/>
            <a class="btn btn-default" href="/knowledge/create">新增一条知识</a>
        </form:form>
    </div>

    <c:forEach items="${knowledgeVoList}" var="knowledgeVo">
        <article>
            <header>
                <h2><a href="/knowledge/view/${knowledgeVo.id}">${knowledgeVo.title}</a></h2>

                <p class="bottom-solid">分类：${knowledgeVo.knowledgeTypeVo.name}
                    &nbsp; &nbsp;发布于：
                    <time datetime="${knowledgeVo.createTime}" pubdate>${knowledgeVo.createTime}</time>
                </p>
            </header>
            <p>

            <div class="content-summary">${knowledgeVo.content}</div>
            </p>
            <footer>
                更新于：
                <time datetime="${knowledgeVo.updateTime}">${knowledgeVo.updateTime}</time>
                &nbsp; &nbsp;
                <small><a href="/knowledge/edit/${knowledgeVo.id}">修改</a>
                    <a href="/knowledge/delete/${knowledgeVo.id}">删除</a></small>
            </footer>
        </article>
    </c:forEach>
</div>
</body>
</html>
