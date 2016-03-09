<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.user.title.signin" /></title>
    </head>
    <body class="login-body">
        <div class="container">
            <form class="form-signin" method="POST" action="">
                <div class="form-signin-heading text-center">
                    <h1 class="sign-title"><spring:message code="app.user.title.signin" /></h1>
                    <img src="${contextPath}/static/img/login-logo.png" alt="">
                </div>
                <div class="login-wrap">
                    <div class="form-group">
                        <input type="text" name="username" class="form-control" placeholder="<spring:message code="app.user.title.username" />" autofocus>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="<spring:message code="app.user.title.password" />">
                    </div>
                    <button class="btn btn-lg btn-login btn-block" type="submit"><spring:message code="app.user.title.signin" /></button>
                    <div class="registration">
                        <a class="" href=""><spring:message code="app.user.link.signup" /></a>
                    </div>
                    <label class="checkbox">
                        <input type="checkbox" value=""> <spring:message code="app.user.title.signin.remeberMe" />
                        <span class="pull-right">
                            <a href=""> <spring:message code="app.user.title.forgotpassword" /></a>
                        </span>
                    </label>
                </div>
            </form>
        </div>
    </body>
</html>