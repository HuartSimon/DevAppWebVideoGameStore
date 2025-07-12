<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<h1><spring:message code="payment.failure.title"/></h1>

<p><spring:message code="payment.failure.message"/></p>
<a href="<spring:url value="/home"/>"><spring:message code="button.home"/></a>
