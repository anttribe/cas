var cas = cas || {};
$.extend(cas, {
	contentType: {
		listContentTypes: function(callback){
	        $.ajax({
	        	type: 'POST',
	        	async: false,
	        	url: contextPath + '/contentType/list',
	        	data: {},
	        	success: function(result){
	        		if(result && callback){
	        			callback.call(this, result);
	        		}
	        	}
	        });
		},
		contentTypeSelector: function(){
			return new BootstrapDialog({
				size: BootstrapDialog.SIZE_NORMAL,
				type: BootstrapDialog.TYPE_DEFAULT,
				draggable: true,
				closable: true,
	            title: '<div class="model-header-title">选择内容类型</div>',
	            message: $('<div></div>').load(contextPath + '/contentType/select.tool')
	        });
		},
		selectContentType: function(contentType){
    		if(contentType){
    			(window || window.parent).selectContentType(contentType);
    		}
    	}
	}
});