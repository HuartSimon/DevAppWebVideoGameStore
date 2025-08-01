<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<div class="row justify-content-center">
    <div class="col-md-8 col-lg-6">
        <div class="alert alert-success text-center p-4" role="alert">
            <h2 class="mb-3"><spring:message code="payment.success.title"/></h2>
            <p class="mb-4"><spring:message code="payment.success.message"/></p>
            <a href="<spring:url value='/home'/>" class="btn btn-primary">
              <spring:message code="button.home"/>
            </a>
        </div>
    </div>
</div>

