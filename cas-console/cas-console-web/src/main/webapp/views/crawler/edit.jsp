<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.crawler.title" /></title>
        <link rel="stylesheet" type="text/css" href="${contextPath}/assets/jquery-stepy/css/jquery.stepy.css" >
        <link rel="stylesheet" type="text/css" href="${contextPath}/static/css/jquery.stepy.theme.custom.css" >
    </head>
    <body>
        <div class="clearfix"></div>
        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            <span><spring:message code="app.crawler.title" /></span>
                        </header>
                        <div class="panel-body">
                            <div class="stepy-tab"></div>
                            <form id="crawler-form" class="cmxform data-form" method="POST">
                                <fieldset title="<spring:message code="app.crawler.wizard.foundation" />">
                                    <legend><spring:message code="app.crawler.wizard.foundation.legend" /></legend>
                                    <div class="form-group">
                                        <label for="title" class="control-label"><spring:message code="app.crawler.title.title" /></label>
                                        <input type="text" class="form-control" id="title" name="title" value="${PARAM.title}" maxLength="30" placeholder="" />
                                    </div>
                                    <div class="form-group">
                                        <label for="website" class="control-label"><spring:message code="app.crawler.title.website" /></label>
                                        <select class="form-control" id="website" name="website.id">
                                            <option value=""><spring:message code="app.common.title.select" /></option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="title" class="control-label"><spring:message code="app.crawler.title.crawlerUrl" /></label>
                                        <input type="text" class="form-control" id="crawlerUrl" name="crawlerUrl" maxLength="500" placeholder="" />
                                    </div>
                                    <div class="form-group">
								        <label for="charset" class="control-label"><spring:message code="app.website.title.charset" /></label>
								        <input type="text" class="form-control" id="charset" name="charset" maxLength="30" value="${PARAM.charset}" placeholder="<spring:message code="app.website.placeholder.charset" />" />
							        </div>
							        <div class="form-group">
								        <label for="userAgent" class="control-label"><spring:message code="app.website.title.userAgent" /></label>
								        <input type="text" class="form-control" id="userAgent" name="userAgent" maxLength="200" value="${PARAM.userAgent}" placeholder="<spring:message code="app.website.placeholder.userAgent" />" />
							        </div>
                                </fieldset>
                                <fieldset title="<spring:message code="app.crawler.wizard.contentAttrRegulars" />">
                                    <legend><spring:message code="app.crawler.wizard.contentAttrRegulars.legend" /></legend>
                                    <div class="form-group">
                                        <label for="contentType" class="control-label"><spring:message code="app.crawler.title.contentType" /></label>
                                        <select class="form-control" id="contentType" name="contentType.id">
                                            <option value=""><spring:message code="app.common.title.select" /></option>
                                        </select>
                                    </div>
                                    <div id="contentAttrRegulars"></div>
                                </fieldset>
                                <fieldset title="<spring:message code="app.crawler.wizard.runtime" />">
                                    <legend><spring:message code="app.crawler.wizard.runtime.legend" /></legend>
                                    <div class="form-group">
                                        <label for="intervalTime" class="control-label"><spring:message code="app.crawler.title.intervalTime" /></label>
                                        <input type="text" class="form-control" id="intervalTime" name="intervalTime" placeholder="" />
                                    </div>
                                    <div class="form-group">
                                        <label for="retryTimes" class="control-label"><spring:message code="app.crawler.title.retryTimes" /></label>
                                        <input type="text" class="form-control" id="retryTimes" name="retryTimes" placeholder="" />
                                    </div>
                                    <div class="form-group">
                                        <label for="timeout" class="control-label"><spring:message code="app.crawler.title.timeout" /></label>
                                        <input type="text" class="form-control" id="timeout" name="timeout" placeholder="" />
                                    </div>
                                </fieldset>
                                <input type="submit" class="btn btn-primary finish" value="<spring:message code="app.common.action.submit" />"></input>
                            </form>
                        </div>
                    </section>
                </div>
            </div>
        </div>
        <!--body wrapper end-->
        
        <script type="text/javascript" src="${contextPath}/assets/jquery-stepy/js/jquery.stepy.min.js"></script>
        <script type="text/javascript" src="${contextPath}/static/js/website.js"></script>
        <script type="text/javascript" src="${contextPath}/static/js/contentType.js"></script>
        <script type="text/javascript" src="${contextPath}/static/js/contentAttribute.js"></script>
        <script type="text/javascript" src="${contextPath}/static/js/crawler.js"></script>
        <script type="text/javascript">
            $(function(){
            	// 初始化站点下拉选择
            	cas.website.listWebsites({}, function(websites){
            		if(websites && websites.length>0){
            			var $html = '';
            			for(var i=0; i<websites.length; i++){
            				var website = websites[i];
            				if(website && website['id'] && website['siteName']){
            					$html += '<option value="' + website['id'] + '">' + website['siteName'] + '</option>';
            				}
            			}
            			$('#website').append($html);
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
            			$('#contentType').append($html).change(function(){
            				cas.crawler.listContentAttrRegulars($(this).val());
            		    });
            		}
            	});
            });
        </script>
        <script type="text/javascript">
            $(function(){
            	//页面表单向导初始化
        	    $('#crawler-form').stepy({
        		    backLabel: '<spring:message code="app.common.wizard.previous" />',
                    nextLabel: '<spring:message code="app.common.wizard.next" />',
                    titleClick: true,
                    titleTarget: '.stepy-tab',
                    legend: true,
                    block: true,
                    validate: true
        	    });
        	    $('#crawler-form').validate({
	        		focusInvalid: true,
	        		rules: {
	        			title: {
	        				required: true,
	        				maxlength: 30,
	        				remote: {
	                        	type: 'POST',
	                        	url: contextPath + '/crawler/validate/titleUnique',
	                        	data: {
	                        		id: function(){ return ($('input[name="id"]').val() || ''); },
	                        		title: function(){ return ($('input[name="title"]').val() || '');}
	                        	}
	                        }
	        			},
	        			'website.id': {
	        				required: true
	        			},
	        			crawlerUrl: {
	        				required: true,
	        				url: true
	        			},
	        			'contentType.id': {
	        				required: true
	        			},
	        			intervalTime: {
	        				digits: true,
	        				min: 0,
	        				max: 999999999
	        			},
	        			retryTimes: {
	        				digits: true,
	        				min: 0,
	        				max: 5
	        			},
	        			timeout: {
	        				digits: true,
	        				min: 0,
	        				max: 999999999
	        			}
	        		},
	        		messages: {
	        			title: {
	        				remote: '<spring:message code="app.errorNo.040001" />'
	        			}
	        		},
	        		submitHandler: function(){
	        			$('.data-form').ajaxSubmit({
	        				type: 'POST',
	        				url: '${contextPath}/crawler/edit/exec',
	        				success: function(r){
	        					var result = $.parseJSON(r);
	        					if(result && result.resultCode){
	        				    	if(result.resultCode == '000000'){
	        				    		BootstrapDialog.alert({
	        				    			type: BootstrapDialog.TYPE_SUCCESS,
	        				    			message: '<spring:message code="app.common.title.success" />',
	        				    			callback: function(){
	        				    				location.href = '${contextPath}/crawler/index';
	        				    			}
	        				    		});
	        				    	} else if(result.resultCode == '040001'){
	        				    		BootstrapDialog.alert({
	        				    			type: BootstrapDialog.TYPE_WARNING,
	        				    			message: '<spring:message code="app.errorNo.040001" />'
	        				    		});
	        				    	} else{
	        				    		BootstrapDialog.alert({
	        				    			type: BootstrapDialog.TYPE_WARNING,
	        				    			message: '<spring:message code="app.errorNo.000001" />'
	        				    		});
	        				    	}
	        				    } else{
	        				    	BootstrapDialog.alert({
	        				    		type: BootstrapDialog.TYPE_WARNING,
	        				    		message: '<spring:message code="app.errorNo.000001" />'
        				    		});
	        				    }
	        				}
	        			});
	        		}
	        	});
            });
        </script>
    </body>
</html>