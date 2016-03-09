<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<c:forEach items="${categorys}" var="category">
    <tr data-tt-id="${category.id}" data-tt-parent-id="${category.parent.id}" data-tt-branch="${fn:length(category.children) > 0}">
        <td><c:out value="${category.name}" /></td>
        <td>
            <a href="#none" class="text-primary action-edit" title="<spring:message code="app.common.action.edit" />"><i class="fa fa-edit"></i></a>
            <a href="${contextPath}/category/add?parent.id=${category.id}" class="pl10 text-info" title="<spring:message code="app.category.action.addChild" />"><i class="fa fa-list-alt"></i></a>
            <a href="javascript:void(0);" class="pl10 text-danger action-delete" title="<spring:message code="app.common.action.delete" />"><i class="fa fa-trash-o"></i></a>
        </td>
    </tr>
    <c:if test="${fn:length(category.children) > 0}">
        <c:set var="categorys" value="${category.children}" scope="request" />
        <c:import url="list-items.jsp" />
    </c:if>
</c:forEach>