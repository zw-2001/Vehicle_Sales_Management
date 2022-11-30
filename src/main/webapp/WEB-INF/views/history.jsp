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

<body class="body-ajoutvoiture">
<header>
    <div class="background-image-container bg-historique">
        <div class="background-image-overlay"></div>
        <jsp:include page="/WEB-INF/fragments/navbar.jsp"/>
        <div class="cadre">
            <div class="txt animated pulse ">
                <h1 style="color : black">Louez plus qu'une voiture</h1>
                <p style="color : black">Le pouvoir de rouler moins cher </p>
            </div>
        </div>
    </div>
    </div>
</header>

<div class=" content" style="padding-top :50px">
    <section>
        <div class="wrapper wrapper-historique">
            <br>
            <center>Historique des véhicules que vous avez loué</center>
            <%--<?php
                    $facturationhistoriques = $_SESSION[FacturationHistoriques];
                    $lignesfacturationhistoriques = $_SESSION[LignesFacturationHistoriques];

                    foreach ($facturationhistoriques as $facturationhistorique) { 
                        echo
                        <details>
            <summary>Facture # $facturationhistorique[IdFacturation]   </summary>;
            foreach ($lignesfacturationhistoriques as $lignesfacturationhistorique) {
            if ($facturationhistorique[IdFacturation] == $lignesfacturationhistorique[IdFacturation]) {
            echo
            <table>
            <tr style="background-color: rgba(00005);">
                <th scope="row"> Marque </th>
                <td>  $lignesfacturationhistorique[Marque]  </td>
                </tr>
            <tr>
                <th scope="row"> Dates de location </th>
                <td> Du   $lignesfacturationhistorique[DateDebut]    au    $lignesfacturationhistorique[DateFin]  </td>
                </tr>
            <tr>
                <th scope="row"> Vehicule </th>
                <td>  $lignesfacturationhistorique[Type]  </td>
                </tr>
            <tr>
                <th scope="row">Prix</th>
                <td>  $lignesfacturationhistorique[Prix]  </td>
                </tr>
            </table>;
            }
            }
            echo
            </details>;
            }
            ?>--%>
        </div>
    </section>
</div>

<jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</body>
</html>
