<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.category.action.add" /></title>
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
                            <form class="cmxform data-form" role="form" method="POST" action="">
                                <input type="hidden" name="id" value="${category.id}" />
                                <div class="form-group">
                                    <label class="control-label" for="name"><spring:message code="app.category.title.name" /></label>
                                    <input type="text" class="form-control" id="name" name="name" maxLength="30" value="${category.name}" placeholder="" />
                                </div>
                                <div class="form-group">
                                    <label class="control-label" for="parentSelect"><spring:message code="app.category.title.parent" /></label>
                                    <input type="hidden" name="parent.id" value="${category.parent.id}" />
                                    <input type="text" class="form-control" id="parentSelect" name="parentSelect" value="${category.parent.name}" placeholder="" />
                                </div>
                                <button type="submit" class="btn btn-primary submit"><spring:message code="app.common.action.submit" /></button>
                                <a href="${contextPath}/category/index" class="btn btn-default"><spring:message code="app.common.action.cancel" /></a>
                            </form>
                        </div>
                    </section>
                </div>
            </div>
        </div>
        <!--body wrapper end-->
        
        <script type="text/javascript" src="${contextPath}/static/static/js/category.js"></script>
        <script type="text/javascript">
            var categorySelector = null;
            var selectCategory = function(category){
    			if(category){
    				$('input[name="parent.id"]').val(category.id);
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
	        			categorySelector = cas.category.categorySelector({title: '<spring:message code="app.category.title.selector" />'});
	        			if(categorySelector){
	        				categorySelector.open();
	        			}
	        		}
	        	});
	        	
	        	$('.data-form').validate({
	        		focusInvalid: true,
	        		rules: {
	        			name: {
	        				required: true,
	        				maxlength: 30, 
	        				remote: {
	                        	type: 'POST',
	                        	url: contextPath + '/category/validate/nameUnique',
	                        	data: {
	                        		id: function(){return $('input[name="id"]').val();},
	                        		name: function(){return $('input[name="name"]').val();}
	                        	}
	                        }
	        			}
	        		},
	        		messages: {
	        			name: {
	        				remote: '<spring:message code="app.errorNo.010001" />'
	        			}
	        		},
	        		submitHandler: function(){
	        			$('.data-form').ajaxSubmit({
	        				type: 'POST',
	        				url: '${contextPath}/category/edit/exec',
	        				success: function(r){
	        					var result = $.parseJSON(r);
	        					if(result && result.resultCode){
	        				    	if(result.resultCode == '000000'){
	        				    		BootstrapDialog.alert({
	        				    			type: BootstrapDialog.TYPE_SUCCESS,
	        				    			message: '<spring:message code="app.common.title.success" />',
	        				    			callback: function(){
	        				    				location.href = '${contextPath}/category/index';
	        				    			}
	        				    		});
	        				    	} else if(result.resultCode == '010001'){
	        				    		BootstrapDialog.alert({
	        				    			type: BootstrapDialog.TYPE_WARNING,
	        				    			message: '<spring:message code="app.errorNo.010001" />'
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