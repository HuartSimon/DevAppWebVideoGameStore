<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@include file="./include/importTags.jsp"%>--%>

<%--<h1><spring:message code="company.title" /></h1>--%>
<%--<p><spring:message code="company.desc" /></p>--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./include/importTags.jsp"%>

<div class="container mt-5">
    <div class="card shadow-sm">
        <div class="card-body">
            <h1 class="card-title mb-3">
                <spring:message code="company.title" />
            </h1>
            <p class="card-text">
                <spring:message code="company.desc" />
            </p>
        </div>
    </div>
</div>
