<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.appname" /></title>
        <link rel="stylesheet" type="text/css" href="${contextPath}/static/assets/fuelux/css/tree-style.css" >
    </head>
    <body>
        <div class="clearfix"></div>

        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <div class="panel-body">
                            <div id="category-tree-list"></div>
                        </div>
                    </section>
                </div>
            </div>
        </div>
        <!--body wrapper end-->
        
        <script type="text/javascript" src="${contextPath}/static/assets/fuelux/js/tree.js"></script>
        <script type="text/javascript" src="${contextPath}/static/static/js/category.js"></script>
        <script type="text/javascript">
	        $(function(){
	        	// 初始化分类树
	        	$('#category-tree-list').tree({
	        		dataSource: {
	        			data: function(parentData, callback){
	        				cas.category.listCategoriesByParent('', function(datas){
	        					var treeDatas = [];
	        					if(datas && datas.length>0){
	        	        			for(var i=0; i<datas.length; i++){
	        	        				var data = datas[i];
	        	        				if(!data){
	        	        					continue;
	        	        				}
	        	        				data['type'] = 'folder';
	        	        				treeDatas.push(data);
	        	        			}
	        	        			callback({data: treeDatas});
	        	        		}
	        				});
		        		}	
	        		},
	                loadingHTML: '<img src="${contextPath}/static/static/img/input-spinner.gif"/>',
	        	});
	        });
	    </script>
    </body>
</html>