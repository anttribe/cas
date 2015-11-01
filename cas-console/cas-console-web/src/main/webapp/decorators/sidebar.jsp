<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- left side start-->
<div class="left-side sticky-left-side">
    <div class="left-side-inner">
        <!--sidebar nav start-->
        <ul class="nav nav-pills nav-stacked custom-nav">
            <li class="menu-list nav-active"><a href="#"><i class="fa fa-laptop"></i> <span>内容管理</span></a>
                <ul class="sub-menu-list">
                    <li><a href="${contextPath}/category/index"> 分类管理</a></li>
                    <li><a href="${contextPath}/website/index"> 站点管理</a></li>
                </ul>
            </li>
        </ul>
        <!--sidebar nav end-->
    </div>
</div>
<!-- left side end-->