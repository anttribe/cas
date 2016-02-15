<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.contentType.title" /></title>
    </head>
    <body>
        <div class="clearfix"></div>
        <!--body wrapper start-->
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading">
                            <span><spring:message code="app.contentType.action.add" /></span>
                        </header>
                        <div class="panel-body">
                            <form role="form" class="cmxform data-form" method="POST">
                                <input type="hidden" name="id" value="${contentType.id}" />
                                <div class="form-group">
                                    <label for="name"><spring:message code="app.contentType.title.name" /></label>
                                    <input type="text" class="form-control" id="name" name="name" maxLength="30" value="${contentType.name}" placeholder="" />
                                </div>
                                <div class="form-group">
                                    <label for="code"><spring:message code="app.contentType.title.code" /></label>
                                    <input type="text" class="form-control" id="code" name="code" maxLength="30" value="${contentType.code}" placeholder="" />
                                </div>
                                <button type="submit" class="btn btn-primary"><spring:message code="app.common.action.submit" /></button>
                                <a href="${contextPath}/contentType/index" class="btn btn-default"><spring:message code="app.common.action.cancel" /></a>
                            </form>
                        </div>
                    </section>
                </div>
            </div>
        </div>
        <!--body wrapper end-->
        
        <script type="text/javascript">
            $(function(){
            	$('.data-form').validate({
	        		focusInvalid: true,
	        		rules: {
	        			name: {
	        				required: true,
	        				maxlength: 30, 
	        				remote: {
	                        	type: 'POST',
	                        	url: contextPath + '/contentType/validate/nameUnique',
	                        	data: {
	                        		id: function(){return $('input[name="id"]').val();},
	                        		name: function(){return $('input[name="name"]').val();}
	                        	}
	                        }
	        			},
	        			code: {
	        				required: true,
	        				maxlength: 30, 
	        				remote: {
	                        	type: 'POST',
	                        	url: contextPath + '/contentType/validate/codeUnique',
	                        	data: {
	                        		id: function(){return $('input[name="id"]').val();},
	                        		code: function(){return $('input[name="code"]').val();}
	                        	}
	                        }
	        			}
	        		},
	        		messages: {
	        			name: {
	        				remote: '<spring:message code="app.errorNo.030001" />'
	        			},
	        			code: {
	        				remote: '<spring:message code="app.errorNo.030001" />'
	        			}
	        		},
	        		submitHandler: function(){
	        			$('.data-form').ajaxSubmit({
	        				type: 'POST',
	        				url: '${contextPath}/contentType/edit/exec',
	        				success: function(r){
	        					var result = $.parseJSON(r);
	        					if(result && result.resultCode){
	        				    	if(result.resultCode == '000000'){
	        				    		BootstrapDialog.alert({
	        				    			type: BootstrapDialog.TYPE_SUCCESS,
	        				    			message: '<spring:message code="app.common.title.success" />',
	        				    			callback: function(){
	        				    				location.href = '${contextPath}/contentType/index';
	        				    			}
	        				    		});
	        				    	} else if(result.resultCode == '030001' || result.resultCode == '030002'){
	        				    		BootstrapDialog.alert({
	        				    			type: BootstrapDialog.TYPE_WARNING,
	        				    			message: '<spring:message code="app.errorNo.030001" />'
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