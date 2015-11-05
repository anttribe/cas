<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.appname" /></title>
        <link rel="stylesheet" type="text/css" href="${contextPath}/static/assets/jquery-datatable/css/jquery.dataTables.min.css" >
        <link rel="stylesheet" type="text/css" href="${contextPath}/static/assets/adminEx/js/data-tables/DT_bootstrap.css" >
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
        <script type="text/javascript" src="${contextPath}/static/static/js/website.js"></script>
        <script type="text/javascript">
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
		        				       + '<td>' + (website['domain'] || '') + '</td>'
		        				       + '<td>' + ((website['category'] && website['category']['name']) || '') + '</td>'
		        				       + '<td>' + '</td>'
		        				       + '</tr>';
	        				}
	        			}
	        			if($html){
	        				$('tbody', '#website-table').empty().append($html);
	        			}
	        		}
	        		
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
		        			console.log(nTr);
		        		}
		        	});
	        	});
	        });
	    </script>
    </body>
</html>