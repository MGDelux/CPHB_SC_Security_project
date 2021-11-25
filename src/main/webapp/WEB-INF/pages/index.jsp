<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="da">
<head>
    <script src="https://kit.fontawesome.com/e79609ac4a.js" crossorigin="anonymous"></script>
    <link href="<c:url value="/css/mainPage.css"/>" rel="stylesheet"/>
    <style>
        <jsp:include page="/css/mainPage.css"/>
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Velkommen</title>
</head>

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
                    <c:if test="${sessionScope.loggedIn ==null}">
                        <a class="nav-link" href="${pageContext.request.contextPath}/register/">Register</a>
                    </c:if>
                </li>
            </ul>

            <span class="navbar-text">
                <c:choose>
                    <c:when test="${sessionScope.loggedIn != null}">
                        <span class="navbar-text"><a class="nav-link" href="${pageContext.request.contextPath}/profile"> ${sessionScope.user.email} </a>  </span>
                        <span class="navbar-text"><a class="nav-link" href="${pageContext.request.contextPath}/basket"> basket </a>  </span>

                    </c:when>
                    <c:when test="${sessionScope.loggedIn == null}">
                          <a class="nav-link" href="${pageContext.request.contextPath}/login/">Login</a> </span>
            </c:when>
            </c:choose>

            </span>
        </div>
    </div>
</nav>

<body>
<section class="gradient-custom">
    <div class="headers">
        <h1><strong>Velkommen til Solid-Cupcakes</strong></h1>
        <h2 class="header2"><strong>Landets bedste cupcakes, vælg og bestil her</strong></h2>
    </div>

    <div class="row row-cols-1 row-cols-md-5">
        <c:choose>
        <c:when test="${requestScope.productsInStore != false}">
        <c:forEach items="${products}" var="product">
            <form method="post">


            <div class="col"  id="">
            <div class="card bg-dark">
                <img src="http://cdn.sallysbakingaddiction.com/wp-content/uploads/2017/06/moist-chocolate-cupcakes-5.jpg"
                     width="35" height="250" class="card-img-top" alt="...">

                <div class="card-body bg-dark text-white">

                    <h5 id="Pepega" class="card-title">${product.productName} - ${product.productID} </h5>
                    <p class="card-text">${product.productDescription}</p>
                </div>
                <div class="Addcupcake">
                    <input name="productId" value="${product.productID}" type="hidden">
                    <button class="btn btn-secondary" name="AddCupcakeToKurv" type="submit">Tilføj til kurv</button>
                </div>

                <!__ Modal button1 starter her -->
                <div>
                    <button type="button" class="btn btn-secondary" data-toggle="modal"
                            data-target="#Modal${product.productID}">
                        Se mere
                    </button>
                </div>

            </div>

            </form>

    </div></c:forEach>

            <!__ Modal button1 slutter her -->

            <!__ Modal content1 starter her -->




        <div>
            <c:forEach items="${products}" var="productInformation">

            <div class="modal fade" id="Modal${productInformation.productID}" tabindex="-1"
                 role="dialog"
                 aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content bg-dark">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="card bg-dark">
                                <img src="http://cdn.sallysbakingaddiction.com/wp-content/uploads/2017/06/moist-chocolate-cupcakes-5.jpg"
                                     width="35" height="250" class="card-img-top" alt="...">
                                <div class="card-body bg-dark text-white">
                                    <h5 class="card-title">${productInformation.productName}</h5>
                                    <p class="card-text">${productInformation.productDescription}
                                    </p>
                                </div>
                               <h4>Comment reviews</h4>
                                <div class="container mt-5">
                                    <div class="d-flex">
                                        <div class="col-lg-12">
                                            <div class="p-3 bg-white rounded">
                                                <h6>Reviews[8]</h6>
                                                <div class="review mt-4">
                                                    <div class="d-flex flex-row comment-user"><img class="rounded" src="https://i.imgur.com/xxJl1D7.jpg" width="40">
                                                        <div class="ml-2">
                                                            <div class="d-flex flex-row align-items-center"><span class="name font-weight-bold">Hui jhong</span><span class="dot"></span><span class="date">12 Aug 2020</span></div>
                                                            <div class="rating"><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i></div>
                                                        </div>
                                                    </div>
                                                    <div class="mt-2">
                                                        <p class="comment-text">It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.</p>
                                                    </div>
                                                </div>
                                                <div class="review mt-4">
                                                    <div class="d-flex flex-row comment-user"><img class="rounded" src="https://i.imgur.com/xxJl1D7.jpg" width="40">
                                                        <div class="ml-2">
                                                            <div class="d-flex flex-row align-items-center"><span class="name font-weight-bold">Timso hui</span><span class="dot"></span><span class="date">12 Aug 2020</span></div>
                                                            <div class="rating"><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i></div>
                                                        </div>
                                                    </div>
                                                    <div class="mt-2">
                                                        <p class="comment-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip</p>
                                                    </div>
                                                </div>
                                                <div class="review mt-4">
                                                    <div class="d-flex flex-row comment-user"><img class="rounded" src="https://i.imgur.com/xxJl1D7.jpg" width="40">
                                                        <div class="ml-2">
                                                            <div class="d-flex align-items-center"><span class="name font-weight-bold">Hui jhong</span><span class="dot"></span><span class="date">12 Aug 2020</span></div>
                                                            <div class="rating"><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i></div>
                                                        </div>
                                                    </div>
                                                    <div class="mt-2">
                                                        <p class="comment-text">It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <hr class="solid text-white">
                                <div id="comment">
                                    <div class="card bg-dark text-white" id="commentCard">
                                        <div class="row">
                                            <div class="col-2"><img
                                                    src="https://i.imgur.com/xELPaag.jpg"
                                                    width="70" class="rounded-circle mt-2">
                                            </div>
                                            <div class="col-10">
                                                <div class="comment-box ml-2">
                                                    <h4>Add a comment</h4>
                                                    <div class="rating">
                                                        <input type="radio" name="rating" value="5" id="5${productInformation.productID}"><label for="5${productInformation.productID}">☆</label>
                                                        <input type="radio" id="4"><label for="4">☆</label> <input type="radio"
                                                                                     name="rating"
                                                                                     value="3"
                                                                                     id="3${productInformation.productID}"><label for="3${productInformation.productID}">☆</label> <input type="radio"
                                                                                     name="rating"
                                                                                     value="2"
                                                                                     id="2${productInformation.productID}"><label for="2${productInformation.productID}">☆</label> <input type="radio"
                                                                                     name="rating"
                                                                                     value="1"
                                                                                     id="1${productInformation.productID}"><label for="1${productInformation.productID}">☆</label></div>
                                                    <div class="comment-area"><textarea
                                                            class="form-control"
                                                            placeholder="what is your view?"
                                                            rows="4"></textarea>
                                                    </div>
                                                    <div class="comment-btns mt-2">
                                                        <div class="row">
                                                            <div class="col-6">
                                                                <div class="pull-left">
                                                                    <button class="btn btn-secondary btn-sm">
                                                                        Cancel
                                                                    </button>
                                                                </div>
                                                            </div>
                                                            <div class="col-6">
                                                                <div class="pull-right"
                                                                     id="commentButton">
                                                                    <button name="PostComment" class="btn btn-secondary send btn-sm" type="submit       ">
                                                                        Send <i
                                                                            class="fa fa-long-arrow-right ml-1"></i>
                                                                    </button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary"
                                            data-dismiss="modal">
                                        Close
                                    </button>
                                    <button class="btn btn-secondary" name="AddCupcakeToKurv2"
                                            type="submit">
                                        Tilføj til kurv
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
            </form>

        </c:forEach>
        </c:when>
        <c:when test="${requestScope.productsInStore == false}">
        <div>
        </div>
        <h2>We have no products on the store right now.. check back at a later date</h2>
        </c:when>
        </c:choose>


</section>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>