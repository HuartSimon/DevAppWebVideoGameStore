<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<h1><spring:message code="paypalPayment.title"/></h1>

<form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
    <!-- PayPal Required Fields -->
    <input type="hidden" name="business" value="emilienberlemontsellor@business.example.com">
    <input type="hidden" name="cert_id" value="AdRnk4V3O1FCsqRX3qgQoutj4AcHA2-VuAYurVgGfLUDjWOvyWhSTBNy-V6SXUpq9Fw2cxXE09skI7YW">
    <input type="hidden" name="cmd" value="_xclick">

    <!-- Payment Information -->
    <input type="hidden" name="amount" value="${orderPrice}"> <!-- Replace with the amount -->
    <input type="hidden" name="item_name" value="Sample Item"> <!-- Replace with the item name -->

    <!-- Additional Fields -->
    <input type="hidden" name="currency_code" value="USD"> <!-- Currency, e.g., USD -->
    <input type="hidden" name="lc" value="en_US"> <!-- Locale for checkout page -->
    <input type="hidden" name="locale.x" value="en_US">

    <input type="hidden" name="return" value="http://localhost:3002${pageContext.request.contextPath}/payment/${order.id}/paymentSuccess"> <!-- Success URL -->
    <input type="hidden" name="cancel_return" value="http://localhost:3002${pageContext.request.contextPath}/payment/${order.id}/paymentFailed"> <!-- Cancel URL -->

    <!-- Submit Button -->
    <button type="submit"><spring:message code="paypalPayment.payButton"/></button>
</form>
<form action="<spring:url value="/myOrders"/>" method="GET">
    <button type="submit"><spring:message code="paypalPayment.payLaterButton"/></button>
</form>

