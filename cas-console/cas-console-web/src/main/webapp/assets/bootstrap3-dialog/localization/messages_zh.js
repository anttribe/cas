(function(){
	$.extend(BootstrapDialog.DEFAULT_TEXTS, {
	    'OK': '确定',
	    'CANCEL': '取消',
	    'CONFIRM': '确认'
	});
	BootstrapDialog.DEFAULT_TEXTS[BootstrapDialog.TYPE_DEFAULT] = '消息';
    BootstrapDialog.DEFAULT_TEXTS[BootstrapDialog.TYPE_INFO] = '消息';
    BootstrapDialog.DEFAULT_TEXTS[BootstrapDialog.TYPE_PRIMARY] = '消息';
    BootstrapDialog.DEFAULT_TEXTS[BootstrapDialog.TYPE_SUCCESS] = '成功';
    BootstrapDialog.DEFAULT_TEXTS[BootstrapDialog.TYPE_WARNING] = '警告';
    BootstrapDialog.DEFAULT_TEXTS[BootstrapDialog.TYPE_DANGER] = '危险';
    
})($);