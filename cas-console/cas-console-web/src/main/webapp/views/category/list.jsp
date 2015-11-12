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
                            <spring:message code="app.category.title.list" />
                            <span class="tools pull-right"></span>
                        </header>
                        <div class="panel-body">
                            <div class="btn-group mb10">
                                <a href="${contextPath}/category/goAdd" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i> <spring:message code="app.category.action.add" /></a>
                            </div>
                            <div class="table-responsive">
                                <table id="category-table" class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th width="60%"><spring:message code="app.category.title.name" /></th>
                                            <th width="24%"><spring:message code="app.common.action.operate" /></th>
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
        <script type="text/javascript" src="${contextPath}/static/assets/bootstrap3-dialog/js/bootstrap-dialog.min.js"></script>
        <script type="text/javascript" src="${contextPath}/static/static/js/category.js"></script>
        <script type="text/javascript">
            var listCategories = function(parentCategory){
            	var nTrs = [];
            	cas.category.listCategoriesByParent(parentCategory, function(datas){
	        		if(datas && datas.length>0){
	        			for(var i=0; i<datas.length; i++){
	        				var data = datas[i];
	        				if(!data){
	        					continue;
	        				}
	        				nTrs.push($('<tr>', {
	        					'data-tt-id': data['id'],
	        					'data-tt-parent-id': data['parent'],
	        					'data-tt-branch': (data['children'] && data['children'].length>0 ? true : false),
	        					'html': '<td>' + (data['name'] || '') + '</td>'
		        				      + '<td><a href="javascript:void(0);" class="edit"><i class="fa fa-edit"></i><spring:message code="app.common.action.edit" /></a><a href="javascript:void(0);" class="pl5 delete"><i class="fa fa-trash-o"></i><spring:message code="app.common.action.delete" /></a></td>'
	        				}));
	        			}
	        		}
	        	});
            	return nTrs;
            };
            var goEditCategory = function(){
            	var nTr = $(this).parents('tr');
            	if(nTr){
            		var categoryId = $(nTr).attr('data-tt-id');
            		if(categoryId){
            			cas.category.goEditCategory(categoryId);
            		}
            	}
            };
            var goDeleteCategory = function(){
            	var nTr = $(this).parents('tr');
            	if(nTr){
            		var categoryId = $(nTr).attr('data-tt-id');
            		if(categoryId){
            			BootstrapDialog.confirm({
            				//size: BootstrapDialog.SIZE_NORMAL,
            				type: BootstrapDialog.TYPE_WARNING,
            				draggable: true,
            				closable: true,
            	            title: '<spring:message code="app.category.delete.title" />',
            	            message: '<spring:message code="app.category.delete.confirm" />',
            	            btnCancelLabel: '<spring:message code="app.common.action.cancel" />',
            	            btnOKLabel: '<spring:message code="app.common.action.confirm" />',
            	            btnOKClass: 'btn-warning',
            	            callback: function(result) {
            	                if(result) {
            	                	cas.category.deleteCategory(categoryId);
            	                }
            	            }
            	        });
            		}
            	}
            };
        </script>
        <script type="text/javascript">
	        $(function(){
	        	var nTrs = listCategories('');
    			if(nTrs){
    				$('tbody', '#category-table').append(nTrs);
    				
    				// 表格treetable化
    	        	$('#category-table').treetable({
    	        		column: 0,
    	        		expandable: true,
    	        		stringExpand: '',
    	        		stringCollapse: '',
    	        		onNodeInitialized: function(){
    	        			// 绑定事件
    	        			$('.edit', '#category-table').click(goEditCategory);
    	        			$('.delete', '#category-table').click(goDeleteCategory);
    	        		},
    	        		onNodeExpand: function(){
    	        			if(this.children && this.children.length>0){
    	        				return;
    	        			}
    	        			var categoryId = this.id;
    	        			if(categoryId){
    	        				// 加载子分类数据
    	        				var categories = listCategories(categoryId);
    	        				if(categories && categories.length>0){
    	        					for(var i=0; i<categories.length; i++){
    	        						var category = categories[i];
    	        						if(category){
    	        							$('#category-table').treetable('loadBranch', this, category);
    	        						}
    	        					}
    	        				}
    	        			}
    	        		}
    	        	});
    			}
	        });
	    </script>
    </body>
</html>