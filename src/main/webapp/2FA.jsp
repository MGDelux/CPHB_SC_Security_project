<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <script src="https://www.google.com/recaptcha/api.js"></script>
    <title>verify Authenticator</title>
    <style>
        <jsp:include page="css/loginstyle.css"/>
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body>
<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card bg-dark text-white" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">

                        <div class="mb-md-5 mt-md-4 pb-5">
                            <form method="post">

                                <h2 class="fw-bold mb-2 text-uppercase">verify Authenticator</h2>
                                <p class="text-white-50 mb-5">Please enter your Verification code from google auth!</p>

                                <div class="form-outline form-white mb-4">
                                    <input name="SecretKey" type="password" id="SecretKey"
                                           class="form-control form-control-lg" placeholder="SecretKey" required/>
                                    <label class="form-label" for="SecretKey">Verification</label>

                                    <div class="g-recaptcha"
                                         data-sitekey="6LcfzUEdAAAAAJ2BgqoyBq5ajTxipA13MzeZ77yD"></div>

                                    <button class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>
                                </div>

                            </form>

                            <p class="small mb-5 pb-lg-2"><a class="text-white-50" href="#!">Forgot password?</a></p>
                            <div class="text-danger fw-bold">
                                <c:if test="${requestScope.LogInError != null}">
                                    ${requestScope.LogInError}


                            </div>

                        </div>

                        <div>
                            <p class="mb-0">Don't have an account? <a
                                    href="${pageContext.request.contextPath}/register/" class="text-danger fw-bold">Sign
                                Up</a></p>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>