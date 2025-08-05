<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ include file="../include/importTags.jsp" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Template</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

        <spring:url var="localeFr" value=""> <spring:param name="locale" value="fr"/> </spring:url>
        <spring:url var="localeEn" value=""> <spring:param name="locale" value="en"/> </spring:url>
    </head>
    <body class="d-flex flex-column vh-100">

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark p-2">
            <a class="navbar-brand" href="<spring:url value='/home'/>"><spring:message code="template.brand" /></a>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item"><a class="nav-link" href="<spring:url value='/categories'/>"><spring:message code="template.shop" /></a></li>
                    <li class="nav-item"><a class="nav-link" href="<spring:url value='/company'/>"><spring:message code="template.company" /></a></li>
                    <li class="nav-item"><a class="nav-link" href="<spring:url value='/cart'/>"><spring:message code="template.cart" /></a></li>
                </ul>

                <ul class="navbar-nav mb-2 mb-lg-0">
                    <sec:authorize access="isAuthenticated()">
                        <li class="nav-item">
                            <span class="navbar-text text-white me-2">
                                <spring:message code="template.message">
                                    <spring:argument value="${pageContext.request.userPrincipal.principal.username}" />
                                </spring:message>
                            </span>
                        </li>
                        <li class="nav-item"><a class="nav-link" href="<spring:url value='/logout'/>"><spring:message code="template.logout"/></a></li>
                        <li class="nav-item"><a class="nav-link" href="<spring:url value='/myPage'/>"><spring:message code="template.myPage" /></a></li>
                        <li class="nav-item"><a class="nav-link" href="<spring:url value='/editAccount'/>"><spring:message code="template.editAccount" /></a></li>
                        <li class="nav-item"><a class="nav-link" href="<spring:url value='/myOrders'/>"><spring:message code="template.myOrders" /></a></li>
                    </sec:authorize>

                    <sec:authorize access="!isAuthenticated()">
                        <li class="nav-item"><a class="nav-link" href="<spring:url value='/login'/>"><spring:message code="template.login" /></a></li>
                        <li class="nav-item"><a class="nav-link" href="<spring:url value='/signUp'/>"><spring:message code="template.signUp" /></a></li>
                    </sec:authorize>

                    <li class="nav-item">
                        <a class="nav-link p-1" href="${localeFr}">
                            <img src="<spring:url value='/images/localeFr.png'/>" alt="FR" width="30">
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link p-1" href="${localeEn}">
                            <img src="<spring:url value='/images/localeEn.png'/>" alt="EN" width="30">
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main class="container-fluid my-5">
            <tiles:insertAttribute name="main-content"/>
        </main>

        <footer class="bg-dark text-white text-center py-3 mt-auto">
            <p class="mb-0"><spring:message code="template.text" /></p>
        </footer>

    </body>
</html>
