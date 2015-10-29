var cas = cas || {};
$.extend(cas, {
	category: {
		listCategoriesByParent: function(parent, callback){
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
		},
		categorySelector: function(){
			return new BootstrapDialog({
				size: BootstrapDialog.SIZE_NORMAL,
				type: BootstrapDialog.TYPE_DEFAULT,
				draggable: true,
				closable: true,
	            title: '<div class="model-header-title">选择分类</div>',
	            message: $('<div></div>').load(contextPath + '/category/select.tool')
	        });
		},
		selectCategory: function(category){
    		if(category){
    			(window || window.parent).selectCategory(category);
    		}
    	}
	}
});