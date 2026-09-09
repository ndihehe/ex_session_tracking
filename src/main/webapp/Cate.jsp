<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset = "UTF-8">
    <title>Exercise_6-1</title>
    <link rel = "stylesheet" href = "styles/main.css">
</head>

<body>
    <h1>Your Cart</h1>
    <table>
        <thread>
            <tr>
                <th>Description</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Amount</th>
                <th></th>
            </tr>
        </thread>
        <tbody>
            <c:forEach var="item" items="${cart.items}">
                <tr>
                    <td>
                        <form action = "update" method = "post">
                        <input type = "hidden" name = "productCode" value = "item.product.code">
                        <input type = "number" name = "quantity" value = "${item.quantity}" min = "1">
                        <button type = "submit">Update</button>
                    </td>
                    <td>${item.product.description}</td>
                    <td>${item.product.price}</td>
                    <td>${item.total}</td>
                    <td>
                        <form action = "remove" method = "post">
                            <input type = "hidden" name = "productCode" value = "${item.product.code}">
                            <button type = "submit">Remove</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    <a href="${pageContext.request.contextPath}/home">
        <button type="button">Continue Shopping</button>
    </a>
    <a href="${pageContext.request.contextPath}/checkout">
        <button type="button">Checkout</button>
    </a>
</body>