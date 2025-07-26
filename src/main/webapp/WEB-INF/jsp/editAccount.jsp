<%--<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>--%>
<%--<%@include file="./include/importTags.jsp"%>--%>

<%--<h1><spring:message code="editAccount.title" /></h1>--%>

<%--<form:form method="post" modelAttribute="currentUser">--%>
<%--    <label><spring:message code="editAccount.passwordLabel" /></label>--%>
<%--    <a href="<spring:url value="/changePassword"/>"><spring:message code="editAccount.changePasswordLink" /></a>--%>
<%--    <br>--%>

<%--    <form:label path="firstName"><spring:message code="editAccount.firstNameLabel" /></form:label>--%>
<%--    <form:input path="firstName"/>--%>
<%--    <br>--%>

<%--    <form:label path="lastName"><spring:message code="editAccount.lastNameLabel" /></form:label>--%>
<%--    <form:input path="lastName"/>--%>
<%--    <br>--%>

<%--    <form:label path="address"><spring:message code="editAccount.addressLabel" /></form:label>--%>
<%--    <form:input path="address"/>--%>
<%--    <br>--%>

<%--    <form:label path="phoneNumber"><spring:message code="editAccount.phoneNumberLabel" /></form:label>--%>
<%--    <form:input path="phoneNumber"/>--%>
<%--    <br>--%>

<%--    <c:set var="maleLabel"> <spring:message code="editAccount.gender.male" /> </c:set>--%>
<%--    <c:set var="femaleLabel"> <spring:message code="editAccount.gender.female" /> </c:set>--%>
<%--    <c:set var="unspecifiedLabel"> <spring:message code="editAccount.gender.notSpecified" /> </c:set>--%>

<%--    <form:label path="isMan"><spring:message code="editAccount.genderLabel" /></form:label>--%>
<%--    <form:radiobutton path="isMan" id="maleRadio" value="true" label="Male" onclick="toggleGender('maleRadio', 'femaleRadio')"/>--%>
<%--    <form:radiobutton path="isMan" id="femaleRadio" value="false" label="Female" onclick="toggleGender('femaleRadio', 'maleRadio')"/>--%>
<%--    <form:radiobutton path="isMan" id="notSpecifiedRadio" value="" label="NonSpecified" onclick="toggleGender('notSpecifiedRadio', ['maleRadio', 'femaleRadio'])"/>--%>

<%--    <script>--%>
<%--        function toggleGender(selectedId, otherIds) {--%>
<%--            const selectedButton = document.getElementById(selectedId);--%>

<%--            if (selectedButton.checked) {--%>
<%--                otherIds.forEach(function(otherId) {--%>
<%--                    const otherButton = document.getElementById(otherId);--%>
<%--                    if (otherButton) {--%>
<%--                        otherButton.checked = false--%>
<%--                    }--%>
<%--                });--%>
<%--            }--%>
<%--        }--%>
<%--    </script>--%>

<%--    <c:if test="${not empty validationErrors}">--%>
<%--        <p style="color: red">Errors !</p>--%>
<%--        <ul>--%>
<%--            <c:forEach items="${validationErrors}" var="error">--%>
<%--                <li style="color: red">${error}</li>--%>
<%--            </c:forEach>--%>
<%--        </ul>--%>
<%--    </c:if>--%>
<%--    <br>--%>
<%--    <form:button><spring:message code="editAccount.submit" /></form:button>--%>
<%--</form:form>--%>

<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8 col-lg-6">
            <div class="card shadow-sm">
                <div class="card-body">
                    <h1 class="card-title text-center mb-4">
                        <spring:message code="editAccount.title" />
                    </h1>

                    <form:form method="post" modelAttribute="editUserForm">
                        <!-- Change Password -->
                        <div class="mb-3 d-flex justify-content-between align-items-center">
                            <label class="form-label m-0">
                                <spring:message code="editAccount.passwordLabel" />
                            </label>
                            <a href="<spring:url value='/changePassword'/>">
                                <spring:message code="editAccount.changePasswordLink" />
                            </a>
                        </div>

                        <!-- First Name -->
                        <div class="mb-3">
                            <form:label path="firstName" cssClass="form-label">
                                <spring:message code="editAccount.firstNameLabel" />
                            </form:label>
                            <form:input path="firstName" cssClass="form-control" />
                        </div>

                        <!-- Last Name -->
                        <div class="mb-3">
                            <form:label path="lastName" cssClass="form-label">
                                <spring:message code="editAccount.lastNameLabel" />
                            </form:label>
                            <form:input path="lastName" cssClass="form-control" />
                        </div>

                        <!-- Address -->
                        <div class="mb-3">
                            <form:label path="address" cssClass="form-label">
                                <spring:message code="editAccount.addressLabel" />
                            </form:label>
                            <form:input path="address" cssClass="form-control" />
                        </div>

                        <!-- Phone -->
                        <div class="mb-3">
                            <form:label path="phoneNumber" cssClass="form-label">
                                <spring:message code="editAccount.phoneNumberLabel" />
                            </form:label>
                            <form:input path="phoneNumber" cssClass="form-control" />
                        </div>

                        <!-- Gender -->
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

                        <!-- Validation Errors -->
                        <c:if test="${not empty validationErrors}">
                            <div class="alert alert-danger">
                                <ul class="mb-0">
                                    <c:forEach items="${validationErrors}" var="error">
                                        <li>${error}</li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>

                        <!-- Submit -->
                        <div class="d-grid">
                            <form:button cssClass="btn btn-primary">
                                <spring:message code="editAccount.submit" />
                            </form:button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
