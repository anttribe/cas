<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<c:if test="${pagination != null and pagination.totalPages > 0 }">
    <div id="pagination">
    </div>
    
    <link rel="stylesheet" type="text/css" href="${contextPath}/static/static/css/bootstrap-paginator.css" />
    <script type="text/javascript" src="${contextPath}/static/assets/bootstrap-paginator/js/bootstrap-paginator.js"></script>
    <script type="text/javascript">
        $(function(){
    	    // 分页
    	    var page = $('#pagination').bootstrapPaginator({
    	    	alignment: 'right',  // left, center and right
    	    	currentPage: parseInt('${pagination.currentPage}' || 0),
    	    	totalPages: parseInt('${pagination.totalPages}' || 0),
    	    	numberOfPages: 5,
    	    	tooltipTitles: function (type, page, current) {
                    switch (type) {
                        case 'first':
                            return '<spring:message code="app.common.pagination.first" />';
                        case 'prev':
                            return '<spring:message code="app.common.pagination.previous" />';
                        case 'next':
                            return '<spring:message code="app.common.pagination.next" />';
                        case 'last':
                            return '<spring:message code="app.common.pagination.last" />';
                        case 'page':
                            return '';
                    }
                },
    	    	onPageClicked: function(event, originalEvent, type, page){
    	    		var currentPage = parseInt('${pagination.currentPage}' || 0);
    	    		if(page != currentPage){
    	    			// 页面搜索表单
        	    		var searchForm = $('#search-form');
        	    		if(searchForm && searchForm.length>0){
        	    			$('<input>', {
        	    				'type': 'hidden',
        	    				'name': 'currentPage'
        	    			}).val(page).appendTo(searchForm);
        	    			$(searchForm).submit();
        	    		} else{
        	    			// 获取当前请求url
         	    			var requestUrl = location.href;
         	    			if(requestUrl){
         	    				var params = {};
         	    				var parameterString = requestUrl.substring(requestUrl.lastIndexOf('?') + 1);
         	    				if(parameterString){
         	    					var parameters = parameterString.split('&');
         	    					if(parameters && parameters.length>0){
         	    						for(var i=0; i<parameters.length; i++){
         	    							var param = parameters[i];
         	    							if(param){
         	    								params[param.substring(0, param.indexOf('='))] = '' + param.substring(param.indexOf('=') + 1);
         	    							}
         	    						}
         	    					}
         	    				}
         	    				params['currentPage'] = page;
         	    				
         	    				var index = 0;
         	    				requestUrl = requestUrl.substring(0, requestUrl.lastIndexOf('?')) + '?';
         	    				for(var paramName in params){
         	    					if(index > 0){
     									requestUrl += '&';
     								}
         	    					requestUrl += paramName + '=' + params[paramName];
     								index++;
         	    				}
         	    				location.href = requestUrl;
         	    			}
        	    		}
    	    		}
    	    	}
    	    });
        });
    </script>
</c:if>
