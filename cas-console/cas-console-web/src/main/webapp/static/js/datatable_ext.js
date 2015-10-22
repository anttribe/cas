(function ($, window) {
	var datatable_ext = function(oSettings){
		if(this.length>0){
			this.each(function(i, item){
				if(item && (oSettings.bRowChild || oSettings.bRowDetail)){
					$('<th>').insertBefore($('th:first-child', $('tr', item)));
					var tbody = $('tbody', item);
					if(tbody){
						$('<td>', {
							'class': 'details-open'
						}).insertBefore($('td:first-child', $('tr', tbody)));
					}
				}
				var oTable = $(this).dataTable(oSettings);
				if(item && (oSettings.bRowChild || oSettings.bRowDetail)){
					$('td.details-open', item).on('click', function(){
						if(oSettings.bRowChild){
							_fnRowChildCallback(oSettings, $(this), oTable);
						} else if(oSettings.bRowDetail){
							_fnRowDetailCallback();
						}
					});
				}
			});
		}
		
		function _fnRowDetailCallback(oSettings, nTd){
			var nTr = $(this).parents('tr')[0];
		}
		
        function _fnRowChildCallback(oSettings, nTd, oTable){
        	var nTr = $(nTd).parents('tr')[0];
        	if ($(nTd).hasClass('details-close')){
				$(nTd).removeClass('details-close').addClass('details-open');
	        } else{
	        	$(nTd).removeClass('details-open').addClass('details-close');
	        	if(oSettings.fnRowChildCallback){
            		return oSettings.fnRowChildCallback.call(this, oTable.fnGetData(nTr));
            	}
			}
		}
	};
	
	$.fn.datatable_ext = datatable_ext;
	$.fn.dataTable_ext = datatable_ext;
	$.fn.DataTable_ext = datatable_ext;
})(jQuery, window);