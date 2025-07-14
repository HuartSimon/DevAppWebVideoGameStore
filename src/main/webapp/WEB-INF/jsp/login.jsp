<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<h1><spring:message code="login.title"/></h1>

<form:form method="post" modelAttribute="currentUser">
    <form:label path="username"><spring:message code="login.username" /></form:label>
    <form:input path="username"/>

    <form:label path="password"><spring:message code="login.password" /></form:label>
    <form:password path="password"/>

    <c:if test="${param.error}">
        <p><spring:message code="login.error" /></p>
    </c:if>

    <form:button><spring:message code="login.button" /></form:button>
</form:form>