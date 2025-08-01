<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<div class="row justify-content-center">
    <div class="col-md-8 col-lg-6">
        <div class="card">
            <div class="card-body text-center">
                <h1 class="card-title mb-4">
                    <spring:message code="paypalPayment.title" />
                </h1>
                    <form action="${order.id}/goToPayment" method="post" class="mb-3">
                        <button type="submit" class="btn btn-success w-100 mb-2">
                            <i class="bi bi-paypal"></i>
                            <spring:message code="paypalPayment.payButton" />
                        </button>
                    </form>
                <form action="<spring:url value='/myOrders'/>" method="GET">
                    <button type="submit" class="btn btn-outline-secondary w-100">
                        <spring:message code="paypalPayment.payLaterButton" />
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>

