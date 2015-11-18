<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.appname" /></title>
        <link rel="stylesheet" type="text/css" href="${contextPath}/static/assets/adminEx/js/data-tables/DT_bootstrap.css" >
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
                            <spring:message code="app.website.title.list" />
                            <span class="tools pull-right"></span>
                        </header>
                        <div class="panel-body">
                            <div class="btn-group mb10">
                                <a href="${contextPath}/website/goAdd" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i> <spring:message code="app.website.action.add" /></a>
                            </div>
                            <div class="adv-table">
                                <table id="website-table" class="display table table-striped">
                                    <thead>
                                        <tr>
                                            <th><spring:message code="app.website.title.siteName" /></th>
                                            <th><spring:message code="app.website.title.domain" /></th>
                                            <th><spring:message code="app.category.title.category" /></th>
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
        
        <script type="text/javascript" src="${contextPath}/static/assets/jquery-datatable/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="${contextPath}/static/assets/adminEx/js/data-tables/DT_bootstrap.js"></script>
        <script type="text/javascript" src="${contextPath}/static/static/js/datatable_ext.js"></script>
        <script type="text/javascript" src="${contextPath}/static/assets/bootstrap3-dialog/js/bootstrap-dialog.min.js"></script>
        <script type="text/javascript" src="${contextPath}/static/static/js/website.js"></script>
        <script type="text/javascript">
            var showWebsiteDetail = function(website){
            	if(website){
            		return '<table>' 
            		     + '<tr>' + '<td><spring:message code="app.website.title.siteName" />:</td><td>' + (website['siteName'] || '') + '</td>' + '</tr>'
            		     + '<tr>' + '<td><spring:message code="app.website.title.domain" />:</td><td>' + (website['domain'] || '') + '</td><td><spring:message code="app.category.title.category" />:</td><td>' + ((website['category'] && website['category']['name']) || '') + '</td>' + '</tr>'
            		     + '<tr>' + '<td><spring:message code="app.website.title.charset" />:</td><td>' + (website['charset'] || '') + '</td><td><spring:message code="app.website.title.userAgent" />:</td><td>' + (website['userAgent'] || '') + '</td>' + '</tr>'
            		     + '</table>';
            	}
            };
            var goEditWebsite = function(){
            	var nTr = $(this).parents('tr');
            	if(nTr){
            		var websiteId = $(nTr).attr('data-id');
            		if(websiteId){
            			cas.website.goEditWebsite(websiteId);
            		}
            	}
            };
            var goDeleteWebsite = function(){
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
            	            btnCancelLabel: '<spring:message code="app.common.action.cancel" />',
            	            btnOKLabel: '<spring:message code="app.common.action.confirm" />',
            	            btnOKClass: 'btn-warning',
            	            callback: function(result) {
            	                if(result) {
            	                	cas.website.deleteWebsite(websiteId);
            	                }
            	            }
            	        });
            		}
            	}
            };
        </script>
        <script type="text/javascript">
	        $(function(){
	        	cas.website.listWebsites({}, function(websites){
	        		if(websites && websites.length>0){
	        			var $html = '';
	        			for(var i=0; i<websites.length; i++){
	        				var website = websites[i];
	        				if(website){
	        					$html += '<tr data-id="' + website['id'] + '">' 
		        				       + '<td>' + (website['siteName'] || '') + '</td>'
		        				       + '<td><a href="' + (website['domain'] || '#') + '" target="_blank">' + (website['domain'] || '') + '</a></td>'
		        				       + '<td>' + ((website['category'] && website['category']['name']) || '') + '</td>'
		        				       + '<td><a href="javascript:void(0);" class="edit"><i class="fa fa-edit"></i><spring:message code="app.common.action.edit" /></a><a href="javascript:void(0);" class="pl5 delete"><i class="fa fa-trash-o"></i><spring:message code="app.common.action.delete" /></a></td>'
		        				       + '</tr>';
	        				}
	        			}
	        			if($html){
	        				$('tbody', '#website-table').empty().append($html);
	        			}
	        			
	        			$('.edit', '#website-table').click(goEditWebsite);
	        			$('.delete', '#website-table').click(goDeleteWebsite);
	        		}
	        		
	        		var websites = {};
	        		$('#website-table').dataTable_ext({
		        		'bAutoWidth': true,
	     				'bStateSave': true,
	 		        	'aoColumnDefs': [
	 		        	],
			        	'bSort': false,
	     				'bFilter': false,
		        		'oLanguage': {
		        			'sUrl': contextPath + '/static/static/i18n/datatable_zh_CN.txt'
		        		},
		        		bRowDetail: true,
		        		fnRowDetailCallback: function(oTable, nTr){
		        			if(nTr){
		        				var websiteId = $(nTr).attr('data-id');
		        				if(websiteId){
		        					var website = websites[websiteId];
		        					if(!website){
		        						cas.website.loadWebsite(websiteId, function(w){
		        							if(w){
		        								website = w;
		        							}
		        						});
		        					}
		        					return showWebsiteDetail(website);
		        				}
		        			}
		        			return '';
		        		}
		        	});
	        	});
	        });
	    </script>
    </body>
</html>