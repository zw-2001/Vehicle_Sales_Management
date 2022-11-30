<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="utf-8">
    <title>Cupcake</title>
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
            <div class="txt animated pulse ">
                <h1 style="color : white">Louez plus qu'une voiture</h1>
                <p style="color : white">Le pouvoir de rouler moins cher </p>
            </div>
        </div>
    </div>
    </div>
</header>

<div class="content" style="padding-top :50px">
    <form action="/management" method="POST">
        <c:forEach var="vehicle" items="${vehicles}">
            <div class="container">
                <div class=" box boxL">
                    <img src="/resources/images/cars/catalog/${vehicle.getImage()}"/>
                </div>

                <div class=" box boxR">
                    <div class="boxR-prix">
                        <p class="prix-bloc"> ${vehicle.getPrice()} euros</p>
                    </div>

                    <table>
                        <tr>
                            <c:set var="user" scope="session" value="${user}"/>
                            <th> Véhicule</th>
                            <th> Type</th>
                            <th> Marque</th>
                            <th> Énergie</th>
                            <th> Boîte de vitesse</th>
                            <c:if test="${user == 'Administrator' || user == 'Company' || user == 'Individual'}">
                                <th> Stock</th>
                                <th> Ajouter</th>
                            </c:if>
                        </tr>
                        <tr>
                            <td>${vehicle.getVehicle()}</td>
                            <td>${vehicle.getType()}</td>
                            <td> ${vehicle.getBrand()}</td>
                            <td> ${vehicle.getEnergy()}</td>
                            <td> ${vehicle.getGearbox()}</td>
                            <c:if test="${user == 'Administrator' || user == 'Company' || user == 'Individual'}">
                                <td> ${vehicle.getStock()}</td>
                                <td><input type="checkbox" value="${vehicle.getId()}" name="checkbox[]"></td>
                            </c:if>
                        </tr>
                    </table>
                </div>
            </div>
        </c:forEach>

        <c:if test="${user == 'Administrator'}">
            <button type="submit" name="action" value="delete" class="btn btn-connexion btn-outline-dark"
                    style="float : right; margin: 0px 50px 50px 0px">Supprimer
            </button>
            <button type="submit" name="action" value="available" class="btn btn-connexion btn-outline-dark"
                    style="float : right; margin: 0px 50px 50px 0px">Mettre à disposition
            </button>
            <button type="submit" name="action" value="review" class="btn btn-connexion btn-outline-dark"
                    style="float : right; margin: 0px 50px 50px 0px">Mettre en revision
            </button>
        </c:if>
    </form>
    <c:if test="${user == 'Administrator'}">
        <form action="/add-car" method="POST">
            <button type="sumit" class="btn btn-connexion btn-outline-dark"
                    style="margin-left: 50px">Ajouter une voiture
            </button>
        </form>
    </c:if>
    <c:if test="${user == 'Company' || user == 'Individual'}">
        <form>
            <button type="submit" class="btn btn-connexion btn-outline-dark"
                    style="float : right; margin: 0px 50px 50px 0px">Confirmer
            </button>
        </form>
    </c:if>
</div>

<jsp:include page="/WEB-INF/fragments/footer.jsp"/>

</body>
</html>