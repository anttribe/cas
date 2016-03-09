<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.category.title.category" /></title>
        <link rel="stylesheet" type="text/css" href="${contextPath}/assets/zTree/css/zTreeStyle/zTreeStyle.css" >
        <link rel="stylesheet" type="text/css" href="${contextPath}/assets/zTree/css/metroStyle/metroStyle.css" >
    </head>
    <body>
        <div class="clearfix"></div>

        <!--body wrapper start-->
        <div class="">
            <div class="row">
                <div class="col-sm-12">
                    <section class="">
                        <div id="category-list-tree" class="ztree"></div>
                    </section>
                </div>
            </div>
        </div>
        <!--body wrapper end-->
        
        <script type="text/javascript" src="${contextPath}/assets/zTree/js/jquery.ztree.all-3.5.min.js"></script>
        <script type="text/javascript" src="${contextPath}/static/js/category.js"></script>
        <script type="text/javascript">
	        $(function(){
	        	function processCategoryTreeData(categorys){
	        		if(categorys && categorys.length > 0){
    					var categoryTreeDatas = [];
						for(var i=0; i<categorys.length; i++){
							var category = categorys[i];
							if(category && category['id']){
								categoryTreeDatas.push({
									'id': category['id'],
									'name': category['name'] || '',
									'parentId': (category['parent'] && category['parent']['id']) || null,
									'children': processCategoryTreeData(category['children']) || null
								});
							}
						}
						return categoryTreeDatas;
	        		}
	        	}
	        	$.ajax({
	        		type: 'POST',
	        		url: '${contextPath}/category/list/exec',
	        		success: function(r){
	        			if(r){
	        				var result = $.parseJSON(r);
	        				if(result && result.resultCode == '000000'){
	        					var categorys = result.data;
	        					// 构造成tree数据
	        					var categoryTreeDatas = processCategoryTreeData(categorys);
	        					// 初始化tree
	        		            zTreeObj = $.fn.zTree.init($("#category-list-tree"), {
	        		        		view: {
	        		                    dblClickExpand: false
	        		                },
	        		                data: {
	        		                    simpleData: {
	        		                        enable: true,
	        		                        idKey: 'id',
	        		                        pIdKey: 'parentId'
	        		                    }
	        		                },
	        		                callback: {
	        		                	onClick: function(e, treeId, treeNode){
	        		                		var zTree = $.fn.zTree.getZTreeObj(treeId);
	        		                		if(zTree){
	        		                			if(treeNode.isParent){
	        		                				zTree.expandNode(treeNode, null, false, true, true);
	        		                			}
	        		                		}
	        		                	},
	        		                	onDblClick: function(e, treeId, treeNode){
	        		                		var resurce = {
	        		                			id: treeNode.id,
	        		                			name: treeNode.name
	        		                		};
	        		                		cas.category.selectCategory(resurce);
	        		                	}
	        		                }
	        		            }, categoryTreeDatas);
	        		            zTreeObj.expandAll(true);
	        				}
	        			}
	        		}
	        	});
	        });
	    </script>
    </body>
</html>