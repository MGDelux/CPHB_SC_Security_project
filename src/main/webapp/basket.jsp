<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 25-11-2021
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/css/mainPage.css"/>" rel="stylesheet"/>
    <style>
        <jsp:include page="/css/mainPage.css"/>
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Title</title>
</head>
<body>
<h1>basket</h1>
<div class="ordredetalje" align="center">
    <label>Your basket</label>
    <c:choose>
        <c:when test="${sessionScope.userBasket != null}">
            <table id="ordre" border="1" title="Ordrelinje" class="orderBorder">
                <thead>
                <tr>
                    <th align="center">#ID</th>
                    <th align="center">Product Name:</th>
                    <th align="center">Description:</th>
                    <th align="center">Price:</th>
                    <th align="center">option:</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${userBasket.products}" var="cartsitems" varStatus="loop">

                    <tr>
                        <td align="center">
                                ${loop.index}
                        </td>
                        <td align="center">
                                ${cartsitems.productName}
                        </td>
                        <td align="center">
                                ${cartsitems.productDescription}
                        </td>
                        <td align="center">
                                ${cartsitems.productPrice} kr.
                        </td>
                        <td align="center">
                            <form method="post">
                                <input name="basketId" value="${loop.index}" type="text">
                                <button name="deleteItem" class="btn btn-secondary" type="submit">Delete</button>
                            </form>
                        </td>

                    </tr>

                </c:forEach>
                </tbody>

            </table>
            <a href="${pageContext.request.contextPath}/"><input class="backbutton" type="button" value="Tilbage"></a>
        </c:when>
        <c:when test="${sessionScope.userBasket == null}">
            <h2>Basket is empty</h2>
        </c:when>
    </c:choose>
</div>

</body>
</html>
