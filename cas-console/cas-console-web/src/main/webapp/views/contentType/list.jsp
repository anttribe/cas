<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.contentType.title" /></title>
    </head>
    <body>
        <div class="clearfix"></div>
        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            <spring:message code="app.contentType.title" />
                            <span class="tools pull-right"></span>
                        </header>
                        <div class="panel-body">
                            <div class="btn-group">
                                <a href="#none" class="btn btn-primary btn-sm action-add"><i class="fa fa-plus"></i> <spring:message code="app.contentType.action.add" /></a>
                            </div>
                            <div class="clearfix"></div>
                            <div class="mt10 table-responsive">
                                <table id="contentType-table" class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th width="80"><spring:message code="app.common.title.serial" /></th>
                                            <th><spring:message code="app.contentType.title.name" /></th>
                                            <th><spring:message code="app.contentType.title.code" /></th>
                                            <th width="10%"><spring:message code="app.common.action.operate" /></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${PAGE_DATA}" var="contentType" varStatus="s">
                                            <tr data-id="${contentType.id}">
                                                <td><c:out value="${s.index + 1}" /></td>
                                                <td><c:out value="${contentType.name}" /></td>
                                                <td><c:out value="${contentType.code}" /></td>
                                                <td>
                                                    <a href="javascript:void(0);" class="text-primary action-edit" title="<spring:message code="app.common.action.edit" />"><i class="fa fa-edit"></i></a>
                                                    <a href="javascript:void(0);" class="pl10 text-info action-edit-contentAttribute" title="<spring:message code="app.contentType.action.editContentAttribute" />"><i class="fa fa-list-alt"></i></a>
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
        
        <script type="text/javascript" src="${contextPath}/static/static/js/contentType.js"></script>
        <script type="text/javascript">
	        $(function(){
	        	$('.action-add').click(function(){
	        		location.href = '${contextPath}/contentType/add';
	        	});
	        	$('.action-edit', '#contentType-table').click(function(){
	            	var nTr = $(this).parents('tr');
	            	if(nTr){
	            		var contentTypeId = $(nTr).attr('data-id');
	            		if(contentTypeId){
	            			location.href = contextPath + '/contentType/edit' + '?id=' + contentTypeId;
	            		}
	            	}
	            });
	        	$('.action-edit-contentAttribute', '#contentType-table').click(function(){
	            	var nTr = $(this).parents('tr');
	            	if(nTr){
	            		var contentTypeId = $(nTr).attr('data-id');
	            		if(contentTypeId){
	            			location.href = contextPath + '/contentAttribute/list' + '?contentType.id=' + contentTypeId;
	            		}
	            	}
	            });
    			$('.action-delete', '#contentType-table').click(function(){
                	var nTr = $(this).parents('tr');
                	if(nTr){
                		var contentTypeId = $(nTr).attr('data-id');
                		if(contentTypeId){
                			BootstrapDialog.confirm({
                				size: BootstrapDialog.SIZE_NORMAL,
                				type: BootstrapDialog.TYPE_WARNING,
                				draggable: true,
                				closable: true,
                	            title: '<spring:message code="app.contentType.delete.title" />',
                	            message: '<spring:message code="app.contentType.delete.confirm" />',
                	            btnOKClass: 'btn-warning',
                	            callback: function(r) {
                	                if(r) {
                	                	$.ajax({
                	                		type: 'POST',
                	                		url: '${contextPath}/contentType/delete/exec',
                	                		data: {id: contentTypeId},
                	                		success: function(r){
                	                			var result = $.parseJSON(r);
                	                			if(result && result.resultCode){
                	        				    	if(result.resultCode == '000000'){
                	        				    		BootstrapDialog.alert({
                	        				    			type: BootstrapDialog.TYPE_SUCCESS,
                	        				    			message: '<spring:message code="app.common.title.success" />',
                	        				    			callback: function(){
                	        				    				location.href = '${contextPath}/contentType/index';
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
	        });
	    </script>
    </body>
</html>