<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <script src="https://www.google.com/recaptcha/api.js"></script>
    <title>Register</title>
    <style>
        <jsp:include page="css/loginstyle.css"/>
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body oncopy="return false" oncut="return false" onpaste="return false">

<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card bg-white text-dark" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">

                        <div class="mb-md-5 mt-md-4 pb-5">
                            <h2 class="fw-bold mb-2 text-uppercase">Register</h2>
                            <p class="text-white-50 mb-5">Please enter your Email and password!</p>
                            <form method="post">
                                <div class="form-outline form-white mb-4">
                                    <label class="form-label" for="email">Email</label>

                                    <input type="email" name="email" id="email" class="form-control form-control-lg"
                                           placeholder="Email" required/>
                                </div>

                                <div class="form-outline form-white mb-4">
                                    <label class="form-label" for="password">Password</label>

                                    <input type="password" name="password" id="password"
                                           class="form-control form-control-lg" placeholder="Password" required/>

                                    <label class="form-label" for="Repeatpassword">Repeat Password</label>

                                    <input type="password" name="RetypedPassword" id="Repeatpassword"
                                           class="form-control form-control-lg" placeholder="Repeat your password"
                                           required/>


                                    <div class="g-recaptcha"
                                         data-sitekey="6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhI"></div>
                                    <button class="btn btn-outline-dark btn-lg px-5" type="submit">Register</button>
                                </div>
                            </form>


                            <p class="small mb-5 pb-lg-2"><a class="text-dark" href="#!">Forgot password?</a></p>

                            <div class="text-danger fw-bold">
                                <c:if test="${requestScope.ReqError != null}">
                                    ${requestScope.ReqError}
                                </c:if>

                            </div>
<div>
    <p class="mb-0">Password requirments: minimum length 8, One upper case letter, 1 number</p>

</div>
                            <div>
                                  <p class="mb-0">Already have an account? <a
                                        href="${pageContext.request.contextPath}/login/" class="text-danger fw-bold">Sign
                                    In</a></p>
                            </div>

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