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
        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            <span><spring:message code="app.contentAttribute.action.add" /></span>
                        </header>
                        <div class="panel-body">
                            <form role="form" method="post" action="${contextPath}/contentAttribute/edit">
                                <div class="form-group">
                                    <label for="name"><spring:message code="app.contentAttribute.title.name" /></label>
                                    <input type="text" class="form-control" id="name" name="name" placeholder="" />
                                </div>
                                <div class="form-group">
                                    <label for="contentType"><spring:message code="app.contentType.title.contentType" /></label>
                                    <select class="form-control" id="contentType" name="contentType.id">
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary"><spring:message code="app.common.action.submit" /></button>
                                <a href="${contextPath}/contentAttribute/index" class="btn btn-default"><spring:message code="app.common.action.cancel" /></a>
                            </form>
                        </div>
                    </section>
                </div>
            </div>
        </div>
        <!--body wrapper end-->
        
        <script type="text/javascript" src="${contextPath}/static/static/js/contentType.js"></script>
        <script type="text/javascript">
            $(function(){
            	cas.contentType.listContentTypes(function(contentTypes){
            		if(contentTypes && contentTypes.length>0){
            			var $html = '';
            			for(var i=0; i<contentTypes.length; i++){
            				var contentType = contentTypes[i];
            				if(contentType && contentType['id'] && contentType['name']){
            					$html += '<option value="' + contentType['id'] + '">' + contentType['name'] + '</option>';
            				}
            			}
            			$('#contentType').empty().append($html);
            		}
            	});
            });
        </script>
    </body>
</html>