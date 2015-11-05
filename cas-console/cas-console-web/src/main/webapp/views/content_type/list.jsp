<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.appname" /></title>
    </head>
    <body>
        <div class="clearfix"></div>
        <!-- page heading start-->
        <div class="page-heading">
            <h3>内容类型</h3>
            <ul class="breadcrumb">
                <li><a href="#">Dashboard</a></li>
                <li class="active"> 内容类型</li>
            </ul>
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                                                        内容类型列表
                            <span class="tools pull-right"></span>
                        </header>
                        <div class="panel-body">
                            <div class="btn-group mb10">
                                <a href="${contextPath}/content_type/goAdd" class="btn btn-primary btn-sm" title="新增内容类型"><i class="fa fa-plus"></i> 新增内容类型</a>
                            </div>
                            <div class="table-responsive">
                                <table id="contentType-table" class="display table table-striped">
                                    <thead>
                                        <tr>
                                            <th>名称</th>
                                            <th>编码code</th>
                                            <th>操作</th>
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
		        				       + '<td>' + '</td>'
		        				       + '</tr>';
	        				}
	        			}
	        			if($html){
	        				$('tbody', '#contentType-table').empty().append($html);
	        			}
	        		}
	        	});
            }
        </script>
        <script type="text/javascript">
	        $(function(){
	        	listContentTypes();
	        });
	    </script>
    </body>
</html>