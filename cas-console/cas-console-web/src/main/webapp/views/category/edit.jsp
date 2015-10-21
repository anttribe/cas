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
                                    <label for="exampleInputEmail1">分类名称</label>
                                    <input type="text" class="form-control" name="name" placeholder="">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">父分类</label>
                                    <select class="form-control" name="parent">
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary">提交</button>
                            </form>
                        </div>
                    </section>
                </div>
            </div>
        </div>
        <!--body wrapper end-->
        
        <script type="text/javascript" src="${contextPath}/static/static/js/category.js"></script>
        <script type="text/javascript">
	        $(function(){
	        });
	    </script>
    </body>
</html>