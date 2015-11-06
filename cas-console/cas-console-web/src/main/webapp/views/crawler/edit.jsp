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
                            <span><spring:message code="app.crawler.action.add" /></span>
                        </header>
                        <div class="panel-body">
                            <form role="form" method="post" action="${contextPath}/crawler/edit">
                                <div class="form-group">
                                    <label for="title"><spring:message code="app.crawler.title.title" /></label>
                                    <input type="text" class="form-control" id="title" name="title" placeholder="" />
                                </div>
                                <div class="form-group">
                                    <label for="website"><spring:message code="app.crawler.title.website" /></label>
                                    <select class="form-control" id="website" name="website.id">
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="contentType"><spring:message code="app.crawler.title.contentType" /></label>
                                    <select class="form-control" id="contentType" name="contentType.id">
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="intervalTime"><spring:message code="app.crawler.title.intervalTime" /></label>
                                    <input type="text" class="form-control" id="intervalTime" name="intervalTime" placeholder="" />
                                </div>
                                <div class="form-group">
                                    <label for="retryTimes"><spring:message code="app.crawler.title.retryTimes" /></label>
                                    <input type="text" class="form-control" id="retryTimes" name="retryTimes" placeholder="" />
                                </div>
                                <div class="form-group">
                                    <label for="timeout"><spring:message code="app.crawler.title.timeout" /></label>
                                    <input type="text" class="form-control" id="timeout" name="timeout" placeholder="" />
                                </div>
                                <button type="submit" class="btn btn-primary"><spring:message code="app.common.action.submit" /></button>
                                <a href="${contextPath}/crawler/index" class="btn btn-default"><spring:message code="app.common.action.cancel" /></a>
                            </form>
                        </div>
                    </section>
                </div>
            </div>
        </div>
        <!--body wrapper end-->
        
        <script type="text/javascript" src="${contextPath}/static/assets/bootstrap3-dialog/js/bootstrap-dialog.min.js"></script>
        <script type="text/javascript" src="${contextPath}/static/static/js/website.js"></script>
        <script type="text/javascript" src="${contextPath}/static/static/js/contentType.js"></script>
        <script type="text/javascript">
            $(function(){
            	// 站点初始化
            	cas.website.listWebsites({}, function(websites){
            		console.log(websites);
            		
            		if(websites && websites.length>0){
            			var $html = '';
            			for(var i=0; i<websites.length; i++){
            				var website = websites[i];
            				if(website && website['id'] && website['siteName']){
            					$html += '<option value="' + website['id'] + '">' + website['siteName'] + '</option>';
            				}
            			}
            			$('#website').empty().append($html);
            		}
            	});
            	// 内容类型初始化
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