var cas = cas || {};
$.extend(cas, {
	contentAttribute: {
		listContentAttributes: function(criteria, callback){
	        $.ajax({
	        	type: 'POST',
	        	async: false,
	        	url: contextPath + '/contentAttribute/list',
	        	data: criteria || {},
	        	success: function(result){
	        		if(callback){
	        			callback.call(this, result);
	        		}
	        	}
	        });
		}
	}
});