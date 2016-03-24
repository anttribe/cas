<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.crawler.title" /></title>
    </head>
    <body>
        <div class="clearfix"></div>
        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            <spring:message code="app.crawler.title" />
                            <span class="tools pull-right"></span>
                        </header>
                        <div class="panel-body">
                            <div class="search-body">
                                <div class="btn-group">
                                    <a href="#none" class="btn btn-primary btn-sm action-add"><i class="fa fa-plus"></i> <spring:message code="app.crawler.action.add" /></a>
                                </div>
                                <form class="search-form form-inline pull-right" role="form" action="${contextPath}/crawler/list" method="POST">
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
                                <table id="crawler-table" class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th width="80"><spring:message code="app.common.title.serial" /></th>
                                            <th><spring:message code="app.crawler.title.title" /></th>
                                            <th><spring:message code="app.crawler.title.website" /></th>
                                            <th><spring:message code="app.crawler.title.contentType" /></th>
                                            <th width="120"><spring:message code="app.crawler.title.state" /></th>
                                            <th><spring:message code="app.crawler.title.crawlTime" /></th>
                                            <th width="10%"><spring:message code="app.common.action.operate" /></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${PAGE_DATA}" var="crawler" varStatus="s">
                                            <tr data-id="${crawler.id}">
                                                <td><c:out value="${s.index + 1}" /></td>
                                                <td><c:out value="${crawler.title}" /></td>
                                                <td><c:out value="${crawler.website.siteName}" /></td>
                                                <td><c:out value="${crawler.contentType.name}" /></td>
                                                <td><spring:message code="app.crawler.state.${crawler.state}" text="" /></td>
                                                <td><fmt:formatDate value="${crawler.crawlTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                                <td>
                                                    <a href="#none" class="text-primary action-edit" title="<spring:message code="app.common.action.edit" />"><i class="fa fa-edit"></i></a>
                                                    <c:if test="${crawler.state == 'INIT' or crawler.state == 'STOP'}">
                                                        <a href="#none" class="pl10 text-success action-startup" title="<spring:message code="app.common.action.startup" />"><i class="fa fa-play"></i></a>
                                                    </c:if>
                                                    <c:if test="${crawler.state == 'RUNNING'}">
                                                        <a href="#none" class="pl10 text-warning action-stop" title="<spring:message code="app.common.action.stop" />"><i class="fa fa-pause"></i></a>
                                                    </c:if>
                                                    <a href="#none" class="pl10 text-danger action-delete" title="<spring:message code="app.common.action.delete" />"><i class="fa fa-trash-o"></i></a>
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
        
        <script type="text/javascript" src="${contextPath}/static/js/crawler.js"></script>
        <script type="text/javascript">
	        $(function(){
	        	$('.action-add').click(function(){
	        		location.href = '${contextPath}/crawler/add';
	        	});
	        	$('.action-delete').click(function(e){
	        		e.preventDefault();
	            	
	            	var nTr = $(this).parents('tr');
	            	if(nTr){
	            		var crawlerId = $(this).parents('tr').attr('data-id');
	            		if(crawlerId){
                			BootstrapDialog.confirm({
                				size: BootstrapDialog.SIZE_NORMAL,
                				type: BootstrapDialog.TYPE_WARNING,
                				draggable: true,
                				closable: true,
                	            title: '<spring:message code="app.website.action.delete.title" />',
                	            message: '<spring:message code="app.website.action.delete.confirm" />',
                	            btnOKClass: 'btn-warning',
                	            callback: function(r) {
                	                if(r) {
                	                	$.ajax({
                	                		type: 'POST',
                	                		url: '${contextPath}/crawler/delete/exec',
                	                		data: {id: crawlerId},
                	                		success: function(r){
                	                			var result = $.parseJSON(r);
                	                			if(result && result.resultCode){
                	        				    	if(result.resultCode == '000000'){
                	        				    		BootstrapDialog.alert({
                	        				    			type: BootstrapDialog.TYPE_SUCCESS,
                	        				    			message: '<spring:message code="app.common.title.success" />',
                	        				    			callback: function(){
                	        				    				location.href = '${contextPath}/crawler/index';
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
	        	$('.action-startup').click(function(e){
	        		e.preventDefault();
	        		var nTr = $(this).parents('tr');
	            	if(nTr){
	            		var crawlerId = $(this).parents('tr').attr('data-id');
	            		if(crawlerId){
	            			cas.crawler.startup({id: crawlerId});
	            		}
	            	}
	        	});
	        	$('.action-stop').click(function(e){
	        		e.preventDefault();
	        		var nTr = $(this).parents('tr');
	            	if(nTr){
	            		var crawlerId = $(this).parents('tr').attr('data-id');
	            		if(crawlerId){
	            			cas.crawler.stop({id: crawlerId});
	            		}
	            	}
	        	});
	        });
	    </script>
    </body>
</html>