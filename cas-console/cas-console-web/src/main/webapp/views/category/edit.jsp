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
        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            <span><spring:message code="app.category.action.add" /></span>
                        </header>
                        <div class="panel-body">
                            <form role="form" method="post" action="${contextPath}/category/edit">
                                <div class="form-group">
                                    <label for="name"><spring:message code="app.category.title.name" /></label>
                                    <input type="text" class="form-control" id="name" name="name" placeholder="" />
                                </div>
                                <div class="form-group">
                                    <label for="parentSelect"><spring:message code="app.category.title.parent" /></label>
                                    <input type="hidden" name="parent" />
                                    <input type="text" class="form-control" id="parentSelect" name="parentSelect" placeholder="" />
                                </div>
                                <button type="submit" class="btn btn-primary"><spring:message code="app.common.action.submit" /></button>
                                <a href="${contextPath}/category/index" class="btn btn-default"><spring:message code="app.common.action.cancel" /></a>
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