<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.appname" /></title>
        <link rel="stylesheet" type="text/css" href="${contextPath}/static/assets/jquery-treetable/css/jquery.treetable.css" >
        <link rel="stylesheet" type="text/css" href="${contextPath}/static/static/css/jquery.treetable.theme.custom.css" >
    </head>
    <body>
        <div class="clearfix"></div>
        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            <spring:message code="app.crawler.title.list" />
                            <span class="tools pull-right"></span>
                        </header>
                        <div class="panel-body">
                            <div class="btn-group mb10">
                                <a href="${contextPath}/crawler/goAdd" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i> <spring:message code="app.crawler.action.add" /></a>
                            </div>
                            <div class="table-responsive">
                                <table id="crawler-table" class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th><spring:message code="app.crawler.title.title" /></th>
                                            <th><spring:message code="app.crawler.title.website" /></th>
                                            <th><spring:message code="app.crawler.title.contentType" /></th>
                                            <th><spring:message code="app.crawler.title.state" /></th>
                                            <th><spring:message code="app.crawler.title.createTime" /></th>
                                            <th><spring:message code="app.crawler.title.available" /></th>
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
        
        <script type="text/javascript" src="${contextPath}/static/assets/jquery-treetable/js/jquery.treetable.js"></script>
        <script type="text/javascript" src="${contextPath}/static/static/js/crawler.js"></script>
        <script type="text/javascript">
	        $(function(){
	        	cas.crawler.listCrawlers({}, function(crawlers){
	        		if(crawlers && crawlers.length>0){
	        			var $html = '';
	        			for(var i=0; i<crawlers.length; i++){
	        				var crawler = crawlers[i];
	        				if(crawler){
	        					$html += '<tr data-id="' + crawler['id'] + '">' 
		        				       + '<td>' + (crawler['title'] || '') + '</td>'
		        				       + '<td>' + ((crawler['website'] && crawler['website']['name']) || '') + '</td>'
		        				       + '<td>' + ((crawler['contentType'] && crawler['contentType']['name']) || '') + '</td>'
		        				       + '<td>' + (crawler['state'] || '') + '</td>'
		        				       + '<td>' + (crawler['createTime'] || '') + '</td>'
		        				       + '<td>' + (crawler['available'] || '') + '</td>'
		        				       + '<td>' + '</td>'
		        				       + '</tr>';
	        				}
	        			}
	        			if($html){
	        				$('tbody', '#crawler-table').empty().append($html);
	        			}
	        		}
	        		
	        		$('#crawler-table').dataTable_ext({
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