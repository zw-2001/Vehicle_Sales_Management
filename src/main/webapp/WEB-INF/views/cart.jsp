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
            <div class="txt animated pulse ">
                <h1 style="color : white">Louez plus qu'une voiture</h1>
                <p style="color : white">Le pouvoir de rouler moins cher </p>
            </div>
        </div>
    </div>
    </div>
</header>
<div class=" content" style="padding-top :50px">
    <form action='/invoice' method='POST'>
        <c:forEach var="cartVehicle" items="${cartVehicles}">
        <div class="container catalog-container">
            <div class=" box boxL">
                <img src="/resources/images/cars/catalog/${cartVehicle.getImage()}" >
            </div>
            <div class=" box boxR">
                <div class="boxR-prix">
                    <p class="prix-bloc"> Total : ${cartVehicle.getPrice(cartVehicle.getQuantity())} euros </p>
                </div>
                <table>
                    <tr>
                        <th> Véhicule</th>
                        <th> Type</th>
                        <th> Marque</th>
                        <th> Énergie</th>
                        <th> Boîte de vitesse</th>
                        <th> Nombre de places</th>
                        <th> Quantité </th>
                        <th> Prix </th>
                    </tr>
                    <tr>
                        <td> ${cartVehicle.getVehicle()}</td>
                        <td> ${cartVehicle.getType()}</td>
                        <td> ${cartVehicle.getBrand()}</td>
                        <td> ${cartVehicle.getEnergy()}</td>
                        <td> ${cartVehicle.getGearbox()}</td>
                        <td> ${cartVehicle.getSeat()}</td>
                        <td>
                            <input type="number" value="${cartVehicle.getQuantity()}" name="quantity[]" min="0"
                                       max="${cartVehicle.getQuantity()}" style="width: 50px" required>
                        </td>
                        <td> ${cartVehicle.getPrice(1)} €</td>
                        <td style="display: none"><input type="checkbox" value="${cartVehicle.getId()}" name="checkbox[]" checked></td>
                    </tr>
                </table>
            </div>
        </div>
        </c:forEach>
        <button type="submit" class="btn btn-connexion btn-outline-dark"
                style="float : right; margin: 0px 50px 50px 0px">Confirmer</button>
    </form>
    <form action="/clear-cart" method="POST">
        <button type="submit" class="btn btn-connexion btn-outline-dark"
                style="float : right; margin: 0px 50px 50px 0px">Vider</button>
    </form>
    <div style="text-align: center; padding-bottom: 20px">${msg}</div>
</div>

<jsp:include page="/WEB-INF/fragments/footer.jsp"/>

</body>
</html>