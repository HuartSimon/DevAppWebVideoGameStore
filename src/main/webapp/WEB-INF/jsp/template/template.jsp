<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@include file="../include/importTags.jsp"%>

<html>
<head>
    <title>Template</title>
</head>
<body>
    <header>
        <a href="<spring:url value="/home"/>">Home</a>
        <a href="<spring:url value="/products"/>">Shop</a>
        <a href="<spring:url value="/company"/>">Company</a>
        <a href="<spring:url value="/cart"/>">My cart</a>


        <sec:authorize access="isAuthenticated()">
            <p>Welcome ${pageContext.request.userPrincipal.principal.username} !</p>
            <a href="<spring:url value="/logout"/>">Log out</a>
            <a href="<spring:url value="/myPage"/>">My Page</a>
            <a href="<spring:url value="/editAccount"/>">Edit Account</a>
            <a href="<spring:url value="/myOrders"/>">My orders</a>
        </sec:authorize>

        <sec:authorize access="!isAuthenticated()">
            <a href="<spring:url value="/login"/>">Log in</a>
            <a href="<spring:url value="/signUp"/>">Sign up</a>
        </sec:authorize>
    </header>
    <main>
        <tiles:insertAttribute name="main-content"/>
    </main>
    <footer>Footer</footer>
</body>
</html>
