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
					$('td.details-open', item).on('click', function(oTable){
						return function(){
							if(oSettings.bRowChild){
							    _fnRowChildCallback(oSettings, $(this), oTable);
						    } else if(oSettings.bRowDetail){
							    _fnRowDetailCallback(oSettings, $(this), oTable);
						    }
						};
					}(oTable));
				}
			});
		}
		
		function _fnRowDetailCallback(oSettings, nTd, oTable){
			var nTr = $(nTd).closest('tr')[0];
			if(oTable.fnIsOpen(nTr)){
				$(nTd).removeClass('details-close').addClass('details-open');
	            oTable.fnClose( nTr );
	        } else {
	        	$(nTd).removeClass('details-open').addClass('details-close');
	            oTable.fnOpen( nTr, (oSettings.fnRowDetailCallback && oSettings.fnRowDetailCallback.call(this, oTable, nTr)), 'details');
	        }
		}
		
        function _fnRowChildCallback(oSettings, nTd, oTable){
        	var nTr = $(nTd).closest('tr')[0];
        	if(!$(nTr).next().hasClass('child-table')){
        		$('<td colspan="' + (oTable._fnVisbleColumns()) + '">').appendTo($('<tr class="child-table">').insertAfter(nTr));
        	} else if($('td', $(nTr).next()).length<=0){
        		$('<td colspan="' + (oTable._fnVisbleColumns()) + '">').appendTo($(nTr).next());
        	}
        	var newTd = $('td', $(nTr).next('.child-table'));
        	if ($(nTd).hasClass('details-close')){
				$(nTd).removeClass('details-close').addClass('details-open');
				$(newTd).hide();
	        } else{
	        	$(nTd).removeClass('details-open').addClass('details-close');
	        	if(oSettings.fnRowChildCallback){
            		oSettings.fnRowChildCallback.call(this, oTable.fnGetData(nTr), newTd);
            	}
	        	$(newTd).show();
			}
		}
	};
	
	$.fn.datatable_ext = datatable_ext;
	$.fn.dataTable_ext = datatable_ext;
	$.fn.DataTable_ext = datatable_ext;
})(jQuery, window);