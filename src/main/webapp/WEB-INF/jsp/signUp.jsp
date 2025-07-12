<%--<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>--%>
<%--<%@include file="./include/importTags.jsp"%>--%>

<%--<h1><spring:message code="signup.title"/></h1>--%>

<%--<form:form method="post" modelAttribute="currentUser">--%>
<%--    <form:label path="username"><spring:message code="signup.username" /></form:label>--%>
<%--    <form:input path="username"/>--%>
<%--    <br>--%>
<%--    --%>
<%--    <form:label path="password"><spring:message code="signup.password" /></form:label>--%>
<%--    <form:password path="password"/>--%>
<%--    <br>--%>

<%--    <label><spring:message code="signup.confirmPassword" /> </label>--%>
<%--    <input type="password" id="confirmedPassword" name="confirmedPassword"/>--%>
<%--    <br>--%>

<%--    <form:label path="firstName"><spring:message code="signup.firstName" /> </form:label>--%>
<%--    <form:input path="firstName"/>--%>
<%--    <br>--%>

<%--    <form:label path="lastName"><spring:message code="signup.lastName" /> </form:label>--%>
<%--    <form:input path="lastName"/>--%>
<%--    <br>--%>

<%--    <form:label path="email"><spring:message code="signup.email" />  : </form:label>--%>
<%--    <form:input path="email"/>--%>
<%--    <br>--%>
<%--    --%>
<%--    <form:label path="address"><spring:message code="signup.address" />  </form:label>--%>
<%--    <form:input path="address"/>--%>
<%--    <br>--%>
<%--    --%>
<%--    <form:label path="phoneNumber"><spring:message code="signup.phoneNumber" />  </form:label>--%>
<%--    <form:input path="phoneNumber"/>--%>
<%--    <br>--%>

<%--    <form:label path="isMan"><spring:message code="signup.gender" /> </form:label>--%>
<%--    <c:set var="maleLabel"> <spring:message code="signup.gender.male" /></c:set>--%>
<%--    <c:set var="femaleLabel"> <spring:message code="signup.gender.female" /> </c:set>--%>
<%--    <c:set var="unspecifiedLabel"> <spring:message code="signup.gender.unspecified" /> </c:set>--%>

<%--    <form:radiobutton path="isMan" id="maleRadio" value="true" label="${maleLabel}" onclick="toggleGender('maleRadio', ['femaleRadio', 'notSpecifiedRadio'])"/>--%>
<%--    <form:radiobutton path="isMan" id="femaleRadio" value="false" label="${femaleLabel}" onclick="toggleGender('femaleRadio', ['maleRadio', 'notSpecifiedRadio'])"/>--%>
<%--    <form:radiobutton path="isMan" id="notSpecifiedRadio" value="" checked="true" label="${unspecifiedLabel}" onclick="toggleGender('notSpecifiedRadio', ['maleRadio', 'femaleRadio'])"/>--%>

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

<%--    <c:if test="${usernameError}"> <p style="color: red"><spring:message code="Username.Error.Unique" /></p> </c:if>--%>
<%--    <c:if test="${emailError}"> <p style="color: red"><spring:message code="Email.Error.Unique" /></p> </c:if>--%>
<%--    <c:if test="${passwordError}"> <p style="color: red"><spring:message code="Password.Error" /></p> </c:if>--%>

<%--    <c:if test="${not empty validationErrors}">--%>
<%--        <p style="color: red"><spring:message code="general.errorsTitle"/></p>--%>
<%--        <ul>--%>
<%--            <c:forEach items="${validationErrors}" var="error">--%>
<%--                <li style="color: red">${error}</li>--%>
<%--            </c:forEach>--%>
<%--        </ul>--%>
<%--    </c:if>--%>
<%--    <br>--%>
<%--    <form:button><spring:message code="signup.submit" /></form:button>--%>
<%--</form:form>--%>

<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ include file="./include/importTags.jsp" %>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous"/>

<div class="container mt-5 mb-5">
    <div class="row justify-content-center">
        <div class="col-md-8 col-lg-6">
            <div class="card shadow-lg">
                <div class="card-body">
                    <h1 class="text-center mb-4"><spring:message code="signup.title"/></h1>

                    <form:form method="post" modelAttribute="currentUser">
                        <div class="mb-3">
                            <form:label path="username" cssClass="form-label"><spring:message code="signup.username" /></form:label>
                            <form:input path="username" cssClass="form-control"/>
                        </div>

                        <div class="mb-3">
                            <form:label path="password" cssClass="form-label"><spring:message code="signup.password" /></form:label>
                            <form:password path="password" cssClass="form-control"/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label"><spring:message code="signup.confirmPassword" /></label>
                            <input type="password" id="confirmedPassword" name="confirmedPassword" class="form-control"/>
                        </div>

                        <div class="mb-3">
                            <form:label path="firstName" cssClass="form-label"><spring:message code="signup.firstName" /></form:label>
                            <form:input path="firstName" cssClass="form-control"/>
                        </div>

                        <div class="mb-3">
                            <form:label path="lastName" cssClass="form-label"><spring:message code="signup.lastName" /></form:label>
                            <form:input path="lastName" cssClass="form-control"/>
                        </div>

                        <div class="mb-3">
                            <form:label path="email" cssClass="form-label"><spring:message code="signup.email" /></form:label>
                            <form:input path="email" cssClass="form-control"/>
                        </div>

                        <div class="mb-3">
                            <form:label path="address" cssClass="form-label"><spring:message code="signup.address" /></form:label>
                            <form:input path="address" cssClass="form-control"/>
                        </div>

                        <div class="mb-3">
                            <form:label path="phoneNumber" cssClass="form-label"><spring:message code="signup.phoneNumber" /></form:label>
                            <form:input path="phoneNumber" cssClass="form-control"/>
                        </div>

                        <div class="mb-3">
                            <form:label path="isMan" cssClass="form-label d-block"><spring:message code="signup.gender" /></form:label>
                            <c:set var="maleLabel"><spring:message code="signup.gender.male" /></c:set>
                            <c:set var="femaleLabel"><spring:message code="signup.gender.female" /></c:set>
                            <c:set var="unspecifiedLabel"><spring:message code="signup.gender.unspecified" /></c:set>

                            <div class="form-check form-check-inline">
                                <form:radiobutton path="isMan" id="maleRadio" value="true" cssClass="form-check-input"
                                                  onclick="toggleGender('maleRadio', ['femaleRadio', 'notSpecifiedRadio'])"/>
                                <label class="form-check-label" for="maleRadio">${maleLabel}</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <form:radiobutton path="isMan" id="femaleRadio" value="false" cssClass="form-check-input"
                                                  onclick="toggleGender('femaleRadio', ['maleRadio', 'notSpecifiedRadio'])"/>
                                <label class="form-check-label" for="femaleRadio">${femaleLabel}</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <form:radiobutton path="isMan" id="notSpecifiedRadio" value="" cssClass="form-check-input" checked="true"
                                                  onclick="toggleGender('notSpecifiedRadio', ['maleRadio', 'femaleRadio'])"/>
                                <label class="form-check-label" for="notSpecifiedRadio">${unspecifiedLabel}</label>
                            </div>
                        </div>

                        <script>
                            function toggleGender(selectedId, otherIds) {
                                const selectedButton = document.getElementById(selectedId);
                                if (selectedButton.checked) {
                                    otherIds.forEach(function(otherId) {
                                        const otherButton = document.getElementById(otherId);
                                        if (otherButton) {
                                            otherButton.checked = false;
                                        }
                                    });
                                }
                            }
                        </script>

                        <!-- Error Handling -->
                        <c:if test="${usernameError}">
                            <p class="text-danger"><spring:message code="Username.Error.Unique" /></p>
                        </c:if>

                        <c:if test="${emailError}">
                            <p class="text-danger"><spring:message code="Email.Error.Unique" /></p>
                        </c:if>

                        <c:if test="${passwordError}">
                            <p class="text-danger"><spring:message code="Password.Error" /></p>
                        </c:if>

                        <c:if test="${not empty validationErrors}">
                            <div class="alert alert-danger">
                                <p><strong><spring:message code="general.errorsTitle"/></strong></p>
                                <ul>
                                    <c:forEach items="${validationErrors}" var="error">
                                        <li>${error}</li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>

                        <!-- Submit -->
                        <div class="d-grid">
                            <form:button cssClass="btn btn-primary">
                                <spring:message code="signup.submit" />
                            </form:button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
