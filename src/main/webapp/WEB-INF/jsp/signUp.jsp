<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ include file="./include/importTags.jsp" %>

<div class="row justify-content-center">
    <div class="col-md-8 col-lg-6">
        <div class="card">
            <div class="card-body">
                <h1 class="text-center mb-4"><spring:message code="signup.title"/></h1>

                <form:form method="post" modelAttribute="userForm">
                    <div class="mb-3">
                        <form:label path="username" cssClass="form-label"><spring:message code="signup.username" /></form:label>
                        <form:input path="username" cssClass="form-control"/>
                        <form:errors path="username" cssClass="text-danger"/>
                    </div>

                    <div class="mb-3">
                        <form:label path="password" cssClass="form-label"><spring:message code="signup.password" /></form:label>
                        <form:password path="password" cssClass="form-control"/>
                        <form:errors path="password" cssClass="text-danger"/>
                    </div>

                    <div class="mb-3">
                        <label class="form-label"><spring:message code="signup.confirmPassword" /></label>
                        <input type="password" id="confirmPassword" name="confirmPassword" class="form-control"/>
                        <form:errors path="password" cssClass="text-danger"/>
                    </div>

                    <div class="mb-3">
                        <form:label path="firstName" cssClass="form-label"><spring:message code="signup.firstName" /></form:label>
                        <form:input path="firstName" cssClass="form-control"/>
                        <form:errors path="firstName" cssClass="text-danger"/>
                    </div>

                    <div class="mb-3">
                        <form:label path="lastName" cssClass="form-label"><spring:message code="signup.lastName" /></form:label>
                        <form:input path="lastName" cssClass="form-control"/>
                        <form:errors path="lastName" cssClass="text-danger"/>
                    </div>

                    <div class="mb-3">
                        <form:label path="email" cssClass="form-label"><spring:message code="signup.email" /></form:label>
                        <form:input path="email" cssClass="form-control"/>
                        <form:errors path="email" cssClass="text-danger"/>
                    </div>

                    <div class="mb-3">
                        <form:label path="address" cssClass="form-label"><spring:message code="signup.address" /></form:label>
                        <form:input path="address" cssClass="form-control"/>
                        <form:errors path="address" cssClass="text-danger"/>
                    </div>

                    <div class="mb-3">
                        <form:label path="phoneNumber" cssClass="form-label"><spring:message code="signup.phoneNumber" /></form:label>
                        <form:input path="phoneNumber" cssClass="form-control"/>
                        <form:errors path="phoneNumber" cssClass="text-danger"/>
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
                            <form:radiobutton path="isMan" cssClass="form-check-input" id="notSpecifiedRadio" value=""/>
                            <label class="form-check-label" for="notSpecifiedRadio">
                                <spring:message code="editAccount.gender.notSpecified" />
                            </label>
                        </div>
                        <form:errors path="isMan" cssClass="text-danger"/>
                    </div>
                    <button type="submit" class="btn btn-primary w-100"> <spring:message code="signup.submit" /> </button>
                </form:form>
            </div>
        </div>
    </div>
</div>
