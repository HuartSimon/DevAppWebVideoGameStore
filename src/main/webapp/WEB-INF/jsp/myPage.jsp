<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<p>
    <spring:message code="myPage.username"/> ${currentUser.username}
    <br>
    <spring:message code="myPage.firstName"/> ${currentUser.firstName}
    <br>
    <spring:message code="myPage.lastName"/> ${currentUser.lastName}
    <br>
    <spring:message code="myPage.email"/> ${currentUser.email}
    <br>
    <spring:message code="myPage.phoneNumber"/> ${currentUser.phoneNumber}
    <br>
    <spring:message code="myPage.address"/> ${currentUser.address}
    <br>

    <c:set var="maleLabel"> <spring:message code="myPage.gender.male" /> </c:set>
    <c:set var="femaleLabel"> <spring:message code="myPage.gender.female" /> </c:set>
    <spring:message code="myPage.gender"/> ${currentUser.isMan ? maleLabel : femaleLabel}
</p>