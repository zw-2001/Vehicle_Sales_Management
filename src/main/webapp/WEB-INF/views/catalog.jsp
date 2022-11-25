<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="utf-8">
    <title>Cupcake</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/resources/css/style.css" />
</head>

<body class ="body-location">
<header>
    <div class="background-image-container bg-location">
        <div class="background-image-overlay"></div>
        <jsp:include page="/WEB-INF/fragments/navbar/${navbar}.jsp" />
        <div class="cadre">
            <div class="txt animated pulse ">
                <h1 style ="color : white">Louez plus qu'une voiture</h1>
                <p style ="color : white">Le pouvoir de rouler moins cher </p>
            </div>
        </div>
    </div>
    </div>
</header>

<div class=" content location-content" style="padding-top :50px">
<%--    <c:forEach items="${locations}" var="location">
        <div class="card" style="width: 18rem;">
            <img src="${location.image}" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">${location.name}</h5>
                <p class="card-text">${location.description}</p>
                <a href="/location/${location.id}" class="btn btn-primary">Voir plus</a>
            </div>
        </div>--%>
    <%--<?php
                $vehicules = $_SESSION['Vehicules'];

                foreach ($vehicules as $vehicule) {
                    echo '<div class = "container">',

    '<div class = " box boxL">',
    "<img src = View/Design/images/", $vehicule['Photo'] . "  > ",
    '</div>',

    '<div class = " box boxR">',

    '<div class ="boxR-prix">',
        '<p class="prix-bloc"> '. $vehicule['Prix'] . " euros/jour" .'</p>',
        '</div>',

    '<table>',
        '<tr><th> Modèle </th> <th> Caracteristiques </th></tr>',
        '<tr>',
            '<td>' . $vehicule['Type'] . '</td>',
            '<td>' . $vehicule['Caracteristiques'] . '</td>',

            '</tr>',
        '</table>',
    '</div>',

    '</div>';
}

?>--%>
</div>

<jsp:include page="/WEB-INF/fragments/footer/footer.jsp" />

</body>
</html>