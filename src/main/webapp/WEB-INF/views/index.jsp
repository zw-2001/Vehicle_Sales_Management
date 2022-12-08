<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <title>Cupcake</title>
    <link rel="shortcut icon" href="/resources/images/logo/logo-icon.png">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@8.4.4/swiper-bundle.min.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/resources/css/style.css"/>
</head>

<body>
<header>
    <div class="background-image-container bg-index">
        <div class="background-image-overlay"></div>
        <jsp:include page="/WEB-INF/fragments/navbar.jsp"/>
        <div class="cadre">
            <div class="txt animated pulse ">
                <h1 style="color : white">Achetez plus qu'une voiture</h1>
                <p style="color : white">Le pouvoir de rouler moins cher</p>
                <c:if test="${user == 'General'}">
                    <div class="box-1">
                        <a href="login">
                            <div class="btn btn-one">
                                <span>Commencez à acheter</span>
                            </div>
                        </a>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</header>

<div class=" content" style="padding-top :50px">
    <div class="jumbotron jumbotron-fluid">
        <div class="row">
            <div class="col-md box"
                 style="background-image:url(https://cdn.shopify.com/s/files/1/0068/6289/7199/files/banner-v1-1.jpg?v=1564546967)">

                <h3>Nos partenaires</h3>
                <a href="https://www.lacentrale.fr/">
                    <button type="button" class="btn btn-outline-primary" style="margin-top:20px">Voir</button>
                </a>
            </div>
            <div class="col-md box"
                 style="background-image:url(https://cdn.shopify.com/s/files/1/0068/6289/7199/files/banner-v1-2.jpg?v=1564546976)">

                <h3>Nos partenaires</h3>
                <a href="https://www.occasionsdulion.com/">
                    <button type="button" class="btn btn-outline-primary" style="margin-top:20px">Voir</button>
                </a>
            </div>
        </div>
    </div>

    <div class="swiper-container">
        <div class="container-title">
            <h1>Nos voitures</h1>
        </div>
        <div class="swiper-wrapper">
            <div class="swiper-slide" style="background-image:url(/resources/images/cars/carousel/Range_Rover.png)">
                <div class="carousel-title-car">Range Rover</div>
            </div>
            <div class="swiper-slide" style="background-image:url(/resources/images/cars/carousel/Mercedes.png)">
                <div class="carousel-title-car">Mercedes-Benz</div>
            </div>
            <div class="swiper-slide" style="background-image:url(/resources/images/cars/carousel/Mini.png)">
                <div class="carousel-title-car">Mini</div>
            </div>
            <div class="swiper-slide" style="background-image:url(/resources/images/cars/carousel/Renault.png)">
                <div class="carousel-title-car">Renault</div>
            </div>
            <div class="swiper-slide" style="background-image:url(/resources/images/cars/carousel/Tesla.png)">
                <div class="carousel-title-car">Tesla</div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/fragments/footer.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/swiper@8.4.4/swiper-bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js"></script>

<script>
    var swiper = new Swiper('.swiper-container', {
        autoplay: {
            delay: 2000,
        },
        loop: true,
        effect: 'coverflow',
        grabCursor: true,
        centeredSlides: true,
        speed: 1250,
        slidesPerView: 'auto',
        coverflowEffect: {
            rotate: 20,
            stretch: 0,
            depth: 200,
            modifier: 1,
            slideShadows: true,
        },
    });
</script>
</body>
</html>