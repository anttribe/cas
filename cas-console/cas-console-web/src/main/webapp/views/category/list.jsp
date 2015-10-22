<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.appname" /></title>
        <link rel="stylesheet" type="text/css" href="${contextPath}/static/assets/jquery-datatable/css/jquery.dataTables.css" >
        <link rel="stylesheet" type="text/css" href="${contextPath}/static/assets/adminEx/js/data-tables/DT_bootstrap.css" >
    </head>
    <body>
        <div class="clearfix"></div>
        <!-- page heading start-->
        <div class="page-heading">
            <h3>分类管理</h3>
            <ul class="breadcrumb">
                <li><a href="#">Dashboard</a></li>
                <li class="active"> 分类管理</li>
            </ul>
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            <span>分类列表</span>
                            <span class="tools pull-right">
                                <a href="${contextPath}/category/goAdd" title="新建分类" class="fa fa-plus-square"></a>
                            </span>
                        </header>
                        <div class="panel-body">
                            <div class="adv-table">
                                <table class="display table table-bordered table-striped table-hidden-detail">
                                    <thead>
                                        <tr>
                                            <th>分类id</th>
                                            <th>分类名称</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody id="categories">
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
        <script type="text/javascript" src="${contextPath}/static/static/js/category.js"></script>
        <script type="text/javascript">
	        $(function(){
	        	// 初始化父分类
	        	cas.category.listCategoriesByParent('', function(datas){
	        		if(datas && datas.length>0){
	        			var $html = '';
	        			for(var i=0; i<datas.length; i++){
	        				var data = datas[i];
	        				if(!data){
	        					continue;
	        				}
	        				$html += '<tr data-id="' + data['id'] + '">'
	        				       + '<td>' + (data['id'] || '') + '</td>'
	        				       + '<td>' + (data['name'] || '') + '</td>'
	        				       + '<td></td>'
	        				       + '</tr>';
	        			}
	        			$('#categories').append($html);
	        			
	        			initialDataTable('.table-hidden-detail');
	        			function initialDataTable(tableSelector){
		        			$(tableSelector).dataTable_ext({
		        				'bAutoWidth': true,
		        				'bStateSave': false,
		        				'aoColumnDefs': [
		        				    {'bVisible': false, "aTargets": [ 1 ] }
		        				],
		        				'bSort': false,
		        				'bFilter': false,
		        				'oLanguage': {
		        					'sUrl': contextPath + '/static/static/i18n/datatable_zh_CN.txt'
		        				},
		        				'bRowChild': true,
		        				'fnRowChildCallback': function(category){
		        					if(category && category[1]){
		        						cas.category.listCategoriesByParent(category[1], function(datas, nTr){
		        			        		if(datas && datas.length>0){
		        			        			var $html = '<table id="table_' + category[0] + '">';
		        			        			for(var i=0; i<datas.length; i++){
		        			        				var data = datas[i];
		        			        				if(!data){
		        			        					continue;
		        			        				}
		        			        				$html += '<tr data-id="' + data['id'] + '">'
		        			        				       + '<td>' + (data['id'] || '') + '</td>'
		        			        				       + '<td>' + (data['name'] || '') + '</td>'
		        			        				       + '<td></td>'
		        			        				       + '</tr>';
		        			        			}
		        			        			console.log(nTr);
		        			        			//$($html).insertAfter(nTr);
		        			        		}
		        						});
		        					}
		        				}
		    	            });
	        			};
	        		}
	        	});
	        });
	    </script>
    </body>
</html>