<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>homepage</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    <script src="${pageContext.request.contextPath}/js/utils.js"></script>
    <script src="${pageContext.request.contextPath}/js/homepage.js"></script>
    <style>
            body {font-family: Arial, Helvetica, sans-serif;}

            .navbar {
                width: 100%;
                background-color:#F5F5DC;
                overflow: auto;
            }

            .navbar a {
                float: right;
                padding: 12px;
                color: black;
                text-decoration: none;
                font-size: 17px;
            }

            .navbar a:hover {
                background-color: white;
            }

            .active {
                background-color: 	#C0C0C0;
            }

            @media screen and (max-width: 500px) {
                .navbar a {
                    float: none;
                    display: block;
                }
            }

            /* CSS for Food SEarch Section */

            .food-search{
                background-image: url(../html/images/bg.jpg);
                background-size: 1400px 200px;
                background-repeat: no-repeat;
                background-position: center;
                padding: 7% 0;
            }

            .food-search input[type="search"]{
                width: 50%;
                padding: 1%;
                font-size: 1rem;
                border: none;
                border-radius: 5px;
            }

            /* CSS for Social */
            .social ul{
                list-style-type: none;
            }
            .social ul li{
                display: inline;
                padding: 1%;
            }


        </style>

</head>
<body>

        <nav class="navbar">
            <p>
                <img src="${pageContext.request.contextPath}/images/logo.png" width="70" height="70" class="d-inline-block " alt="">
                MAG Food Delivery
           <p>

            <div class="navbar navbar-collapse justify-content-end ">
<c:choose>
    <c:when test="${!empty sessionScope.email}">
         <a class="active" href="${pageContext.request.contextPath}/jsp/homepage.jsp"><i class="fa fa-fw fa-home"></i> Home</a>
          <a href="${pageContext.request.contextPath}/html/customer-area/menu-page.html?email=${sessionScope.email}"><i class="fa fa-fw fa-search"></i>All products</a>
        <a href="${pageContext.request.contextPath}/html/customer-area/customer-product.html?email=${sessionScope.email}"><i class="fa fa-fw fa-search"></i>My Order</a>
        <a href="${pageContext.request.contextPath}/user/logout/"><i class="fa fa-fw fa-user"></i>Logout</a>
            <c:if test="${!sessionScope.role.equals('customer')}">

                    <a href="${pageContext.request.contextPath}/html/admin-area/admin-page.html"><i class="fa fa-fw fa-user"></i>Admin</a>
                    <c:if test="${!sessionScope.role.equals('admin')}">
                </c:if>

            </c:if>
    </c:when>

    <c:otherwise>
        <a href="${pageContext.request.contextPath}/jsp/login.jsp"><i class="fa fa-fw fa-user"></i>Login</a>
        <a href="${pageContext.request.contextPath}/jsp/register.jsp"><i class="fa fa-fw fa-user"></i>Registration</a>
    </c:otherwise>
</c:choose>
</div>
</nav>


</section>

<div class="position-relative">
    <div class="food-search text-center z-index-1 position-relative">
        <div class="container p-2 ">

        </div>

    </div>


</div>


<div class="container pt-5">

    <div class="row">

        <div class="col-sm">
            <img class="img-responsive" width="400" height="200" src="${pageContext.request.contextPath}/images/order.jpg" alt="Find what do you want to eat!">
            <figcaption class="text-center">Find what do you want to eat!</figcaption>

        </div>
        <div class="col-sm">
            <img class="img-responsive" width="300" height="200"  src="${pageContext.request.contextPath}/images/deliver.jpg" alt="Get your food delivered">
            <figcaption class="text-center">Get your food delivered</figcaption>
        </div>
        <div class="col-sm">
            <img class="img-responsive"  width="300" height="200" src="${pageContext.request.contextPath}/images/payy.jpg" alt="">
            <figcaption class="text-center">Pay on delivery</figcaption>
        </div>
    </div>
</div>

<br><br>

<section class="social">
    <div class="container text-center">
        <ul style="list-style-type: none; display: inline;
    padding: 1%;">
            <li style="display: inline;
    padding: 1%;">
                <a href="#"><img src="https://img.icons8.com/fluent/50/000000/facebook-new.png"/></a>
            </li>
            <li>
                <a href="#"><img src="https://img.icons8.com/fluent/48/000000/instagram-new.png"/></a>
            </li>
            <li>
                <a href="#"><img src="https://img.icons8.com/fluent/48/000000/twitter.png"/></a>
            </li>
        </ul>
    </div>
</section>


<section class="footer">
    <div class="container text-center">
        <p>All rights reserved. <a href="#">MAG Food Order</a></p>
    </div>
</section>
</body>
</html>