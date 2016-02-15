var cas = cas || {};
$.extend(cas, {
	contentType: {
		listContentTypes: function(callback){
	        $.ajax({
	        	type: 'POST',
	        	async: false,
	        	url: contextPath + '/contentType/list/exec',
	        	data: {},
	        	success: function(result){
	        		if(result && callback){
	        			callback.call(this, $.parseJSON(result));
	        		}
	        	}
	        });
		},
    	goEditContentType: function(contentTypeId){
			if(contentTypeId){
				location.href = contextPath + '/contentType/edit' + '?id=' + contentTypeId;
			}
		},
		deleteContentType: function(contentTypeId){
			if(contentTypeId){
				location.href = contextPath + '/contentType/delete' + '?id=' + contentTypeId;
			}
		}
	}
});