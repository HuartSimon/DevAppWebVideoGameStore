<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<h1>Login</h1>

<form:form method="post" modelAttribute="user">
    <form:label path="username">Username</form:label>
    <form:input path="username"/>

    <form:label path="password">Password</form:label>
    <form:input path="password"/>

    <c:if test="${param.error}">
        <p>Invalid username or password. Please try again.</p>
    </c:if>

    <form:button>Login</form:button>
</form:form>