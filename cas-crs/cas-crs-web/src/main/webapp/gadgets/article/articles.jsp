<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="gadget" uri="/gadget" %>

<div id="content" class="pb20">
    <ul id="topicTabs" class="nav nav-flat f14">
        <li role="presentation" class="active"><a href="#recommend"><spring:message code="app.article.title.recommend" /></a></li>
        <li role="presentation"><a href="#hotArticles"><spring:message code="app.article.title.hotArticles" /></a></li>
        <c:forEach items="${topics}" var="topic">
            <li><a class="ajax-link" href="#${topic.topicId}" data-value="${topic.topicId}"><span> ${topic.topicName}</span></a></li>
        </c:forEach>
    </ul>
    <div class="tab-content pt10 pb10">
        <div class="tab-pane active" id="recommend">
            <iframe src="${contextPath}/article/recommend"></iframe>
        </div>
        <div class="tab-pane" id="hotArticles">
            <iframe src="${contextPath}/article/hotArticles"></iframe>
        </div>
        <c:forEach items="${topics}" var="topic">
            <div class="tab-pane" id="${topic.topicId}">
                <iframe data-value="${topic.topicId}" src="${contextPath}/article/topicArticles?topic=${topic.topicId}"></iframe>
            </div>
        </c:forEach>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function(){
	    $('#topicTabs a').click(function (e) {
	        e.preventDefault();
	        $(this).tab('show');
	    });
    });
</script>
</html>