<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.appname" /></title>
        <link rel="stylesheet" type="text/css" href="${contextPath}/static/assets/zTree/css/awesomeStyle/awesome.css" >
    </head>
    <body>
        <div class="clearfix"></div>

        <!--body wrapper start-->
        <div class="">
            <div class="row">
                <div class="col-sm-12">
                    <section class="">
                        <div id="category-list-tree" class="tree">
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
	        			url: contextPath + '/category/list'
	        		},
	        		view: {
	                    selectedMulti: false
	                },
	                data: {
	                    simpleData: {
	                        enable: false,
	                        idKey: 'id',
	                        pIdKey: 'parent',
	                        rootPId: null
	                    }
	                }
	        	});
	        });
	    </script>
    </body>
</html>