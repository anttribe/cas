var cas = cas || {};
$.extend(cas, {
	category: {
		listCategoriesByParent : function(parent, callback){
	        $.ajax({
	        	type: 'POST',
	        	url: contextPath + '/category/list',
	        	success: function(result){
	        		if(result && result['resultCode'] == '000000'){
	        			var datas = result['data'];
	        			if(callback){
        					callback.call(this, datas);
        				}
	        		}
	        	}
	        });
		}
	}
});