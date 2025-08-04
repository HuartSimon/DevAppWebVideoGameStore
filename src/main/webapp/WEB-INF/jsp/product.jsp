<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<c:set var="discount" value="${translatedCategory.getCategory().getCurrentDiscountValue()}" />

<div class="card p-4">
    <h1 class="mb-3">
        <spring:message code="product.productDetails"/>
        <span class="text-primary">${product.name}</span>
        <c:choose>
            <c:when test="${discount != null}">
                <span class="text-decoration-line-through text-muted fs-4"> ${product.price}$ </span>
                <span class="text-danger ms-2 fs-4">
                    <fmt:formatNumber value="${product.getFinalPrice()}" type="number" minFractionDigits="2" maxFractionDigits="2" />$
                </span>
            </c:when>
            <c:otherwise>
                <span class="text-muted fs-4">(${product.price}$)</span>
            </c:otherwise>
        </c:choose>
    </h1>

    <p><strong><spring:message code="product.description"/>:</strong> ${product.description}</p>
    <p><strong><spring:message code="product.category"/>:</strong> ${translatedCategory.name}</p>
    <p><strong><spring:message code="product.category.description"/>:</strong> ${translatedCategory.description}</p>

    <form:form method="post" modelAttribute="currentNewOrderLineForm" cssClass="mt-4">
        <div class="mb-3">
            <form:label path="quantity" cssClass="form-label">
                <spring:message code="product.quantity"/>
            </form:label>
            <form:input path="quantity" type="number" min="1" max="100000" step="1" value="1" cssClass="form-control"/>
        </div>

        <c:if test="${not empty errors}">
            <div class="alert alert-danger">
                <strong><spring:message code="general.errorsTitle"/></strong>
                <ul class="mb-0">
                    <c:forEach items="${errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>

        <button type="submit" class="btn btn-primary">
            <spring:message code="product.addToCart"/>
        </button>
    </form:form>
</div>

