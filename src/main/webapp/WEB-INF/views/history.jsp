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

<body class="body-ajoutvoiture">
<header>
    <div class="background-image-container bg-historique">
        <div class="background-image-overlay"></div>
        <jsp:include page="/WEB-INF/fragments/navbar.jsp"/>
        <div class="cadre">
            <div class="txt animated pulse ">
                <h1 style="color : black">Achetez plus qu'une voiture</h1>
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
            <c:forEach var="invoice" items="${invoices}">
                <details>
                <summary>
                    Facture # ${invoice.getId()} |
                    Date : ${invoice.getDate()} |
                    Paiement : ${invoice.getPayment()} |
                    Mensualité : ${invoice.getNbMonth()} |
                    Total : ${invoice.getTotal()} €
                </summary>
                <c:forEach var="invoicedetail" items="${invoice.getInvoiceDetail()}">
                    <table>
                        <tr style="background-color: rgba(0,0,0,0.5);">
                            <th scope="row"> Véhicule </th>
                            <td>  ${invoicedetail.getVehicle().getVehicle()}  </td>
                        </tr>
                        <tr>
                            <th scope="row"> Type </th>
                            <td> ${invoicedetail.getVehicle().getType()} </td>
                        </tr>
                        <tr>
                            <th scope="row"> Marque </th>
                            <td>  ${invoicedetail.getVehicle().getBrand()} </td>
                        </tr>
                        <tr>
                            <th scope="row">Prix</th>
                            <td>  ${invoicedetail.getVehicle().getPrice()}  </td>
                        </tr>
                        <tr>
                            <th scope="row">Quantity</th>
                            <td>  ${invoicedetail.getQuantity()}  </td>
                        </tr>
                        <tr>
                            <th scope="row">Énergie</th>
                            <td>  ${invoicedetail.getVehicle().getGearbox()}  </td>
                        </tr>
                        <tr>
                            <th scope="row">Place</th>
                            <td>  ${invoicedetail.getVehicle().getSeat()}  </td>
                        </tr>
                        <tr>
                            <th scope="row">Total</th>
                            <td>  ${invoicedetail.getTotal()}  </td>
                        </tr>
                    </table>
                </c:forEach>
                </details>
            </c:forEach>
        </div>
        <div> ${msg} </div>
    </section>
</div>

<jsp:include page="/WEB-INF/fragments/footer.jsp"/>
</body>
</html>
