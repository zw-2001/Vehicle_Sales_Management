<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1><%= "Se connecter" %>
    </h1>
    <h1 ${name}></h1>
    <br/>
    <form action="test" method="post">
        <button type="submit" name="your_name" value="your_value" class="btn-link">Test</button>
    </form>
    <form action="" method="post">
        <button type="submit" name="your_name" value="your_value" class="btn-link">Index</button>
    </form>

    <form action="login" method="POST">

        <div class="inputs">
            <input type="text" placeholder="Username" name="username">
            <input type="password" placeholder="Password" name="password">
            <button type="submit">Se connecter</button>
        </div>

    </form>

</body>
</html>