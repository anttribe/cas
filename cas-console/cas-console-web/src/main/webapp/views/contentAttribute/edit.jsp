<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.contentAttribute.title" /></title>
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
                            <form role="form" class="cmxform data-form" method="POST">
                                <input type="hidden" name="id" value="${contentAttribute.id}" />
                                <div class="form-group">
                                    <label for="name"><spring:message code="app.contentAttribute.title.name" /></label>
                                    <input type="text" class="form-control" id="name" name="name" maxLength="30" value="${contentAttribute.name}" placeholder="" />
                                </div>
                                <div class="form-group">
                                    <label for="contentType"><spring:message code="app.contentType.title.contentType" /></label>
                                    <select class="form-control" id="contentType" name="contentType.id">
                                        <option value="">---请选择---</option>
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
            	var contentTypeId = '${contentAttribute.contentType.id}';
            	cas.contentType.listContentTypes(function(contentTypes){
            		if(contentTypes && contentTypes.length>0){
            			var $html = '';
            			for(var i=0; i<contentTypes.length; i++){
            				var contentType = contentTypes[i];
            				if(contentType && contentType['id'] && contentType['name']){
            					$html += '<option value="' + contentType['id'] + '" ' + (contentTypeId && contentType['id'] == contentTypeId ? "selected" : "") + '>' + contentType['name'] + '</option>';
            				}
            			}
            			$('#contentType').append($html);
            		}
            	});
            });
        </script>
        <script type="text/javascript">
            $(function(){
            	$('.data-form').validate({
	        		focusInvalid: true,
	        		rules: {
	        			name: {
	        				required: true,
	        				maxlength: 30
	        			},
	        			'contentType.id': {
	        				required: true
	        			}
	        		},
	        		submitHandler: function(){
	        			$('.data-form').ajaxSubmit({
	        				type: 'POST',
	        				url: '${contextPath}/contentAttribute/edit/exec',
	        				success: function(r){
	        					var result = $.parseJSON(r);
	        					if(result && result.resultCode){
	        				    	if(result.resultCode == '000000'){
	        				    		BootstrapDialog.alert({
	        				    			type: BootstrapDialog.TYPE_SUCCESS,
	        				    			message: '<spring:message code="app.common.title.success" />',
	        				    			callback: function(){
	        				    				location.href = '${contextPath}/contentAttribute/index';
	        				    			}
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