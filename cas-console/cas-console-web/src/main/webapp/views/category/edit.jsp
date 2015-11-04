<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.appname" /></title>
        <link rel="stylesheet" type="text/css" href="${contextPath}/static/assets/bootstrap3-dialog/css/bootstrap-dialog.min.css" >
    </head>
    <body>
        <div class="clearfix"></div>
        <!-- page heading start-->
        <div class="page-heading">
            <h3>分类管理</h3>
            <ul class="breadcrumb">
                <li><a href="#">Dashboard</a></li>
                <li class="active"> 新增分类</li>
            </ul>
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            <span>新增分类</span>
                        </header>
                        <div class="panel-body">
                            <form role="form" method="post" action="${contextPath}/category/edit">
                                <div class="form-group">
                                    <label for="name">分类名称</label>
                                    <input type="text" class="form-control" id="name" name="name" placeholder="" />
                                </div>
                                <div class="form-group">
                                    <label for="parentSelect">父分类</label>
                                    <input type="hidden" name="parent" />
                                    <input type="text" class="form-control" id="parentSelect" name="parentSelect" placeholder="" />
                                </div>
                                <button type="submit" class="btn btn-primary">提交</button>
                                <button type="button" class="btn btn-default">取消</button>
                            </form>
                        </div>
                    </section>
                </div>
            </div>
        </div>
        <!--body wrapper end-->
        
        <script type="text/javascript" src="${contextPath}/static/assets/bootstrap3-dialog/js/bootstrap-dialog.min.js"></script>
        <script type="text/javascript" src="${contextPath}/static/static/js/category.js"></script>
        <script type="text/javascript">
            var categorySelector = null;
            var selectCategory = function(category){
    			if(category){
    				$('input[name="parent"]').val(category.id);
    				$('input[name="parentSelect"]').val(category.name);
    			}
            	if(categorySelector){
    				categorySelector.close();
    			}
            };
        </script>
        <script type="text/javascript">
	        $(function(){
	        	$('input[name="parentSelect"]').bind({
	        		'click': function(){
	        			categorySelector = cas.category.categorySelector();
	        			if(categorySelector){
	        				categorySelector.open();
	        			}
	        		}
	        	});
	        });
	    </script>
    </body>
</html>