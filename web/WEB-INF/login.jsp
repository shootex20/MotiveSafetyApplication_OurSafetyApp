
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login JSP</title>
        <link href="CSS-MEDIA/Index.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="loginHeader">
            <h1>MotiveSafety OurSafety Application</h1>
            <h2>Occupational Health & Safety Consultants</h2>
            <h3>Preventative Maintenance Program</h3>
            <p>${loginMsg}</p>
        </div>
        <form action="login" method="post" class="loginForm">
            <input type="hidden" name="hidden_login" value="hiddenLogin">
            <label>Email: </label><input type="text" name="email_input" value="">
            <label>Password: </label><input type="password" name="password_input" value="">
            <input type="submit" value="Log In">
        </form>
    </body>
</html>