<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.contentAttribute.title" /></title>
    </head>
    <body>
        <div class="clearfix"></div>
        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            <spring:message code="app.contentAttribute.title" />
                            <span class="tools pull-right"></span>
                        </header>
                        <div class="panel-body">
                            <div class="search-body">
                                <div class="btn-group mb10">
                                    <a href="#none" class="btn btn-primary btn-sm action-add"><i class="fa fa-plus"></i> <spring:message code="app.contentAttribute.action.add" /></a>
                                </div>
                                <form id="search-form" class="form-inline pull-right" role="form" action="${contextPath}/contentAttribute/list" method="POST">
                                    <div class="btn-group">
					                    <input type="hidden" name="contentType.id" value="${PARAM.contentType.id}">
					                    <button type="button" data-toggle="dropdown" class="btn btn-default dropdown-toggle"><i class="fa fa-list"></i>
					                        <c:choose>
					                            <c:when test="${null != PARAM.contentType and null != PARAM.contentType.id}">
					                                <c:forEach items="${contentTypes}" var="contentType">
					                                    <c:if test="${contentType.id == PARAM.contentType.id}"><c:out value="${contentType.name}" /></c:if>
						                            </c:forEach>
					                            </c:when>
					                            <c:otherwise><spring:message code="app.common.title.all" /></c:otherwise>
					                        </c:choose>
					                    </button>
						                <ul id="contentType-selector" class="dropdown-menu">
						                    <li data-value=""><a href="#none"><spring:message code="app.common.title.all" /></a></li>
						                    <c:forEach items="${contentTypes}" var="contentType">
						                        <li data-value="${contentType.id}"><a href="#none"><c:out value="${contentType.name}" /></a></li>
						                    </c:forEach>
						                </ul>
					                </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input type="text" name="name" value="<c:out value="${PARAMS.name}" />" class="form-control" placeholder="">
                                            <span class="input-group-btn">
                                                <button type="submit" class="btn btn-search"><i class="fa fa-search"></i></button>
                                            </span>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="clearfix"></div>
                            <div class="mt10 table-responsive">
                                <table id="contentAttribute-table" class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th width="80"><spring:message code="app.common.title.serial" /></th>
                                            <th><spring:message code="app.contentAttribute.title.name" /></th>
                                            <th><spring:message code="app.contentType.title.contentType" /></th>
                                            <th width="10%"><spring:message code="app.common.action.operate" /></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${PAGE_DATA}" var="contentAttribute" varStatus="s">
                                            <tr data-id="${contentAttribute.id}">
                                                <td><c:out value="${s.index + 1}" /></td>
                                                <td><c:out value="${contentAttribute.name}" /></td>
                                                <td><c:out value="${contentAttribute.contentType.name}" /></td>
                                                <td>
                                                    <a href="javascript:void(0);" class="text-primary action-edit" title="<spring:message code="app.common.action.edit" />"><i class="fa fa-edit"></i></a>
                                                    <a href="javascript:void(0);" class="pl10 text-danger action-delete" title="<spring:message code="app.common.action.delete" />"><i class="fa fa-trash-o"></i></a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <%@include file="../components/pagination.jsp" %>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </div>
        <!--body wrapper end-->
        
        <script type="text/javascript" src="${contextPath}/static/js/contentAttribute.js"></script>
        <script type="text/javascript">
	        $(function(){
	        	$('.action-add').click(function(){
	        		location.href = '${contextPath}/contentAttribute/add';
	        	});
	        	$('.action-edit', '#contentAttribute-table').click(function(){
		        	var nTr = $(this).parents('tr');
		        	if(nTr){
		        		var contentAttributeId = $(nTr).attr('data-id');
		        		if(contentAttributeId){
		        			location.href = contextPath + '/contentAttribute/edit' + '?id=' + contentAttributeId;
		        		}
		        	}
		        });
    			$('.action-delete', '#contentAttribute-table').click(function(){
    	        	var nTr = $(this).parents('tr');
    	        	if(nTr){
    	        		var contentAttributeId = $(nTr).attr('data-id');
    	        		if(contentAttributeId){
    	        			BootstrapDialog.confirm({
    	        				size: BootstrapDialog.SIZE_NORMAL,
    	        				type: BootstrapDialog.TYPE_WARNING,
    	        				draggable: true,
    	        				closable: true,
    	        	            title: '<spring:message code="app.contentAttribute.delete.title" />',
    	        	            message: '<spring:message code="app.contentAttribute.delete.confirm" />',
    	        	            btnOKClass: 'btn-warning',
    	        	            callback: function(r) {
    	        	                if(r) {
    	        	                	$.ajax({
                	                		type: 'POST',
                	                		url: '${contextPath}/contentAttribute/delete/exec',
                	                		data: {id: contentAttributeId},
                	                		success: function(r){
                	                			var result = $.parseJSON(r);
                	                			if(result && result.resultCode){
                	        				    	if(result.resultCode == '000000'){
                	        				    		BootstrapDialog.alert({
                	        				    			type: BootstrapDialog.TYPE_SUCCESS,
                	        				    			message: '<spring:message code="app.common.title.success" />',
                	        				    			callback: function(){
                	        				    				location.href = '${contextPath}/contentAttribute/index';
                	        				    			}
                	        				    		});
                	        				    	} else{
                	        				    		BootstrapDialog.alert({
                	        				    			type: BootstrapDialog.TYPE_WARNING,
                	        				    			message: '<spring:message code="app.errorNo.000001" />'
                	        				    		});
                	        				    	}
                	        				    } else{
                	        				    	BootstrapDialog.alert({
                	        				    		type: BootstrapDialog.TYPE_WARNING,
                	        				    		message: '<spring:message code="app.errorNo.000001" />'
                	    				    		});
                	        				    }
                	                		}
                	                	});
    	        	                }
    	        	            }
    	        	        });
    	        		}
    	        	}
    	        });
    			
    			$('li', '#contentType-selector').click(function(){
    				var categoryId = $(this).attr('data-value');
    				$('input[name="contentType.id"]').val(categoryId);
					$('#search-form').submit();
    			});
	        });
	    </script>
    </body>
</html>