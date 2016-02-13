<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en_US">
    <head>
        <title><spring:message code="app.website.title" /></title>
    </head>
    <body>
	    <div class="clearfix"></div>
	    <!--body wrapper start-->
	    <div class="wrapper">
		    <div class="row">
			    <div class="col-sm-12">
				    <section class="panel">
					    <header class="panel-heading">
						    <span><spring:message code="app.website.title" /></span>
					    </header>
					    <div class="panel-body">
						    <form role="form" class="cmxform data-form" method="POST" action="">
							    <input type="hidden" name="id" value="${website.id}" />
							    <div class="form-group">
								    <label for="siteName" class="control-label"><spring:message code="app.website.title.siteName" /></label>
								    <input type="text" class="form-control" id="siteName" name="siteName" maxLength="30" value="${website.siteName}" placeholder="" />
							    </div>
							    <div class="form-group">
								    <label for="domain" class="control-label"><spring:message code="app.website.title.domain" /></label>
								    <input type="url" class="form-control" id="domain" name="domain" maxLength="500" value="${website.domain}" placeholder="" />
							    </div>
							    <div class="form-group">
                                    <label for="categorySelect"><spring:message code="app.category.title.category" /></label>
                                    <input type="hidden" name="category.id" value="${website.category.id}" />
                                    <input type="text" class="form-control" id="categorySelect" name="categorySelect" value="${website.category.name}" placeholder="" />
                                </div>
							    <div class="form-group">
								    <label for="charset" class="control-label"><spring:message code="app.website.title.charset" /></label>
								    <input type="text" class="form-control" id="charset" name="charset" maxLength="30" value="${website.charset}" placeholder="" />
							    </div>
							    <div class="form-group">
								    <label for="userAgent" class="control-label"><spring:message code="app.website.title.userAgent" /></label>
								    <input type="text" class="form-control" id="userAgent" name="userAgent" maxLength="200" value="${website.userAgent}" placeholder="" />
							    </div>
							    <div class="clearfix"></div>
							    <button type="submit" class="btn btn-primary"><spring:message code="app.common.action.submit" /></button>
							    <a href="${contextPath}/website/index" class="btn btn-default"><spring:message code="app.common.action.cancel" /></a>
						    </form>
					    </div>
				    </section>
			    </div>
		    </div>
	    </div>
	    <!--body wrapper end-->

	    <script type="text/javascript" src="${contextPath}/static/static/js/category.js"></script>
	    <script type="text/javascript" src="${contextPath}/static/static/js/website.js"></script>
	    <script type="text/javascript">
		    var categorySelector = null;
		    var selectCategory = function(category) {
			    if (category) {
				    $('input[name="category.id"]').val(category.id);
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
			    
			    $('.data-form').validate({
	        		focusInvalid: true,
	        		rules: {
	        			siteName: {
	        				required: true,
	        				maxlength: 30, 
	        				remote: {
	                        	type: 'POST',
	                        	url: contextPath + '/website/validate/nameUnique',
	                        	data: {
	                        		id: function(){return $('input[name="id"]').val();},
	                        		name: function(){return $('input[name="siteName"]').val();}
	                        	}
	                        }
	        			},
	        			domain: {
	        				url: true
	        			}
	        		},
	        		messages: {
	        			siteName: {
	        				remote: '<spring:message code="app.errorNo.020001" />'
	        			}
	        		},
	        		submitHandler: function(){
	        			$('.data-form').ajaxSubmit({
	        				type: 'POST',
	        				url: '${contextPath}/website/edit/exec',
	        				success: function(result){
	        					if(result && result.resultCode){
	        				    	if(result.resultCode == '000000'){
	        				    		BootstrapDialog.alert({
	        				    			type: BootstrapDialog.TYPE_SUCCESS,
	        				    			message: '<spring:message code="app.common.title.success" />',
	        				    			callback: function(){
	        				    				location.href = '${contextPath}/website/index';
	        				    			}
	        				    		});
	        				    	} else if(result.resultCode == '020001'){
	        				    		BootstrapDialog.alert({
	        				    			type: BootstrapDialog.TYPE_WARNING,
	        				    			message: '<spring:message code="app.errorNo.020001" />'
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