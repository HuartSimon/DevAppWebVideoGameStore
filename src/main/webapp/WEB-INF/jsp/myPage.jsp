<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<p>
    Username : ${pageContext.request.userPrincipal.principal.username}
    <br>
    First Name : ${pageContext.request.userPrincipal.principal.firstName}
    <br>
    Last Name : ${pageContext.request.userPrincipal.principal.lastName}
    <br>
    ...
</p>