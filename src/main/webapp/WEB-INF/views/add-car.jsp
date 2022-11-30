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
<body class="body-ajoutvoiture" style="background-color :#191919!important; color : white">
<header>
    <div class="background-image-container bg-ajoutvoiture">
        <div class="background-image-overlay"></div>
        <jsp:include page="/WEB-INF/fragments/navbar.jsp"/>
        <div class="cadre">
            <div class="txt animated pulse ">
                <h1 color="black ; font-weight: bold;">Louez plus qu'une voiture</h1>
                <p color="black ; font-weight: bold;">Le pouvoir de rouler moins cher </p>
            </div>
        </div>
    </div>
    </div>
</header>

<div class=" content" style="padding-top :50px ; background-color : #302E27 ">
    <section>
        <div clas="wrapper">
            <form action="/add-car-check" method="POST" class="ajoutervoiture-form">
                <center style="font-weight: bold ; "><br>Ajouter une voiture en location</center>
                <div class="input-fieldscar addcar">
                    <label>Type : </label>
                    <input class=" champ" type="text" placeholder="Votre type" name="type" required/>

                    <label>Prix/Jour : </label>
                    <input class=" champ" type="text" placeholder="Le prix" name="prix" required/>

                    <label>Caractéristiques : </label>
                    <input class=" champ" type="text" placeholder="Caracteristique de voiture" name="caracteristique"
                           required/>

                    <label>Nom de la photo : </label>
                    <input class=" champ" type="text" placeholder="Photo de voiture" name="photo" required/>
                </div>

                <div>${msg}</div>

                <div id="file-upload-form" class="uploader" style="margin-bottom:50px">
                    <input id="file-upload" type="file" name="fileUpload" accept="image/*"/>

                    <label for="file-upload" id="file-drag">
                        <img id="file-image" src="#" alt="Preview" class="hidden">
                        <div id="start">
                            <i class="fa fa-download" aria-hidden="true"></i>
                            <div>Selectionner une image ou déposer ici</div>
                            <div id="notimage" class="hidden">Choisir une image</div>
                            <span id="file-upload-btn" class="btn btn-primary">Choisir une image</span>
                        </div>
                        <div id="response" class="hidden">
                            <div id="messages"></div>
                            <progress class="progress" id="file-progress" value="0">
                                <span>0</span>%
                            </progress>
                        </div>
                    </label>
                </div>
                <button type="submit" class="btn btn-outline-warning" style="float : right; margin: 50px 50px 50px 0px">
                    Poster
                </button>
            </form>
        </div>
    </section>
</div>
<jsp:include page="/WEB-INF/fragments/footer.jsp"/>

<script src="js/upload.js"></script>
</body>
</html>
