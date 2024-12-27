<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@include file="./include/importTags.jsp"%>

<h1>Your cart</h1>
<p>CURRENT_USER : ${currentUser}</p>
<p>OrderLines : ${orderLines}</p>

<c:if test="${empty orderLines}">
    <p>Your cart is empty.</p>
</c:if>

<c:if test="${not empty orderLines}">
    <p><strong>Order Lines:</strong></p>
    <ul>
        <c:set var="totalOrder" value="0"/>
        <c:forEach items="${orderLines}" var="orderLine">
            <li id="orderLine-${orderLine.id}">
                <button
                        class="removeButton"
                        onclick="removeItem(`${pageContext.request.contextPath}/cart/remove/${orderLine.id}`, ${orderLine.id})">-
                </button>
                <button class="addButton"
                        onclick="addItem(`${pageContext.request.contextPath}/cart/add/${orderLine.id}`, ${orderLine.id})">+
                </button>

                ${orderLine.quantity}x ${orderLine.product.name} at ${orderLine.price}$ with ${orderLine.discount*100}% discount = ${(orderLine.quantity*orderLine.price)*(1-orderLine.discount)}$

                <button class="deleteButton"
                        onclick="deleteOrderLine(`${pageContext.request.contextPath}/cart/delete/${orderLine.id}`, ${orderLine.id})">Delete
                </button>
                <c:set var="totalLine" value="${(orderLine.quantity*orderLine.price)*(1-orderLine.discount)}"/>
                <c:set var="totalOrder" value="${totalOrder+totalLine}"/>
            </li>
            <br>
        </c:forEach>

        <c:if test="${not empty notAuthenticatedError}">
            <p style="color: red">${notAuthenticatedError}</p>
        </c:if>

        <p>Total : <span id="totalOrder">${totalOrder}$</span></p>

        <form:form method="post" modelAttribute="currentCart">
            <form:button>Order</form:button>
        </form:form>
    </ul>
</c:if>

<script>
    // Fonction pour supprimer une ligne du panier
    function deleteOrderLine(url) {
        fetch(url)
            .then(response => response.text())
            .then(() => {
                location.reload();
            })
            .catch(error => console.error("Error:", error));
    }

    // Fonction pour ajouter une quantité
    function addItem(url) {
        fetch(url)
            .then(response => response.text())
            .then(() => {
                location.reload();
            })
            .catch(error => console.error("Error:", error));
    }

    // Fonction pour retirer une quantité
    function removeItem(url) {
        fetch(url)
            .then(response => response.text())
            .then(() => {
                location.reload();
            })
            .catch(error => console.error("Error:", error));
    }
</script>
