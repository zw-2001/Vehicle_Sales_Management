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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.9.3/html2pdf.bundle.min.js"></script>
</head>

<body class="body-facturation">
<header>
    <div class="background-image-container bg-facture">
        <div class="background-image-overlay"></div>
        <jsp:include page="/WEB-INF/fragments/navbar.jsp"/>
        <div class="cadre">
            <div class="txt animated pulse ">
                <h1 style="color : white">Achetez plus qu'une voiture</h1>
                <p style="color : white ">Le pouvoir de rouler moins cher </p>
            </div>
        </div>
    </div>
    </div>
</header>

<div class=" content" style="padding-top :50px">
    <div id="facturation">
        <div class="background-facturation"></div>
        <div id="invoice" class="shadow">

            <div id="invoice-top">
                <div class="logo-cupcake">
                    <img class="avec" src="/resources/images/logo/logo.png" style="height : 100px">
                </div>
                <div class="title">
                    <h1 class="numfac"> Facture numéro : ${invoiceId}</h1>
                    <br><br>
                    <p class="info-fac" style="float : right"> Date: ${currentDate}</p>
                </div>
            </div>
            <div id="invoice-mid">
                <div class="info">
                    <h2 class="pers-loc">${userAttribute.getFirstName()} ${userAttribute.getLastName()}</h2>
                    <p class="info-fac">${userAttribute.getEmail()}</p>
                </div>
            </div>
            <div id="invoice-bot">
                <div id="table">
                    <table>
                        <tr class="tabletitle">
                            <th><h2 class="info-fac-table">Véhicule</h2></th>
                            <th><h2 class="info-fac-table">Type</h2></th>
                            <th><h2 class="info-fac-table">Marque</h2></th>
                            <th><h2 class="info-fac-table">Prix</h2></th>
                            <th><h2 class="info-fac-table">Quantité</h2></th>
                            <th><h2 class="info-fac-table">Remise</h2></th>
                            <th><h2 class="info-fac-table">Total</h2></th>
                        </tr>
                        <c:forEach var="cartVehicle" items="${cartVehicles}">
                            <tr class="service">
                                <td><p class="itemtext info-fac"> ${cartVehicle.getVehicle()}</p></td>
                                <td><p class="itemtext info-fac"> ${cartVehicle.getType()}</p></td>
                                <td><p class="itemtext info-fac"> ${cartVehicle.getBrand()}</p></td>
                                <td><p class="itemtext info-fac"> ${cartVehicle.getPrice(1)} €</p></td>
                                <td><p class="itemtext info-fac"> ${cartVehicle.getQuantity()}</p></td>
                                <td><p class="itemtext info-fac"> ${Math.round(cartVehicle.getDiscount() * 100)} %</p></td>
                                <td><p class="itemtext info-fac"> ${cartVehicle.getPrice(cartVehicle.getQuantity())}
                                    €</p></td>
                            </tr>
                        </c:forEach>

                        <tr class="tabletitle">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td style="text-align: right"><h2>Total :</h2></td>
                            <td colspan="2" style="text-align: right"><h2>${total} €</h2></td>
                        </tr>
                        <tr class="tabletitle"></tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td style="text-align: right"><h2>Taxes :</h2></td>
                        <td colspan="2" style="text-align: right">
                            <h2>${(userAttribute.getCountry().getTax().replace(',', '.') * 100) - 100} %</h2></td>
                    </table>
                </div>
            </div>
        </div>
        <div style="text-align: center; padding-bottom: 20px">${msg}</div>

        <form action="/invoice-management" method='POST'>
            <c:if test="${invoicePayment == false}">
                <button type="submit" class="btn btn-facturation btn-outline-dark" value="cash" name="payment"
                        style="float : right; margin: 50px 50px 50px 0px">Paiment au comptant
                </button>
                <button type="submit" class="btn btn-facturation btn-outline-dark" value="credit3" name="payment"
                        style="float : right; margin: 50px 50px 50px 0px">Paiment à crédit 12 mois
                </button>
                <button type="submit" class="btn btn-facturation btn-outline-dark" value="credit6" name="payment"
                        style="float : right; margin: 50px 50px 50px 0px">Paiment à crédit 6 mois
                </button>
                <button type="submit" class="btn btn-facturation btn-outline-dark" value="credit12" name="payment"
                        style="float : right; margin: 50px 50px 50px 0px">Paiment à crédit 3 mois
                </button>
            </c:if>
        </form>
        <c:if test="${invoicePayment == true}">
            <button class="btn btn-facturation btn-outline-dark" onclick="generatePDF();"
                    style="float : right; margin: 50px 50px 50px 0px">Impression HTML
            </button>
            <button class="btn btn-facturation btn-outline-dark" onclick="generatePDF();"
                    style="float : right; margin: 50px 50px 50px 0px">Impression PDF
            </button>
        </c:if>
    </div>
</div>
<jsp:include page="/WEB-INF/fragments/footer.jsp"/>

<script>
    function generatePDF() {
        const pdf = document.getElementById('invoice');
        html2pdf().from(pdf).save("facture.pdf");
    }
</script>
</body>
</html>