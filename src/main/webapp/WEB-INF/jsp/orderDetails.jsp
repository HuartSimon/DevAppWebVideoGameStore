<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<h1>Order details</h1>

Order date : ${orderDetails.order.orderDate}<br>
Status : ${ordersWithPrice.order.isPayed ? "payed" : "not payed"}
<c:if test="${!(orderDetails.order.isPayed)}">
    <a href="<spring:url value="/payment/${orderDetails.order.id}"/>"> -> Pay</a>
</c:if>
<br>Price : ${orderDetails.orderPrice}$<br>
<ul>
    <c:forEach items="${orderDetails.orderLines}" var="orderLine">
        <li>
            ${orderLine.quantity}x ${orderLine.product.name} at ${orderLine.price}$ with ${orderLine.discount*100}% discount = ${(orderLine.quantity*orderLine.price)*(1-orderLine.discount)}$
        </li><br>
    </c:forEach>
</ul>
