<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="utf-8">
    <title>Cupcake</title>
    <link rel="shortcut icon" href="/resources/images/logo/logo-icon.png">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/resources/css/style.css"/>
</head>

<body class="body-location">
<header>
    <div class="background-image-container bg-location">
        <div class="background-image-overlay"></div>
        <jsp:include page="/WEB-INF/fragments/navbar.jsp"/>
        <div class="cadre">
            <div class="txt animated pulse">
                <h1 style="color : white">Achetez plus qu'une voiture</h1>
                <p style="color : white">Le pouvoir de rouler moins cher </p>
            </div>
        </div>
    </div>
    </div>
</header>

<div class="content" style="padding-top :50px">
    <form action="/search" method="POST">
        <div class="main-search-input-wrap">
            <div class="main-search-input fl-wrap">
                <div class="main-search-input-item">
                    <input type="text" value="" name="search" placeholder="Rechercher...">
                </div>
                <button type="submit" class="main-search-button">Rechercher</button>
            </div>
        </div>
    </form>
    <form action="/management" method="POST">
        <c:forEach var="vehicle" items="${vehicles}">
            <div class="container catalog-container">
                <div class=" box boxL">
                    <img src="/resources/images/cars/catalog/${vehicle.getImage()}"/>
                </div>

                <div class=" box boxR">
                    <div class="boxR-prix">
                        <p class="prix-bloc"> ${vehicle.getPrice(1)} euros</p>
                    </div>

                    <table>
                        <tr>
                            <c:set var="user" scope="session" value="${user}"/>
                            <th> Véhicule</th>
                            <th> Type</th>
                            <th> Marque</th>
                            <th> Énergie</th>
                            <th> Boîte de vitesse</th>
                            <th> Nombre de places</th>
                            <c:if test="${user == 'Administrator' || user == 'Company' || user == 'Individual'}">
                                <th> Quantité</th>
                            </c:if>
                        </tr>
                        <tr>
                            <td>${vehicle.getVehicle()}</td>
                            <td>${vehicle.getType()}</td>
                            <td> ${vehicle.getBrand()}</td>
                            <td> ${vehicle.getEnergy()}</td>
                            <td> ${vehicle.getGearbox()}</td>
                            <td> ${vehicle.getSeat()}</td>
                            <c:if test="${user == 'Administrator' || user == 'Company' || user == 'Individual'}">
                                <c:if test="${user == 'Administrator'}">
                                    <td><input type="number" value="${vehicle.getQuantity()}" name="quantity[]" min="0"
                                               max="${vehicle.getQuantity()}" style="width: 50px" required></td>
                                </c:if>
                                <c:if test="${user == 'Company'}">
                                    <td><input type="number" value="0" name="quantity[]" min="0"
                                               max="${vehicle.getQuantity()}" style="width: 50px" required></td>
                                </c:if>
                                <c:if test="${user == 'Individual'}">
                                    <td><input type="number" value="0" name="quantity[]" min="0"
                                               max="${Math.min(vehicle.getQuantity(), Integer.parseInt("5"))}"
                                               style="width: 50px" required></td>
                                </c:if>
                                <td style="display: none"><input type="checkbox" value="${vehicle.getId()}" name="checkbox[]" checked></td>
                            </c:if>
                        </tr>
                    </table>
                </div>
            </div>
        </c:forEach>

        <c:if test="${user == 'Administrator'}">
            <button type="submit" value="delete" name="action" class="btn btn-connexion btn-outline-dark"
                    style="float : right; margin: 0px 50px 50px 0px">Supprimer
            </button>
        </c:if>
        <c:if test="${user == 'Company' || user == 'Individual'}">
            <button type="submit" value="cart" name="action" class="btn btn-connexion btn-outline-dark"
                    style="float : right; margin: 0px 50px 50px 0px">Ajouter
            </button>
        </c:if>
    </form>
    <c:if test="${user == 'Administrator'}">
        <form action="/add-car" method="POST">
            <button type="submit" class="btn btn-connexion btn-outline-dark"
                    style="margin-left: 50px">Ajouter une voiture
            </button>
        </form>
    </c:if>
    <div style="text-align: center; padding-bottom: 20px">${msg}</div>
</div>

<jsp:include page="/WEB-INF/fragments/footer.jsp"/>

</body>
</html>