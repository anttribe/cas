<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container-fluid">
            <div class="row">
                <div id="article-list">
                    <c:forEach items="${articles}" var="article">
                        <div class="item">
                            <c:if test="${null != article.thumbnail}">
                                <a class="pull-left thumb" href="#" style="background-image: url(${article.thumbnail});"></a>
                            </c:if>
                            <div class="metadata">
                                <a class="title" href="#">${article.title}</a>
                                <div class="author">
                                    <a href="javascript:void(0);">${article.author}</a>&nbsp;â¢&nbsp;<span class="time">${article.publishTime}</span>
                                </div>
                                <div class="brief">${article.brief}</div>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>