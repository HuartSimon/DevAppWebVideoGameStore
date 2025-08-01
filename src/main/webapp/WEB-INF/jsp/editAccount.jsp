<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<div class="row justify-content-center">
    <div class="col-md-8 col-lg-6">
        <div class="card">
            <div class="card-body">
                <h1 class="card-title text-center mb-4">
                    <spring:message code="editAccount.title" />
                </h1>

                <form:form method="post" modelAttribute="editUserForm">

                    <div class="mb-3 d-flex justify-content-between align-items-center">
                        <label class="form-label m-0">
                            <spring:message code="editAccount.passwordLabel" />
                        </label>
                        <a href="<spring:url value='/changePassword'/>">
                            <spring:message code="editAccount.changePasswordLink" />
                        </a>
                    </div>

                    <div class="mb-3">
                        <form:label path="firstName" cssClass="form-label">
                            <spring:message code="editAccount.firstNameLabel" />
                        </form:label>
                        <form:input path="firstName" cssClass="form-control" />
                    </div>

                    <div class="mb-3">
                        <form:label path="lastName" cssClass="form-label">
                            <spring:message code="editAccount.lastNameLabel" />
                        </form:label>
                        <form:input path="lastName" cssClass="form-control" />
                    </div>

                    <div class="mb-3">
                        <form:label path="address" cssClass="form-label">
                            <spring:message code="editAccount.addressLabel" />
                        </form:label>
                        <form:input path="address" cssClass="form-control" />
                    </div>

                    <div class="mb-3">
                        <form:label path="phoneNumber" cssClass="form-label">
                            <spring:message code="editAccount.phoneNumberLabel" />
                        </form:label>
                        <form:input path="phoneNumber" cssClass="form-control" />
                    </div>

                    <div class="mb-3">
                        <form:label path="isMan" cssClass="form-label d-block mb-2">
                            <spring:message code="editAccount.genderLabel" />
                        </form:label>
                        <div class="form-check form-check-inline">
                            <form:radiobutton path="isMan" cssClass="form-check-input" id="maleRadio" value="true" />
                            <label class="form-check-label" for="maleRadio">
                                <spring:message code="editAccount.gender.male" />
                            </label>
                        </div>
                        <div class="form-check form-check-inline">
                            <form:radiobutton path="isMan" cssClass="form-check-input" id="femaleRadio" value="false" />
                            <label class="form-check-label" for="femaleRadio">
                                <spring:message code="editAccount.gender.female" />
                            </label>
                        </div>
                        <div class="form-check form-check-inline">
                            <form:radiobutton path="isMan" cssClass="form-check-input" id="notSpecifiedRadio" value="" />
                            <label class="form-check-label" for="notSpecifiedRadio">
                                <spring:message code="editAccount.gender.notSpecified" />
                            </label>
                        </div>
                    </div>

                    <c:if test="${not empty validationErrors}">
                        <div class="alert alert-danger">
                            <ul class="mb-0">
                                <c:forEach items="${validationErrors}" var="error">
                                    <li>${error}</li>
                                </c:forEach>
                            </ul>
                        </div>
                    </c:if>

                    <button class="btn btn-primary w-100"> <spring:message code="editAccount.submit" /> </button>
                </form:form>
            </div>
        </div>
    </div>
</div>
