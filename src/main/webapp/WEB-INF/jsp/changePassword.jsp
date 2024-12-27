<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<h1>Change your password</h1>

<form:form method="post" modelAttribute="currentUser">
    <c:if test="${not empty oldPasswordError}">
        <p style="color: red">${oldPasswordError}</p>
    </c:if>
    <label>The old password : </label>
    <input type="password" name="oldPassword" required/>
    <br>

    <label>New Password : </label>
    <input type="password" name="newPassword" required/>
    <br>

    <c:if test="${not empty confirmedNewPasswordError}">
        <p style="color: red">${confirmedNewPasswordError}</p>
    </c:if>
    <label>Confirm the new Password : </label>
    <input type="password" name="confirmedNewPassword" required/>
    <br>

    <form:button>Edit</form:button>
</form:form>