<%--<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>--%>
<%--<%@include file="./include/importTags.jsp"%>--%>

<%--<h1><spring:message code="myOrders.title"/> </h1>--%>

<%--<ul>--%>
<%--    <c:forEach items="${ordersWithPrice}" var="ordersWithPrice">--%>
<%--        <li>--%>
<%--            <spring:message code="myOrders.orderDate" /> ${ordersWithPrice.order.orderDate}<br>--%>

<%--            <c:set var="payedLabel"> <spring:message code="myOrders.status.payed" /> </c:set>--%>
<%--            <c:set var="notPayedLabel"> <spring:message code="myOrders.status.notPayed" /> </c:set>--%>

<%--            <spring:message code="myOrders.status" /> ${ordersWithPrice.order.isPayed ? payedLabel : notPayedLabel} <br>--%>
<%--            <spring:message code="myOrders.price" /> ${ordersWithPrice.orderPrice}$ <br>--%>
<%--            <a href="<spring:url value="/orderDetails/${ordersWithPrice.order.id}"/>"> <spring:message code="myOrders.detailsLink" /> </a>--%>
<%--        </li><br>--%>
<%--    </c:forEach>--%>
<%--</ul>--%>


<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<div class="container my-5">
    <h1 class="mb-4"><spring:message code="myOrders.title"/> </h1>

    <div class="row row-cols-1 row-cols-md-2 g-4">
        <c:forEach items="${ordersWithPrice}" var="ordersWithPrice">
            <div class="col">
                <div class="card shadow-sm h-100">
                    <div class="card-body">
                        <h5 class="card-title">
                            <spring:message code="myOrders.orderDate" /> ${ordersWithPrice.order.orderDate}
                        </h5>

                        <c:set var="payedLabel"><spring:message code="myOrders.status.payed" /></c:set>
                        <c:set var="notPayedLabel"><spring:message code="myOrders.status.notPayed" /></c:set>

                        <p class="card-text">
                            <strong><spring:message code="myOrders.status" />:</strong>
                            <span class="${ordersWithPrice.order.isPayed ? 'text-success' : 'text-danger'}">
                                ${ordersWithPrice.order.isPayed ? payedLabel : notPayedLabel}
                            </span><br>
                            <strong><spring:message code="myOrders.price" />:</strong> ${ordersWithPrice.orderPrice}$
                        </p>

                        <a href="<spring:url value='/orderDetails/${ordersWithPrice.order.id}'/>" class="btn btn-primary">
                            <spring:message code="myOrders.detailsLink" />
                        </a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
