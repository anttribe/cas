<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="layout" uri="/layout" %>

<!DOCTYPE HTML>
<html lang="en">
    <head>
        <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
        <meta content="IE=edge" http-equiv="X-UA-Compatible">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title><spring:message code="app.name" /> - <spring:message code="app.description" /></title>
        <%@include file="stylesheet.jsp" %>
        <%@include file="javascript.jsp" %>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="sa-container center-block">
            <div>
                <layout:position name="sidebar">
                    <layout:positionRender />
                </layout:position>
            </div>
            <div>
                <layout:position name="center">
                    <layout:positionRender />
                </layout:position>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>