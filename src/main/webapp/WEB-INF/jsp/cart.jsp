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

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous"/>

<div class="container mt-5 mb-5">
    <h1 class="text-center"><spring:message code="cart.title" /></h1>

    <c:if test="${empty orderLines}">
        <div class="alert alert-info text-center mt-4">
            <spring:message code="cart.empty" />
        </div>
    </c:if>

    <c:if test="${not empty orderLines}">
        <p class="mt-4"><strong><spring:message code="cart.orderLines" /></strong></p>
        <ul class="list-group mb-4">
            <c:set var="totalOrder" value="0" />
            <c:forEach items="${orderLines}" var="orderLine">
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
                                        <fmt:formatNumber value="${orderLine.price - (discount * orderLine.price)}" type="number" minFractionDigits="2" maxFractionDigits="2" />$
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
                            <fmt:formatNumber value="${(orderLine.quantity * orderLine.price) * (1 - discount)}" type="number" minFractionDigits="2" maxFractionDigits="2" />$
                        </div>
                    </div>
                    <div class="btn-group btn-group-sm align-self-center" role="group">
                        <button class="btn btn-outline-secondary" onclick="removeItem('${pageContext.request.contextPath}/cart/remove/${orderLine.id}')">−</button>
                        <button class="btn btn-outline-secondary" onclick="addItem('${pageContext.request.contextPath}/cart/add/${orderLine.id}')">+</button>
                        <button class="btn btn-outline-danger" onclick="deleteOrderLine('${pageContext.request.contextPath}/cart/delete/${orderLine.id}')">
                            <spring:message code="cart.deleteButton" />
                        </button>
                    </div>
                </li>
                <c:set var="totalLine" value="${(orderLine.quantity * orderLine.price) * (1 - discount)}" />
                <c:set var="totalOrder" value="${totalOrder + totalLine}" />
            </c:forEach>
        </ul>

        <c:if test="${not empty notAuthenticatedError}">
            <div class="alert alert-danger">${notAuthenticatedError}</div>
        </c:if>

        <p class="fs-5"><strong><spring:message code="cart.total" />:</strong> <span id="totalOrder">${totalOrder}$</span></p>

        <form:form method="post" modelAttribute="currentCart" cssClass="mt-3">
            <form:button cssClass="btn btn-primary"><spring:message code="cart.orderButton" /></form:button>
        </form:form>
    </c:if>
</div>

<!-- JS pour actions panier -->
<script>
    function deleteOrderLine(url) {
        fetch(url)
            .then(response => response.text())
            .then(() => location.reload())
            .catch(error => console.error("Error:", error));
    }

    function addItem(url) {
        fetch(url)
            .then(response => response.text())
            .then(() => location.reload())
            .catch(error => console.error("Error:", error));
    }

    function removeItem(url) {
        fetch(url)
            .then(response => response.text())
            .then(() => location.reload())
            .catch(error => console.error("Error:", error));
    }
</script>


