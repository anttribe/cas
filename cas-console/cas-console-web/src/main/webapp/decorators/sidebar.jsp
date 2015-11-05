<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- left side start-->
<div class="left-side sticky-left-side">
    <div class="left-side-inner">
        <!--sidebar nav start-->
        <ul class="nav nav-pills nav-stacked custom-nav">
            <li class="menu-list nav-active"><a href="#"><i class="fa fa-laptop"></i> <span>站点管理</span></a>
                <ul class="sub-menu-list">
                    <li><a href="${contextPath}/category/index"> 站点分类</a></li>
                    <li><a href="${contextPath}/website/index"> 站点管理</a></li>
                </ul>
            </li>
            <li class="menu-list nav-active"><a href="#"><i class="fa fa-laptop"></i> <span>内容管理</span></a>
                <ul class="sub-menu-list">
                    <li><a href="${contextPath}/content_type/index"> 内容类型</a></li>
                    <li><a href="${contextPath}/category/index"> 内容属性</a></li>
                    <li><a href="${contextPath}/website/index"> 站点内容</a></li>
                </ul>
            </li>
            <li><a href="#"><i class="fa fa-laptop"></i> <span>爬虫管理</span></a></li>
            <li class="menu-list nav-active"><a href="#"><i class="fa fa-laptop"></i> <span>系统管理</span></a>
                <ul class="sub-menu-list">
                </ul>
            </li>
        </ul>
        <!--sidebar nav end-->
    </div>
</div>
<!-- left side end-->