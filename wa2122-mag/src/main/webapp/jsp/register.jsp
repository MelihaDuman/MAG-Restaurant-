<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
       <meta charset="utf-8">
       <title>login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
             <style>
                    .bg-image-vertical {
                        position: relative;
                        overflow: hidden;
                        background-repeat: no-repeat;
                        background-position: right center;
                        background-size: auto 100%;
                    }

                    @media (min-width: 1025px) {
                        .h-custom-2 {
                            height: 100%;
                        }
                    }



                </style>
    </head>
    <body>
    <section class="vh-100">
              <div class="container-fluid">
                  <div class="row">
                      <div class="col-sm-6 text-black">



                          <div class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">

                  <form method="POST" action="<c:url value="/user/register/"/>" style="width: 23rem;">
                      <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Register</h3>
                      <div class="form-outline mb-4">
                                                  <input type="TEXT" name="email" class="form-control form-control-lg" />
                                                  <label class="form-label" for="email">Email address</label>
                                              </div>
                      <div class="form-outline mb-4">
                                                                        <input type="TEXT" name="first_name" class="form-control form-control-lg" />
                                                                        <label class="form-label" for="first_name">First Name</label>
                                                                    </div>
                      <div class="form-outline mb-4">
                                                                        <input type="TEXT" name="last_name" class="form-control form-control-lg" />
                                                                        <label class="form-label" for="last_name">Last Name</label>
                                                                    </div>

                       <div class="form-outline mb-4">
                                                  <input type="password" name="password" class="form-control form-control-lg" />
                                                  <label class="form-label" for="password">Password</label>
                                              </div>
                       <div class="form-outline mb-4">
                                                                         <input type="password" name="rpassword" class="form-control form-control-lg" />
                                                                         <label class="form-label" for="rpassword">Repeat password</label>
                                                                     </div>

                                  <div class="pt-1 mb-4">
                                      <button class="btn btn-info btn-lg btn-block" type="submit">Register</button>
                                  </div>

          </form>



                          </div>

                      </div>
                      <div class="col-sm-6 px-0 d-none d-sm-block">
                          <img src="${pageContext.request.contextPath}/images/login.jpg"
                               alt="Login image" class="w-100 vh-100" style="object-fit: cover; object-position: left;">
                      </div>
                  </div>
              </div>
          </section>


                  <c:choose>
                      <c:when test="${message.error}">
                          <p><c:out value="${message.message}"/></p>
                      </c:when>
                      <c:otherwise></c:otherwise>
                  </c:choose>
              </body>
          </html>

