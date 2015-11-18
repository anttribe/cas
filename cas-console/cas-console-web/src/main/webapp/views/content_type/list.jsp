<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.appname" /></title>
        <link rel="stylesheet" type="text/css" href="${contextPath}/static/assets/bootstrap3-dialog/css/bootstrap-dialog.min.css" >
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
                            <div class="btn-group mb10">
                                <a href="${contextPath}/contentType/goAdd" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i> <spring:message code="app.contentType.action.add" /></a>
                            </div>
                            <div class="table-responsive">
                                <table id="contentType-table" class="display table table-striped">
                                    <thead>
                                        <tr>
                                            <th><spring:message code="app.contentType.title.name" /></th>
                                            <th><spring:message code="app.contentType.title.code" /></th>
                                            <th><spring:message code="app.common.action.operate" /></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </div>
        <!--body wrapper end-->
        
        <script type="text/javascript" src="${contextPath}/static/assets/bootstrap3-dialog/js/bootstrap-dialog.min.js"></script>
        <script type="text/javascript" src="${contextPath}/static/static/js/contentType.js"></script>
        <script type="text/javascript">
            var listContentTypes = function(){
            	cas.contentType.listContentTypes(function(datas){
	        		if(datas && datas.length>0){
	        			var $html = '';
	        			for(var i=0; i<datas.length; i++){
	        				var contentType = datas[i];
	        				if(contentType){
	        					$html += '<tr data-id="' + contentType['id'] + '">' 
		        				       + '<td>' + (contentType['name'] || '') + '</td>'
		        				       + '<td>' + (contentType['code'] || '') + '</td>'
		        				       + '<td><a href="javascript:void(0);" class="edit"><i class="fa fa-edit"></i><spring:message code="app.common.action.edit" /></a><a href="javascript:void(0);" class="pl5 delete"><i class="fa fa-trash-o"></i><spring:message code="app.common.action.delete" /></a></td>'
		        				       + '</tr>';
	        				}
	        			}
	        			if($html){
	        				$('tbody', '#contentType-table').empty().append($html);
	        			}
	        			$('.edit', '#contentType-table').click(goEditContentType);
	        			$('.delete', '#contentType-table').click(goDeleteContentType);
	        		}
	        	});
            };
            var goEditContentType = function(){
            	var nTr = $(this).parents('tr');
            	if(nTr){
            		var contentTypeId = $(nTr).attr('data-id');
            		if(contentTypeId){
            			cas.contentType.goEditContentType(contentTypeId);
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
            	            btnCancelLabel: '<spring:message code="app.common.action.cancel" />',
            	            btnOKLabel: '<spring:message code="app.common.action.confirm" />',
            	            btnOKClass: 'btn-warning',
            	            callback: function(result) {
            	                if(result) {
            	                	cas.contentType.deleteContentType(contentTypeId);
            	                }
            	            }
            	        });
            		}
            	}
            };
        </script>
        <script type="text/javascript">
	        $(function(){
	        	listContentTypes();
	        });
	    </script>
    </body>
</html>