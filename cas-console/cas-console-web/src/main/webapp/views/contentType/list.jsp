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
                            <spring:message code="app.contentType.title.list" />
                            <span class="tools pull-right"></span>
                        </header>
                        <div class="panel-body">
                            <div class="btn-group">
                                <a href="${contextPath}/contentType/add" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i> <spring:message code="app.contentType.action.add" /></a>
                            </div>
                            <div class="clearfix"></div>
                            <div class="mt10 table-responsive">
                                <table id="contentType-table" class="display table table-striped">
                                    <thead>
                                        <tr>
                                            <th><spring:message code="app.contentType.title.name" /></th>
                                            <th><spring:message code="app.contentType.title.code" /></th>
                                            <th width="10%"><spring:message code="app.common.action.operate" /></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${PAGE_DATA}" var="contentType">
                                            <tr data-id="${contentType.id}">
                                                <td><c:out value="${contentType.name}" /></td>
                                                <td><c:out value="${contentType.code}" /></td>
                                                <td>
                                                    <a href="javascript:void(0);" class="text-primary edit" title="<spring:message code="app.common.action.edit" />"><i class="fa fa-edit"></i></a>
                                                    <a href="javascript:void(0);" class="pl10 text-danger delete" title="<spring:message code="app.common.action.delete" />"><i class="fa fa-trash-o"></i></a>
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
            var goEditContentType = function(){
            	var nTr = $(this).parents('tr');
            	if(nTr){
            		var contentTypeId = $(nTr).attr('data-id');
            		if(contentTypeId){
            			location.href = contextPath + '/contentType/edit' + '?id=' + contentTypeId;
            		}
            	}
            };
            var goDeleteContentType = function(){
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
            };
        </script>
        <script type="text/javascript">
	        $(function(){
	        	$('.edit', '#contentType-table').click(goEditContentType);
    			$('.delete', '#contentType-table').click(goDeleteContentType);
	        });
	    </script>
    </body>
</html>