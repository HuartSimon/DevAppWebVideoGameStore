<%--<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>--%>
<%--<%@include file="./include/importTags.jsp"%>--%>

<%--<h1><spring:message code="paypalPayment.title"/></h1>--%>

<%--<form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">--%>
<%--    <!-- PayPal Required Fields -->--%>
<%--    <input type="hidden" name="business" value="emilienberlemontsellor@business.example.com">--%>
<%--    <input type="hidden" name="cert_id" value="AdRnk4V3O1FCsqRX3qgQoutj4AcHA2-VuAYurVgGfLUDjWOvyWhSTBNy-V6SXUpq9Fw2cxXE09skI7YW">--%>
<%--    <input type="hidden" name="cmd" value="_xclick">--%>

<%--    <!-- Payment Information -->--%>
<%--    <input type="hidden" name="amount" value="${orderPrice}"> <!-- Replace with the amount -->--%>
<%--    <input type="hidden" name="item_name" value="Sample Item"> <!-- Replace with the item name -->--%>

<%--    <!-- Additional Fields -->--%>
<%--    <input type="hidden" name="currency_code" value="USD"> <!-- Currency, e.g., USD -->--%>
<%--    <input type="hidden" name="lc" value="en_US"> <!-- Locale for checkout page -->--%>
<%--    <input type="hidden" name="locale.x" value="en_US">--%>

<%--    <input type="hidden" name="return" value="http://localhost:3002${pageContext.request.contextPath}/payment/${order.id}/paymentSuccess"> <!-- Success URL -->--%>
<%--    <input type="hidden" name="cancel_return" value="http://localhost:3002${pageContext.request.contextPath}/payment/${order.id}/paymentFailed"> <!-- Cancel URL -->--%>

<%--    <!-- Submit Button -->--%>
<%--    <button type="submit"><spring:message code="paypalPayment.payButton"/></button>--%>
<%--</form>--%>
<%--<form action="<spring:url value="/myOrders"/>" method="GET">--%>
<%--    <button type="submit"><spring:message code="paypalPayment.payLaterButton"/></button>--%>
<%--</form>--%>

<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8 col-lg-6">
            <div class="card shadow-sm">
                <div class="card-body text-center">
                    <h1 class="card-title mb-4">
                        <spring:message code="paypalPayment.title" />
                    </h1>

                    <!-- PayPal Payment Form -->
                    <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post" class="mb-3">
                        <!-- PayPal Required Fields -->
                        <input type="hidden" name="business" value="emilienberlemontsellor@business.example.com">
                        <input type="hidden" name="cert_id" value="AdRnk4V3O1FCsqRX3qgQoutj4AcHA2-VuAYurVgGfLUDjWOvyWhSTBNy-V6SXUpq9Fw2cxXE09skI7YW">
                        <input type="hidden" name="cmd" value="_xclick">

                        <!-- Payment Info -->
                        <input type="hidden" name="amount" value="${orderPrice}">
                        <input type="hidden" name="item_name" value="Sample Item">
                        <input type="hidden" name="currency_code" value="USD">
                        <input type="hidden" name="lc" value="en_US">
                        <input type="hidden" name="locale.x" value="en_US">

                        <!-- Return URLs -->
                        <input type="hidden" name="return" value="http://localhost:3002${pageContext.request.contextPath}/payment/${order.id}/paymentSuccess">
                        <input type="hidden" name="cancel_return" value="http://localhost:3002${pageContext.request.contextPath}/payment/${order.id}/paymentFailed">

                        <!-- Submit -->
                        <button type="submit" class="btn btn-success w-100 mb-2">
                            <i class="bi bi-paypal"></i>
                            <spring:message code="paypalPayment.payButton" />
                        </button>
                    </form>

                    <!-- Pay Later Form -->
                    <form action="<spring:url value='/myOrders'/>" method="GET">
                        <button type="submit" class="btn btn-outline-secondary w-100">
                            <spring:message code="paypalPayment.payLaterButton" />
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

