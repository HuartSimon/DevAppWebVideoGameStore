<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<div class="row justify-content-center">
    <div class="col-md-8 col-lg-6">
        <div class="card">
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
                        <c:set var="nonSpecifiedLabel"><spring:message code="myPage.gender.nonSpecified" /></c:set>
                        <strong><spring:message code="myPage.gender"/>:</strong>
                        ${currentUser.isMan ? maleLabel : (currentUser.isMan == null ? nonSpecifiedLabel : femaleLabel)}
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
