<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en_US">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="app.appname" /> - <sitemesh:write property='title'/></title>
        <%@include file="stylesheet.jsp" %>
        <%@include file="javascript.jsp" %>
        <sitemesh:write property='head'/>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <sitemesh:write property='body'/>
        <%@include file="footer.jsp" %>
    </body>
</html>