<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<h1>Details about ${item.product.name} (${item.product.price}$)</h1>

<p>description : ${item.product.description}</p>
<p>catégorie : ${item.translatedCategory.name}</p>
<p>description de la catégorie : ${item.translatedCategory.description}</p>

<form:form method="post" modelAttribute="currentOrderLine">
    <form:label path="quantity">Quantity : </form:label>
    <form:input type="number" min="1" max="100000" step="1" value="1" path="quantity"/>

    <c:if test="${not empty errors}">
        <p style="color: red">Errors !</p>
        <ul>
            <c:forEach items="${errors}" var="error">
                <li style="color: red">${error}</li>
            </c:forEach>
        </ul>
    </c:if>

    <form:button>Add to cart</form:button>
</form:form>


