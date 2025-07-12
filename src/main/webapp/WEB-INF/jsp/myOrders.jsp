<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<h1><spring:message code="myOrders.title"/> </h1>

<ul>
    <c:forEach items="${ordersWithPrice}" var="ordersWithPrice">
        <li>
            <spring:message code="myOrders.orderDate" /> ${ordersWithPrice.order.orderDate}<br>

            <c:set var="payedLabel"> <spring:message code="myOrders.status.payed" /> </c:set>
            <c:set var="notPayedLabel"> <spring:message code="myOrders.status.notPayed" /> </c:set>

            <spring:message code="myOrders.status" /> ${ordersWithPrice.order.isPayed ? payedLabel : notPayedLabel}<br>
            <spring:message code="myOrders.price" /> ${ordersWithPrice.orderPrice}$<br>
            <a href="<spring:url value="/orderDetails/${ordersWithPrice.order.id}"/>"><spring:message code="myOrders.detailsLink" /></a>
        </li><br>
    </c:forEach>
</ul>