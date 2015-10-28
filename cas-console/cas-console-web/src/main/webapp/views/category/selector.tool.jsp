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
        <div class="">
            <div class="row">
                <div class="col-sm-12">
                    <section class="">
                        <div id="category-tree-list" class="tree">
                            <div class = "tree-folder" style="display:none;">
                                <div class="tree-folder-header">
                                    <i class="fa fa-folder"></i>
                                    <div class="tree-folder-name"></div>
                                </div>
                                <div class="tree-folder-content"></div>
                                <div class="tree-loader" style="display:none"></div>
                            </div>
                            <div class="tree-item" style="display:none;">
                                <i class="tree-dot"></i>
                                <div class="tree-item-name"></div>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </div>
        <!--body wrapper end-->
        
        <script type="text/javascript" src="${contextPath}/static/assets/fuelux/js/tree.min.js"></script>
        <script type="text/javascript" src="${contextPath}/static/static/js/category.js"></script>
        <script type="text/javascript">
	        $(function(){
	        	var categories = {};
	        	// 初始化分类树
	        	$('#category-tree-list').tree({
	        		dataSource: {
	        			data: function(parentData, callback){
	        				var parentId = '';
	        				if(parentData){
	        					parentId = parentData['id'];
	        				}
	        				var treeDatas = categories[(parentId || '-1')];
	        				if(!treeDatas){
	        					cas.category.listCategoriesByParent(parentId, function(datas){
		        					treeDatas = [];
		        					if(datas && datas.length>0){
		        	        			for(var i=0; i<datas.length; i++){
		        	        				var data = datas[i];
		        	        				if(!data){
		        	        					continue;
		        	        				}
		        	        				$.extend(data, {
		        	        					type: 'folder'
		        	        				});
		        	        				treeDatas.push(data);
		        	        			}
		        	        		}
		        				});
	        					categories[(parentId || '-1')] = treeDatas;
	        				}
	        				callback({data: treeDatas || []});
		        		}	
	        		},
	                loadingHTML: '<img src="${contextPath}/static/static/img/input-spinner.gif"/>',
	        	});
	        });
	    </script>
    </body>
</html>