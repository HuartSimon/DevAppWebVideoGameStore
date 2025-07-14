<%--<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>--%>
<%--<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>--%>
<%--<%@include file="../include/importTags.jsp"%>--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title>Template</title>--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">--%>
<%--    <spring:url var="localeFr" value="">--%>
<%--        <spring:param name="locale" value="fr"/>--%>
<%--    </spring:url>--%>
<%--    <spring:url var="localeEn" value="">--%>
<%--        <spring:param name="locale" value="en"/>--%>
<%--    </spring:url>--%>
<%--</head>--%>
<%--<body>--%>
<%--    <header>--%>
<%--        <a href="<spring:url value="/home"/>">Home</a>--%>
<%--        <a href="<spring:url value="/products"/>">Shop</a>--%>
<%--        <a href="<spring:url value="/company"/>">Company</a>--%>
<%--        <a href="<spring:url value="/cart"/>">My cart</a>--%>


<%--        <sec:authorize access="isAuthenticated()">--%>
<%--            <p>Welcome ${pageContext.request.userPrincipal.principal.username} !</p>--%>
<%--            <a href="<spring:url value="/logout"/>">Log out</a>--%>
<%--            <a href="<spring:url value="/myPage"/>">My Page</a>--%>
<%--            <a href="<spring:url value="/editAccount"/>">Edit Account</a>--%>
<%--            <a href="<spring:url value="/myOrders"/>">My orders</a>--%>
<%--        </sec:authorize>--%>

<%--        <sec:authorize access="!isAuthenticated()">--%>
<%--            <a href="<spring:url value="/login"/>">Log in</a>--%>
<%--            <a href="<spring:url value="/signUp"/>">Sign up</a>--%>
<%--        </sec:authorize>--%>

<%--        <a href="${localeFr}">--%>
<%--            <img width="50px" alt="fr" src='<spring:url value="/images/localeFr.png"/>'/>--%>
<%--        </a>--%>
<%--        <a href="${localeEn}">--%>
<%--            <img width="50px" alt="en" src='<spring:url value="/images/localeEn.png"/>'/>--%>
<%--        </a>--%>
<%--    </header>--%>
<%--    <main>--%>
<%--        <tiles:insertAttribute name="main-content"/>--%>
<%--    </main>--%>
<%--    <footer>Footer</footer>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ include file="../include/importTags.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <!-- Spring URL for language switching -->
    <spring:url var="localeFr" value=""> <spring:param name="locale" value="fr"/> </spring:url>
    <spring:url var="localeEn" value=""> <spring:param name="locale" value="en"/> </spring:url>
</head>
<body class="d-flex flex-column min-vh-100">

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="<spring:url value='/home'/>"><spring:message code="template.brand" /></a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent"
                aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarContent">
            <!-- Left nav -->
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link" href="<spring:url value='/categories'/>"><spring:message code="template.shop" /></a></li>
                <li class="nav-item"><a class="nav-link" href="<spring:url value='/company'/>"><spring:message code="template.company" /></a></li>
                <li class="nav-item"><a class="nav-link" href="<spring:url value='/cart'/>"><spring:message code="template.cart" /></a></li>
            </ul>

            <!-- Right nav -->
            <ul class="navbar-nav mb-2 mb-lg-0">
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <span class="navbar-text text-white me-2">
                            Welcome ${pageContext.request.userPrincipal.principal.username} !
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
    </div>
</nav>

<!-- MAIN -->
<main class="container my-5 flex-fill">
    <tiles:insertAttribute name="main-content"/>
</main>

<!-- FOOTER -->
<footer class="bg-dark text-white text-center py-3 mt-auto">
    <p class="mb-0"><spring:message code="template.text" /></p>
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

</body>
</html>
