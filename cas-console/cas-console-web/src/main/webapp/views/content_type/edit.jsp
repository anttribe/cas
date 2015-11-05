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
            <h3>内容类型</h3>
            <ul class="breadcrumb">
                <li><a href="#">Dashboard</a></li>
                <li class="active"> 新增内容类型</li>
            </ul>
        </div>
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            <span>新增内容类型</span>
                        </header>
                        <div class="panel-body">
                            <form role="form" method="post" action="${contextPath}/content_type/edit">
                                <div class="form-group">
                                    <label for="name">类型名称</label>
                                    <input type="text" class="form-control" id="name" name="name" placeholder="" />
                                </div>
                                <div class="form-group">
                                    <label for="code">类型编码code</label>
                                    <input type="text" class="form-control" id="code" name="code" placeholder="" />
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
    </body>
</html>