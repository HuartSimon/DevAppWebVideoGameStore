<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<div class="row justify-content-center">
    <div class="col-md-6 col-lg-5">
        <div class="card">
            <div class="card-body">
                <h1 class="card-title text-center mb-4"><spring:message code="login.title"/></h1>

                <form:form method="post" modelAttribute="currentUser">
                    <div class="mb-3">
                        <form:label path="username" cssClass="form-label">
                            <spring:message code="login.username" />
                        </form:label>
                        <form:input path="username" cssClass="form-control"/>
                    </div>

                    <div class="mb-3">
                        <form:label path="password" cssClass="form-label">
                            <spring:message code="login.password" />
                        </form:label>
                        <form:password path="password" cssClass="form-control"/>
                    </div>

                    <c:if test="${param.error}">
                        <div class="alert alert-danger" role="alert">
                            <spring:message code="login.error" />
                        </div>
                    </c:if>

                    <button class="btn btn-primary w-100"> <spring:message code="login.button" /> </button>
                </form:form>
            </div>
        </div>
    </div>
</div>
