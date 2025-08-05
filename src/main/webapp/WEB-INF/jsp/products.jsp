
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<c:set var="discount" value='${translatedCategory.category.getCurrentDiscountValue()}' />

<h1 class="mb-4 text-center"><spring:message code="products.title" /></h1>
<h4 class="mb-4 text-center">
    <span> ${translatedCategory.name} </span>
    <c:if test="${discount != null}">
        <span class="text-danger ms-2">${discount * 100}%</span>
    </c:if>
</h4>

<div class="row g-4">
    <c:forEach items="${products}" var="product">
        <div class="col-12 col-md-6 col-lg-4">
            <div class="card h-100">
                <div class="card-body">
                    <h5 class="card-title">${product.name}</h5>
                    <p class="card-text">
                        <spring:message code="products.price.label" />:
                        <c:choose>
                            <c:when test="${discount != null}">
                                <span class="text-decoration-line-through text-muted"> ${product.price} </span>$
                                <span class="text-danger ms-2">
                                    <fmt:formatNumber value="${product.getFinalPrice()}" type="number" minFractionDigits="2" maxFractionDigits="2" />$
                                </span>
                            </c:when>
                            <c:otherwise>
                                <span class="text-muted"> ${product.price}$ </span>
                            </c:otherwise>
                        </c:choose>
                    </p>
                    <a href="<spring:url value="/product/${product.id}"/>" class="btn btn-primary">
                        <spring:message code="products.details.details"/>
                    </a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

