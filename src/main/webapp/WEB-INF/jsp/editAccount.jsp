<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<h1><spring:message code="editAccount.title" /></h1>

<form:form method="post" modelAttribute="currentUser">
    <label><spring:message code="editAccount.passwordLabel" /></label>
    <a href="<spring:url value="/changePassword"/>"><spring:message code="editAccount.changePasswordLink" /></a>
    <br>

    <form:label path="firstName"><spring:message code="editAccount.firstNameLabel" /></form:label>
    <form:input path="firstName"/>
    <br>

    <form:label path="lastName"><spring:message code="editAccount.lastNameLabel" /></form:label>
    <form:input path="lastName"/>
    <br>

    <form:label path="address"><spring:message code="editAccount.addressLabel" /></form:label>
    <form:input path="address"/>
    <br>

    <form:label path="phoneNumber"><spring:message code="editAccount.phoneNumberLabel" /></form:label>
    <form:input path="phoneNumber"/>
    <br>

    <c:set var="maleLabel"> <spring:message code="editAccount.gender.male" /> </c:set>
    <c:set var="femaleLabel"> <spring:message code="editAccount.gender.female" /> </c:set>
    <c:set var="unspecifiedLabel"> <spring:message code="editAccount.gender.notSpecified" /> </c:set>

    <form:label path="isMan"><spring:message code="editAccount.genderLabel" /></form:label>
    <form:radiobutton path="isMan" id="maleRadio" value="true" label="Male" onclick="toggleGender('maleRadio', 'femaleRadio')"/>
    <form:radiobutton path="isMan" id="femaleRadio" value="false" label="Female" onclick="toggleGender('femaleRadio', 'maleRadio')"/>
    <form:radiobutton path="isMan" id="notSpecifiedRadio" value="" label="NonSpecified" onclick="toggleGender('notSpecifiedRadio', ['maleRadio', 'femaleRadio'])"/>

    <script>
        function toggleGender(selectedId, otherIds) {
            const selectedButton = document.getElementById(selectedId);

            if (selectedButton.checked) {
                otherIds.forEach(function(otherId) {
                    const otherButton = document.getElementById(otherId);
                    if (otherButton) {
                        otherButton.checked = false
                    }
                });
            }
        }
    </script>

    <c:if test="${not empty validationErrors}">
        <p style="color: red">Errors !</p>
        <ul>
            <c:forEach items="${validationErrors}" var="error">
                <li style="color: red">${error}</li>
            </c:forEach>
        </ul>
    </c:if>
    <br>
    <form:button><spring:message code="editAccount.submit" /></form:button>
</form:form>