<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.appname" /></title>
        <link rel="stylesheet" type="text/css" href="${contextPath}/static/assets/bootstrap3-dialog/css/bootstrap-dialog.min.css">
    </head>
    <body>
	    <div class="clearfix"></div>
	    <!-- page heading start-->
	    <div class="page-heading">
		    <h3>站点管理</h3>
		    <ul class="breadcrumb">
			    <li><a href="#">内容管理</a></li>
			    <li class="active">站点管理</li>
		    </ul>
	    </div>
	    <!-- page heading end-->

	    <!--body wrapper start-->
	    <div class="wrapper">
		    <div class="row">
			    <div class="col-sm-12">
				    <section class="panel">
					    <header class="panel-heading">
						    <span>新增站点</span>
					    </header>
					    <div class="panel-body">
						    <form role="form" class="form-horizontal" method="post" action="${contextPath}/website/edit">
							    <div class="form-group">
								    <label for="siteName" class="col-sm-2 control-label">站点名称</label>
								    <div class="col-sm-4"><input type="text" class="form-control" id="siteName" name="siteName" placeholder="" /></div>
							    </div>
							    <div class="form-group">
								    <label for="domain" class="col-sm-2 control-label">域名</label>
								    <div class="col-sm-6"><input type="url" class="form-control" id="domain" name="domain" placeholder="" /></div>
							    </div>
							    <div class="">
							        <div class="form-group col-sm-6">
								        <label for="charset" class="col-sm-4 control-label">字符集</label>
								        <div class="col-sm-8"><input type="text" class="form-control" id="charset" name="charset" placeholder="" /></div>
							        </div>
							        <div class="form-group col-sm-6">
								        <label for="userAgent" class="col-sm-4 control-label">用户代理</label>
								        <div class="col-sm-8"><input type="text" class="form-control" id="userAgent" name="userAgent" placeholder="" /></div>
							        </div>
							    </div>
							    <div class="">
							        <div class="form-group col-sm-4">
								        <label for="intervalTime" class="col-sm-6 control-label">处理2个page之间的间隔时间</label>
								        <div class="col-sm-6"><input type="text" class="form-control" id="intervalTime" name="intervalTime" placeholder="" /></div>
							        </div>
							        <div class="form-group col-sm-4">
								        <label for="retryTimes" class="col-sm-6 control-label">失败重复次数</label>
								        <div class="col-sm-6"><input type="text" class="form-control" id="retryTimes" name="retryTimes" placeholder="" /></div>
							        </div>
							        <div class="form-group col-sm-4">
								        <label for="timeout" class="col-sm-6 control-label">超时时长</label>
								        <div class="col-sm-6"><input type="text" class="form-control" id="timeout" name="timeout" placeholder="" /></div>
							        </div>
							    </div>
							    <div class="clearfix"></div>
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
	    <script type="text/javascript" src="${contextPath}/static/static/js/website.js"></script>
	    <script type="text/javascript">
		    var categorySelector = null;
		    var selectCategory = function(category) {
			    if (category) {
				    $('input[name="category"]').val(category.id);
				    $('input[name="categorySelect"]').val(category.name);
			    }
			    if (categorySelector) {
				    categorySelector.close();
			    }
		    };
	    </script>
	    <script type="text/javascript">
		    $(function() {
			    $('input[name="categorySelect"]').bind({
				    'click' : function() {
					    categorySelector = cas.category.categorySelector();
					    if (categorySelector) {
						    categorySelector.open();
					    }
				    }
			    });
		    });
	    </script>
    </body>
</html>