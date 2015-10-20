<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- left side start-->
<div class="left-side sticky-left-side">
    <div class="left-side-inner">
        <!--sidebar nav start-->
        <ul class="nav nav-pills nav-stacked custom-nav">
            <li class="menu-list nav-active"><a href="${contextPath}/"><i class="fa fa-home"></i> <span>Dashboard</span></a></li>
            <li class="menu-list"><a href="#"><i class="fa fa-laptop"></i> <span>Layouts</span></a>
                <ul class="sub-menu-list">
                    <li><a href="blank_page.html"> Blank Page</a></li>
                    <li><a href="boxed_view.html"> Boxed Page</a></li>
                    <li><a href="leftmenu_collapsed_view.html"> Sidebar Collapsed</a></li>
                    <li><a href="horizontal_menu.html"> Horizontal Menu</a></li>
                </ul>
            </li>
        </ul>
        <!--sidebar nav end-->
    </div>
</div>
<!-- left side end-->