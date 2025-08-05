<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<div class="row justify-content-center">
    <div class="col-md-6 col-lg-5">
        <div class="card">
            <div class="card-body">
                <h1 class="card-title text-center mb-4">
                    <spring:message code="changePassword.title" />
                </h1>

                <form:form method="post" modelAttribute="currentUser">
                    <div class="mb-3">
                        <label class="form-label">
                            <spring:message code="changePassword.oldPassword.label" />
                        </label>
                        <input type="password" name="oldPassword" class="form-control" required />
                    </div>

                    <div class="mb-3">
                        <label class="form-label">
                            <spring:message code="changePassword.newPassword.label" />
                        </label>
                        <input type="password" name="newPassword" class="form-control" required />
                    </div>

                    <div class="mb-3">
                        <label class="form-label">
                            <spring:message code="changePassword.confirmPassword.label"/>
                        </label>
                        <input type="password" name="confirmedNewPassword" class="form-control" required />
                    </div>

                    <c:if test="${oldPasswordError}">
                        <div class="alert alert-danger" role="alert">
                            <spring:message code="Password.oldPassword" />
                        </div>
                    </c:if>
                    <c:if test="${confirmedNewPasswordError}">
                        <div class="alert alert-danger" role="alert">
                            <spring:message code="Password.mismatch"/>
                        </div>
                    </c:if>

                    <button type="submit" class="btn btn-primary w-100"> <spring:message code="changePassword.submit"/> </button>
                </form:form>
            </div>
        </div>
    </div>
</div>
