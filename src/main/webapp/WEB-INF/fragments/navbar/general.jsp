<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light" style="background-color: transparent!important;">
    <a class="navbar-brand logo" href="/">
        <img class ="avec" src ="/resources/images/logo/logo.png" style="height : 100px">
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto navbar-center ">
            <li color ="black ; font-weight: bold;"><a href="/catalog">Consultation des voitures</a></li>
            <li color ="black ; font-weight: bold;"><a href="/contact">Contact</a></li>
        </ul>
    </div>
    <form action="/login" method="POST">
        <button class="button" type="submit"style="color : black">Se connecter</button>
    </form>
</nav>
