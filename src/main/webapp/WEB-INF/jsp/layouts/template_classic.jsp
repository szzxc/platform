<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/3/10
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%
    String contextPath = request.getContextPath();
    String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><tiles:getAsString name="title"/></title>
    <link href="<%=path%>css/classic.css" rel="stylesheet"/>
    <link href="<%=path%>plugins/bootstrap-select/dist/css/bootstrap-select.min.css" rel="stylesheet" />
    <link href="<%=path%>plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>

    <script src="<%=path%>plugins/jquery/jquery-1.11.2.min.js" type="text/javascript"></script>

    <script src="<%=path%>plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

    <script src="<%=path%>plugins/bootstrap-select/dist/js/bootstrap-select.min.js" type="text/javascript"/>
    <%--下面的不能去掉！用了select插件后bootstrap.min.js需要再引一次，否则页面出错，原因不明！--%>
    <script src="<%=path%>plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

    <script src="<%=path%>plugins/jquery-highlight/jquery-highlight.js" type="text/javascript"></script>

    <script src="<%=path%>plugins/ckeditor/ckeditor.js" type="text/javascript"></script>
</head>
<body>
<div>
    <tiles:insertAttribute name="top"/>
</div>
<div>
    <tiles:insertAttribute name="body"/>
</div>
<div>
    <tiles:insertAttribute name="bottom"/>
</div>
</body>
</html>
