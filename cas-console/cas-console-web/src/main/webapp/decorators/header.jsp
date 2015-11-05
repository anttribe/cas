<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- header section start -->
<div class="header-section">
    <!--logo and iconic logo start-->
    <div class="logo">
        <a href="/"><img src="${contextPath}/static/static/img/logo.png" alt=""></a>
    </div>
    <div class="logo-icon text-center">
        <a href="/"><img src="${contextPath}/static/static/img/logo_icon.png" alt=""></a>
    </div>
    <!--logo and iconic logo end-->

    <!--toggle button start-->
    <a class="toggle-btn"><i class="fa fa-bars"></i></a>
    <!--toggle button end-->

    <!--search start-->
    <form class="searchform" action="index.html" method="post">
        <input type="text" class="form-control" name="keyword" placeholder="Search here..." />
    </form>
    <!--search end-->

    <!--notification menu start -->
    <div class="menu-right">
        <ul class="notification-menu">
            <li>
                <a href="#" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown"><i class="fa fa-tasks"></i><span class="badge">8</span></a>
                <div class="dropdown-menu dropdown-menu-head pull-right">
                    <h5 class="title">task</h5>
                    <ul class="dropdown-list user-list">
                    </ul>
                </div>
            </li>
            <li>
                <a href="#" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown"><i class="fa fa-envelope-o"></i><span class="badge">5</span></a>
                <div class="dropdown-menu dropdown-menu-head pull-right">
                    <h5 class="title">You have 5 Mails </h5>
                    <ul class="dropdown-list normal-list">
                    </ul>
                </div>
            </li>
            <li>
                <a href="#" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown"><i class="fa fa-bell-o"></i><span class="badge">4</span></a>
                <div class="dropdown-menu dropdown-menu-head pull-right">
                    <h5 class="title">Notifications</h5>
                    <ul class="dropdown-list normal-list">
                    </ul>
                </div>
            </li>
            <li>
                <a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <img src="${contextPath}/static/static/img/photos/user-avatar.png" alt="" />
                    John Doe
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu dropdown-menu-usermenu pull-right">
                    <li><a href="#"><i class="fa fa-user"></i>  Profile</a></li>
                    <li><a href="#"><i class="fa fa-cog"></i>  Settings</a></li>
                    <li><a href="#"><i class="fa fa-sign-out"></i> Log Out</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <!--notification menu end -->
</div>
<!-- header section end-->