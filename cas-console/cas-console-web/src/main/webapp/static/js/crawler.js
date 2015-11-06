var cas = cas || {};
$.extend(cas, {
	crawler: {
		listCrawlers: function(criteria, callback){
	        $.ajax({
	        	type: 'POST',
	        	async: false,
	        	url: contextPath + '/crawler/list',
	        	data: criteria || {},
	        	success: function(result){
	        		if(result && callback){
	        			callback.call(this, result);
	        		}
	        	}
	        });
		}
	}
});