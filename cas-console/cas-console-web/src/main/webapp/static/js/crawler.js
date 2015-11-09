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
		},
		_angulars: {},
		listContentAttrAngulars: function(contentType){
			if(contentType){
				var angulars = cas.crawler._angulars[contentType];
				if(!angulars){
					cas.contentAttribute.listContentAttributes({
						'contentType.id': contentType
					}, function(attributes){
						var angulars = [];
						if(attributes && attributes.length>0){
							for(var i=0; i<attributes.length; i++){
								var attribute = attributes[i];
								if(attribute){
									angulars.push({
										attribute: attribute
									});
								}
							}
						}
						cas.crawler.showContentAttrAngulars(angulars);
					});
					return;
				}
				cas.crawler.showContentAttrAngulars(angulars);
			}
		},
		showContentAttrAngulars: function(angulars){
			var $html = '';
			if(angulars && angulars.length>0){
				cas.crawler._angulars[contentType] = angulars;
				for(var i=0; i<angulars.length; i++){
					var angular = angulars[i];
					if(angular){
						$html += '<div class="form-group">'
							   + '<label for="' + (angular['id'] || '') + '">' + (angular['attribute'] && angular['attribute']['name'])  + '</label>'
							   + '<input type="hidden" name="regulars[' + i + '].id" value="' + (angular['id'] || '') + '" />'
							   + '<input type="text" class="form-control" id="' + (angular['id'] || '') + '" name="regulars[' + i + '].regular" value="' + (angular['regular'] || '') + '" placeholder="" />'
							   + '</div>';
					}
				}
			}
			
			$('#contentAttrRegulars').empty();
			if($html){
				$('#contentAttrRegulars').append($html);
			}
		}
	}
});