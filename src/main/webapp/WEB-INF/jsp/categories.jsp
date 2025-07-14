<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<div class="container my-5">
    <h1 class="mb-4 text-center">
        <spring:message code="categories.title" />
    </h1>

    <!-- Responsive Category Cards -->
    <div class="row g-4">
        <c:forEach items="${finalCategories}" var="finalCategory">
            <c:set var="translatedCategory" value='${finalCategory.get("translatedCategory")}' />
            <c:set var="discount" value='${finalCategory.get("discount")}' />

            <div class="col-12 col-md-6 col-lg-4">
                <div class="card h-100 shadow-sm">
                    <a href="<spring:url value='/products/${translatedCategory.getCategory().getId()}'/>" class="stretched-link text-decoration-none text-dark">
                        <div class="card-body d-flex flex-column">
                            <h5 class="card-title">${translatedCategory.getName()}</h5>
                            <p class="card-text">${translatedCategory.getDescription()}</p>
                            <c:if test="${discount.isPresent()}">
                                <p class="text-danger">${discount.get().getDiscountVal() * 100}%</p>
                            </c:if>
                        </div>
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
