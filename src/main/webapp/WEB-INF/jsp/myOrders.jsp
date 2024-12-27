<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<h1>My Orders</h1>

<ul>
    <c:forEach items="${ordersWithPrice}" var="ordersWithPrice">
        <li>
            Order date : ${ordersWithPrice.order.orderDate}<br>
            Is payed : ${ordersWithPrice.order.isPayed ? "yes" : "no"}<br>
            Price : ${ordersWithPrice.orderPrice}$<br>
            <a href="<spring:url value="/myOrders/${order.id}"/>">More details</a>
        </li><br>
    </c:forEach>
</ul>