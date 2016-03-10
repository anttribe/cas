<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.category.title" /></title>
        <link rel="stylesheet" type="text/css" href="${contextPath}/assets/jquery-treetable/css/jquery.treetable.css" >
        <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/jquery.treetable.theme.custom.css" >
    </head>
    <body>
        <div class="clearfix"></div>
        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            <spring:message code="app.category.title" />
                            <span class="tools pull-right"></span>
                        </header>
                        <div class="panel-body">
                            <div class="btn-group mb10">
                                <a href="#none" class="btn btn-primary btn-sm action-add"><i class="fa fa-plus"></i> <spring:message code="app.category.action.add" /></a>
                            </div>
                            <div class="table-responsive">
                                <table id="category-table" class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th><spring:message code="app.category.title.name" /></th>
                                            <th width="10%"><spring:message code="app.common.action.operate" /></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:set var="categorys" value="${PAGE_DATA}" scope="request" />
                                        <c:import url="list-items.jsp" />
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </div>
        <!--body wrapper end-->
        
        <script type="text/javascript" src="${contextPath}/assets/jquery-treetable/js/jquery.treetable.js"></script>
        <script type="text/javascript" src="${contextPath}/static/js/category.js"></script>
        <script type="text/javascript">
	        $(function(){
	        	$('.action-add').click(function(){
	        		location.href = '${contextPath}/category/add';
	        	});
	        	$('.action-edit').click(function(e){
	            	e.preventDefault();
	            	
	            	var nTr = $(this).parents('tr');
	            	if(nTr){
	            		var categoryId = $(nTr).attr('data-tt-id');
	            		if(categoryId){
	            			location.href = contextPath + '/category/edit' + '?id=' + categoryId;
	            		}
	            	}
	            });
	        	$('.action-add-child').click(function(e){
	        		e.preventDefault();
	            	
	            	var nTr = $(this).parents('tr');
	            	if(nTr){
	            		var categoryId = $(nTr).attr('data-tt-id');
	            		if(categoryId){
	            			location.href = contextPath + '/category/add' + '?parent.id=' + categoryId;
	            		}
	            	}
	        	});
	        	$('.action-delete').click(function(e){
	            	e.preventDefault();
	            	
	            	var nTr = $(this).parents('tr');
	            	if(nTr){
	            		var categoryId = $(nTr).attr('data-tt-id');
	            		if(categoryId){
	            			BootstrapDialog.confirm({
	            				size: BootstrapDialog.SIZE_NORMAL,
	            				type: BootstrapDialog.TYPE_WARNING,
	            				draggable: true,
	            				closable: true,
	            	            title: '<spring:message code="app.category.title.delete" />',
	            	            message: '<spring:message code="app.category.title.delete.confirm" />',
	            	            callback: function(r) {
	            	                if(r) {
	            	                	$.ajax({
	            	                		type: 'POST',
	            	                		url: '${contextPath}/category/delete/exec',
	            	                		data: {id: categoryId},
	            	                		success: function(r){
	            	                			var result = $.parseJSON(r);
	            	                			if(result && result.resultCode){
	            	        				    	if(result.resultCode == '000000'){
	            	        				    		BootstrapDialog.alert({
	            	        				    			type: BootstrapDialog.TYPE_SUCCESS,
	            	        				    			message: '<spring:message code="app.common.title.success" />',
	            	        				    			callback: function(){
	            	        				    				location.href = '${contextPath}/category/index';
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
	        	//treeTable
	        	$("#category-table").treetable({
	        		column: 0,
	        		expandable: true,
	        		stringExpand: '',
	        		stringCollapse: '',
	        		initialState: 'collapsed'  //expanded
	        	}).show();
	        });
	    </script>
    </body>
</html>