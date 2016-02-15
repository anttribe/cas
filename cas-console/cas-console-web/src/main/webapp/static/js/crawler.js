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
	        			callback.call(this, $.parseJSON(result));
	        		}
	        	}
	        });
		},
		_regulars: {},
		listContentAttrRegulars: function(contentType){
			if(contentType){
				var regulars = cas.crawler._regulars[contentType];
				if(!regulars){
					cas.contentAttribute.listContentAttributes({
						'contentType.id': contentType
					}, function(attributes){
						var regulars = [];
						if(attributes && attributes.length>0){
							for(var i=0; i<attributes.length; i++){
								var attribute = attributes[i];
								if(attribute){
									regulars.push({
										attribute: attribute
									});
								}
							}
						}
						cas.crawler.showContentAttrAngulars(regulars);
					});
					return;
				}
				cas.crawler.showContentAttrAngulars(regulars);
			}
		},
		showContentAttrAngulars: function(regulars){
			var $html = '';
			if(regulars && regulars.length>0){
				cas.crawler._regulars[contentType] = regulars;
				for(var i=0; i<regulars.length; i++){
					var regular = regulars[i];
					if(regular){
						console.log(regular);
						$html += '<div class="form-group">'
							   + '<label class="control-label">' + (regular['attribute'] && regular['attribute']['name']) + '</label>'
							   + '<input type="hidden" name="regulars[' + i + '].id" value="' + (regular['id'] || '') + '" />'
							   + '<input type="hidden" name="regulars[' + i + '].attribute" value="' + (regular['attribute'] && regular['attribute']['id']) + '" />'
							   + '<input type="text" class="form-control" name="regulars[' + i + '].regular" value="' + (regular['regular'] || '') + '" placeholder="" />'
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