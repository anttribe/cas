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
                                <table class="display table table-bordered table-striped">
                                    <thead>
                                        <tr>
                                            <th>Rendering engine</th>
                                            <th>Browser</th>
                                            <th>Platform(s)</th>
                                            <th class="hidden-phone">Engine version</th>
                                            <th class="hidden-phone">CSS grade</th>
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
        
        <script type="text/javascript">
	        var cas = cas || {
	        	category: {
	        		listCategoriesByParent : function(parent, callback){
	        	        $.ajax({
	        	        	type: 'POST',
	        	        	url: '${contextPath}/category/list',
	        	        	success: function(result){
	        	        		if(result && result['resultCode'] == '000000'){
	        	        			var datas = result['data'];
	        	        			if(callback && $.isFuntion(callback)){
	    	        					callback.apply(datas);
	    	        				}
	        	        		}
	        	        	}
	        	        });
	        		}
	        	}
	        };
	        $(function(){
	        	// 初始化父分类
	        	cas.category.listCategoriesByParent('', function(datas){
	        		console.log(datas);
	        		if(datas && datas.length>0){
	        			for(var i=0; i<datas.length; i++){
	        			}
	        		}
	        	});
	        });
	    </script>
    </body>
</html>