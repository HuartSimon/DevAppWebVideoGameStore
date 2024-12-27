<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<h1>Our products</h1>

<form:form modelAttribute="currentCategory" method="get">
    <p>Category : </p>
    <select name="category" id="category" onchange="this.form.submit()">
        <c:forEach items="${translatedCategories}" var="translatedCategory">
            <c:choose>
                <c:when test="${translatedCategory.category.id == selectedCategoryId}">
                    <option value="${translatedCategory.category.id}" selected>${translatedCategory.name}</option>
                </c:when>
                <c:otherwise>
                    <option value="${translatedCategory.category.id}">${translatedCategory.name}</option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:choose>
            <c:when test="${selectedCategoryId == null}">
                <option value="" selected>All</option>
            </c:when>
            <c:otherwise>
                <option value="">All</option>
            </c:otherwise>
        </c:choose>
    </select>
</form:form>

<ul>
    <c:forEach items="${products}" var="product">
        <li>
            name : ${product.name}<br>
            price : ${product.price}$<br>
            <a href="<spring:url value="/product/${product.id}"/>">More details</a>
        </li><br>
    </c:forEach>
</ul>
