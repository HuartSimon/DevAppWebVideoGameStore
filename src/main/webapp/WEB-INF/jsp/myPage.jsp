<%--<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>--%>
<%--<%@include file="./include/importTags.jsp"%>--%>

<%--<p>--%>
<%--    <spring:message code="myPage.username"/> ${currentUser.username}--%>
<%--    <br>--%>
<%--    <spring:message code="myPage.firstName"/> ${currentUser.firstName}--%>
<%--    <br>--%>
<%--    <spring:message code="myPage.lastName"/> ${currentUser.lastName}--%>
<%--    <br>--%>
<%--    <spring:message code="myPage.email"/> ${currentUser.email}--%>
<%--    <br>--%>
<%--    <spring:message code="myPage.phoneNumber"/> ${currentUser.phoneNumber}--%>
<%--    <br>--%>
<%--    <spring:message code="myPage.address"/> ${currentUser.address}--%>
<%--    <br>--%>

<%--    <c:set var="maleLabel"> <spring:message code="myPage.gender.male" /> </c:set>--%>
<%--    <c:set var="femaleLabel"> <spring:message code="myPage.gender.female" /> </c:set>--%>
<%--    <spring:message code="myPage.gender"/> ${currentUser.isMan ? maleLabel : femaleLabel}--%>
<%--</p>--%>

<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8 col-lg-6">
            <div class="card shadow-sm">
                <div class="card-body">
                    <h4 class="card-title mb-4">
                        <spring:message code="myPage.title" />
                    </h4>

                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <strong><spring:message code="myPage.username"/>:</strong>
                            ${currentUser.username}
                        </li>
                        <li class="list-group-item">
                            <strong><spring:message code="myPage.firstName"/>:</strong>
                            ${currentUser.firstName}
                        </li>
                        <li class="list-group-item">
                            <strong><spring:message code="myPage.lastName"/>:</strong>
                            ${currentUser.lastName}
                        </li>
                        <li class="list-group-item">
                            <strong><spring:message code="myPage.email"/>:</strong>
                            ${currentUser.email}
                        </li>
                        <li class="list-group-item">
                            <strong><spring:message code="myPage.phoneNumber"/>:</strong>
                            ${currentUser.phoneNumber}
                        </li>
                        <li class="list-group-item">
                            <strong><spring:message code="myPage.address"/>:</strong>
                            ${currentUser.address}
                        </li>
                        <li class="list-group-item">
                            <c:set var="maleLabel"><spring:message code="myPage.gender.male" /></c:set>
                            <c:set var="femaleLabel"><spring:message code="myPage.gender.female" /></c:set>
                            <strong><spring:message code="myPage.gender"/>:</strong>
                            ${currentUser.isMan ? maleLabel : femaleLabel}
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
