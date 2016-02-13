<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<c:if test="${pagination != null}">
    <div id="pagination"></div>
    
    <script type="text/javascript" src="${contextPath}/static/assets/bootstrap-paginator/js/bootstrap-paginator.js"></script>
    <script type="text/javascript">
        $(function(){
    	    // 分页
    	    $('#pagination').bootstrapPaginator({
    	    	alignment: 'right',  // left, center and right
    	    	currentPage: parseInt('${pagination.currentPage}' || 0),
    	    	totalPages: parseInt('${pagination.totalPages}' || 0),
    	    	numberOfPages: 5,
    	    	onPageClicked: function(){
    	    	}
    	    });
        });
    </script>
</c:if>
