<%--
  User: ihorlt
  Date: 18.07.16
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:importAttribute name="javascripts"/>
<tiles:importAttribute name="stylesheets"/>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><tiles:insertAttribute name="title" /></title>
    <!-- stylesheets -->
    <c:forEach var="css" items="${stylesheets}">
        <link rel="stylesheet" type="text/css" href="<spring:url value="${css}"/>">
    </c:forEach>
    <!-- end stylesheets -->
</head>
<body>
<div class="page">
    <tiles:insertAttribute name="header" />
    <div class="content">
        <tiles:insertAttribute name="menu" />
        <div class="container-fluid">
            <tiles:insertAttribute name="content" />
        </div>
    </div>
    <tiles:insertAttribute name="footer" />
</div>

<!-- scripts -->
<c:forEach var="script" items="${javascripts}">
    <script src="<c:url value="${script}"/>"></script>
</c:forEach>
<!-- end scripts -->
</body>
</html>