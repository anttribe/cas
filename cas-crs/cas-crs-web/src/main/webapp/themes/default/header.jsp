<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="gadget" uri="/gadget" %>

<!-- header -->
<div class="navbar navbar-default">
    <div class="navbar-inner">
        <a class="navbar-brand" href="${contextPath}">
            <img alt="CAS Logo" src="<c:url value='/static/static/img/logo.png' />" class="hidden-xs"/>
            <span><spring:message code="app.name" /></span>
        </a>
        
        <c:choose>
            <c:when test="${null != USER_SESSION}">
                <!-- user profile -->
                <div class="btn-group pull-right">
                    <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"> user</span>
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#"><spring:message code="app.user.title.profile" /></a></li>
                        <li class="divider"></li>
                        <li><a href=""><spring:message code="app.user.title.logout" /></a></li>
                    </ul>
                </div>
            </c:when>
            <c:otherwise>
                <div class="btn-group pull-right">
                    <a href="${contextPath}/signin"><spring:message code="app.user.title.signin" /></a>
                    <a href="${contextPath}/signup"><spring:message code="app.user.title.signup" /></a>
                </div>
            </c:otherwise>
        </c:choose>

        <!-- theme selector -->
        <ul class="nav navbar-nav pull-right">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-tint"></i></a>
                <ul class="dropdown-menu" id="themes">
                    <c:forEach var="theme" items="${themes}">
                        <li><a data-value="${theme.themeId}" href="#"><i class="whitespace"></i> <spring:message code="${theme.themeName}" /></a></li>
                    </c:forEach>
                </ul>
            </li>
        </ul>

        <ul class="collapse navbar-collapse nav navbar-nav top-menu">
            <li><a class="fb" href="${contextPath}/article"><spring:message code="app.article.title.article" /></a></li>
            <li><a class="fb" href="${contextPath}/site"><spring:message code="app.site.title.site" /></a></li>
            <li><a class="fb" href="${contextPath}/topic"><spring:message code="app.topic.title.topic" /></a></li>
            <li><a class="fb" href="${contextPath}/course"><spring:message code="app.course.title.course" /></a></li>
            <li>
                <form class="navbar-search pull-left">
                    <input placeholder="Search" class="search-query form-control col-md-10" name="query" type="text">
                </form>
            </li>
        </ul>
    </div>
</div>
<div class="clearfix"></div>