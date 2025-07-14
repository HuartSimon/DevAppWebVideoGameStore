<%--<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>--%>
<%--<%@include file="./include/importTags.jsp"%>--%>

<%--<h1>Our products</h1>--%>

<%--<form:form modelAttribute="currentCategory" method="get">--%>
<%--    <p>Category : </p>--%>
<%--    <select name="category" id="category" onchange="this.form.submit()">--%>
<%--        <c:forEach items="${translatedCategories}" var="translatedCategory">--%>
<%--            <c:choose>--%>
<%--                <c:when test="${translatedCategory.category.id == selectedCategoryId}">--%>
<%--                    <option value="${translatedCategory.category.id}" selected>${translatedCategory.name}</option>--%>
<%--                </c:when>--%>
<%--                <c:otherwise>--%>
<%--                    <option value="${translatedCategory.category.id}">${translatedCategory.name}</option>--%>
<%--                </c:otherwise>--%>
<%--            </c:choose>--%>
<%--        </c:forEach>--%>
<%--        <c:choose>--%>
<%--            <c:when test="${selectedCategoryId == null}">--%>
<%--                <option value="" selected>All</option>--%>
<%--            </c:when>--%>
<%--            <c:otherwise>--%>
<%--                <option value="">All</option>--%>
<%--            </c:otherwise>--%>
<%--        </c:choose>--%>
<%--    </select>--%>
<%--</form:form>--%>

<%--<ul>--%>
<%--    <c:forEach items="${products}" var="product">--%>
<%--        <li>--%>
<%--            name : ${product.name}<br>--%>
<%--            price : ${product.price}$<br>--%>
<%--            <a href="<spring:url value="/product/${product.id}"/>">More details</a>--%>
<%--        </li><br>--%>
<%--    </c:forEach>--%>
<%--</ul>--%>


<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<div class="container my-5">
    <c:set var="discount" value='${finalCategory.get("discount")}' />

    <h1 class="mb-4 text-center"><spring:message code="products.title" /></h1>
    <h4 class="mb-4 text-center">
        <span> ${finalCategory.get("translatedCategory").name} </span>
        <c:if test="${discount != null}">
            <span class="text-danger ms-2">${discount.discountVal * 100}%</span>
        </c:if>
    </h4>

    <!-- Products List -->
    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
        <c:forEach items="${products}" var="product">
            <div class="col">
                <div class="card h-100">
                    <div class="card-body">
                        <h5 class="card-title">${product.name}</h5>
                        <p class="card-text">
                            <spring:message code="products.price.label" />
                            <c:choose>
                                <c:when test="${discount != null}">
                                    <span class="text-decoration-line-through text-muted"> ${product.price}$ </span>
                                    <span class="text-danger ms-2">
                                        <fmt:formatNumber value="${product.price - (discount.discountVal * product.price)}" type="number" minFractionDigits="2" maxFractionDigits="2" />$
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
</div>

<!-- Bootstrap JS (si nécessaire) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
