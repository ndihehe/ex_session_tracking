<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset = "UTF-8">
    <title>Exercise_6-1</title>
    <link rel = "stylesheet" href = "styles/main.css">
</head>

<body>
    <h1>CD List</h1>
    <table>
        <thread>
        <tr>
            <th>Description</th>
            <th>Price</th>
        </tr>
        </thread>
        <c:forEach var="cd" items="${products}">
            <tr>
                <td>${cd.description}</td>
                <td>${cd.price}</td>
                <td>
                    <form action = "home" method = "get">
                        <input type = "hidden" name = "productCode" value = "${cd.code}">
                        <form action="cart" method="post">
                            <input type="hidden" name="productCode" value="${cd.code}">
                            <button type="submit">Add To Cart</button>
                        </form>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>