<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- header section start -->
<div class="header-section">
    <!--logo and iconic logo start-->
    <div class="logo">
        <a href="${contextPath}/"><img src="${contextPath}/static/static/img/logo.png" alt=""></a>
    </div>
    <div class="logo-icon text-center">
        <a href="${contextPath}/"><img src="${contextPath}/static/static/img/logo_icon.png" alt=""></a>
    </div>
    <!--logo and iconic logo end-->

    <!--toggle button start-->
    <a class="toggle-btn"><i class="fa fa-bars"></i></a>
    <!--toggle button end-->

    <c:if test="null != USER_SESSION">
        <!--notification menu start -->
        <div class="menu-right">
            <ul class="notification-menu">
                <li>
                    <a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        <c:choose>
                            <c:when test="null != USER_SESSION.avatar">
                                <img src="USER_SESSION.avatar" alt="avatar" />
                            </c:when>
                            <c:otherwise>
                                <img src="${contextPath}/static/static/img/photos/user-avatar.png" alt="avatar" />
                            </c:otherwise>
                        </c:choose>
                        <c:out value="${USER_SESSION.username}"></c:out>
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-usermenu pull-right">
                        <li><a href="#"><i class="fa fa-user"></i> <spring:message code="app.user.title.profile" /></a></li>
                        <li><a href="#"><i class="fa fa-cog"></i> <spring:message code="app.user.title.settings" /></a></li>
                        <li><a href="#"><i class="fa fa-sign-out"></i> <spring:message code="app.user.action.signout" /></a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <!--notification menu end -->
    </c:if>
</div>
<!-- header section end-->