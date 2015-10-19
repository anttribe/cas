<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="gadget" uri="/gadget" %>

<div id="content" class="pb20">
    <ul id="topicTabs" class="nav nav-flat f14">
        <li role="presentation" class="active"><a href="#recommend" data-url="${contextPath}/article/recommend"><spring:message code="app.article.title.recommend" /></a></li>
        <li role="presentation"><a href="#hotArticles" data-url="${contextPath}/article/hotArticles"><spring:message code="app.article.title.hotArticles" /></a></li>
        <c:forEach items="${topics}" var="topic">
            <li><a class="ajax-link" href="#${topic.topicId}" data-value="${topic.topicId}" data-url="${contextPath}/article/topicArticles?topic=${topic.topicId}"><span> ${topic.topicName}</span></a></li>
        </c:forEach>
    </ul>
    <div class="tab-content pt10 pb10">
        <div class="tab-pane active" id="recommend">
            <iframe src="${contextPath}/article/recommend"></iframe>
        </div>
        <div class="tab-pane" id="hotArticles">
        </div>
        <c:forEach items="${topics}" var="topic">
            <div class="tab-pane" id="${topic.topicId}">
            </div>
        </c:forEach>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function(){
	    $('#topicTabs a').click(function (e) {
	        e.preventDefault();
	        $(this).tab('show');
	        
	        // tab页签点击时生成
	        var tabBodyHref = $(this).attr('href');
	        var dataUrl = $(this).attr('data-url');
	        if(tabBodyHref && dataUrl){
	        	if($('iframe[src="' + dataUrl + '"]', '' + tabBodyHref).length <= 0){
	        		$('<iframe>', {
	        			'src': '' + dataUrl,
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
	        	    }).appendTo(tabBodyHref);
	        	}
	        }
	    });
    });
</script>
</html>