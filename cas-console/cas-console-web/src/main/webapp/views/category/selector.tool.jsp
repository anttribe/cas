<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.appname" /></title>
        <link rel="stylesheet" type="text/css" href="${contextPath}/static/assets/zTree/css/zTreeStyle/zTreeStyle.css" >
        <link rel="stylesheet" type="text/css" href="${contextPath}/static/assets/zTree/css/metroStyle/metroStyle.css" >
    </head>
    <body>
        <div class="clearfix"></div>

        <!--body wrapper start-->
        <div class="">
            <div class="row">
                <div class="col-sm-12">
                    <section class="">
                        <div id="category-list-tree" class="ztree">
                        </div>
                    </section>
                </div>
            </div>
        </div>
        <!--body wrapper end-->
        
        <script type="text/javascript" src="${contextPath}/static/assets/zTree/js/jquery.ztree.all-3.5.min.js"></script>
        <script type="text/javascript" src="${contextPath}/static/static/js/category.js"></script>
        <script type="text/javascript">
	        $(function(){
	        	var categories = {};
	        	// 初始化分类树
	        	$.fn.zTree.init($("#category-list-tree"), {
	        		async: {
	        			enable: true,
	        			type: 'POST',
	        			autoParam: ['parent.id'],
	        			url: contextPath + '/category/list' + '?parent.id=' + ''
	        		},
	        		view: {
	                    selectedMulti: false,
	                    dblClickExpand: false
	                },
	                data: {
	                    simpleData: {
	                        enable: true,
	                        idKey: 'id'
	                    }
	                },
	                callback: {
	                	onNodeCreated: function(e, treeId, treeNode){
	                		if(treeNode.children){
	                			treeNode.isParent = true;
	                			treeNode.children = null;
	                		}
	                	},
	                	onClick: function(e, treeId, treeNode){
	                		var zTree = $.fn.zTree.getZTreeObj(treeId);
	                		if(zTree){
	                			if(treeNode.isParent){
	                				zTree.expandNode(treeNode, null, false, true, true);
	                			}
	                		}
	                	},
	                	onExpand: function(e, treeId, treeNode){
	                		var zTree = $.fn.zTree.getZTreeObj(treeId);
	                		if(zTree && !treeNode.children){
	                			// 异步加载子节点
	                			cas.category.listCategoriesByParent(treeNode.id, function(datas){
	                				zTree.addNodes(treeNode, datas);
	                			});
	                		}
	                	},
	                	onDblClick: function(e, treeId, treeNode){
	                		var category = {
	                			id: treeNode.id,
	                			name: treeNode.name
	                		};
	                		cas.category.selectCategory(category);
	                	}
	                }
	        	});
	        });
	    </script>
    </body>
</html>