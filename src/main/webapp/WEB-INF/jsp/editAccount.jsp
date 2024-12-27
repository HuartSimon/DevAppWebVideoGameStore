<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<h1>Edit Account</h1>

<form:form method="post" modelAttribute="currentUser">
    <label>Password : </label>
    <a href="<spring:url value="/changePassword"/>">Change my password</a>
    <br>

    <form:label path="firstName">First name : </form:label>
    <form:input path="firstName"/>
    <br>

    <form:label path="lastName">Last name : </form:label>
    <form:input path="lastName"/>
    <br>

    <form:label path="address">Adress : </form:label>
    <form:input path="address"/>
    <br>

    <form:label path="phoneNumber">Phone number : </form:label>
    <form:input path="phoneNumber"/>
    <br>

    <form:label path="isMan">Gender (optional) : </form:label>
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
    <form:button>Edit</form:button>
</form:form>