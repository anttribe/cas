var cas = cas || {};
$.extend(cas, {
	contentAttribute: {
		listContentAttributes: function(criteria, callback){
	        $.ajax({
	        	type: 'POST',
	        	async: false,
	        	url: contextPath + '/contentAttribute/list/exec',
	        	data: criteria || {},
	        	success: function(result){
	        		if(callback){
	        			callback.call(this, result);
	        		}
	        	}
	        });
		},
		goEditContentAttribute: function(contentAttributeId){
			if(contentAttributeId){
				location.href = contextPath + '/contentAttribute/goEdit' + '?id=' + contentAttributeId;
			}
		},
		deleteContentAttribute: function(contentAttributeId){
			if(contentAttributeId){
				location.href = contextPath + '/contentAttribute/delete' + '?id=' + contentAttributeId;
			}
		}
	}
});