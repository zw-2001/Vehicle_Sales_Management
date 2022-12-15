<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

<body class="body-connexion">
<div class="section-background section-background-color">
    <jsp:include page="/WEB-INF/fragments/navbar.jsp"/>
    <div class="cadre">
        <div class="txt animated pulse connexion-content">
            <div class="connexion-left-content">
                <img src="https://images.unsplash.com/photo-1589750602846-60028879da9b?ixlib=rb-1.2.1&auto=format&fit=crop&w=334&q=80">
            </div>
            <div class="connexion-right-content">
                <section>
                    <table>
                        <tr>
                            <th id="title-form">Se connecter</th>
                        </tr>
                        <td>
                            <form action="login-check" method="POST" class="connexion-form">
                                <table class="input-fields">
                                    <tr>
                                        <td>E-mail :</td>
                                        <td><input class="input" type="email" placeholder="exemple@gmail.com"
                                                   name="email"/></td>
                                    </tr>
                                    <tr>
                                        <td>Mot de passe :</td>
                                        <td><input class="input" type="password" placeholder="Mot de passe"
                                                   name="password"/></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <button type="submit"
                                                    class="btn btn-connexion btn-outline-dark">Connecter
                                            </button>
                                        </td>
                                    </tr>
                                </table>
                                <a href="/register" style="color : white"> Pas encore inscrit ? </a>
                            </form>
                            <div>${msg}</div>
                        </td>
                    </table>
                </section>
            </div>
        </div>
    </div>
</div>
</body>
</html>