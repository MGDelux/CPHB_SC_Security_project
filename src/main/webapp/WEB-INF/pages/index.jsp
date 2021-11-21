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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Velkommen</title>
</head>

<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar w/ text</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Features</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Pricing</a>
                </li>
            </ul>
            <span class="navbar-text">
        Navbar text with an inline element
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

<div class="row row-cols-1 row-cols-md-3 g-4">
        <div class="col">
            <div class="card bg-dark">
                <img src="http://cdn.sallysbakingaddiction.com/wp-content/uploads/2017/06/moist-chocolate-cupcakes-5.jpg"width="250" height="380" class="card-img-top" alt="...">
                <div class="card-body bg-dark text-white">
                    <h5 class="card-title">Choko cupcake</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                </div>
                <div class="Addcupcake">
                    <button class="addtokurv" name="AddCupcakeToKurv" type="submit">Tilføj til kurv</button>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card bg-dark">
                <img src="http://cdn.sallysbakingaddiction.com/wp-content/uploads/2017/06/moist-chocolate-cupcakes-5.jpg"width="250" height="380" class="card-img-top" alt="...">
                <div class="card-body bg-dark text-white">
                    <h5 class="card-title">vanilje cupcake</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                </div>
                <div class="Addcupcake">
                    <button class="addtokurv" name="AddCupcakeToKurv" type="submit">Tilføj til kurv</button>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card bg-dark bg-dark text-white">
                <img src="http://cdn.sallysbakingaddiction.com/wp-content/uploads/2017/06/moist-chocolate-cupcakes-5.jpg"width="250" height="380" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">jordbær sprinkle</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
                </div>
                <div class="Addcupcake">
                    <button class="addtokurv" name="AddCupcakeToKurv" type="submit">Tilføj til kurv</button>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card bg-dark bg-dark text-white">
                <img src="http://cdn.sallysbakingaddiction.com/wp-content/uploads/2017/06/moist-chocolate-cupcakes-5.jpg"width="250" height="380" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Vegan cupcake</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                </div>
                <div class="Addcupcake">
                    <button class="addtokurv" name="AddCupcakeToKurv" type="submit">Tilføj til kurv</button>
                </div>
            </div>
        </div>
    <div class="col">
        <div class="card bg-dark bg-dark text-white">
            <img src="http://cdn.sallysbakingaddiction.com/wp-content/uploads/2017/06/moist-chocolate-cupcakes-5.jpg"width="250" height="380" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Vegan cupcake</h5>
                <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
            </div>
            <div class="Addcupcake">
                <button class="addtokurv" name="AddCupcakeToKurv" type="submit">Tilføj til kurv</button>
            </div>
        </div>
    </div>
    <div class="col">
        <div class="card bg-dark bg-dark text-white">
            <img src="http://cdn.sallysbakingaddiction.com/wp-content/uploads/2017/06/moist-chocolate-cupcakes-5.jpg"width="250" height="380" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Vegan cupcake</h5>
                <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
            </div>
            <div class="Addcupcake">
                <button class="addtokurv" name="AddCupcakeToKurv" type="submit">Tilføj til kurv</button>
            </div>
        </div>

    </div>
    </div>
</div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>

</html>