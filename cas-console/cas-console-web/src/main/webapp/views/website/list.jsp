<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.website.title" /></title>
    </head>
    <body>
        <div class="clearfix"></div>
        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            <spring:message code="app.website.title.list" />
                            <span class="tools pull-right"></span>
                        </header>
                        <div class="panel-body">
                            <div class="search-body">
                                <div class="btn-group">
                                    <a href="${contextPath}/website/add" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i> <spring:message code="app.website.action.add" /></a>
                                </div>
                                <form class="search-form form-inline pull-right" role="form" action="${contextPath}/website/list" method="POST">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input type="text" name="siteName" value="<c:out value="${PARAMS.siteName}" />" class="form-control" placeholder="">
                                            <span class="input-group-btn">
                                                <button type="submit" class="btn btn-search"><i class="fa fa-search"></i></button>
                                            </span>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="clearfix"></div>
                            <div class="mt10 table-responsive">
                                <table id="website-table" class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th width="60%"><spring:message code="app.website.title.siteName" /></th>
                                            <th><spring:message code="app.category.title.category" /></th>
                                            <th><spring:message code="app.common.action.operate" /></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${PAGE_DATA}" var="website">
                                            <tr data-id="${website.id}">
                                                <td>
                                                    <a href="${website.domain}" target="_blank">
                                                        <c:choose>
                                                            <c:when test="${website.logo != null and website.logo != ''}">
                                                                <img alt="" src="${website.logo}" />
                                                            </c:when>
                                                        </c:choose>
                                                        <span><c:out value="${website.siteName}" /></span>
                                                    </a>
                                                </td>
                                                <td><c:out value="${website.category.name}" /></td>
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
        
        <script type="text/javascript" src="${contextPath}/static/static/js/website.js"></script>
        <script type="text/javascript">
            var goEditWebsite = function(e){
            	e.preventDefault();
            	
            	var nTr = $(this).parents('tr');
            	if(nTr){
            		var websiteId = $(nTr).attr('data-id');
            		if(websiteId){
            			location.href = contextPath + '/website/edit' + '?id=' + websiteId;
            		}
            	}
            };
            var goDeleteWebsite = function(e){
            	e.preventDefault();
            	
            	var nTr = $(this).parents('tr');
            	if(nTr){
            		var websiteId = $(nTr).attr('data-id');
            		if(websiteId){
            			BootstrapDialog.confirm({
            				size: BootstrapDialog.SIZE_NORMAL,
            				type: BootstrapDialog.TYPE_WARNING,
            				draggable: true,
            				closable: true,
            	            title: '<spring:message code="app.website.delete.title" />',
            	            message: '<spring:message code="app.website.delete.confirm" />',
            	            btnOKClass: 'btn-warning',
            	            callback: function(r) {
            	                if(r) {
            	                	$.ajax({
            	                		type: 'POST',
            	                		url: '${contextPath}/website/delete/exec',
            	                		data: {id: websiteId},
            	                		success: function(r){
            	                			var result = $.parseJSON(r);
            	                			if(result && result.resultCode){
            	        				    	if(result.resultCode == '000000'){
            	        				    		BootstrapDialog.alert({
            	        				    			type: BootstrapDialog.TYPE_SUCCESS,
            	        				    			message: '<spring:message code="app.common.title.success" />',
            	        				    			callback: function(){
            	        				    				location.href = '${contextPath}/website/index';
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
	        	$('.edit', '#website-table').bind('click', goEditWebsite);
    			$('.delete', '#website-table').bind('click', goDeleteWebsite);
	        });
	    </script>
    </body>
</html>