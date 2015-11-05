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
                                                        分类列表
                            <span class="tools pull-right"></span>
                        </header>
                        <div class="panel-body">
                            <div class="btn-group mb10">
                                <a href="${contextPath}/category/goAdd" class="btn btn-primary btn-sm" title="新增分类"><i class="fa fa-plus"></i> 新增分类</a>
                            </div>
                            <div class="table-responsive">
                                <table id="category-table" class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th width="60%">分类名称</th>
                                            <th width="24%">操作</th>
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
		        				      + '<td></td>'
	        				}));
	        			}
	        		}
	        	});
            	return nTrs;
            }
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
    			
    			// 绑定事件
//     			$('.btn-ck-select-all').click(function(){
//     				var that = this;
//     				var dataRefer = $(that).attr('data-refer');
//     				if(dataRefer){
//     					var cks = $('input[type="checkbox"][name="' + dataRefer + '"]');
//     					if(cks && cks.length>0){
//     						$.each(cks, function(i, item){
//     							$(item).attr('checked', $(that).prop('checked') || false);
//     						});
//     					}
//     				}
//     			});
	        });
	    </script>
    </body>
</html>