<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cupcake</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">    <link rel="stylesheet" href="resources/css/style.css" />
    <link rel="stylesheet" href="/resources/css/style.css" />
</head>

<body class="body-connexion">
<div class="section-background section-background-color">
    <jsp:include page="/WEB-INF/fragments/navbar/${navbar}.jsp" />
    <div class="cadre">
        <div class="txt animated pulse inscription-content">
            <div class="connexion-right-content">
                <section>
                    <table>
                        <tr>
                            <th id="title-form-insc">S'inscrire</th>
                        </tr>
                        <td>
                            <form action="/signup-check" method="POST" class="connexion-form">
                                <table class="input-fields">
                                    <tr>
                                        <td>Marque : </td>
                                        <td> <input class="input" type="text" placeholder="Votre marque"
                                                    name="marque" required /> </td>
                                    </tr>
                                    <tr>
                                        <td>Type de compte : </td>
                                        <td><input type="radio" name="utilisateur"
                                                   value="loueur" /><label>Loueur</label>
                                            <input class="input" type="radio" name="utilisateur" value="entreprise"
                                                   style="margin-left: 30px;" /><label>Entreprise</label></td>
                                    </tr>
                                    <tr>
                                        <td>E-mail : </td>
                                        <td> <input class="input" type="email" placeholder="Votre e-mail"
                                                    name="email" required /> </td>
                                    </tr>
                                    <tr>
                                        <td>Mot de passe : </td>
                                        <td> <input class="input" type="password" placeholder="Votre mot de passe"
                                                    name="motdepasse" required /> </td>
                                    </tr>
                                    <tr>
                                        <td><button type="submit"
                                                    class="btn btn-connexion btn-outline-dark">Inscrire</button></td>
                                    </tr>
                                    <!--Nous attribuons une classe spécifique à cette balise pour des raisons ésthétiques-->
                                </table>
                                <!--Ce tableau est le tableau ou un utilisateur non inscrit rendre ses identifiants-->
                                <a href="/login" style="color : white ;"> Déjà inscrit ? </a>
                            </form>
                            <?php echo $msg?>
                        </td>
                    </table>
                </section>
            </div>

            <div class="inscription-left-content ">
                <img src="/resources/images/mirror.jpg">
            </div>
        </div>
    </div>
</body>
</html>
