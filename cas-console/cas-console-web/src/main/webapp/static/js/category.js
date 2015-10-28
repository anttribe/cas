var cas = cas || {};
$.extend(cas, {
	category: {
		listCategoriesByParent : function(parent, callback){
	        $.ajax({
	        	type: 'POST',
	        	async: false,
	        	url: contextPath + '/category/list',
	        	data: {parent: parent},
	        	success: function(result){
	        		if(result && callback){
	        			callback.call(this, result);
	        		}
	        	}
	        });
		}
	}
});