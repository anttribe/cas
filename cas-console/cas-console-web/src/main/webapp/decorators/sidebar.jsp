<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- left side start-->
<div class="left-side sticky-left-side">
    <div class="left-side-inner">
        <!--sidebar nav start-->
        <ul class="nav nav-pills nav-stacked custom-nav">
            <li><a href="#"><i class="fa fa-dashboard"></i> <span><spring:message code="app.dashboard.title" /></span></a></li>
            <li class="menu-list"><a href="#"><i class="fa fa-laptop"></i> <span><spring:message code="app.website.title" /></span></a>
                <ul class="sub-menu-list">
                    <li><a href="${contextPath}/category/index"> <spring:message code="app.category.title" /></a></li>
                    <li><a href="${contextPath}/website/index"> <spring:message code="app.website.title" /></a></li>
                </ul>
            </li>
            <li class="menu-list"><a href="#"><i class="fa fa-tasks"></i> <span><spring:message code="app.content.title" /></span></a>
                <ul class="sub-menu-list">
                    <li><a href="${contextPath}/contentType/index"> <spring:message code="app.contentType.title" /></a></li>
                    <li><a href="${contextPath}/contentAttribute/index"> <spring:message code="app.contentAttribute.title" /></a></li>
                </ul>
            </li>
            <li><a href="#"><i class="fa fa-bug"></i> <span><spring:message code="app.crawler.title" /></span></a></li>
            <li class="menu-list"><a href="#"><i class="fa fa-cogs"></i> <span><spring:message code="app.system.title" /></span></a>
                <ul class="sub-menu-list">
                </ul>
            </li>
        </ul>
        <!--sidebar nav end-->
    </div>
</div>
<!-- left side end-->