var cas = cas || {};
$.extend(cas, {
	website: {
		listWebsites: function(criteria, callback){
	        $.ajax({
	        	type: 'POST',
	        	async: false,
	        	url: contextPath + '/website/list',
	        	data: criteria || {},
	        	success: function(result){
	        		if(result && callback){
	        			callback.call(this, result);
	        		}
	        	}
	        });
		},
		loadWebsite: function(websiteId, callback){
			if(websiteId){
				$.ajax({
		        	type: 'POST',
		        	async: false,
		        	url: contextPath + '/website/load',
		        	data: {id: websiteId},
		        	success: function(website){
		        		if(website && callback){
		        			callback.call(this, website);
		        		}
		        	}
		        });
			}
		},
		goEditWebsite: function(websiteId){
			if(websiteId){
				location.href = contextPath + '/website/goEdit' + '?id=' + websiteId;
			}
		},
		deleteWebsite: function(websiteId){
			if(websiteId){
				location.href = contextPath + '/website/delete' + '?id=' + websiteId;
			}
		}
	}
});