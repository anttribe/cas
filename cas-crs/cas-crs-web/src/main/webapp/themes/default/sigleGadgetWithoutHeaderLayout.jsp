<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="layout" uri="/layout" %>

<!DOCTYPE HTML>
<html lang="en">
    <head>
        <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
        <meta content="IE=edge" http-equiv="X-UA-Compatible">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <title><spring:message code="teamwork.appname" /></title>
        <%@include file="stylesheet.jsp" %>
        <%@include file="javascript.jsp" %>
    </head>
    <body>
        <div class="container-fluid center-block">
            <layout:position name="center">
                <layout:positionRender />
            </layout:position>
        </div>
    </body>
</html>