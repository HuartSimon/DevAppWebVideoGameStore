<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<h1 class="mb-4"><spring:message code="myOrders.title"/> </h1>

<div class="row g-4">
    <c:forEach items="${orders}" var="order">
        <div class="col-12 col-md-6 col-lg-4">
            <div class="card h-100">
                <div class="card-body">
                    <h5 class="card-title">
                        <spring:message code="myOrders.orderDate" /> ${order.orderDate}
                    </h5>

                    <c:set var="payedLabel"><spring:message code="myOrders.status.payed" /></c:set>
                    <c:set var="notPayedLabel"><spring:message code="myOrders.status.notPayed" /></c:set>

                    <p class="card-text">
                        <strong><spring:message code="myOrders.status" />:</strong>
                        <span class="${order.isPayed ? 'text-success' : 'text-danger'}">
                            ${order.isPayed ? payedLabel : notPayedLabel}
                        </span><br>
                        <strong><spring:message code="myOrders.price" />:</strong>
                            <fmt:formatNumber value="${order.getTotalPrice()}" type="number" minFractionDigits="2" maxFractionDigits="2" />$
                    </p>

                    <a href="<spring:url value='/orderDetails/${order.id}'/>" class="btn btn-primary">
                        <spring:message code="myOrders.detailsLink" />
                    </a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
