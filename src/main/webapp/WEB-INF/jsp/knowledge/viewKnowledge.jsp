<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/3/23
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
    <article>
        <header>
            <h2>${knowledgeVo.title}</h2>

            <p class="bottom-solid">分类：${knowledgeVo.knowledgeTypeVo.name}
                &nbsp; &nbsp;发布于：
                <time datetime="${knowledgeVo.createTime}" pubdate>${knowledgeVo.createTime}</time>
            </p>
        </header>
        <p>
            ${knowledgeVo.content}
        </p>
        <footer>
            更新于：
            <time datetime="${knowledgeVo.updateTime}">${knowledgeVo.updateTime}</time>
            &nbsp; &nbsp;
            <small><a href="/knowledge/edit/${knowledgeVo.id}">修改</a>
                <a href="/knowledge/delete/${knowledgeVo.id}">删除</a></small>
        </footer>
    </article>
</div>
</body>
</html>
