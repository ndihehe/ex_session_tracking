<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Checkout</title>
        <link rel="stylesheet"
                  href="${pageContext.request.contextPath}/style/main.css">
    </head>

    <body>
        <h1>CheckOut</h1>
        <table>
        <thead>
            <tr>
                <th>Description</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Amount</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${cart.items}">
            <tr>
                <td>${item.product.description}</td>
                <td>${item.product.price}</td>
                <td>${item.quantity}</td>
                <td>${item.total}</td>
            </tr>
            </c:forEach>
        </tbody>
        </table>
        <h3>Total: ${cart.total}</h3>
    </body>
</html>