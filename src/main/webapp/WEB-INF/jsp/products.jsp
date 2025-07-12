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

    <h1 class="mb-4 text-center"><spring:message code="products.title" /></h1>

    <!-- Filter Form -->
    <form:form modelAttribute="currentCategory" method="get" cssClass="mb-4">
        <div class="row align-items-center">
            <div class="col-md-3 col-sm-12 mb-2">
                <label for="category" class="form-label"><spring:message code="products.category.label" />:</label>
            </div>
            <div class="col-md-6 col-sm-12 mb-2">
                <select name="category" id="category" class="form-select" onchange="this.form.submit()">
                    <c:forEach items="${translatedCategories}" var="translatedCategory">
                        <c:choose>
                            <c:when test="${translatedCategory.category.id == selectedCategoryId}">
                                <option value="${translatedCategory.category.id}" selected>
                                    ${translatedCategory.name}
                                </option>
                            </c:when>
                            <c:otherwise>
                                <option value="${translatedCategory.category.id}">
                                    ${translatedCategory.name}
                                </option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${selectedCategoryId == null}">
                            <option value="" selected><spring:message code="products.price.label" /></option>
                        </c:when>
                        <c:otherwise>
                            <option value=""><spring:message code="products.category.all" /></option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>
        </div>
    </form:form>

    <!-- Products List -->
    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
        <c:forEach items="${products}" var="product">
            <div class="col">
                <div class="card h-100">
                    <div class="card-body">
                        <h5 class="card-title">${product.name}</h5>
                        <p class="card-text"><spring:message code="products.price.label" />${product.price}$</p>
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
