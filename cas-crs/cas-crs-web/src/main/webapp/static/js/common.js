var index = {
    changeTheme: function(themeId){  // 切换皮肤
	    $('#theme-css').attr('href', contextPath + '/themes/' + themeId + '/css/' + themeId + '.css');
	    
	    function changeIframeTheme(d, themeId){
	    	if(d && $('iframe', d).length > 0){
	    		$('iframe', d).each(function(index, iframe){
		    		if(this.contentWindow){
		    			$('#theme-css', this.contentWindow.document).attr('href', contextPath + '/themes/' + themeId + '/css/' + themeId + '.css');
		    			changeIframeTheme(this.contentWindow.document, themeId);
		    		}
		    	});
	    	}
	    }
	    changeIframeTheme(document, themeId);
    }
};
$(document).ready(function(){
    // 获取当前皮肤
	var currentTheme = $.cookie('theme');
	if(currentTheme){
	    index.changeTheme(currentTheme);
	    $('#themes a[data-value="' + currentTheme + '"]').find('i')
	    .removeClass('whitespace').addClass('glyphicon glyphicon-ok')
	    .siblings().removeClass('glyphicon glyphicon-ok whitespace').addClass('whitespace');
	}
	    	
	$('#themes a').click(function(e){
	    // 阻止浏览器默认事件
	    e.preventDefault();
			    
        currentTheme = $(this).attr('data-value');
		$.cookie('theme', currentTheme, {expires:365});
		index.changeTheme(currentTheme);
		$('#themes i').removeClass('glyphicon glyphicon-ok whitespace').addClass('whitespace');
		$(this).find('i').removeClass('whitespace').addClass('glyphicon glyphicon-ok');
	});
	
	// 处理页面上所有iframe
	$('iframe').attr({
		frameborder: 'no',
        marginheight: '10px',
        width: '100%',
        scrolling: 'no',
        seamless: 'seamless'
    }).bind({
        'load': function () {
            if (this && this.contentWindow) {
                var contentHeight = Math.max(this.contentWindow.document.documentElement.scrollHeight, this.contentWindow.document.body.scrollHeight);
                var windowHeight = Math.max(window.document.documentElement.scrollHeight, window.document.body.scrollHeight);
                var maxHeight = Math.max(contentHeight, windowHeight);
                $(this).height(maxHeight);
                $(window).height(maxHeight).scrollTop(0);
                //$(this.contentWindow).height(maxHeight).scrollTop(0);

                if (window.frameElement) {
                    if ($(window.frameElement).is('iframe') && window.frameElement.contentWindow) {
                        contentHeight = Math.max(window.frameElement.contentWindow.document.documentElement.scrollHeight, window.frameElement.contentWindow.document.body.scrollHeight);
                        $(window.frameElement).height(contentHeight);
                    }
                }
            }
        }
    });
});