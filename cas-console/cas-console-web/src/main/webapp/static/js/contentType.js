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
    	goEditContentType: function(contentTypeId){
			if(contentTypeId){
				location.href = contextPath + '/contentType/goEdit' + '?id=' + contentTypeId;
			}
		},
		deleteContentType: function(contentTypeId){
			if(contentTypeId){
				location.href = contextPath + '/contentType/delete' + '?id=' + contentTypeId;
			}
		}
	}
});