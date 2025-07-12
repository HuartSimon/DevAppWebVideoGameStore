<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<h1><spring:message code="changePassword.title" /></h1>

<form:form method="post" modelAttribute="currentUser">
    <c:if test="${oldPasswordError}">
        < style="color: red"><spring:message code="Password.oldPassword" /></p>
    </c:if>
    <label><spring:message code="changePassword.oldPassword.label" /></label>
    <input type="password" name="oldPassword" required/>
    <br>

    <label><spring:message code="changePassword.newPassword.label" />></label>
    <input type="password" name="newPassword" required/>
    <br>

    <c:if test="confirmedNewPasswordError">
        <p style="color: #ef0d0d"><spring:message code="Password.mismatch"/></p>
    </c:if>
    <label><spring:message code="changePassword.confirmPassword.label"/></label>
    <input type="password" name="confirmedNewPassword" required/>
    <br>

    <form:button><spring:message code="changePassword.submit"/></form:button>
</form:form>