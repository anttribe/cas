var cas = cas || {};
$.extend(cas, {
	category: {
		listCategoriesByParent: function(parent, callback){
	        $.ajax({
	        	type: 'POST',
	        	async: false,
	        	url: contextPath + '/category/list/exec',
	        	data: {'parent.id': parent},
	        	success: function(result){
	        		if(result && callback){
	        			callback.call(this, $.parseJSON(result));
	        		}
	        	}
	        });
		},
		goEditCategory: function(categoryId){
			if(categoryId){
				location.href = contextPath + '/category/edit' + '?id=' + categoryId;
			}
		},
		deleteCategory: function(categoryId){
			if(categoryId){
			}
		},
		categorySelector: function(options){
			return new BootstrapDialog({
				size: BootstrapDialog.SIZE_NORMAL,
				type: BootstrapDialog.TYPE_DEFAULT,
				draggable: true,
				closable: true,
	            title: (options && options.title) || '',
	            message: $('<div></div>').load(contextPath + '/category/tool/selector'),
	            buttons: [{
	            	label: BootstrapDialog.DEFAULT_TEXTS.CANCEL,
	            	action: function(dialogRef) {
	            		dialogRef.close();
	                }
	            }]
	        });
		},
		selectCategory: function(category){
    		if(category){
    			(window || window.parent).selectCategory(category);
    		}
    	}
	}
});