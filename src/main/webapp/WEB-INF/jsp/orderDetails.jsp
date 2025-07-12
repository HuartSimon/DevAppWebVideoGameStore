<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<h1><spring:message code="orderDetails.title"/></h1>

<spring:message code="orderDetails.orderDate"/> : ${orderDetails.order.orderDate}<br>

<c:set var="payedLabel"> <spring:message code="orderDetails.status.payed" /> </c:set>
<c:set var="notPayedLabel"> <spring:message code="orderDetails.status.notPayed" /> </c:set>

<spring:message code="orderDetails.status" /> : ${ordersWithPrice.order.isPayed ? payedLabel : notPayedLabel}
<c:if test="${!(orderDetails.order.isPayed)}">
    <a href="<spring:url value="/payment/${orderDetails.order.id}"/>"> -> <spring:message code="orderDetails.payLink"/></a>
</c:if>
<br><spring:message code="orderDetails.price"/> : ${orderDetails.orderPrice}$<br>
<ul>
    <c:forEach items="${orderDetails.orderLines}" var="orderLine">
        <li>
            ${orderLine.quantity}x ${orderLine.product.name} at ${orderLine.price}$ with ${orderLine.discount*100}% discount = ${(orderLine.quantity*orderLine.price)*(1-orderLine.discount)}$
        </li><br>
    </c:forEach>
</ul>
