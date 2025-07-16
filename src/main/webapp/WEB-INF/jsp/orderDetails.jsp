<%--<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>--%>
<%--<%@include file="./include/importTags.jsp"%>--%>

<%--<h1><spring:message code="orderDetails.title"/></h1>--%>

<%--<spring:message code="orderDetails.orderDate"/> : ${orderDetails.order.orderDate}<br>--%>

<%--<c:set var="payedLabel"> <spring:message code="orderDetails.status.payed" /> </c:set>--%>
<%--<c:set var="notPayedLabel"> <spring:message code="orderDetails.status.notPayed" /> </c:set>--%>

<%--<spring:message code="orderDetails.status" /> : ${ordersWithPrice.order.isPayed ? payedLabel : notPayedLabel}--%>
<%--<c:if test="${!(orderDetails.order.isPayed)}">--%>
<%--    <a href="<spring:url value="/payment/${orderDetails.order.id}"/>"> -> <spring:message code="orderDetails.payLink"/></a>--%>
<%--</c:if>--%>
<%--<br><spring:message code="orderDetails.price"/> : ${orderDetails.orderPrice}$<br>--%>
<%--<ul>--%>
<%--    <c:forEach items="${orderDetails.orderLines}" var="orderLine">--%>
<%--        <li>--%>
<%--            ${orderLine.quantity}x ${orderLine.product.name} at ${orderLine.price}$ with ${orderLine.discount*100}% discount = ${(orderLine.quantity*orderLine.price)*(1-orderLine.discount)}$--%>
<%--        </li><br>--%>
<%--    </c:forEach>--%>
<%--</ul>--%>

<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><spring:message code="orderDetails.title"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container my-5">
    <div class="card shadow-sm">
        <div class="card-body">
            <h1 class="card-title text-primary mb-4">
                <spring:message code="orderDetails.title"/>
            </h1>

            <p>
                <strong><spring:message code="orderDetails.orderDate"/>:</strong>
                ${orderDetails.order.orderDate}
            </p>

            <c:set var="payedLabel">
                <spring:message code="orderDetails.status.payed" />
            </c:set>
            <c:set var="notPayedLabel">
                <spring:message code="orderDetails.status.notPayed" />
            </c:set>

            <p>
                <strong><spring:message code="orderDetails.status" />:</strong>
                <span class="badge
                    ${ordersWithPrice.order.isPayed ? 'bg-success' : 'bg-danger'}">
                    ${ordersWithPrice.order.isPayed ? payedLabel : notPayedLabel}
                </span>
            </p>

            <c:if test="${!orderDetails.order.isPayed}">
                <a href="<spring:url value='/payment/${orderDetails.order.id}'/>"
                   class="btn btn-warning my-2">
                    💳 <spring:message code="orderDetails.payLink"/>
                </a>
            </c:if>

            <p>
                <strong><spring:message code="orderDetails.price"/>:</strong>
                ${orderDetails.orderPrice}$
            </p>

            <hr>

            <h5 class="mt-4 mb-3">🧾 <spring:message code="orderDetails.items"/></h5>
            <ul class="list-group">
                <c:forEach items="${orderDetails.orderLines}" var="orderLine">
                    <li class="list-group-item d-flex justify-content-between align-items-start">
                        <div>
                            <strong>${orderLine.quantity}x</strong>
                            ${orderLine.product.name}
                            at <strong>${orderLine.price}$</strong><br>
                            <small class="text-muted">
                                Discount: ${orderLine.discount * 100}%
                                → Total: ${(orderLine.quantity * orderLine.price) * (1 - orderLine.discount)}$
                            </small>
                        </div>
                    </li>
                </c:forEach>
            </ul>

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
