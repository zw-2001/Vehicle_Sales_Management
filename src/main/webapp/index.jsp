<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!-- start session -->

<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1><%= "Se connecter" %>
    </h1>
    <br/>
    <form action="#" th.:action="@{/login}" method="POST">

        <a href="hello-servlet">Hello Servlet</a>
        <div class="inputs">
            <input type="email" placeholder="Email">
            <input type="password" placeholder="Password">
            <button action="/login" type="submit">Se connecter</button>
        </div>

    </form>

</body>
</html>