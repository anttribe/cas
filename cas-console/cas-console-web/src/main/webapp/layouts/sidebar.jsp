<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- left side start-->
<div class="left-side sticky-left-side">
    <!--logo and iconic logo start-->
    <div class="logo">
        <a href="${contextPath}/"><img src="${contextPath}/static/img/logo.png" alt=""></a>
    </div>
    <div class="logo-icon text-center">
        <a href="${contextPath}/"><img src="${contextPath}/static/img/logo_icon.png" alt=""></a>
    </div>
    <!--logo and iconic logo end-->
    
    <div id="menus" class="left-side-inner">
        <!--sidebar nav start-->
        <ul class="nav nav-pills nav-stacked custom-nav">
            <c:set var="menus" value="${MENUS}" scope="request" />
            <c:set var="level" value="0" scope="request" />
            <c:import url="menu-items.jsp" />
        </ul>
        <!--sidebar nav end-->
    </div>
</div>
<!-- left side end-->
<script type="text/javascript">
    $(function(){
    	var requestURL = window.location.href;
        requestURL = requestURL.substring(0, requestURL.indexOf('?') > 0 ? requestURL.indexOf('?') : requestURL.length);
        if(requestURL){
        	var menuAs = $('a', '#menus');
        	if(menuAs && menuAs.length > 0){
        		for(var i=0; i<menuAs.length; i++){
        			var menuA = menuAs[i];
        			var match = false;
        			if(menuA && menuA['href']){
        				var href = menuA['href'];
        				if(href == requestURL){
        					match = true;
        				} else if(requestURL.endsWith(href)){
        					match = true;
        				}
        				if(match){
        					$(menuA).parents('li').addClass('active');
        					break;
        				}
        			}
        		}
        	}
        }
    });
</script>