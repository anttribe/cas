var cas = cas || {};
$.extend(cas, {
	website: {
		listWebsites: function(criteria, callback){
	        $.ajax({
	        	type: 'POST',
	        	async: false,
	        	url: contextPath + '/website/list/exec',
	        	data: criteria || {},
	        	success: function(result){
	        		if(result && callback){
	        			var r = $.parseJSON(result);
	        			callback.call(this, r['data']);
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
		        			callback.call(this, $.parseJSON(website));
		        		}
		        	}
		        });
			}
		},
		goEditWebsite: function(websiteId){
			if(websiteId){
				location.href = contextPath + '/website/edit' + '?id=' + websiteId;
			}
		},
		deleteWebsite: function(websiteId){
			if(websiteId){
			}
		}
	}
});