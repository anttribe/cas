<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
        <meta name="keywords" content="<spring:message code="app.keywords" />">
        <meta name="description" content="<spring:message code="app.description" />">
        <title><spring:message code="app.appname" /> - <sitemesh:write property='title'/></title>
        <%@include file="stylesheet.jsp" %>
        <%@include file="javascript-required.jsp" %>
        <sitemesh:write property='head'/>
    </head>
    <body class="login-body">
        <sitemesh:write property='body'/>
        <%@include file="javascript.jsp" %>
    </body>
</html>