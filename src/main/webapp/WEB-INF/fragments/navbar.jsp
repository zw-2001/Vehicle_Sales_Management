<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>

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
                        <button type="submit"><mark class="black">Consultation du catalogue</mark></button>
                    </c:if>
                    <c:if test="${user == 'Administrator'}">
                        <button type="submit"><mark class="black">Gestion des véhicules</mark></button>
                    </c:if>
                    <c:if test="${user == 'Company' || user == 'Individual'}">
                        <button type="submit"><mark class="black">Obtenir un véhicule</mark></button>
                    </c:if>

                </li>
            </form>
            <c:if test="${user == 'Administrator'}">
                <form action="/add-car" method="POST">
                    <li color="black ; font-weight: bold;">
                        <button type="submit"><mark class="black">Ajouter des voitures</mark></button>
                    </li>
                </form>
            </c:if>
            <c:if test="${user == 'Administrator' || user == 'Company' || user == 'Individual'}">
                <form action="/history" method="POST">
                    <li color="black ; font-weight: bold;">
                        <c:if test="${user == 'Administrator'}">
                            <button type="submit"><mark class="black">Historique des ventes</mark></button>
                        </c:if>
                        <c:if test="${user == 'Company' || user == 'Individual'}">
                            <button type="submit"><mark class="black">Historique d'achats</mark></button>
                        </c:if>
                    </li>
                </form>
            </c:if>
            <form action="/contact" method="POST">
                <li color="black ; font-weight: bold;">
                    <c:if test="${user == 'General' || user == 'Company' || user == 'Individual'}">
                        <button type="submit"><mark class="black">Contact</mark></button>
                    </c:if>
                </li>
            </form>
        </ul>
    </div>
    <c:if test="${user == 'Company' || user == 'Individual'}">
    <a href="C:\Users\zheng\OneDrive\Bureau\M1 MIAGE\Semestre 1\Programmation Objet avancée\Projet\Vehicle_Sales_Management\src\main\webapp\WEB-INF\views\cart.jsp" class="button" style="color : black"><i class='fas fa-cart-arrow-down'></i> Panier</a>
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
