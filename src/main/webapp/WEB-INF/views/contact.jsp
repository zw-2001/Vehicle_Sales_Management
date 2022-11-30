<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="utf-8">
    <title>Cupcake</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/resources/css/style.css"/>
</head>

<body class="body-contact">
<header>
    <div class="background-image-container bg-contact">
        <div class="background-image-overlay"></div>
        <jsp:include page="/WEB-INF/fragments/navbar.jsp"/>
        <div class="cadre">
            <div class="txt animated pulse ">
                <h1 style="color : white">Louez plus qu'une voiture</h1>
                <p style="color : white">Le pouvoir de rouler moins cher</p>
            </div>
        </div>
    </div>
    </div>
</header>

<div class=" content">
    <div class="fond">
        <div class="cadre content-info">
            <div class="boxL">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2624.3740547935377!2d2.2714310155654522!3d48.870145407833164!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x47e6655922d250b7%3A0x3393b4fa95ac9e83!2sUniversit%C3%A9%20Paris%20Dauphine-PSL!5e0!3m2!1sfr!2sfr!4v1669338859893!5m2!1sfr!2sfr"
                        width="100%" height="800" style="border:0;" allowfullscreen="" loading="lazy"
                        referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>
            <div class="boxM">
                <div class="content-boxM">
                    <h3><i class="fas fa-map-marker-alt"></i> Localisation</h3>
                    <p>Pl. du Maréchal de Lattre de Tassigny, 75016 Paris</p><br>

                    <h3><i class="fas fa-phone"></i>Téléphone</h3>
                    <p>01 44 05 44 05</p><br>

                    <h3><i class="fas fa-barcode"></i>Qui nous-sommes ?</h3>
                    <p>Cupcake</p>
                    <p>Nous sommes une agence de vente de voitures en ligne.<br></p>
                    <p>Une équipe de deux merveilleux étudiants voulant avoir une bonne note à leur projet.</p><br><br>
                    <h3><i class="far fa-clock"></i>Horaires</h3>
                    <p>
                        Lundi : 9h - 18h<br>
                        Mardi : 9h - 18h <br>
                        Mrcredi : 9h - 18h <br>
                        Jeudi : 9h - 18h <br>
                        Vendredi : 9h - 18h <br>
                        Samedi : 9h - 18h<br>
                        Dimanche : Fermé <br>
                    </p>
                </div>
            </div>

            <div class="boxR">
                <div class="wrapper">
                    <h3>Laissez un message</h3><br>
                    <div class="contact-form">
                        <div class="input-fields">
                            <input type="text" class="input" placeholder="Nom">
                            <input type="email" class="input" placeholder="Email">
                        </div>
                        <form action="/send-message" method="POST" class="msg">
                            <textarea placeholder="Messages"></textarea>
                            <button type="submit" class="btn btn-contact btn-outline-dark" style="margin-top : 20px">
                                Envoyer
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/fragments/footer.jsp"/>

</body>
<html>
