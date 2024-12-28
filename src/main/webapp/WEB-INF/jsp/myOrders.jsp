<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<h1>My Orders</h1>

<ul>
    <c:forEach items="${ordersWithPrice}" var="ordersWithPrice">
        <li>
            Order date : ${ordersWithPrice.order.orderDate}<br>
            Status : ${ordersWithPrice.order.isPayed ? "payed" : "not payed"}<br>
            Price : ${ordersWithPrice.orderPrice}$<br>
            <a href="<spring:url value="/orderDetails/${ordersWithPrice.order.id}"/>">More details</a>
        </li><br>
    </c:forEach>
</ul>