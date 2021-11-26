<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 26-11-2021
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://kit.fontawesome.com/e79609ac4a.js" crossorigin="anonymous"></script>
    <link href="<c:url value="/css/mainPage.css"/>" rel="stylesheet"/>
    <style>
        <jsp:include page="/css/mainPage.css"/>
    </style>
    <script src="https://kit.fontawesome.com/e79609ac4a.js" crossorigin="anonymous"></script>
    <style>
        <jsp:include page="/css/mainPage.css"/>
    </style>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Velkommen</title>
    <nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">SolidCode</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText"
                    aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item">

                    </li>
                </ul>

                <span class="navbar-text">
                <c:choose>
                    <c:when test="${sessionScope.loggedIn != null}">
                        <span class="navbar-text"><a class="nav-link"
                                                     href="${pageContext.request.contextPath}/profile"> ${sessionScope.user.email} </a>  </span>

                    </c:when>
                </c:choose>

                </span>
            </div>
        </div>
    </nav>
</head>
<body>
<div class="container">

    <div class="row">
        <div class="col-md-4 order-md-2 mb-4">
            <h4 class="d-flex justify-content-between align-items-center mb-3">
                <span class="text-muted">Your cart</span>
                <span class="badge badge-secondary badge-pill">3</span>
            </h4>
            <ul class="list-group mb-3 sticky-top">
                <c:forEach items="${userBasket.products}" var="cartsitems" varStatus="loop">

                    <li class="list-group-item d-flex justify-content-between lh-condensed">
                        <div>
                            <h6 class="my-0"> ${cartsitems.productName}</h6>
                            <small class="text-muted"> ${cartsitems.productDescription}</small>
                        </div>

                        <span class="text-muted">   ${cartsitems.productPrice}kr.</span>
                        <form method="post">
                            <input name="basketId" value="${loop.index}" type="hidden">

                            <button name="deleteItem" class="btn btn-secondary" type="submit">Delete</button>

                        </form>

                    </li>

                </c:forEach>
                <li class="list-group-item d-flex justify-content-between">
                    <span>Total (DDK)</span>
                    <c:choose>
                        <c:when test="${sessionScope.TotalPrice != null}">
                            <strong> ${sessionScope.TotalPrice}KR</strong>
                        </c:when>
                    </c:choose>
                </li>

            </ul>

        </div>


        <div class="col-md-8 order-md-1">
            <form method="post">
            <h4 class="mb-3">Billing address</h4>
            <form class="needs-validation" novalidate="">
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="firstName">First name</label>
                        <input type="text" class="form-control"
                               value="${sessionScope.user.customerInfomation.firstName}" id="firstName" placeholder=""
                               value="" required="">
                        <div class="invalid-feedback"> Valid first name is required.</div>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="lastName">Last name</label>
                        <input type="text" class="form-control" value="${sessionScope.user.customerInfomation.lastName}"
                               id="lastName" placeholder="" value="" required="">
                        <div class="invalid-feedback"> Valid last name is required.</div>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="username">Username</label>
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">@</span>
                        </div>
                        <input type="text" class="form-control" id="username" value="${sessionScope.user.username}"
                               placeholder="Username" required="">
                        <div class="invalid-feedback" style="width: 100%;"> Your username is required.</div>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" value="${sessionScope.user.email}"
                           placeholder="${sessionScope.user.email}">
                    <div class="invalid-feedback"> Please enter a valid email address for shipping updates.</div>
                </div>
                <div class="mb-3">
                    <label for="Gaddress">Address</label>
                    <input name="Gaddress" type="text" class="form-control" id="address" placeholder="Street "
                           value="${sessionScope.user.customerInfomation.address}" required="true">
                    <div class="invalid-feedback"> Please enter your shipping address.</div>
                </div>
                <div class="mb-3">
                    <label for="address2">Address 2 <span class="text-muted">(Optional)</span></label>
                    <input name="Gaddress2" type="text" class="form-control" id="address2"
                           value="${sessionScope.user.customerInfomation.address.houseNumber}"
                           placeholder="Apartment or suite">
                </div>
                <div class="row">
                    <div class="col-md-5 mb-3">
                        <label for="Gcountry">Country</label>
                        <select name="Gcountry" class="custom-select d-block w-100" id="Gcountry" required="">
                            <option value="">Choose...</option>
                            <option>Denmark</option>
                        </select>
                        <div class="invalid-feedback"> Please select a valid country.</div>
                    </div>

                    <div class="col-md-3 mb-3">
                        <label for="Gzip">Zip</label>
                        <input id="Gzip" name="Gzip" type="text" class="form-control"  placeholder="0000"
                               value="${sessionScope.user.customerInfomation.address.shippingZipCode}" required="">
                        <div class="invalid-feedback"> Zip code required.</div>
                    </div>
                </div>
                <hr class="mb-4">
                <div class="custom-control custom-checkbox">
                    <input name="saveShippingInfo" type="checkbox" class="custom-control-input" id="save-info">
                    <label class="custom-control-label" for="save-info">Save this information for next time</label>
                </div>
                <hr class="mb-4">
                <h4 class="mb-3">Payment</h4>
                <div class="d-block my-3">
                    <div class="d-block my-3">

                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="cc-name">Name on card</label>
                                <input type="text" class="form-control" id="cc-name" placeholder="" required="">
                                <small class="text-muted">Full name as displayed on card</small>
                                <div class="invalid-feedback"> Name on card is required</div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="cc-number">Credit card number</label>
                                <input type="text" class="form-control" id="cc-number" placeholder="" required="">
                                <div class="invalid-feedback"> Credit card number is required</div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3 mb-3">
                                <label for="cc-expiration">Expiration</label>
                                <input type="text" class="form-control" id="cc-expiration" placeholder="" required="">
                                <div class="invalid-feedback"> Expiration date required</div>
                            </div>
                            <div class="col-md-3 mb-3">
                                <label for="cc-cvv">CVV</label>
                                <input type="text" class="form-control" id="cc-cvv" placeholder="" required="">
                                <div class="invalid-feedback"> Security code required</div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr class="mb-4">
                <button name="checkOut" class="btn btn-secondary" type="submit">Check Out</button>
                </button>
            </form>
        </div>

    </div>
</div>
</body>
</html>
