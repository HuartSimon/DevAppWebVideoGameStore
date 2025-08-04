<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<div class="card">
    <div class="card-body">
        <h1 class="card-title text-primary mb-4">
            <spring:message code="orderDetails.title"/>
        </h1>

        <p>
            <strong><spring:message code="orderDetails.orderDate"/>:</strong>
            ${order.orderDate}
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
                ${order.isPayed ? 'bg-success' : 'bg-danger'}">
                ${order.isPayed ? payedLabel : notPayedLabel}
            </span>
        </p>

        <c:if test="${!order.isPayed}">
            <a href="<spring:url value='/payment/${order.id}'/>"
               class="btn btn-warning my-2">
                💳 <spring:message code="orderDetails.payLink"/>
            </a>
        </c:if>

        <p>
            <strong><spring:message code="orderDetails.price"/>:</strong>
            <fmt:formatNumber value="${order.getTotalPrice()}" type="number" minFractionDigits="2" maxFractionDigits="2" />$
        </p>

        <hr>

        <h5 class="mt-4 mb-3">🧾 <spring:message code="orderDetails.items"/></h5>
        <ul class="list-group">
            <c:forEach items="${order.orderLines}" var="orderLine">
                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div>
                        <strong>${orderLine.quantity}x</strong>
                        ${orderLine.product.name}

                        <spring:message code="orderDetails.at"/> <strong>${orderLine.price}$</strong><br>
                        <small class="text-muted">
                            <spring:message code="orderDetails.discount"/>: ${orderLine.discount * 100}%
                            → <spring:message code="orderDetails.total"/>:
                            <fmt:formatNumber value="${(orderLine.getFinalPrice())}" type="number" minFractionDigits="2" maxFractionDigits="2" />$
                        </small>
                    </div>
                </li>
            </c:forEach>
        </ul>

    </div>
</div>
