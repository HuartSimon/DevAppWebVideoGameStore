<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ include file="./include/importTags.jsp" %>

<h1 class="text-center"><spring:message code="cart.title" /></h1>

<c:choose>
    <c:when test="${cart.isEmpty()}">
        <div class="alert alert-info text-center mt-4">
            <spring:message code="cart.empty" />
        </div>
    </c:when>
    <c:otherwise>
        <p class="mt-4"><strong><spring:message code="cart.orderLines" /></strong></p>
        <ul class="list-group mb-4">
            <c:forEach items="${cart.orderLines.entrySet()}" var="orderLineEntrySet">
                <c:set value="${orderLineEntrySet.getKey()}" var="orderLineKey" />
                <c:set value="${orderLineEntrySet.getValue()}" var="orderLine" />
                <c:set value="${orderLine.discount}" var="discount" />

                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">
                            ${orderLine.quantity}× ${orderLine.product.name}
                        </div>
                        <div>
                            <spring:message code="cart.unitPrice" /> :
                            <c:choose>
                                <c:when test="${discount != null}">
                                    <span class="text-decoration-line-through text-muted"> ${orderLine.price}$ </span>
                                    <span class="text-danger ms-2">
                                    <fmt:formatNumber value="${orderLine.getFinalPrice()}" type="number" minFractionDigits="2" maxFractionDigits="2" />$
                                    </span>
                                        <span class="text-danger ms-2">
                                        (${discount * 100}%)
                                    </span>
                                </c:when>
                                <c:otherwise>
                                    ${orderLine.price}$
                                </c:otherwise>
                            </c:choose>
                            <br />

                            <spring:message code="cart.lineTotal" /> :
                            <fmt:formatNumber value="${orderLine.getTotalPrice()}" type="number" minFractionDigits="2" maxFractionDigits="2" />$
                        </div>
                    </div>
                    <div class="btn-group btn-group-sm align-self-center d-flex gap-2" role="group">
                        <form:form method="post" modelAttribute="currentCart" action="cart/decrease/${orderLineKey}">
                            <button type="submit" class="btn btn-outline-secondary">-</button>
                        </form:form>

                        <form:form method="post" modelAttribute="currentCart" action="cart/add/${orderLineKey}">
                            <button type="submit" class="btn btn-outline-secondary">+</button>
                        </form:form>

                        <form:form method="post" modelAttribute="currentCart" action="cart/remove/${orderLineKey}">
                            <button type="submit" class="btn btn-outline-secondary">
                                <spring:message code="cart.deleteButton" />
                            </button>
                        </form:form>
                    </div>
                </li>
            </c:forEach>
        </ul>

        <c:if test="${notAuthenticatedError}">
            <div class="alert alert-danger"><spring:message code="Authentication.notAuthenticatedError"/></div>
        </c:if>

        <p class="fs-5"><strong><spring:message code="cart.total" />:</strong> <span id="totalOrder">
            <fmt:formatNumber value="${currentCart.getTotalPrice()}" type="number" minFractionDigits="2" maxFractionDigits="2" />$
        </span></p>

        <form:form method="post" modelAttribute="currentCart" cssClass="mt-3">
            <button type="submit" class="btn btn-outline-primary"><spring:message code="cart.orderButton" /></button>
        </form:form>
    </c:otherwise>
</c:choose>

