<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="gadget" uri="/gadget" %>
<div id="header" class="navbar-default navbar-fixed-top navbar-top">
    <div class="container-fluid">
        <div class="collapse navbar-collapse">
            <div class="navbar-header">
                <a href="#none" class="navbar-brand">
                    <img src="<c:url value='/static/${currentSite.theme.themePath}/img/logo.png' />">
                </a>
            </div>
            <div class="navbar-right pr10">
                <c:choose>
                    <c:when test="${null != USER_SESSION}">
                        <ul class="nav navbar-nav tools">
                            <li class="tool-item"><a href="#" title='<spring:message code="teamwork.page.message" />'><i class="icon glyphicon glyphicon-envelope"></i></a></li>
                            <li class="dropdown tool-item">
                                <a href="#" class="dropdown-toggle avatar" data-toggle="dropdown" role="button" aria-expanded="false" title="${USER_SESSION.username}">
                                    <img alt="${USER_SESSION.username}" src="${contextPath}${USER_SESSION.avatar}" />
                                    <span class="caret"></span>
                                </a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#"><i class="icon glyphicon glyphicon-cog"></i>settings</a></li>
                                    <li><a href="<gadget:actionUrl mode="/signin/signout" />"><i class="icon glyphicon glyphicon-log-out"></i><spring:message code="app.user.title.logout" /></a></li>
                                </ul>
                            </li>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        <a type="button" href="${contextPath}/${currentSite.name}/signin" class="btn btn-primary navbar-btn"><spring:message code="app.user.title.signin" /></a>
                        <a type="button" href="${contextPath}/${currentSite.name}/signup" class="btn btn-success navbar-btn"><spring:message code="app.user.title.signup" /></a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>
<div class="clearfix"></div>