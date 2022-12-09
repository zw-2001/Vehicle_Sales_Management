<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light" style="background-color: transparent!important;">
    <a class="navbar-brand logo" href="/">
        <img class="avec" src="/resources/images/logo/logo.png" style="height : 80px">
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto navbar-center ">
            <c:set var="user" scope="session" value="${user}"/>
            <form action="/catalog" method="POST">
                <li color="black ; font-weight: bold;">
                    <c:if test="${user == 'General'}">
                        <button type="submit"><mark class="black" style="border-radius: 30px">Consultation du catalogue</mark></button>
                    </c:if>
                    <c:if test="${user == 'Administrator'}">
                        <button type="submit"><mark class="black" style="border-radius: 30px">Gestion des véhicules</mark></button>
                    </c:if>
                    <c:if test="${user == 'Company' || user == 'Individual'}">
                        <button type="submit"><mark class="black" style="border-radius: 30px">Obtenir un véhicule</mark></button>
                    </c:if>

                </li>
            </form>
            <c:if test="${user == 'Administrator'}">
                <form action="/add-car" method="POST">
                    <li color="black ; font-weight: bold;">
                        <button type="submit"><mark class="black" style="border-radius: 30px">Ajouter des voitures</mark></button>
                    </li>
                </form>
            </c:if>
            <c:if test="${user == 'Administrator' || user == 'Company' || user == 'Individual'}">
                <form action="/history" method="POST">
                    <li color="black ; font-weight: bold;">
                        <c:if test="${user == 'Administrator'}">
                            <button type="submit"><mark class="black" style="border-radius: 30px">Historique des ventes</mark></button>
                        </c:if>
                        <c:if test="${user == 'Company' || user == 'Individual'}">
                            <button type="submit"><mark class="black" style="border-radius: 30px">Historique d'achats</mark></button>
                        </c:if>
                    </li>
                </form>
            </c:if>
            <form action="/contact" method="POST">
                <li color="black ; font-weight: bold;">
                    <c:if test="${user == 'General' || user == 'Company' || user == 'Individual'}">
                        <button type="submit"><mark class="black" style="border-radius: 30px">Contact</mark></button>
                    </c:if>
                </li>
            </form>
        </ul>
    </div>
    <c:if test="${user == 'Company' || user == 'Individual'}">
        <form action="/cart" method="POST">
            <button type="submit" class="button" style="color : black"><i class='fas fa-cart-arrow-down'></i> Panier</button>
        </form>
    </c:if>
    <c:choose>
        <c:when test="${user == 'Administrator' || user == 'Company' || user == 'Individual'}">
            <form action="/logout" method="POST">
                <button class="button" type="submit" style="color : black">Se déconnecter</button>
            </form>
        </c:when>
        <c:otherwise>
            <form action="/login" method="POST">
                <button class="button" type="submit" style="color : black">Se connecter</button>
            </form>
        </c:otherwise>
    </c:choose>
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</nav>
