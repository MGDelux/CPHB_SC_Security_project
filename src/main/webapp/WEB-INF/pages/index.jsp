<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="da">
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
                        <span class="navbar-text"><a class="nav-link"
                                                     href="${pageContext.request.contextPath}/profile/"> ${sessionScope.user.email} </a>  </span>

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
        <div class="col">
            <div class="card bg-dark">
                <img src="http://cdn.sallysbakingaddiction.com/wp-content/uploads/2017/06/moist-chocolate-cupcakes-5.jpg"
                     width="35" height="250" class="card-img-top" alt="...">
                <div class="card-body bg-dark text-white">
                    <h5 class="card-title">Choko cupcake</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to
                        additional content. This content is a little bit longer.</p>
                </div>
                <div class="Addcupcake">
                    <button class="btn btn-secondary" name="AddCupcakeToKurv" type="submit">Tilføj til kurv</button>
                </div>
                <div>
                    <!__ Modal button1 starter her -->
                    <div>
                        <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#Modal1">
                            Se mere
                        </button>
                    </div>
                    <!__ Modal button1 slutter her -->

                    <!__ Modal content1 starter her -->
                    <div>
                        <div class="modal fade" id="Modal1" tabindex="-1" role="dialog"
                             aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content bg-dark">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLongTitle2">Choko cupcake</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="card bg-dark">
                                            <img src="http://cdn.sallysbakingaddiction.com/wp-content/uploads/2017/06/moist-chocolate-cupcakes-5.jpg"
                                                 width="35" height="250" class="card-img-top" alt="...">
                                            <div class="card-body bg-dark text-white">
                                                <h5 class="card-title">Choko cupcake</h5>
                                                <p class="card-text">This is a longer card with supporting text below as
                                                    a natural lead-in to additional content. This content is a little
                                                    bit longer.</p>
                                            </div>
                                            <div id="comment1">
                                                <div class="card bg-dark text-white" id="commentCard1">
                                                    <div class="row">
                                                        <div class="col-2"><img src="https://i.imgur.com/xELPaag.jpg"
                                                                                width="70" class="rounded-circle mt-2">
                                                        </div>
                                                        <div class="col-10">
                                                            <div class="comment-box ml-2">
                                                                <h4>Add a comment</h4>
                                                                <div class="rating"><input type="radio" name="rating"
                                                                                           value="5" id="5"><label
                                                                        for="5">☆</label> <input type="radio"
                                                                                                 name="rating" value="4"
                                                                                                 id="4"><label
                                                                        for="4">☆</label> <input type="radio"
                                                                                                 name="rating" value="3"
                                                                                                 id="3"><label
                                                                        for="3">☆</label> <input type="radio"
                                                                                                 name="rating" value="2"
                                                                                                 id="2"><label
                                                                        for="2">☆</label> <input type="radio"
                                                                                                 name="rating" value="1"
                                                                                                 id="1"><label
                                                                        for="1">☆</label></div>
                                                                <div class="comment-area"><textarea class="form-control"
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
                                                                            <div class="pull-right" id="commentButton1">
                                                                                <button class="btn btn-secondary send btn-sm">
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
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                                    Close
                                                </button>
                                                <button class="btn btn-secondary" name="AddCupcakeToKurv" type="submit">
                                                    Tilføj til kurv
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!__ Modal content1 slutter her -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


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