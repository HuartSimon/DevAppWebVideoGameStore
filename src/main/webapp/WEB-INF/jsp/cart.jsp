<%--<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>--%>
<%--<%@include file="./include/importTags.jsp"%>--%>

<%--<h1><spring:message code="cart.title" /></h1>--%>

<%--<c:if test="${empty orderLines}">--%>
<%--    <p><spring:message code="cart.empty" /></p>--%>
<%--</c:if>--%>

<%--<c:if test="${not empty orderLines}">--%>
<%--    <p><strong><spring:message code="cart.orderLines" /></strong></p>--%>
<%--    <ul>--%>
<%--        <c:set var="totalOrder" value="0"/>--%>
<%--        <c:forEach items="${orderLines}" var="orderLine">--%>
<%--            <li id="orderLine-${orderLine.id}">--%>
<%--                <button--%>
<%--                    class="removeButton"--%>
<%--                    onclick="removeItem(`${pageContext.request.contextPath}/cart/remove/${orderLine.id}`, ${orderLine.id})"--%>
<%--                >--%>
<%--                        ---%>
<%--                </button>--%>
<%--                <button--%>
<%--                    class="addButton"--%>
<%--                    onclick="addItem(`${pageContext.request.contextPath}/cart/add/${orderLine.id}`, ${orderLine.id})"--%>
<%--                >--%>
<%--                    +--%>
<%--                </button>--%>

<%--                ${orderLine.quantity}x ${orderLine.product.name} at ${orderLine.price}$ with ${orderLine.discount*100}% discount = ${(orderLine.quantity*orderLine.price)*(1-orderLine.discount)}$--%>

<%--                <button--%>
<%--                    class="deleteButton"--%>
<%--                    onclick="deleteOrderLine(`${pageContext.request.contextPath}/cart/delete/${orderLine.id}`, ${orderLine.id})"--%>
<%--                >--%>
<%--                    <spring:message code="cart.deleteButton" />--%>
<%--                </button>--%>
<%--                <c:set var="totalLine" value="${(orderLine.quantity*orderLine.price)*(1-orderLine.discount)}"/>--%>
<%--                <c:set var="totalOrder" value="${totalOrder+totalLine}"/>--%>
<%--            </li>--%>
<%--            <br>--%>
<%--        </c:forEach>--%>

<%--        <c:if test="${not empty notAuthenticatedError}">--%>
<%--            <p style="color: red">${notAuthenticatedError}</p>--%>
<%--        </c:if>--%>

<%--        <p><spring:message code="cart.total" /><span id="totalOrder">${totalOrder}$</span></p>--%>

<%--        <form:form method="post" modelAttribute="currentCart">--%>
<%--            <form:button><spring:message code="cart.orderButton" /></form:button>--%>
<%--        </form:form>--%>
<%--    </ul>--%>
<%--</c:if>--%>

<%--<script>--%>
<%--    // Fonction pour supprimer une ligne du panier--%>
<%--    function deleteOrderLine(url) {--%>
<%--        fetch(url)--%>
<%--            .then(response => response.text())--%>
<%--            .then(() => {--%>
<%--                location.reload();--%>
<%--            })--%>
<%--            .catch(error => console.error("Error:", error));--%>
<%--    }--%>

<%--    // Fonction pour ajouter une quantité--%>
<%--    function addItem(url) {--%>
<%--        fetch(url)--%>
<%--            .then(response => response.text())--%>
<%--            .then(() => {--%>
<%--                location.reload();--%>
<%--            })--%>
<%--            .catch(error => console.error("Error:", error));--%>
<%--    }--%>

<%--    // Fonction pour retirer une quantité--%>
<%--    function removeItem(url) {--%>
<%--        fetch(url)--%>
<%--            .then(response => response.text())--%>
<%--            .then(() => {--%>
<%--                location.reload();--%>
<%--            })--%>
<%--            .catch(error => console.error("Error:", error));--%>
<%--    }--%>
<%--</script>--%>

<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ include file="./include/importTags.jsp" %>

<div class="container mt-5 mb-5">
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

                    <li id="orderLine-${orderLine.id}" class="list-group-item d-flex justify-content-between align-items-start">
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
                        <div class="btn-group btn-group-sm align-self-center" role="group">
                            <form:form method="post" modelAttribute="currentCart" action="cart/decrease/${orderLineKey}">
                                <form:button cssClass="btn btn-outline-secondary">-</form:button>
                            </form:form>

                            <form:form method="post" modelAttribute="currentCart" action="cart/add/${orderLineKey}">
                                <form:button cssClass="btn btn-outline-secondary">+</form:button>
                            </form:form>

                            <form:form method="post" modelAttribute="currentCart" action="cart/remove/${orderLineKey}">
                                <form:button cssClass="btn btn-outline-danger">
                                    <spring:message code="cart.deleteButton" />
                                </form:button>
                            </form:form>
                        </div>
                    </li>
                </c:forEach>
            </ul>

            <c:if test="${not empty notAuthenticatedError}">
                <div class="alert alert-danger">${notAuthenticatedError}</div>
            </c:if>

            <p class="fs-5"><strong><spring:message code="cart.total" />:</strong> <span id="totalOrder"><fmt:formatNumber value="${currentCart.getTotalPrice()}" type="number" minFractionDigits="2" maxFractionDigits="2" />$</span></p>

            <form:form method="post" modelAttribute="currentCart" cssClass="mt-3">
                <form:button cssClass="btn btn-primary"><spring:message code="cart.orderButton" /></form:button>
            </form:form>
        </c:otherwise>
    </c:choose>
</div>

