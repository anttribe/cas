<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<c:forEach items="${menus}" var="menu">
    <c:if test="${menu.resourceType == 'MENU' or menu.resourceType == 'PAGE'}">
        <li class="<c:if test="${fn:length(menu.children) > 0}">menu-list</c:if>">
            <c:choose>
                <c:when test="${menu.resourceUrl != null and menu.resourceUrl != ''}">
                    <a href="${menu.resourceUrl}" target="_${fn:toLowerCase(menu.target)}">
                </c:when>
                <c:otherwise>
                    <a href="javascript:void(0);">
                </c:otherwise>
            </c:choose>
                <c:if test="${menu.icon != null and menu.icon != ''}"><i class="${menu.icon}"></i> </c:if>
                <c:choose>
                    <c:when test="${level == 0}">
                        <span><c:out value="${menu.name}" /></span>
                    </c:when>
                    <c:otherwise><c:out value="${menu.name}" /></c:otherwise>
                </c:choose>
            </a>
	        <c:if test="${fn:length(menu.children) > 0}">
                <c:set var="menus" value="${menu.children}" scope="request" />
                <c:set var="level" value="${level + 1}" scope="request" />
                <ul class="sub-menu-list">
                    <c:import url="menu-items.jsp" />
                </ul>
            </c:if>
	    </li>
    </c:if>
</c:forEach>
<c:set var="level" value="${level - 1}" scope="request" />